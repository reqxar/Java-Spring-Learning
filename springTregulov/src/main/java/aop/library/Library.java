package aop.library;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class Library {
    public void getBook(){
        System.out.println("Мы взяли книгу");
        System.out.println("--------------------");
    }

    public void returnBook(){
        System.out.println("Мы вернули книгу");
        System.out.println("--------------------");
    }

    public void addBook(String name, Book book){
        System.out.println("Мы добавили книгу");
        System.out.println("--------------------");
    }
}
