package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    //update()方法用来执行：Insert/Update/Delete语句
    //@return如果返回-1说明执行失败，返回其他表示影响的行数
    public int update(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);    //关闭连接
        }
        return -1;
    }
    //查询返回一个JavaBean的sql语句
    //@param type 返回的对象类型
    //@param sql  执行的sql语句
    //@param args sql对应的参数值
    //@param <T>  返回的类型的泛型
    //@return
    public <T> T queryForOne(Class<T> type, String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
           return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    //查询返回多个javaBean的sql语句
    public <T>List<T> queryForList(Class<T> type ,String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
    //执行返回一行一列的sql语句
    //sql 执行的sql语句
    //args sql对应的参数值
    public Object queryForSingleValue(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
          return  queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
