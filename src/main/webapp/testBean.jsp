<% // Use of PersonBean in a JSP. %>
<jsp:useBean id="person" class="security.UserBean" scope="page"/>
<jsp:setProperty name="person" property="*"/>

<html>
    <body>
        Name: <jsp:getProperty name="person" property="name"/><br/>
        Login? <jsp:getProperty name="person" property="isLogin"/><br/>
        <br/>
        <form name="beanTest" method="POST" action="testBean.jsp">
            Enter a name: <input type="text" name="name" size="50"><br/>
            Choose an option:
            <select name="isLogin">
                <option value="true">Login</option>
                <option value="false">Not Login</option>
            </select>
            <input type="submit" value="Test the Bean">
        </form>
    </body>
</html>