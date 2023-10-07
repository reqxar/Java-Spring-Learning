package aop.aspects;

import aop.library.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class BookMethodsLoggingAspect {


    @Before("aop.aspects.pointcuts.LibraryPointcuts.allLibraryGetMethods()")
    public void beforeGetBookLoggingAdvice(){
        System.out.println("beforeGetBookLoggingAdvice: Логирование получения книги");
        System.out.println("-------------------------------------------------------------------");
    }

    @Before("aop.aspects.pointcuts.LibraryPointcuts.allLibraryReturnMethods()")
    public void beforeReturnBookLoggingAdvice(){
        System.out.println("beforeReturnBookLoggingAdvice: Логирование возвращения книги");
        System.out.println("-------------------------------------------------------------------");
    }
    @Before("aop.aspects.pointcuts.LibraryPointcuts.allLibraryAddMethods()")
    public void beforeAddBookLoggingAdvice(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();

        Object[] arguments = joinPoint.getArgs();


        System.out.println("beforeAddBookLoggingAdvice: Логирование добавления книги");
        System.out.println("methodSignature: "+methodSignature);
        System.out.println("methodSignature.getMethod(): "+methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): "+methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): "+methodSignature.getName());

        for (Object obj :arguments){
            if(obj instanceof Book){
                Book newBook = (Book) obj;
                System.out.println("Название книги: "+newBook.getBookName());
                System.out.println("Автор книги: "+newBook.getAuthorName());
                System.out.println("Год издания: "+newBook.getYear());
            } else if (obj instanceof String) {
                System.out.println("Книгу добавил: "+obj);
            }
        }

        System.out.println("-------------------------------------------------------------------");
    }



}
