package utnfrc.isi.back.tpi.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<Object> {
    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("[GATEWAY] {} {}", request.getMethod(), request.getURI());
            return chain.filter(exchange).doOnSuccess(aVoid -> log.info("[GATEWAY] Response sent"));
        };
    }
}
