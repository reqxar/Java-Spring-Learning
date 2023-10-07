package hibernateManyToMany;

import hibernateManyToMany.entity.Child;
import hibernateManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateRunner {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()){

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Section section1 = new Section("Football");
            Section section2 = new Section("Box");
            Section section3 = new Section("English");

            Child child1 = new Child("Varya");
            Child child2 = new Child("Egor");
            Child child3 = new Child("Dima");
            Child child4 = new Child("Adam");

            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);

            child4.addSection(section1);
            child4.addSection(section2);
            child4.addSection(section3);

            session.persist(section1);
            session.persist(child4);



            System.out.println("BEFORE DELETE");
            for (Section s : child4.getSections()){
                System.out.println(s);
            }
            session.getTransaction().commit();

            Session session2 = factory.openSession();
            session2.beginTransaction();

            Section deleteSection = session2.get(Section.class, 3);
            System.out.println(deleteSection);
            session2.delete(deleteSection);
            session2.getTransaction().commit();

            Session session3 = factory.openSession();
            Child changedChild = session3.get(Child.class, 4);

            System.out.println("AFTER DELETE");

            for (Section s : changedChild.getSections()){
                System.out.println(s);
            }

        }
    }
}
