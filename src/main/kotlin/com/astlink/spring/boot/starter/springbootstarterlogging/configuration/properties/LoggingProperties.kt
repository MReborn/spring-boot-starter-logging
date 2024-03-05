package com.astlink.spring.boot.starter.springbootstarterlogging.configuration.properties

import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration.Companion.logger
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "ast-link")
@Component
class LoggingProperties {
    /**
     * для глобального включения/отключения стартера
     */
    private var enabled: Boolean = false

    @PostConstruct
    fun init() {
        logger.info("Logging properties init")
    }
}