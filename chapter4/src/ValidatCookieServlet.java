import solve.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ValidatCookieServlet", value = "/validatecookie")
public class ValidatCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userName = request.getParameter("userName");
      String userPass = request.getParameter("userPass");
      String ck1 = request.getParameter("checkbox");
      response.setContentType("text/html;charset=utf-8");
      if ("admin".equals(userName)&&"123".equals(userPass)){
          if (ck1 == null){
              Cookie c = new Cookie("users",userName+"-"+userPass);
              c.setMaxAge(0);
              response.addCookie(c);
          }else {
              Cookie c = new Cookie("users",userName+"-"+userPass);
              c.setMaxAge(60*60*24*3);
              response.addCookie(c);
          }
          User user = new User(userName,userPass);
          request.setAttribute("user",user);
          RequestDispatcher rd = request.getRequestDispatcher("/jsp/welcomecookie.jsp");
          rd.forward(request,response);
      }else {
          response.getWriter().println("用户名或密码错误，请重新输入！");
          RequestDispatcher rd = request.getRequestDispatcher("/jsp/indexcookie.jsp");
          rd.include(request,response);
      }
    }
}
