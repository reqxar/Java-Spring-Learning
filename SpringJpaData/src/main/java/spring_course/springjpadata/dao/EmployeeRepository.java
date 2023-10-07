package spring_course.springjpadata.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import spring_course.springjpadata.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);
}
