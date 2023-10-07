package com.reqxar.spring.runners;

import com.reqxar.spring.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationTest1_18_20 {

    public static void main(String[] args) {
        //Конфигурация с помощью аннотаций @Autowired + @Qualifier

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1_14_20.xml");

        Person person = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);

        System.out.println(person==person2);

        person.personPetSay();
        person.getPeronInfo();

        context.close();

    }
}
