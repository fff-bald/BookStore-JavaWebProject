package fff_magic.dao.impl;

import fff_magic.bean.Book;
import fff_magic.bean.Order;
import fff_magic.bean.OrderItem;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` orderid,`create_time` createtime,`price`,`status`,`user_id` userid from t_order ";
        return queryForList(Order.class, sql);
    }

    @Override
    public int send(String orderId) {
        String sql = "update t_order set status=1 where order_id=?";
        return update(sql,orderId);
    }

    @Override
    public int queryOrderItemCountByOrderId(String orderId) {
        String sql = "select count(*) from t_order_item where order_id=?";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<OrderItem> queryForItems(String orderId) {
        String sql = "select `id` , `name` , `count`, `price` , `total_price` totalprice , `order_id` orderid from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,orderId );
    }
}
