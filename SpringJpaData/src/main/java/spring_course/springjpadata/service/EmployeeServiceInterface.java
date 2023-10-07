package spring_course.springjpadata.service;





import spring_course.springjpadata.entity.Employee;

import java.util.List;


public interface EmployeeServiceInterface {
    public List<Employee> getAllEmployee();

    public void createOrUpdateEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> getAllEmployeeByName(String name);
}
