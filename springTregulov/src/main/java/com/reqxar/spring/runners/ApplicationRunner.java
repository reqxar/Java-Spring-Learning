package com.reqxar.spring.runners;

import com.reqxar.spring.entity.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        //Получение бина

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Dog dog = context.getBean("dog", Dog.class);
        dog.say();

        context.close();

    }
}
