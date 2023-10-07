package spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.Employee;
import spring.rest.exceptionHandling.NoSuchEmployeeException;
import spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpringRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        List<Employee> allEmployees = employeeService.getAllEmployee();

        return allEmployees;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new NoSuchEmployeeException("Сотрудник с ID="+id+" -не найден!");
        }

        return employee;

    }
    @PostMapping("/")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.createOrUpdateEmployee(employee);

        return employee;
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.createOrUpdateEmployee(employee);

        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("Employee has been not existed before");
        }
        employeeService.deleteEmployee(id);

        return "Employee with: "+id+" successfully deleted!";
    }


}
