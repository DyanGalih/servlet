import security.Security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        Security security = new Security();
        if(security.login(request)){
            String name = request.getParameter("username");
            out.print("Welcome, "+name);
            HttpSession session=request.getSession();
            session.setAttribute("name",name);
        }
        else{
            out.print("Sorry, username or password not match please try again");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
