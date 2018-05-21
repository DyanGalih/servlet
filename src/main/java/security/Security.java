package security;

import javax.servlet.http.HttpServletRequest;

public class Security {
    public boolean login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }else{
            return false;
        }
    }
}
