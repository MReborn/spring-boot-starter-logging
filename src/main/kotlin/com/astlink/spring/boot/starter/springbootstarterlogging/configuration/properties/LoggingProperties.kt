package com.astlink.spring.boot.starter.springbootstarterlogging.configuration.properties

import com.astlink.spring.boot.starter.springbootstarterlogging.aspect.LoggingAspect.Companion.logger
import jakarta.annotation.PostConstruct
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "log")
class LoggingProperties {
    private var enabled: Boolean = false // для глобального включения/отключения стартера

    @PostConstruct
    fun init() {
        logger.info("Logging properties init")
    }

}