package fff_magic.web;

import fff_magic.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(req, resp);
            JdbcUtils.commitAndClose();// 提交事务
        } catch(Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
             e.printStackTrace();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
