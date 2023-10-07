package com.reqxar.spring.database.pool;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
public class ConnectionPool {
    private static int connectionPoolCounter;
    private final int id;
    private final String url;
    private final String username;
    private final String password;

    public ConnectionPool(@Value("${postgres.url}") String url,
                          @Value("${postgres.username}")String username,
                          @Value("${postgres.password}") String password) {

        connectionPoolCounter++;
        this.id = connectionPoolCounter;
        this.url = url;
        this.username = username;
        this.password = password;
    }
    @PostConstruct
    public void init(){
        System.out.println("ConnectionPoolBean #"+ this.id +" was created successfully");
    }

    public void getConnectionPoolProperty(){
        System.out.println("--------------------------------------------------");
        System.out.println("Pool #" + this.id + " has next properties: ");
        System.out.println("url: "+ this.url);
        System.out.println("username: "+ this.username);
        System.out.println("password: "+ this.password);
        System.out.println("--------------------------------------------------");
    }

    public void getPoolsCount(){
        System.out.println("Totally "+connectionPoolCounter+" pools was created!");
    }
}
