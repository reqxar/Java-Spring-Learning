package spring.rest.service;


import spring.rest.entity.Employee;

import java.util.List;


public interface EmployeeServiceInterface {
    public List<Employee> getAllEmployee();

    public void createOrUpdateEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
