package com.reqxar.spring.runners;

import com.reqxar.spring.entity.Cat;
import com.reqxar.spring.entity.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationTest1_14 {

    public static void main(String[] args) {
        //Конфигурация с помощью аннотаций

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1_14_20.xml");

        Dog dog = context.getBean("dog", Dog.class);
        Cat cat = context.getBean("cat", Cat.class);
        dog.say();
        cat.say();

        context.close();

    }
}
