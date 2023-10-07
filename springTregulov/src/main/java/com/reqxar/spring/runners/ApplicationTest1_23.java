package com.reqxar.spring.runners;

import com.reqxar.spring.config.ApplicationConfig;
import com.reqxar.spring.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationTest1_23 {

    public static void main(String[] args) {
        //Конфигурация с помощью java-кода
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Person person = context.getBean("person", Person.class);

        person.personPetSay();
        person.getPeronInfo();

        context.close();

    }
}
