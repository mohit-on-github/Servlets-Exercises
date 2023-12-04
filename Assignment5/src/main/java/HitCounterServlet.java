
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HitCounter")
public class HitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true); 

        Integer hitCount = (Integer) session.getAttribute("hitCount");
        if (hitCount == null) {
            hitCount = 1;
        } else {
            hitCount++;
        }

        session.setAttribute("hitCount", hitCount);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Page Hit Counter</h2>");
        response.getWriter().println("<p>Total Hits: " + hitCount + "</p>");
        response.getWriter().println("</body></html>");
    }
}
