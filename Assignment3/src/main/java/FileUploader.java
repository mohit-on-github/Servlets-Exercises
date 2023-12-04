import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploader")
@MultipartConfig
public class FileUploader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getPart("file").getSubmittedFileName();
        Part filePart = request.getPart("file");
        boolean overwrite = "on".equals(request.getParameter("overwrite"));

        String uploadsDir = getServletContext().getRealPath("/WEB-INF/uploads");
        File file = new File(uploadsDir, fileName);

        if (file.exists()) {
            if (overwrite) {
                filePart.write(file.getAbsolutePath());
                response.getWriter().println("File is Overwritten.");
            } else {
                response.getWriter().println("File already exists and Overwrite not checked.");
            }
        } else {
            filePart.write(file.getAbsolutePath());
            response.getWriter().println("File Written.");
        }
    }
}
