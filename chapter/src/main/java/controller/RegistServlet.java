package controller;

import pojo.User;
import service.UserService;
import service.UserServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/registservlet")
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
         //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //检查用户名是否可用
        if (userService.existUsername(username)){
            //用户名存在 不可用 跳回注册页面
            System.out.println("用户名【" + username + "】不可用！");
            request.getRequestDispatcher("/jsp/regist.jsp").forward(request,response);
        }else{
            //用户名可用 调用service保存到数据库
            userService.registUser(new User(username,password));
            //跳转到注册成功页面
            response.getWriter().println("注册成功！即将跳转到登录页面！");
            response.addHeader("Refresh","5,url=http://localhost:8080/chapter/jsp/login.jsp");
            //获取字符输出流方法 实现倒计时跳转的显示
            response.getWriter().write("<script type='text/javaScript'>"+
                    "var span = document.getElementById('one');"+
                    "var i = 5;"+
                    "function fun(){"+"i--;"+"if(i>=0){"+
                    "span.innerHTML = i;"+
                    "}"+
                    "}"+
                    "window.setInterval(fun,1000);"+
                    "</script>");
        }
    }
}
