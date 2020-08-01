package fff_magic.service.impl;

import fff_magic.bean.Order;
import fff_magic.bean.User;
import fff_magic.dao.impl.UserDao;
import fff_magic.dao.impl.UserDaoImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new  UserDaoImpl();

    @Override
    public User registUser(User user) {
        userDao.saveUser(user);
        return userDao.queryUserByUsername(user.getUsername());
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        } else return true;
    }

    @Override
    public List<Order> queryOrders(int userId) {
        return userDao.queryOrders(userId);
    }
}
