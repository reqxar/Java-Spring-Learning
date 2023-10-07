package aop.university;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Антон", 1, 5.5);
        Student st2 = new Student("Анна", 2, 8.5);
        Student st3 = new Student("Вова", 4, 6.5);
        Student st4 = new Student("Варя", 2, 9.5);
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
    }

    public Student getDefaultStudent(){
        Student defaultStudent = new Student("Студент", 1, 0.0);
        int a = 10/0;
        return defaultStudent;

    }

    public List<Student> getStudents(){

        return students;
    }
}
