package fff_magic.test;

import fff_magic.bean.OrderItem;
import fff_magic.dao.impl.OrderItemDao;
import fff_magic.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "java 从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567891"));
    }
}