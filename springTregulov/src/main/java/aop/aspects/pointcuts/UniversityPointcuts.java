package aop.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class UniversityPointcuts {

    @Pointcut("execution(* aop.university.University.getStudents())")
    public void universityAllGetMethods(){}

    @Pointcut("execution(* aop.university.University.getDefaultStudent())")
    public void universityGetDefaultStudentMethod(){}

}
