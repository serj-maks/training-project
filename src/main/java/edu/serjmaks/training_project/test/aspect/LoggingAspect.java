package edu.serjmaks.training_project.test.aspect;

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

    @Before(value = "execution(* edu.serjmaks.training_project.test.controller.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("'{}' method start", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* edu.serjmaks.training_project.test.controller.impl.*.*(..))",
                    returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("'{}' method end. Result: '{}'",
                joinPoint.getSignature().getName(),
                result
        );
    }
}
