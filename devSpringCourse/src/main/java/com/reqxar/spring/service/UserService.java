package com.reqxar.spring.service;

import com.reqxar.spring.database.enity.Company;
import com.reqxar.spring.database.repository.CompanyRepository;
import com.reqxar.spring.database.repository.CrudRepository;
import com.reqxar.spring.database.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final CrudRepository<Integer, Company> companyRepository;


    public UserService(CrudRepository<Integer, Company> companyRepository) {
        this.companyRepository = companyRepository;

    }

    @PostConstruct
    public void init(){
        System.out.println("UserService.bean was created!");
    }

}
