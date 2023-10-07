package app;

import app.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertEmployeesRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SessionFactory factory = context.getBean("sessionFactory", SessionFactory.class);
        Employee emp1 = new Employee("Tom", "Jonk", 200);
        Employee emp2 = new Employee("Jack", "Smith", 200);
        Employee emp3 = new Employee("Anny", "Williams", 200);
        Session session = factory.openSession();

        session.beginTransaction();

        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);

        session.getTransaction().commit();


    }
}
