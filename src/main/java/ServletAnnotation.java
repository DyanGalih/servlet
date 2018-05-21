import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/servlet-annotation")
public class ServletAnnotation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();

        if( cookies != null ) {
            out.println("<h2> Found Cookies Name and Value</h2>");

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print("Name : " + cookie.getName( ) + ",  ");
                out.print("Value: " + cookie.getValue( ) + " <br/>");
                cookie.setMaxAge(0);
            }
        } else {
            Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
            Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

            // Set expiry date after 24 Hrs for both the cookies.
            firstName.setMaxAge(60 * 60 * 24);
            lastName.setMaxAge(60 * 60 * 24);

            // Add both the cookies in the response header.
            response.addCookie(firstName);
            response.addCookie(lastName);
        }


        String title = "Using GET / POST Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body> </html>"
        );
    }
}
