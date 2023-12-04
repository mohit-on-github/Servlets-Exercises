import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Map<String, String> loginTable;

    public void init() throws ServletException {
        loginTable = new HashMap<>();
     
        loginTable.put("admin", "admin");
        loginTable.put("mohit", "1234");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginTable.containsKey(username) && loginTable.get(username).equals(password)) {
            out.println("Name/Password Match");
        } else {
            out.println("Name/Password Does Not Match");
        }
    }
}
