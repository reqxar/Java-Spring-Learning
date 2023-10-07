package aop;

import aop.library.Book;
import aop.library.Library;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testRunner1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        Book book = context.getBean("book", Book.class);


        Library library = context.getBean("library", Library.class);
        library.getBook();
        library.returnBook();
        library.addBook("Yuriy", book);

        context.close();
    }
}
