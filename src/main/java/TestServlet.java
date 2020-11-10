import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/")
public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

//        HttpSession session = request.getSession();
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html");
//
//        Object id = session.getAttribute("id");
//
//        if (id == null) {
//            request.setAttribute("message", "Welcome!");
//            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//        } else {
//            request.setAttribute("message", "Welcome back!");
//        }
    }
}
