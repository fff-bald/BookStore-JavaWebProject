package fff_magic.test;

import fff_magic.bean.Order;
import fff_magic.bean.User;
import fff_magic.dao.impl.UserDao;
import fff_magic.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null ){
            System.out.println("用户名可用！");
        } else { System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin1","password") != null) {
            System.out.println("用户名或密码错误，登录失败");
        } else { System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", "wzg168@qq.com")) );
    }

    @Test
    public  void queryOrders(){
        for (Order order: userDao.queryOrders(2)) {
            System.out.printf(order.toString());
        }
    }
}