package dao;

import java.sql.*;
import java.util.Collection;

public class DBUtils1 {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac?useSSL=false","root","111111");
            } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭connection
    public static void close(Connection connection){
        if (connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    //关闭statement
    public static void close(Statement statement){
        if (statement != null){
            try {
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    //关闭resultset
    public static void close(ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    //关闭全部
    public static void close(Connection connection,Statement statement ,ResultSet resultSet){
        close(resultSet);
        close(statement);
        close(connection);
    }
    //关闭全部
    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        close(resultSet);
        close(preparedStatement);
        close(connection);
    }
}
