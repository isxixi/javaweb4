package dao;

import java.sql.*;

public class DBUtils {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
          //1.加载数据库驱动
         //com.mysql.cj.jdbc.Driver：mysql 7或8以上版本
        //Class.forName:Class本身就是一个对象，然后这个对象可以解析所有的Java类或对象，反射机制。
       Class.forName("com.mysql.cj.jdbc.Driver");
       //2.创建和数据库的链接，使用DriverManager下的getConnection方法,有三个参数，url,user,password
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac","root","111111");       //3.创建Statement对象，写sql语句
       Statement statement = connection.createStatement();
       String sql = "select * from product";
       //4.执行sql语句，返回结果
       ResultSet resultSet = statement.executeQuery(sql);
       //5.遍历ResultSet数据集合，展示查询所得数据
        while (resultSet.next()){
           System.out.println("ID：" + resultSet.getInt(1) );
            System.out.println("Name：" + resultSet.getString(2));
            System.out.println("Count:" + resultSet.getInt(3));
            System.out.println("Price:" + resultSet.getDouble(4));
       }
         resultSet.close();
         statement.close();
         connection.close();
    }

}
