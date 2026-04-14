package com.dalen.vetAppDalen.shared.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String traceId = UUID.randomUUID().toString();

        MDC.put("traceId", traceId);

        log.info("Request recebida",
                net.logstash.logback.argument.StructuredArguments.keyValue("method", req.getMethod()),
                net.logstash.logback.argument.StructuredArguments.keyValue("path", req.getRequestURI())
        );

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
