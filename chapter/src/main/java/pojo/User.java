package pojo;

import lombok.Data;
//使用Lombok插件 系统（尤其是框架）会默认参数和方法是对应的
@Data  //这个注解会自动生成get和set方法以及toString等方法
public class User {
   private String username;
   private String password;

    public User(String username, String password) {
    }

    public User() {

    }
}
