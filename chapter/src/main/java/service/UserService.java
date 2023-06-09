package service;

import pojo.User;

public interface UserService {
   //注册用户
    //@param user
    public void registUser(User user);
    //登录
    //@param user
 //@return 如果返回null说明登陆失败，返回有值，是登陆成功
    public User login(User user);
    //检查用户名是否可用
    //@return 返回true表示用户名已存在，返回false表示用户名可用
    public boolean existUsername(String username);
}
