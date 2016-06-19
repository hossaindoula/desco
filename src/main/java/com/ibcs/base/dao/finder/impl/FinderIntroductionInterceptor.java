package com.ibcs.base.dao.finder.impl;

import com.ibcs.base.dao.finder.FinderExecutor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Connects the Spring AOP magic with the Hibernate DAO magic
 * For any method beginning with "find" this interceptor will use the FinderExecutor to call a Hibernate named query
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor, HandlerInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable{

        FinderExecutor executor = (FinderExecutor) methodInvocation.getThis();

        String methodName = methodInvocation.getMethod().getName();
        if(methodName.startsWith("find") || methodName.startsWith("list")) {
            Object[] arguments = methodInvocation.getArguments();
            return executor.executeFinder(methodInvocation.getMethod(), arguments);
        } else if(methodName.startsWith("iterate")){
            Object[] arguments = methodInvocation.getArguments();
            return executor.iterateFinder(methodInvocation.getMethod(), arguments);
        }
//        else if(methodName.startsWith("scroll"))
//        {
//            Object[] arguments = methodInvocation.getArguments();
//            return executor.scrollFinder(methodInvocation.getMethod(), arguments);
//        }
        else {
            return methodInvocation.proceed();
        }
    }

    public boolean implementsInterface(Class intf){
        return intf.isInterface() && FinderExecutor.class.isAssignableFrom(intf);
    }

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
