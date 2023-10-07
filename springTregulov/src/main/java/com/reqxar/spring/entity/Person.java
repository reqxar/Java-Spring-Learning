package com.reqxar.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Person {
    private Pet pet;
    private Integer age;
    private String name;

    public Person() {
    }

    @Autowired
    public Person(@Qualifier("dog") Pet pet) {
        this.pet = pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Integer getAge() {
        return age;
    }
    @Value("${person.age}")
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    @Value("${person.name}")
    public void setName(String name) {
        this.name = name;
    }

    public void personPetSay(){
        System.out.println("----------------");
        System.out.println("Person pet said:");
        this.pet.say();
        System.out.println("----------------");
    }

    public void getPeronInfo(){
        System.out.println("Person name: "+getName());
        System.out.println("Person age: "+getAge());
    }

    @PostConstruct
    public void init(){
        System.out.println("Person bean has been initialized!");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Person bean has been destroy!");
    }


}
