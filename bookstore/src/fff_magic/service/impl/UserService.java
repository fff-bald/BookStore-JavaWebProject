package fff_magic.service.impl;

import fff_magic.bean.Order;
import fff_magic.bean.User;

import java.util.List;

public interface UserService {

    /** 注册用户
     *  @param user
     */
    public User registUser(User user);

    /*** 登录
     *  @param user
     *  @return 如果返回 null，说明登录失败，返回有值，是登录成功
     *  */
    public User login(User user);

    /*** 检查 用户名是否可用
     *  @param username
     *  @return 返回 true 表示用户名已存在，返回 false 表示用户名可用
     *  */
    public boolean existsUsername(String username);

    /**
     * 返回用户订单信息
     * @return
     */
    public List<Order>queryOrders(int userId);
}
