package fff_magic.dao.impl;

import fff_magic.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //使用 DbUtils 操作数据库
    private QueryRunner qr = new QueryRunner();

    /**
     *  update() 方法用来执行：Insert\Update\Delete 语句
     *
     *  @return 如果返回-1,说明执行失败<,返回其他表示影响的行数
     */
    public int update(String sql, Object... args) {

        Connection con = JdbcUtils.getConnection();
        try {
            return  qr.update(con,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {

        Connection con = JdbcUtils.getConnection();
        try {
            return qr.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个 javaBean 的 sql 语句
     * @param type 返回的对象类型
     * @param sql  执行的 sql 语句
     * @param args sql 对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T>List<T> queryForList(Class<T> type, String sql, Object...args) {

        Connection con = JdbcUtils.getConnection();
        try {
            return qr.query(con,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的 sql 语句
     * @param sql  执行的 sql 语句
     * @param args sql 对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){

        Connection con = JdbcUtils.getConnection();
        try {
            return qr.query(con,sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
