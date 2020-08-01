package fff_magic.web;

import fff_magic.bean.Book;
import fff_magic.bean.Order;
import fff_magic.bean.User;
import fff_magic.service.impl.UserService;
import fff_magic.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 注销
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //关闭session
        request.getSession().invalidate();
        //重定向到首页
        response.sendRedirect(request.getContextPath());
    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if(login!=null){
            //登录成功
            request.getSession().setAttribute("user",login);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        } else {
            request.setAttribute("msg","用户名或密码错误！");
            request.setAttribute("username",username);
            //跳回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);

        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码后马上删除
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //验证验证码
        if(token.equalsIgnoreCase(code)&&code!=null){
            if(userService.existsUsername(username)){
                String str = "用户名[" + username + "]已存在!";
                req.setAttribute("msg",str);
                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名可用，传回数据库
                User login=userService.registUser(new User(null, username, password, email));
                req.getSession().setAttribute("user",login);
                //注册成功，跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            String str = "验证码输入有误！";
            req.setAttribute("msg",str);
            // 跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /**
     * 获得用户订单信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        // 通过 OrderService 查询用户所有订单
        List<Order> orders = userService.queryOrders(loginUser.getId());

        // 把订单保存到 Request 域中
        req.getSession().setAttribute("orders", orders);
        // 请求转发
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }
}
