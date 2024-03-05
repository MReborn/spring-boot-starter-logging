package com.astlink.spring.boot.starter.springbootstarterlogging.aspect


import com.astlink.spring.boot.starter.springbootstarterlogging.configuration.LoggingAutoConfiguration.Companion.logger
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class LoggingAspect {


    // @Pointcut("execution(* ru.astondevs.astlink.userservice.service.impl.*.*(..))")
    @Pointcut("execution(* *(..))")
    fun userServiceMethod() {
    }

    @Pointcut("within(ru.astondevs.astlink.userservice.*)")
    fun controllerAdviceMethods() {
    }

    @Before("userServiceMethod()")
    fun logBeforeMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "Вызван метод: $methodName" }
    }

    @AfterReturning("userServiceMethod()")
    fun logAfterReturningMethodCall(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.name
        logger.info { "$methodName\" метод был завершен" }
    }

    @AfterThrowing(
        pointcut = "controllerAdviceMethods()", throwing = "exception"
    )
    fun logAfterThrowing(joinPoint: JoinPoint, exception: Exception) {
        val methodName = joinPoint.signature.name
        logger.error {
            "В методе $methodName выброшено исключение: [${exception::class}] ${exception.message}"
        }
    }
}