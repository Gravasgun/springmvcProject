package service;

import bean.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {
    public boolean insert(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book select(Integer id);

    public List<Book> selectAll();
}
