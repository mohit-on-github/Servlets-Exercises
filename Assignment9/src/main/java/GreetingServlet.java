
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Determine the user's preferred locale based on the browser settings
        Locale locale = request.getLocale();
        
        // Load the appropriate resource bundle based on the user's locale
        ResourceBundle messages = ResourceBundle.getBundle("resources.messages", locale);
        
        // Get the localized greeting message
        String greeting = messages.getString("greeting");
        
        // Get the localized time format
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
        String localizedTime = timeFormat.format(new Date());
        
        // Generate the HTML content
        String htmlContent = "<html><head><title>Localized Greeting</title></head><body>";
        htmlContent += "<h2>" + greeting + "</h2>";
        htmlContent += "<p>Localized Time: " + localizedTime + "</p>";
        htmlContent += "</body></html>";
        
        // Write the HTML content to the response
        response.getWriter().println(htmlContent);
    }
}
