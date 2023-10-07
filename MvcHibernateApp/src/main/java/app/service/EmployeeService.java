package app.service;

import app.dao.EmployeeDao;
import app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
