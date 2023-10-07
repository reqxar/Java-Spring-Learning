package hibernateOneToOne;

import hibernateOneToOne.entity.Details;
import hibernateOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestRunner2 {
    public static void main(String[] args) {
        try (
                SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Details.class)
                        .buildSessionFactory()){

            Details details = new Details("Moscow", "488-722", "worker1@mail.ru");
            Employee employee = new Employee("Tor", "Power", "HR", 1000);
            employee.setEmployeeDetails(details);
            details.setEmployee(employee);


            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.persist(employee);

            int lastId = (int) session.createQuery("select max(id) from Employee").getSingleResult();

            Employee createdEmployee = session.get(Employee.class, lastId);
            System.out.println(createdEmployee);
            session.getTransaction().commit();

        }

    }
}
