package controller;

import org.apache.commons.beanutils.BeanUtils;
import pojo.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //将前端保存的数据传入user
       User user = new User();
        try {
            //被封装的JavaBean必须是标准的Java类
            //该JavaBean必须被public所修饰
            //必须提供空构造器
            //成员变量必须私有化，被private所修饰
            //提供公共的setter和getter方法
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       //以下可以用数据库
//        if ("admin".equals(user.getUsername())&&"1234".equals(user.getPassword())){
//            request.getSession().setAttribute("loginStatus","1");
//            String url = request.getServletContext().getContextPath()+"/listProduct";
//            String newUrl = response.encodeRedirectURL(url);
//            response.sendRedirect(newUrl);
////            response.sendRedirect("listProduct");
//
//        }else{
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("用户名或者密码不正确，请重新输入！");
//            request.getRequestDispatcher("jsp/login.jsp").include(request,response);
//        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用userService.login()登录处理业务
        User loginUser = userService.login(new User(username, password));
        //如果等于null,登录失败 跳到登陆页面
        if (loginUser == null){
            response.setContentType("text/html;charset=utf-8");
         response.getWriter().println("用户名或者密码不正确，请重新输入！");
         request.getRequestDispatcher("jsp/login.jsp").include(request,response);
        }else {
            //登录成功 跳到product页面
            request.getSession().setAttribute("loginStatus","1");
//          String url = request.getServletContext().getContextPath()+"/listProduct";
//           String newUrl = response.encodeRedirectURL(url);
//           response.sendRedirect(newUrl);
           response.sendRedirect("listProduct");
        }
    }
}
