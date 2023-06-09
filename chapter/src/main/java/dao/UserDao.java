package dao;

import pojo.User;

public interface UserDao {

    //根据用户名查询用户信息
    //@param username 用户名
    //@return 如果返回null,说明没有这个用户，反之亦然，查到了说明已经注册了
    public User queryUserByUsername(String username);
    //保存用户信息
    //@return 返回-1表示操作失败，其他是sql语句影响的行数
    public int saveUser(User user);
//根据用户名和密码查询用户信息
    //返回null,说明用户名或密码错误，反之亦然
    public User queryUserByUsernameAndPassword(String username,String password);

}
