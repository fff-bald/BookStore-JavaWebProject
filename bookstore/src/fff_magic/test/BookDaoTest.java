package fff_magic.test;

import fff_magic.bean.Book;
import fff_magic.dao.impl.BookDao;
import fff_magic.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"秀儿是怎么练成的", "杠精", new BigDecimal(9999),1100000,0,null ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(7);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,"秀儿是怎么练成的", "杠精", new BigDecimal(998),777,666,null ));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(22) );
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks())  System.out.println(queryBook);
    }


    @Test
    public void queryForPageItemsByPrice(){
        for (Book queryBook : bookDao.queryForPageItemsByPrice(0,50,0,100)) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageCountByPrice(){
        System.out.println(bookDao.queryForPageCountByPrice(0,100));
    }
    @Test
    public void queryForPageCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }
}