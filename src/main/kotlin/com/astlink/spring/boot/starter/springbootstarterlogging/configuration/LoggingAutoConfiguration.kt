package com.astlink.spring.boot.starter.springbootstarterlogging.configuration

import com.astlink.spring.boot.starter.springbootstarterlogging.aspect.LoggingAspect
import jakarta.annotation.PostConstruct
import mu.KLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(prefix = "astlink-aop-logging", value = ["enabled"], havingValue = "true")
class LoggingAutoConfiguration {
    companion object : KLogging()

    @Bean
    fun loggingAspect(): LoggingAspect {
        return LoggingAspect()
    }

    @PostConstruct
    fun init() {
        logger.info { "LoggingAutoConfiguration initialized" }
    }

}