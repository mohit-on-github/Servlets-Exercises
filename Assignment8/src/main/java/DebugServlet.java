import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debug")
public class DebugServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // System.out.println debugging
        System.out.println("System.out.println: Debugging message");

        // Message Logging
        getServletContext().log("Message Logging: Debugging message");

        // Comments as debugging notes
        // Comment: Debugging message using comments

        // Client & Server Headers
        String clientInfo = "Client Address: " + request.getRemoteAddr() + ", User Agent: " + request.getHeader("User-Agent");
        String serverInfo = "Server Info: " + getServletContext().getServerInfo();

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Debugging Demo</h2>");
        response.getWriter().println("<p>" + clientInfo + "</p>");
        response.getWriter().println("<p>" + serverInfo + "</p>");
        response.getWriter().println("</body></html>");
    }
}