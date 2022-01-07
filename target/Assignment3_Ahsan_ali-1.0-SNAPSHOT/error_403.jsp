<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : error_403
    Created on : Feb 19, 2021, 8:38:46 AM
    Author     : Ahsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='styles/main.css' type='text/css' />
        <title>HTTP 403 - Forbidden</title>
    </head>
    <body>
        <h1 style="display: inline">HTTP 403 - Forbidden</h1> 
        <br><br>
        <p>Access to the requested resource has been denied. 
            The server understood the request but refuses to authorize it.
            <br>Logout and use another account to login.</p>
        <hr>
        <h3><a href="index.html">Go Back</a></h3>
        <a href="http://localhost:8080/Assignment3_Ahsan_Ali/logout">Log Out</a>
        <!-- added full localhost:8080 link as it is no longer needed to use secure protocol 8443 -->
    </body>
</html>
