package mapper;

import bean.Book;

import java.util.List;

public interface BookMapper {
    public boolean insert(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book select(Integer id);

    public List<Book> selectAll();
}
