package com.ibcs.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * This is for the central logging
 * So no need to put any centralized logging in each method
 * Try to avoid the cowboy coding mechanism, even though the deadline
 * is very near. We are Software Engineer not any cowboy.
 * Created by hossain.doula on 5/19/2016.
 */

//@Aspect
public class LoggingAspect {

    protected static Logger logger = Logger.getLogger("aspect");

    //@Before("execution(* *(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.debug("logBefore() is running!");
        logger.debug("hijacked : " + joinPoint.getSignature().getName());
        logger.debug("******");
    }

    //@After("execution(* *(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.debug("logAfter() is running!");
        logger.debug("hijacked : " + joinPoint.getSignature().getName());
        logger.debug("******");
    }

    /*@AfterReturning(
            pointcut = "execution(* *(..))",
            returning= "result")*/
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.debug("logAfterReturning() is running!");
        logger.debug("hijacked : " + joinPoint.getSignature().getName());
        logger.debug("Method returned value is : " + result);
        logger.debug("******");

    }

    /*@AfterThrowing(
            pointcut = "execution(* *(..))",
            throwing= "error")*/
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.debug("logAfterThrowing() is running!");
        logger.debug("hijacked : " + joinPoint.getSignature().getName());
        logger.debug("Exception : " + error);
        logger.debug("******");
    }

    //@Around("execution(* *(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.debug("logAround() is running!");
        logger.debug("hijacked method : " + joinPoint.getSignature().getName());
        logger.debug("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        logger.debug("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        logger.debug("Around after is running!");

        logger.debug("******");
    }
}
