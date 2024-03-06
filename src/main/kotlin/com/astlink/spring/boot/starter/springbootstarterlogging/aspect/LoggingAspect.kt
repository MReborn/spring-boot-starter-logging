package com.astlink.spring.boot.starter.springbootstarterlogging.aspect

import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration.Companion.logger
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class LoggingAspect() {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    fun loggingServiceMethod() {
    }

    @Pointcut("@within(com.astlink.spring.boot.starter.springbootstarterlogging.annotations.MustBeLogged)")
    fun customLoggingServiceMethod() {
    }

    @Before("loggingServiceMethod()|| customLoggingServiceMethod()")
    fun logBeforeMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "Вызван метод: $methodName" }
    }

    @AfterReturning("loggingServiceMethod()|| customLoggingServiceMethod()")
    fun logAfterReturningMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "$methodName\" метод был завершен" }
    }

    @AfterThrowing(
        pointcut = "loggingServiceMethod()|| customLoggingServiceMethod()", throwing = "exception"
    )
    fun logAfterThrowing(joinPoint: JoinPoint, exception: Exception) {
        val methodName = joinPoint.signature.name
        logger.error {
            "В методе $methodName выброшено исключение: [${exception::class}] ${exception.message}"
        }
    }
}