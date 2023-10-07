package spring_course.spring_boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_course.spring_boot.entity.Employee;
import spring_course.spring_boot.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpringRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        List<Employee> allEmployees = employeeService.getAllEmployee();

        System.out.println("seeeee");
        return allEmployees;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployee(id);


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

        employeeService.deleteEmployee(id);

        return "Employee with: "+id+" successfully deleted!";
    }


}
