package controller;

import bean.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println(book);
        return "{'module':'book save'}";
    }

    @GetMapping
    public List<Book> getAll() {
        System.out.println("books is running!");
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "计算机类", "SpringMVC终极开发", "这是一本好书"));
        bookList.add(new Book(2, "计算机类", "SpringMBoot终极开发", "这是一本好书"));
        return bookList;
    }
}
