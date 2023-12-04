import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DigitalClockServlet")
public class DigitalClockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
    
        response.setIntHeader("Refresh", 1);
        
        // Get the current time
        String currentTime = new SimpleDateFormat("hh:mm:ss a").format(new Date());
        
        String htmlContent = "<html><head><title>Digital Clock</title></head><body>";
        htmlContent += "<h1>Digital Clock</h1>";
        htmlContent += "<p>Current Time: " + currentTime + "</p>";
        htmlContent += "</body></html>";
        
        response.getWriter().println(htmlContent);
    }
}
