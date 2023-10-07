package spring.rest.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.rest.dao.EmployeeDao;
import spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.exceptionHandling.NoSuchEmployeeException;
import spring.rest.exceptionHandling.NoSuchEmployeeExceptionData;

import java.util.List;


@Service
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(int id) {
        Employee employee = employeeDao.getEmployee(id);


        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = employeeDao.getAllEmployee();
        return allEmployees;

    }

    @Override
    public void createOrUpdateEmployee(Employee employee) {
        employeeDao.createOrUpdateEmployee(employee);
    }

}
