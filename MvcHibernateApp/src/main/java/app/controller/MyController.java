package app.controller;
import app.entity.Employee;
import app.service.EmployeeService;
import app.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeServiceInterface employeeService;

    @RequestMapping("/")
    public String getAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployee();
        model.addAttribute("allEmployees", allEmployees);

        return "allEmployees";
    }
    @RequestMapping("/createNewEmployee")
    public String createNewEmployee(Model model){
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "createOrUpdateEmployee";
    }
    @RequestMapping("/saveOrUpdateEmployee")
    public String saveOrUpdateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.createOrUpdateEmployee(employee);

        return "redirect:/";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id,
                                 Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "createOrUpdateEmployee";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
            employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
