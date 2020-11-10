import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    private static short count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        response.setContentType("text/html");

        Object id = session.getAttribute("id");

        if (id == null) {
            session.setAttribute("message", "Welcome!");
            session.setAttribute("id", ++count);
        }

        request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
    }

}
