package spring_course.springjpadata.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_course.springjpadata.dao.EmployeeRepository;
import spring_course.springjpadata.entity.Employee;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;

    }

    public Employee getEmployee(int id) {
        Employee employee = null;

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            employee = optional.get();
        }

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);

        return employees;
    }


    @Override
    public void createOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}
