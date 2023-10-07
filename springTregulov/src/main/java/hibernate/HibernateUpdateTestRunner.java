package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUpdateTestRunner {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp1 = (Employee) session.createQuery("from Employee where name = 'CRY'").getResultList().get(0);
            emp1.setDepartment("CHANGED");

            //session.createQuery("update Employee set salary = salary+salary/100*20 where salary<1000").executeUpdate();

            session.getTransaction().commit();

        }

    }
}
