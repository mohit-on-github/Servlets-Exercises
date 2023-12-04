import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingAndValidationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Logging
        String ipAddress = httpRequest.getRemoteAddr();
        String requestUri = httpRequest.getRequestURI();
        System.out.println("Request from " + ipAddress + " to " + requestUri);

        // Session validation 
        if (httpRequest.getSession(false) == null) {
            request.getRequestDispatcher("/invalidSession.jsp").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
