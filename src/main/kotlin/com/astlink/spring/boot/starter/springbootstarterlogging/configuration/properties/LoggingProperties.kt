package com.astlink.spring.boot.starter.springbootstarterlogging.configuration.properties

import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration.Companion.logger
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "astlink")
class LoggingProperties {
    private var enabled: Boolean = true // для глобального включения/отключения стартера

    @PostConstruct
    fun init() {
        logger.info("Logging properties init")
    }
}