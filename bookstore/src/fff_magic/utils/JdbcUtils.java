package fff_magic.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource = null;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            // 读取 jdbc.properties 属性配置文件
            Properties pro = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //加载数据库连接池配置信息
            pro.load(resourceAsStream);
            // 创建 数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池中的连接
     * @return 如果返回 null,说明获取连接失败,有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if (conn == null) {
            try {conn = dataSource.getConnection();
                //从数据库连接池中获取连接
                conns.set(conn);
                // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
                conn.setAutoCommit(false);
                // 设置为手动管理事务
                 } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，关闭并释放连接
     */
    public static  void  commitAndClose() {
        Connection connection = conns.get();
        if(connection!=null){
            //说明之前使用过连接
            try {
                connection.commit();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，关闭并释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if(connection!=null){
            //说明之前使用过连接
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }
}
