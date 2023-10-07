package com.reqxar.spring.database.repository;

import com.reqxar.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;
    private final Integer poolSize;


    public UserRepository(@Qualifier("pool2") ConnectionPool connectionPool,
                          @Value("${oracle.poolSize}") Integer poolSize) {
        this.connectionPool = connectionPool;
        this.poolSize = poolSize;
    }

    public void getPoolInfo(){
       connectionPool.getConnectionPoolProperty();
    }
}