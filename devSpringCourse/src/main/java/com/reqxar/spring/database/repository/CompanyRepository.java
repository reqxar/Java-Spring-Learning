package com.reqxar.spring.database.repository;

import com.reqxar.spring.bpp.Auditing;
import com.reqxar.spring.bpp.InjectBean;
import com.reqxar.spring.bpp.Transaction;
import com.reqxar.spring.database.enity.Company;
import com.reqxar.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private ConnectionPool connectionPool;
    private Integer poolSize;

    public CompanyRepository(@Qualifier("pool1") ConnectionPool connectionPool,
                             @Value("${postgres.pool}") Integer poolSize) {

        this.connectionPool = connectionPool;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init(){
        System.out.println("CompanyRepository postConstruct method!");
        System.out.println("CompanyRepository.bean poolSize = "+poolSize);
    }

    public void getMessage(){
        System.out.println("CompanyRepository bean was created!");
        System.out.println("CompanyRepository.bean connectionPool property was injected from BPP");

    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company enity) {
        System.out.println("delete method...");

    }
}
