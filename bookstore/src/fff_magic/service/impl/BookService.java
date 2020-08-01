package fff_magic.service.impl;

import fff_magic.bean.Book;
import fff_magic.bean.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> page(int pageNo, int pageSize);
    public Page<Book> pageByPrice(int pageNo, int pageSize,int max,int min);
}
