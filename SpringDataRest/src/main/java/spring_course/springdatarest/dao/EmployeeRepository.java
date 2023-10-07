package spring_course.springdatarest.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import spring_course.springdatarest.entity.Employee;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
