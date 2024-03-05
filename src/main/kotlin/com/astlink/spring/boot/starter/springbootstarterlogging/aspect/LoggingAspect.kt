package com.astlink.spring.boot.starter.springbootstarterlogging.aspect


import mu.KLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*


@Aspect
class LoggingAspect {
    companion object : KLogging()

//    @Pointcut("execution(* ru.astondevs.astlink.userservice.service.impl.*.*(..))")
    @Pointcut("execution(* com.example.demo.*.*(..))")
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