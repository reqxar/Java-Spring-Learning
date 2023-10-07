package com.reqxar.spring.runners;

import com.reqxar.spring.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest1_10 {

    public static void main(String[] args) {
        //Внедрение значений из property файла

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Person personWithCat = context.getBean("personWithCat", Person.class);
        personWithCat.personPetSay();

        Person personWithDog = context.getBean("personWithDog", Person.class);
        personWithDog.personPetSay();
        personWithDog.getPeronInfo();

        context.close();

    }
}
