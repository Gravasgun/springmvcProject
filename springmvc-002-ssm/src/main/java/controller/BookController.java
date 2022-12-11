package controller;

import bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result insert(@RequestBody Book book) {
        boolean flag = bookService.insert(book);
        return new Result(flag ? Code.INSERT_SUCCESS : Code.INSERT_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_SUCCESS : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_SUCCESS : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id) {
        Book book = bookService.select(id);
        Integer code = book != null ? Code.SELECT_SUCCESS : Code.SELECT_ERR;
        String message = book != null ? "查询成功" : "数据查询失败，请重试";
        return new Result(code, book, message);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> bookList = bookService.selectAll();
        Integer code = bookList != null ? Code.SELECT_SUCCESS : Code.SELECT_ERR;
        String message = bookList != null ? "查询成功" : "数据查询失败，请重试";
        return new Result(code, bookList, message);
    }
}
