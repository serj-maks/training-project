package edu.serjmaks.training_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* edu.serjmaks.training_project.controller.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("start method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* edu.serjmaks.training_project.controller.impl.*.*(..))",
        returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("end method. Result: " + result);
    }
}
