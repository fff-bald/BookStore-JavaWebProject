package fff_magic.dao.impl;

import fff_magic.bean.Book;
import fff_magic.bean.Order;
import fff_magic.bean.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        if (queryUserByUsername(user.getUsername())!=null) return 1;
        else {
            String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
            return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        }
    }

    @Override
    public List<Order> queryOrders(int userId) {
        String sql = "select `order_id` orderid,`create_time` createtime,`price`,`status`,`user_id` userid from t_order where user_id=?";
        return queryForList(Order.class, sql,userId);
    }
}
