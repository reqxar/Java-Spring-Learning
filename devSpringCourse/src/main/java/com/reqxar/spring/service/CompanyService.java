package com.reqxar.spring.service;

import com.reqxar.spring.database.enity.Company;
import com.reqxar.spring.database.repository.CrudRepository;
import com.reqxar.spring.dto.CompanyReadDto;
import com.reqxar.spring.listeners.AccesType;
import com.reqxar.spring.listeners.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository, ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccesType.READ));
                    return new CompanyReadDto(entity.id());
                });

    }
}
