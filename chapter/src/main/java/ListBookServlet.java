import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//展示所有产品
@WebServlet(name = "ListBookServlet", value = "/listbook")
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         1在文件里一个一个的写
//        2仿照之前Book的那个例子，写一个类方法作为本地数据库，或者就在一个本地文件里保存产品信息（例如，进阶版和白金版作业）
//        3放一个点击购买的操作（可以是超链接，也可以是按钮），点击之后跳到一个新的servlet，BuyBookServlet
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
