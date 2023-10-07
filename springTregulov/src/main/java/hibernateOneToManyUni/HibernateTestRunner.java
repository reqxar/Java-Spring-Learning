package hibernateOneToManyUni;


import hibernateOneToManyUni.entity.Department;
import hibernateOneToManyUni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateTestRunner {
    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Department.class)
                        .buildSessionFactory()){

            Department department = new Department("HR", 3500, 500);

            Employee emp1 = new Employee("ALEX", "Wilson", 600);
            Employee emp2 = new Employee("MARGO", "Smith", 850);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.persist(department);




            session.getTransaction().commit();


        }
    }
}
