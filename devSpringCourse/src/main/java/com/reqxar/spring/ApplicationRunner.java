package com.reqxar.spring;

import com.reqxar.spring.config.ApplicationConfiguration;
import com.reqxar.spring.database.pool.ConnectionPool;
import com.reqxar.spring.database.repository.CrudRepository;
import com.reqxar.spring.database.repository.UserRepository;
import com.reqxar.spring.service.CompanyService;
import com.reqxar.spring.web.WebConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationRunner {

    public static void main(String[] args) {
        /*Объявление контекста xml-файлом*/
        //var context = new ClassPathXmlApplicationContext("application.xml");

        /*Объявление контекста java-кодом*/
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        ConnectionPool pool1 = context.getBean("pool1", ConnectionPool.class);

        pool1.getConnectionPoolProperty();

        CompanyService companyService = context.getBean(CompanyService.class);
        System.out.println(companyService.findById(1));

        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        userRepository.getPoolInfo();

        WebConfiguration webConfiguration = context.getBean("webConfiguration", WebConfiguration.class);





    }
}
