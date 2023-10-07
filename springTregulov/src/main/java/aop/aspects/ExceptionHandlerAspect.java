package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlerAspect {
    @Before("aop.aspects.pointcuts.LibraryPointcuts.allLibraryGetMethods()")
    public void beforeGetBookException(){
        System.out.println("beforeGetBookException: Поиск ошибки при попытке получения книги из библиотеки");
        System.out.println("-------------------------------------------------------------------");
    }
}
