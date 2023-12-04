import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MultilingualTimeServlet")
public class MultilingualTimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        out.println("<html><head><title>Multilingual Time Servlet</title></head><body>");

        out.println("<h2>Hello World!</h2>");
        out.println("<p>Current time in different languages and the Pacific Time Zone:</p>");

        String[] languages = {"en", "es", "ja", "zh", "ko", "ru"};
        String[] languageNames = {"English", "Spanish", "Japanese", "Chinese", "Korean", "Russian"};

        for (int i = 0; i < languages.length; i++) {
            String language = languages[i];
            String languageName = languageNames[i];
            Locale locale = new Locale(language);

            ZoneId pacificTimeZone = ZoneId.of("America/Los_Angeles");
            String formattedTime = currentTime.atZone(pacificTimeZone).format(formatter);

            out.println("<p>" + languageName + ": " + formattedTime + "</p>");
        }

        out.println("</body></html>");
    }
}
