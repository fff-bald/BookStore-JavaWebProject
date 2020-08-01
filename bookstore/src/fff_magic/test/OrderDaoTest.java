package fff_magic.test;

import fff_magic.bean.Order;
import fff_magic.bean.OrderItem;
import fff_magic.dao.impl.OrderDao;
import fff_magic.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public  void queryOrders(){
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order: orderDao.queryOrders())
        {
            System.out.println(order.toString());
        }
    }
    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567891",new Date(),new BigDecimal(100),0, 1));
    }
    @Test
    public void queryForItems() {
        OrderDao orderDao = new OrderDaoImpl();
        for (OrderItem oi: orderDao.queryForItems("15962572210132")) {
            System.out.println(oi.toString());
        }
    }
}