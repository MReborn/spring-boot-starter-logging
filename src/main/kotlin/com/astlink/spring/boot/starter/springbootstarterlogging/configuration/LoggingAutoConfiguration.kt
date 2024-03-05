package com.astlink.spring.boot.starter.springbootstarterlogging.configuration

import com.astlink.spring.boot.starter.springbootstarterlogging.aspect.LoggingAspect
import com.astlink.spring.boot.starter.springbootstarterlogging.aspect.LoggingAspect.Companion.logger
import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.properties.LoggingProperties
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(LoggingProperties::class)
@ConditionalOnClass(LoggingProperties::class)
@ConditionalOnProperty(prefix = "log", value = ["enabled"], havingValue = "true", matchIfMissing = false)
class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun loggingAspect(): LoggingAspect {
        return LoggingAspect()
    }

    @PostConstruct
    fun init(){
        logger.info { "LoggingAutoConfiguration initialized" }
    }

}