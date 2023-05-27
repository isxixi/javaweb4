import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//练习cookie的创建和获取方法
//实验cookie的生命周期
@WebServlet(name = "ServletNewCookie", value = "/newcookie")
public class ServletNewCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
       request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //获取cookie
        Cookie[] cookies = request.getCookies();
        out.println("<html><body><h1>当下所有定义的Cookie</h1><table>");
        for (Cookie cookie:cookies){
            out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
        }
        out.println("</table></body></html>");
        //创建cookie
        Cookie firstCookie = new Cookie("firstCookie","这是第一个Cookie");
        //设置cookie的存在时间为八小时
        firstCookie.setMaxAge(60*60*8);
        //设置cookie的存在域，服务器名称
        firstCookie.setDomain(request.getServerName());
        //设置cookie的路径，网站或者项目的名称
        firstCookie.setPath(request.getContextPath());
        response.addCookie(firstCookie);
        //设置第二个cookie，设置为临时cookie
        Cookie secondCookie = new Cookie("secondCookie","这是第二个Cookie");
        response.addCookie(secondCookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
