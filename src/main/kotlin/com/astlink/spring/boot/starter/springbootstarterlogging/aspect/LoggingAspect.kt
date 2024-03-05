package com.astlink.spring.boot.starter.springbootstarterlogging.aspect

import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration.Companion.logger
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class LoggingAspect() {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    fun loggingServiceMethod() {
    }

    @Before("loggingServiceMethod()")
    fun logBeforeMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "Вызван метод: $methodName" }
    }

    @AfterReturning("loggingServiceMethod()")
    fun logAfterReturningMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "$methodName\" метод был завершен" }
    }

    @AfterThrowing(
        pointcut = "loggingServiceMethod()", throwing = "exception"
    )
    fun logAfterThrowing(joinPoint: JoinPoint, exception: Exception) {
        val methodName = joinPoint.signature.name
        logger.error {
            "В методе $methodName выброшено исключение: [${exception::class}] ${exception.message}"
        }
    }
}