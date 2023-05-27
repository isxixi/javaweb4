package dao;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    @Test
    public void testSelect(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //获取Connection对象
            connection = DBUtils1.getConnection();
            statement = connection.createStatement();
            String sql = "select * from product";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID：" + resultSet.getInt(1) );
                System.out.println("Name：" + resultSet.getString(2));
                System.out.println("Count:" + resultSet.getInt(3));
                System.out.println("Price:" + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils1.close(connection,statement,resultSet);
        }

    }
    @Test
    public void selectByName(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
//        String  variable = "苹果";
        try {
            //获取Connection对象
            connection = DBUtils1.getConnection();
            statement = connection.createStatement();
            String sql = "select * from product ";
//            where name = '"+ variable +" '
            resultSet = statement.executeQuery(sql);
            System.out.println(resultSet.next());
            while (resultSet.next()){
                System.out.println("ID：" + resultSet.getInt(1) );
                System.out.println("Name：" + resultSet.getString(2));
                System.out.println("Count:" + resultSet.getInt(3));
                System.out.println("Price:" + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils1.close(connection,statement,resultSet);
        }

    }
    @Test
    public void insert(){
        Connection connection = null;
        Statement statement = null;
        int num =0;
        String  variable = "苹果";
        try {
            //获取Connection对象
            connection = DBUtils1.getConnection();
            statement = connection.createStatement();
            String sql = "insert into product(name ,count ,price) values ('梨',1,2)";
            num = statement.executeUpdate(sql);
            System.out.println(num);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils1.close(connection);
            DBUtils1.close(statement);
        }
    }
    //junit要求返回值为空且为public类型
    @Test
    public void selectByNamePreparedStatement() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String  variable = "苹果";
        try {
            //获取Connection对象
            connection = DBUtils1.getConnection();
            String sql = "select * from product where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"variable");
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.println("ID：" + resultSet.getInt(1) );
                System.out.println("Name：" + resultSet.getString(2));
                System.out.println("Count:" + resultSet.getInt(3));
                System.out.println("Price:" + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils1.close(connection,preparedStatement,resultSet);
        }

    }
    @Test
    public void insertProduct() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = DBUtils1.getConnection();
        String sql = "insert into product(name, count , price , time) values  (?, ? , ? , ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"水浒传");
        preparedStatement.setInt(2,50);
        preparedStatement.setDouble(3,51.99);
       //时间问题 MySQL的时间类型和Java中的时间类型不完全一致，在保存时间时需要使用Java.sql包下的时间类型转换java.util包下边的时间类型
        preparedStatement.setTimestamp(4,Timestamp.valueOf(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())));
        int num = preparedStatement.executeUpdate();
        System.out.println(num);
    }
    @Test
    public void updatePreparedStatement() throws SQLException{
        int purchaseNum = 3;
        String name = "水浒传";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = DBUtils1.getConnection();
        String sql = "update product set count = count - ? where name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(1,purchaseNum);
        int num = preparedStatement.executeUpdate();
        System.out.println(num);
    }
}
