package com.reqxar.spring.runners;

import com.reqxar.spring.entity.Dog;
import com.reqxar.spring.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest1_8 {

    public static void main(String[] args) {
        //Внедрение зависимостей

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Person personWithCat = context.getBean("personWithCat", Person.class);
        personWithCat.personPetSay();

        Person personWithDog = context.getBean("personWithDog", Person.class);
        personWithDog.personPetSay();

        context.close();

    }
}
