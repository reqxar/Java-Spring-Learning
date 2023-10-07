package spring_course.spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_course.spring_boot.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    @Transactional
    public void createOrUpdateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
