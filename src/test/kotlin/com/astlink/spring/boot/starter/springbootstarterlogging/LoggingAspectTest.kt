package com.astlink.spring.boot.starter.springbootstarterlogging

import com.astlink.spring.boot.starter.springbootstarterlogging.aspect.LoggingAspect
import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration
import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.properties.LoggingProperties
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [LoggingAutoConfiguration::class, LoggingAspect::class, LoggingProperties::class])
class LoggingAspectTest{
    @Test
    fun contextStartUp2() {
        TODO("Not yet implemented")
    }
}