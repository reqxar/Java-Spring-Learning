package spring.rest.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.rest.app.config.RestAppConfig;
import spring.rest.app.entity.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RestAppConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();

        System.out.println(allEmployees);

        System.out.println();

        Employee employee = communication.getEmployee(3);
        System.out.println(employee);

        employee.setSalary(700);

        communication.saveOrUpdateEmployee(employee);

        System.out.println();

        //Employee newEmployee = new Employee("ForDelete", "forDelete", 0);
        //communication.saveOrUpdateEmployee(newEmployee);

        communication.deleteEmployee(12);
        allEmployees = communication.getAllEmployees();

        System.out.println(allEmployees);



    }
}
