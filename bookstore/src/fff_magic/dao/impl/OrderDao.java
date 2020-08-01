package fff_magic.dao.impl;

import fff_magic.bean.Order;
import fff_magic.bean.OrderItem;

import java.util.List;

public interface OrderDao  {
    public int saveOrder(Order order);
    public List<Order> queryOrders();
    public int send(String orderId);
    public int queryOrderItemCountByOrderId(String orderId);
    public List<OrderItem> queryForItems( String orderId);
}