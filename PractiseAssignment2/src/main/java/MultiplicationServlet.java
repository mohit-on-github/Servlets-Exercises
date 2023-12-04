import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/table")
public class MultiplicationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Multiplication Table of 12</h2>");
        
        response.getWriter().println("<table border='1'>");
        for (int i = 1; i <= 10; i++) {
            response.getWriter().println("<tr><td>" + 12 + " x " + i + "</td><td>" + (12 * i) + "</td></tr>");
        }
        response.getWriter().println("</table>");
        
        response.getWriter().println("</body></html>");
    }
}