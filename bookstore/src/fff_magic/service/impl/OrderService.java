package fff_magic.service.impl;

import fff_magic.bean.*;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
    public List<Order> listOrders();
    public void send(String orderId);
    public List<OrderItem> listOrderItems(String orderId);
}

