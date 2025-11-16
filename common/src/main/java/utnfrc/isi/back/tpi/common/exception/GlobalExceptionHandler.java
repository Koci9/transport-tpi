package utnfrc.isi.back.tpi.common.exception;

import utnfrc.isi.back.tpi.common.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse body = new ErrorResponse();
        body.setStatus(status.value());
        // reconstruct a HttpStatus to get reason phrase (HttpStatusCode doesn't expose it)
        body.setError(HttpStatus.valueOf(status.value()).getReasonPhrase());
        body.setMessage("Validation failed");
        body.setValidationErrors(errors);
        body.setPath(request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(status.value()).headers(headers).body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        ErrorResponse body = new ErrorResponse();
        body.setStatus(HttpStatus.BAD_REQUEST.value());
        body.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.setMessage("Validation failed");
        body.setValidationErrors(errors);
        body.setPath(request.getRequestURI());
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, HttpServletRequest request) {
        ErrorResponse body = new ErrorResponse();
        body.setStatus(ex.getStatus());
        body.setError(HttpStatus.valueOf(ex.getStatus()).getReasonPhrase());
        body.setMessage(ex.getMessage());
        body.setPath(request.getRequestURI());
        return ResponseEntity.status(ex.getStatus()).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest request) {
        ErrorResponse body = new ErrorResponse();
        body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        body.setMessage(ex.getMessage());
        body.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}