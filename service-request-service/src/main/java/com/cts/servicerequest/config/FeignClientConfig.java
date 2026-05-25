package com.cts.servicerequest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cts.servicerequest.client.CustomFeignClientError;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Feign interceptor that forwards the incoming JWT Authorization header
 * to outbound calls made by CitizenServiceClient.
 *
 * Without this, the citizen-service would reject the Feign call with 401.
 */
@Configuration
public class FeignClientConfig {
	

    @Bean
    RequestInterceptor jwtPropagationInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attrs =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                HttpServletRequest request = attrs.getRequest();
                String authHeader = request.getHeader("Authorization");
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    requestTemplate.header("Authorization", authHeader);
                }
            }
        };
    }
    @Bean
    ErrorDecoder errorDecoder() {
    	return new CustomFeignClientError();
    }
}
