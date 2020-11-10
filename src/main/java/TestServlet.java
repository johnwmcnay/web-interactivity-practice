import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Object id = session.getAttribute("id");
        System.out.println("id = " + id);

        if (id == null) {
            session.setAttribute("message", "Welcome!");
            session.setAttribute("id", 1);
        }

        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }
}
