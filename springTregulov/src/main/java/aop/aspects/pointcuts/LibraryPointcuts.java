package aop.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class LibraryPointcuts {
    @Pointcut("execution(public void aop.library.Library.get*())")
    public void allLibraryGetMethods(){}

    @Pointcut("execution(* aop.library.Library.return*())")
    public void allLibraryReturnMethods(){}

    @Pointcut("execution(* aop.library.Library.add*(..))")
    public void allLibraryAddMethods(){}

    @Pointcut("execution(public void aop.library.Library.*())")
    public void allLibraryMethods(){

    }

    @Pointcut("allLibraryGetMethods() || allLibraryReturnMethods()")
    public void allLibraryGetAndReturnMethods(){}
}
