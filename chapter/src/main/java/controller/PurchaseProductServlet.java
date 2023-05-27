package controller;

import db.DB;
import pojo.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "PurchaseProductServlet", value = "/purchaseProduct")
public class PurchaseProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginStatus = (String) request.getSession().getAttribute("loginStatus");
        if ("1".equals(loginStatus)){
            String id = request.getParameter("id");
            Product product = DB.find(id);
            Collection<Product> orders = (Collection<Product>) request.getSession().getAttribute("orders");
            if (orders == null){
                orders = new ArrayList<>();
            }
            orders.add(product);
            System.out.println("orders:"+orders);
            //覆盖
            request.getSession().setAttribute("orders",orders);
//            String url = request.getServletContext().getContextPath()+"/jsp/orders.jsp";
//            String newUrl = response.encodeRedirectURL(url);
//            response.sendRedirect(url);
            response.sendRedirect("jsp/orders.jsp");
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
