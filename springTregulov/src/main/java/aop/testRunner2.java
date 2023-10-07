package aop;

import aop.library.Book;
import aop.library.Library;
import aop.university.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testRunner2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        University university = context.getBean("university", University.class);
        System.out.println(university.getDefaultStudent());



        context.close();
    }
}
