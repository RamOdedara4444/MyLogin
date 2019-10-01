<%-- 
    Document   : login
    Created on : Oct 1, 2019, 1:56:03 PM
    Author     : 798125
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <h1>MyLogin</h1>
        
        <form action="login" method="post">
            Username:<input type="text" name="username"><br>
               Password:<input type="text" name="password"><br>
            <input type="submit" name="submit" value="Log in">
        </form>
        
        <span >${error}</span>
                <span>${success}</span>
    </body>
</html>
