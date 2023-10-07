package spring_course.springjpadata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_course.springjpadata.entity.Employee;
import spring_course.springjpadata.service.EmployeeService;


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
        employeeService.deleteEmployee(id);

        return "Employee with: "+id+" successfully deleted!";
    }

    @GetMapping("/findByName/{name}")
    public List<Employee> getAllEmployeeByName(@PathVariable("name") String name){
        List<Employee> employees = employeeService.getAllEmployeeByName(name);

        return employees;
    }


}
