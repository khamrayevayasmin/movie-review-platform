package com.movie_review_platform.config;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@Component
public class KhamrayevaYasminLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();

        log.info("REQUEST: {} {} from IP: {}",
                httpRequest.getMethod(),
                httpRequest.getRequestURI(),
                httpRequest.getRemoteAddr());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;

        log.info("RESPONSE: {} {} - Status: {} - Duration: {}ms",
                httpRequest.getMethod(),
                httpRequest.getRequestURI(),
                httpResponse.getStatus(),
                duration);
    }
}