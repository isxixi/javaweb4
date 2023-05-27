import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//1 需要对用户的登录状态进行验证，HttpSession session = request.getSession();获取session,然后判断session里的loginStatus参数，是否表明用户已经登录
//如果没有这个参数或者这个参数为False，表明用户还没有登录，之后就跳转到登录页面，请用户完成登录和注册
//如果用户已经登录，在这里实现购买操作
//购买就是将用户购买的产品信息放入到session里去
//然后跳转到订单页面，显示保存在session中的已经购买的产品信息（建议：放一个跳转按钮，可以跳转到产品列表那一页，使用户可以再次购买）
@WebServlet(name = "BuyBookServlet", value = "/BUyBookServlet")
public class BuyBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
