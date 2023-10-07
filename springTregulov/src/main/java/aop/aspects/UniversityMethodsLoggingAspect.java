package aop.aspects;

import aop.university.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
@Aspect
public class UniversityMethodsLoggingAspect {


    //@AfterReturning(pointcut = "aop.aspects.pointcuts.UniversityPointcuts.universityAllGetMethods()",returning = "students")
    public void afterReturningGetStudentsAdvice(List<Student> students){
        System.out.println("beforeReturningGetStudentsAdvice: Начало преобразования");
        System.out.println("afterReturningGetStudentsAdvice: Выведение полученого списка студентов");
        System.out.println(students);

        for(Student student: students){
            if (student.getName().equals("Варя")){
                student.setAvgGrade(10.0);
                student.setName("Мисс "+student.getName());
            }
        }

        System.out.println("afterReturningGetStudentsAdvice: Выведение измененного списка студентов");
        System.out.println(students);
        System.out.println("afterReturningGetStudentsAdvice: Конец преобразования");
    }

    @AfterThrowing(pointcut = "aop.aspects.pointcuts.UniversityPointcuts.universityAllGetMethods()", throwing = "exception")
    public void afterThrowingGetStudentsAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsAdvice: Начало поиска исключения");
        System.out.println("afterThrowingGetStudentsAdvice: Была поймана ошибка: "+exception);
        System.out.println("afterThrowingGetStudentsAdvice: Конец поиска исключения");

    }

    @After("aop.aspects.pointcuts.UniversityPointcuts.universityAllGetMethods()")
    public void afterGetStudentsAdvice(){
        System.out.println("afterGetStudentsAdvice: начало и конец логирования");
    }

    @Around("aop.aspects.pointcuts.UniversityPointcuts.universityGetDefaultStudentMethod()")
    public Student aroundGetDefaultStudentAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Student targetMethodReturn = null;



        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("aroundGetDefaultStudentAdvice: Начало логирования");
        try {
            targetMethodReturn = (Student) proceedingJoinPoint.proceed();
        } catch (Exception e){
            System.out.println("В ходе работы метода возникло исключение "+e);
            System.out.println("aroundGetDefaultStudentAdvice: Конец логирования");
            System.out.println("--------------------------------------------------------------------------------------------");

            throw e;
        }
        System.out.println("Полученная информация о студенте: "+targetMethodReturn);
        System.out.println("aroundGetDefaultStudentAdvice: Преобразование студента...");
        long timeBegin = System.currentTimeMillis();
        targetMethodReturn.setName("Андрей");
        targetMethodReturn.setAvgGrade(10.0);
        targetMethodReturn.setCourse(2);
        long timeEnd = System.currentTimeMillis();
        System.out.println("aroundGetDefaultStudentAdvice: Студент был преобразован, на преобразование понадобилось "+(timeEnd - timeBegin)+" милисекунд");
        System.out.println("Новая информация о студенте: "+targetMethodReturn);
        System.out.println("aroundGetDefaultStudentAdvice: Конец логирования");
        System.out.println("--------------------------------------------------------------------------------------------");
        return targetMethodReturn;
    }
}
