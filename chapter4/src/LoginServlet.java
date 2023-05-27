import solve.User;

import javax.security.auth.login.LoginException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//获取登录页面输入的用户名与密码
        String password = request.getParameter("password");
        System.out.println(username+";"+password);
        UserService service = new UserService();//调用service完成登录操作
        try{
            User user = service.login(username,password);
            System.out.println(user.getUsername()+";"+user.getPassword());
            request.getSession().setAttribute("user",user);
            String[] ck1 = request.getParameterValues("checkbox");
            if(ck1==null){
                Cookie c = new Cookie("users",username+"-"+password);
                c.setMaxAge(0);
                response.addCookie(c);
                System.out.println("===step3");
            }else{
                Cookie c =new Cookie("users",username +"-" +password );
                c.setMaxAge(60*60*24*3);
                response.addCookie(c);
//                if ("ok".equals(ck1[0])){
//                    Cookie c = new Cookie("users",username+"-"+password);
//                    c.setMaxAge(60*60*24*3);
//                    response.addCookie(c);
//                    System.out.println("===step1");
//                }else if("ok".equals(ck1[0])){
//                    Cookie c = new Cookie("users",username + "-" + "");
//                }
            }
            String role = user.getRole();
            if ("超级用户".equals(role)){
                response.sendRedirect(request.getContextPath()+"/jsp/welcomecookie.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (LoginException e){
//            e.printStackTrace();
//            request.setAttribute("register_message",e.getMessage());
//            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
//        }
    }
}
