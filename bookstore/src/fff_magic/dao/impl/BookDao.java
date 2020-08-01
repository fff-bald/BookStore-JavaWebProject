package fff_magic.dao.impl;

import fff_magic.bean.Book;

import java.util.List;

public interface BookDao {
    /**
     * 往数据库中添加图书
     * @param book
     * @return 如果返回-1,说明执行失败<,返回其他表示影响的行数
     */
    public int addBook(Book book);

    /**
     * 通过图书id从数据库中删除图书
     * @param id
     * @return 如果返回-1,说明执行失败<,返回其他表示影响的行数
     */
    public int deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     * @return 如果返回-1,说明执行失败<,返回其他表示影响的行数
     */
    public int updateBook(Book book);

    /**
     * 通过图书id查找图书信息
     * @param id
     * @return 找到相关图书的实例化对象
     */
    public Book queryBookById(Integer id);

    /**
     * 查找图书信息
     * @return 返回数据库中所有图书的实例化对象，用列表存储
     */
    public List<Book> queryBooks();

    /**
     *  查找有多少种书
     * @return Interger,表示数据库中书的种类数量
     */
    public Integer queryForPageTotalCount();

    /**
     *  查找价格区间内有多少种书
     * @return Interger,表示数据库中价格区间内书的种类数量
     */
    public Integer queryForPageCountByPrice(int min, int max);

    /**
     * 同一页上的所有书的信息
     * @param begin 第一条记录的序号
     * @param pageSize  一页有多少条记录
     * @return 一个记录这一页所有图书信息的列表
     */
    public List<Book> queryForPageItems(int begin, int pageSize);

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
