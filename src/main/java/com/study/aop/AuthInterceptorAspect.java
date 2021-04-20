
package com.study.aop;

import com.study.domain.User;
import com.study.utils.ServeResponse;
import com.study.service.ISessionAuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


@Aspect
@Component
public class AuthInterceptorAspect {


    @Autowired
    private ISessionAuthService sessionAuthService;

    /**
     * 通过注解 定义切面
     */
    @Pointcut("@annotation(com.study.aop.AuthInterceptor)")
    public void authenticationService() {

    }


    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("authenticationService()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        // 获得注解
        AuthInterceptor authInterceptor = method.getAnnotation(AuthInterceptor.class);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        //只处理设置了true的请求
        if (authInterceptor.header()) {
            //验证sessionId 是否有效
            String authentication = request.getHeader("authentication");
            if (StringUtils.isEmpty(authentication)) {
                return ServeResponse.errorResponse("000002", "当前会话无效！请重新登录");
            }
            User userBySession = sessionAuthService.getUserBySession(authentication);
            if (userBySession == null) {
                return ServeResponse.errorResponse("000002", "当前会话无效！请重新登录");
            }

            //为当前线程设置用户
            sessionAuthService.setCurrentUserThread(userBySession);
        }
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.error("服务器错误");
        }
        return proceed;

    }
}