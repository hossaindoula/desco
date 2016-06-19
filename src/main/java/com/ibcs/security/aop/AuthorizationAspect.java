package com.ibcs.security.aop;

/**
 * Created by hossain.doula on 5/29/2016.
 */
import com.ibcs.security.SessionUtil;
import com.ibcs.security.model.Feature;
import com.ibcs.security.service.AuthenticationAndAuthorizationService;
import com.ibcs.AppConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibcs.security.service.SecurityService;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Annotation;
import java.util.List;


/**
 * This is an AspectJ class to authorization check for any controllers method
 * This is done in purely centralized fashion.
 * For this Authorization checking User, Token, Authority, AuthorizedGroups and Feature will
 * be taken into concern. Feature is the least domain class which will be responsible to
 * hold all the components' operations and Authority is the one which will be mapped to AuthorizedGroups
 * and Features and subsequently act as a bridge to communicate and leveraging the optimal
 * AAS<AuthenticationAndAuthorizationServices> in a supreme and efficient way.
 * @author hossain.doula <hossain.doula@ibcs-primax.com>
 */
@Aspect
public class AuthorizationAspect {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AuthenticationAndAuthorizationService authorizationService;
    private List<Feature> features = null;
    private boolean isAllowed = false;
    String module = null;
    String operation = null;
    String requestMapping = null;


    @Pointcut("within(@org.springframework.stereotype.Controller *) " +
            "&& !within(@org.springframework.stereotype.Controller com.ibcs.general.AuthenticationController)")
    public void allControllers(){}

    @Pointcut("execution(* save*(..))")
    public void allSaveOperations(){}

    @Pointcut("execution(* update*(..))")
    public void allUpdateOperations(){}

    @Pointcut("execution(* *List(..))")
    public void allListOperations(){}

    @Pointcut("execution(* delete*(..))")
    public void allDeleteOperations(){}

    @Pointcut("execution(* *Assignment(..))")
    public void allAssignmentOperations(){}

    @Around("allControllers() && allSaveOperations()")
    public Object proceedToSaveAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        /*features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");*/

        return proceedJoinPoint.proceed();
    }

    @Around("allControllers() && allUpdateOperations()")
    public Object proceedToUpdateAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        /*features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");
*/
        return proceedJoinPoint.proceed();
    }

    @Around("allControllers() && allListOperations()")
    public Object proceedToListAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        /*features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");*/
        return proceedJoinPoint.proceed();

    }

    @Around("allControllers() && allDeleteOperations()")
    public Object proceedToDeleteAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        /*features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");
*/
        return proceedJoinPoint.proceed();
    }

    @Around("allControllers() && allAssignmentOperations()")
    public Object proceedToAssignmentAction(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
        /*features = SessionUtil.getSessionUserFeatures();
        int annotationFind = 0;
        int annotationLength = proceedJoinPoint.getTarget().getClass().getAnnotations().length;
        for(int i = 0; i < annotationLength; i++){
            if(proceedJoinPoint.getTarget().getClass().getAnnotations()[i].toString()
                    .contains("RequestMapping")){
                annotationFind = i;
                break;

            }
        }

        requestMapping = proceedJoinPoint.getTarget().getClass().
                getAnnotations()[annotationFind].toString();
        module = requestMapping.split(",")[1].split("/")[1];

        operation = proceedJoinPoint.getSignature().getName();
        isAllowed = authorizationService.checkAuthorization(features,module,operation);
        if(isAllowed) return proceedJoinPoint.proceed(); else return new ModelAndView("/security/unauthorized");*/

        return proceedJoinPoint.proceed();

    }
}
