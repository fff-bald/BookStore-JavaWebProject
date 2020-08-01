package fff_magic.web;

import fff_magic.bean.*;
import fff_magic.service.impl.OrderService;
import fff_magic.service.impl.OrderServiceImpl;
import fff_magic.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     *  生成订单
     *  @param req
     *  @param resp
     *  @throws ServletException
     *  @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        //req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    /**
     * 订单管理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过 OrderService 查询全部订单
        List<Order> orders = orderService.listOrders();
        //2 把全部订单保存到 Request 域中
        req.setAttribute("orders", orders);
        //3、请求转发
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    /**
     * 送货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService.send(req.getParameter("oid"));
        req.getRequestDispatcher("/orderServlet?action=listOrder").forward(req, resp);
    }

    /**
     * 获得订单详细信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void imformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1 通过 OrderService 查询全部订单
        List<OrderItem> items = orderService.listOrderItems(req.getParameter("oid"));
        //2 把全部订单保存到 Request 域中
        req.setAttribute("oid", req.getParameter("oid"));
        req.setAttribute("items", items);
        //3、请求转发
        req.getRequestDispatcher("/pages/order/order_message.jsp").forward(req, resp);
    }
}
