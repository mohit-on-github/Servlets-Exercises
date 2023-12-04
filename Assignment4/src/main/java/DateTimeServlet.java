

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateTime")
public class DateTimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");

        // Get the current date and time
        Date currentDate = new Date();

        // Format the date and time using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        String formattedDate = dateFormat.format(currentDate);

        response.getWriter().println("<h2>Current Date & Time</h2>");
        response.getWriter().println("<p>" + formattedDate + "</p>");

        response.getWriter().println("</body></html>");
    }
}
