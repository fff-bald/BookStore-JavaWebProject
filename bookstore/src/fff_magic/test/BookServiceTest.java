package fff_magic.test;

import fff_magic.bean.Book;
import fff_magic.service.impl.BookService;
import fff_magic.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"辟邪在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(2,"社会人", "佩奇", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        for (Book book:bookService.queryBooks()
             ) {
            System.out.println(book);
        }
    }
}