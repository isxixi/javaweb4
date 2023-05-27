package controller;

import db.DB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListProductServlet", value = "/listProduct")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //进行身份验证
      String loginStatus = (String) request.getSession().getAttribute("loginStatus");
      if ("1".equals(loginStatus)){
          request.getSession().setAttribute("products", DB.getAll());
          String url = request.getServletContext().getContextPath()+"/jsp/product.jsp";
          String newUrl = response.encodeRedirectURL(url);
          response.sendRedirect(url);
//          response.sendRedirect("jsp/product.jsp");
      }else{
          response.setContentType("text/html;charset=utf-8");
          response.getWriter().println("您尚未登录，请登录再进行后续操作！");
          request.getRequestDispatcher("jsp/login.jsp").include(request,response);
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
