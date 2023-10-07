package spring.rest.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.rest.app.entity.Employee;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/";

    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Employee>>(){});


        List<Employee> allEmployees = responseEntity.getBody();

        return allEmployees;
    }

    public Employee getEmployee(int id){

        Employee employee = restTemplate.getForObject(URL+id, Employee.class);

        return employee;
    }

    public void saveOrUpdateEmployee(Employee employee){
        int employeeId = employee.getId();



        if (employeeId == 0){
            restTemplate.put(URL, employee);
            System.out.println("Employee was successfully created!");
            System.out.println(employee);
        } else {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("Employee was successfully updated!");
            System.out.println(responseEntity.getBody());
        }


    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL+id);

        System.out.println("Employee with id="+id+" was deleted!");
    }

}
