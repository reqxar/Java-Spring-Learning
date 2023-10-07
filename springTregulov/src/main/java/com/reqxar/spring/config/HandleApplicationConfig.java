package com.reqxar.spring.config;

import com.reqxar.spring.entity.Cat;
import com.reqxar.spring.entity.Dog;
import com.reqxar.spring.entity.Person;
import com.reqxar.spring.entity.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandleApplicationConfig {

    @Bean("cat")
    public Pet catBean(){
        return new Cat();
    }

    @Bean("dog")
    public Pet dogBean(){
        return new Dog();
    }

    @Bean("person")
    public Person personBean(){
        return new Person(dogBean());
    }

}
