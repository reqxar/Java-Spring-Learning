package spring_course.spring_boot.dao;


import spring_course.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployee();

    public void createOrUpdateEmployee(Employee employee);

    Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
