package fff_magic.web;

import fff_magic.bean.Book;
import fff_magic.bean.Page;
import fff_magic.service.impl.BookService;
import fff_magic.service.impl.BookServiceImpl;
import fff_magic.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();
    /*** 处理分页功能
     *  @param req
     *  @param resp
     *  @throws ServletException
     *  @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用 BookService.page(pageNo，pageSize)：Page 对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3 保存 Page 对象到 Request 域中
        req.setAttribute("page",page);
        //4 请求转发到 pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    /***
     * 查找处于价格区间内的书目信息
     *  @param req
     *  @param resp
     *  @throws ServletException
     *  @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        //2 调用 BookService.page(pageNo，pageSize)：Page 对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder str = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("max")!=null){
            str.append("&max=").append(req.getParameter("max"));
        }
        if(req.getParameter("min")!=null){
            str.append("&min=").append(req.getParameter("min"));
        }
        page.setUrl(str.toString());
        //3 保存 Page 对象到 Request 域中
        req.setAttribute("page",page);
        //4 请求转发到 pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
