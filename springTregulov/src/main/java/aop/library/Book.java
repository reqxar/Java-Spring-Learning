package aop.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преустпление и наказание")
    private String bookName;
    @Value("1866")
    private int year;
    @Value("Ф.М Достоевский")
    private String authorName;

    public String getBookName() {
        return bookName;
    }

    public int getYear() {
        return year;
    }

    public String getAuthorName() {
        return authorName;
    }
}
