package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
    @Before("aop.aspects.pointcuts.LibraryPointcuts.allLibraryMethods()")
    public void beforeGetBookSecurityAdvice(){
        System.out.println("beforeGetBookSecurityAdvice: Проверка прав");
        System.out.println("-------------------------------------------------------------------");
    }
}
