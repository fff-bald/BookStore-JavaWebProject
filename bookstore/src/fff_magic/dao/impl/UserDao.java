package fff_magic.dao.impl;

import fff_magic.bean.Book;
import fff_magic.bean.Order;
import fff_magic.bean.User;

import java.util.List;

public interface UserDao {
    /** 根据用户名查询用户信息
     * @param username 用户名
     *  @return 如果返回 null,说明没有这个用户。反之亦然
     */
    public User queryUserByUsername(String username);

    /** 根据 用户名和密码查询用户信息
     * @param username
     * @param password * @return 如果返回 null,说明用户名或密码错误,反之亦然
    `*/
    public User queryUserByUsernameAndPassword(String username,String password);

    /**  保存用户信息
     * @param user
     *  @return 返回-1 表示操作失败，其他是 sql 语句影响的行数
     */
    public int saveUser(User user);

    /**
     * 返回用户订单信息
     * @return
     */
    public List<Order> queryOrders(int userId);
}
