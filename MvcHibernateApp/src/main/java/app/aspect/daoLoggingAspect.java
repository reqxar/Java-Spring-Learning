package app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class daoLoggingAspect {

    public String allDaoMethods(){
        return "app.dao ";
    }
    @Around("execution(* app.dao.*.*(..))")
    public Object allDaoMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Начало работы метода: "+methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("Конец работы метода: "+methodName);
        return targetMethodResult;
    }
}
