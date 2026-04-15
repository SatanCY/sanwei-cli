package com.sanwei.framework.web.config;

import com.sanwei.framework.web.core.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * SanweiWebAutoConfiguration
 *
 * @author caiyang
 * @date 2026/4/14
 */
@AutoConfiguration
public class SanweiWebAutoConfiguration {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
