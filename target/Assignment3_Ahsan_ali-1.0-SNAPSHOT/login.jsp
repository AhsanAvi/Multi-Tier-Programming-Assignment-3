<%-- 
    Document   : login
    Created on : Mar 15, 2021, 12:22:02 PM
    Author     : Ahsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='styles/main.css' type='text/css' />
        <title>Login</title>
    </head>
    <body>
        <h1 style="display: inline">Login</h1> 
        <hr>
        <form action="j_security_check" method="POST">
            <label>Username:</label>
            <input type="text" name="j_username" value="" /><br><br>
            <label>Password</label>
            <input type="text" name="j_password" value="" /><br><br>
            
            <input type="submit" value="Login" />
        </form>
        <hr>
        <p>For testing,<br> use <b>admin/admin</b> or <b>guest/guest</b></p><br>
        <a href="index.html">Go Back</a>
    </body>
</html>
