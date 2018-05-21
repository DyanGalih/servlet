package security;

import java.io.Serializable;
import java.util.List;

public class UserBean implements Serializable {
    private boolean isLogin = false;

    private String name = null;

    private List list;

    public UserBean(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setIsLogin(boolean isLogin){
        this.isLogin = isLogin;
    }

    public boolean getIsLogin(){
        return this.isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
