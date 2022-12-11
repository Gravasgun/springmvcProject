import bean.Book;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BookService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testSelect() {
        Book book = bookService.select(1);
        System.out.println(book);
    }

    @Test
    public void testSelectAll() {
        List<Book> bookList = bookService.selectAll();
        System.out.println(bookList);
    }

    @Test
    public void testInsert() {
        bookService.insert(new Book(null, "汽车类", "汽车大全", "好多车！"));
    }

    @Test
    public void testDelete(){
        bookService.delete(3);
        bookService.delete(4);
    }

    @Test
    public void testUpdate(){
        boolean flag = bookService.update(new Book(2, "美食类", "中国美食", "中国美食真好吃"));
    }
}
