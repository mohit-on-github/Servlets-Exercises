

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SpanishGreetings
 */
@WebServlet("/spanish_greetings")
public class SpanishGreetings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpanishGreetings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Locale spanishLocale = new Locale("es","ES");
		
		ResourceBundle message = ResourceBundle.getBundle("i18n.messages",spanishLocale);
		String msg = message.getString("hello.message");
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss",spanishLocale);
		String localtime = sdf.format(new Date());
		
		PrintWriter out = response.getWriter();
		out.println("<html<body><h1>");
		out.println(msg+"</h1>");
		out.println("<h2>"+localtime+"</h2>");
		out.println("</body><html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
