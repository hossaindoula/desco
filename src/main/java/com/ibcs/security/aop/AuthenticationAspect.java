package com.ibcs.security.aop;

/**
 * Created by hossain.doula on 5/31/2016.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibcs.security.model.User;
import com.ibcs.AppConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ibcs.security.SessionUtil;

@Aspect
public class AuthenticationAspect {

    @Pointcut("within(@org.springframework.stereotype.Controller *) " +
            "&& !within(@org.springframework.stereotype.Controller com.ibcs.general.AuthenticationController) ")
    public void allControllers(){}

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {}

    @Around("allControllers() && methodPointcut()")
    public Object proceedToAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();

        String referrer = request.getHeader("referer");

        if(SessionUtil.getSession().getAttribute(AppConstants.SESSION_USER) instanceof User){
            /*System.out.println("referrer = " + referrer);
            if(referrer != null){
                return new ModelAndView(referrer);
            }*/
            return proceedJoinPoint.proceed();
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}