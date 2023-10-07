package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateGetTestRunner {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            List<Employee> employeesWithBiggestSalary;
            employeesWithBiggestSalary = session.createQuery(
                    "from Employee order by salary desc"
                    )
                    .getResultList();

            session.getTransaction().commit();

            for (Employee emp : employeesWithBiggestSalary){
                System.out.println(emp);
            }


        }

    }
}
