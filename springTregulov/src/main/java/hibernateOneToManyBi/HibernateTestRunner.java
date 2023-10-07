package hibernateOneToManyBi;

import hibernateOneToManyBi.entity.Department;
import hibernateOneToManyBi.entity.Employee;
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

            Department department = new Department("HR", 500, 3500);

            Employee emp1 = new Employee("Kent", "Wilson", 600);
            Employee emp2 = new Employee("Elena", "Smith", 850);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            Session session = factory.getCurrentSession();
            session.beginTransaction();


            session.persist(department);

            session.getTransaction().commit();

            Session session2 = factory.openSession();
            session2.beginTransaction();
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("DEPARTMENT");
            Department newDepartment = session2.get(Department.class, 1);
            System.out.println(department);

            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("DEPARTMENT EMPLOYEES");
            System.out.println(newDepartment.getDepartmentEmployees());

        }
    }
}
