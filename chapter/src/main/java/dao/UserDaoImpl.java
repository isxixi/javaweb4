package dao;

import pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String  sql = "select 'username','password' from user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
       String sql = "insert into user(`username`,`password`) values (?,?)";
       return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String  sql = "select 'username','password' from user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }
}
