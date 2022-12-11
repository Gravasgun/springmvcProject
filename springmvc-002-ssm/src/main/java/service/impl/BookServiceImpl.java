package service.impl;

import bean.Book;
import controller.Code;
import exception.BusinessException;
import exception.SystemException;
import mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean insert(Book book) {
        boolean flag = bookMapper.insert(book);
        return flag;
    }


    public boolean update(Book book) {
        boolean flag = bookMapper.update(book);
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = bookMapper.delete(id);
        return flag;
    }

    @Override
    public Book select(Integer id) {
//        if (id == 3) {
//            throw new BusinessException(Code.BUSINESS_ERR, "请不要使用你的技术挑战我的耐性!");
//        }
//
//
//        //模拟系统异常，将可能出现的异常进行包装，转换成自定义异常
//        try{
//            int i = 1/0;
//        }catch (Exception e){
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"服务器访问超时，请重试!",e);
//        }
        Book book = bookMapper.select(id);
        return book;
    }

    @Override
    public List<Book> selectAll() {
        List<Book> bookList = bookMapper.selectAll();
        return bookList;
    }
}
