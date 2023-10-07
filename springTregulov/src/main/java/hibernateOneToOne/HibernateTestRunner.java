package hibernateOneToOne;

import hibernateOneToOne.entity.Details;
import hibernateOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestRunner {
    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Details.class)
                        .buildSessionFactory();){

            Details details = new Details("Moscow", "488-722", "worker1@mail.ru");
            Employee employee = new Employee("Lanny", "Gray", "HR", 500);
            employee.setEmployeeDetails(details);

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.persist(employee);

            Employee createdEmployee = session.get(Employee.class, 2);
            System.out.println(createdEmployee);
            session.getTransaction().commit();

        }

    }
}
