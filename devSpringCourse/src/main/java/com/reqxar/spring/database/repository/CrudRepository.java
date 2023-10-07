package com.reqxar.spring.database.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CrudRepository <K,E>{
    Optional<E> findById(K id);

    void delete(E enity);
}
