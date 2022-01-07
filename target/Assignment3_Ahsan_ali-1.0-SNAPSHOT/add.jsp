<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : add
    Created on : Mar 15, 2021, 12:21:25 PM
    Author     : Ahsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='styles/main.css' type='text/css' />
        <title>Add a Worker</title>
    </head>
    <body>
        <h1 style="display: inline">Add A Worker</h1> 
        <a style="margin-left: 7em;" href="http://localhost:8080/Assignment3_Ahsan_Ali/logout">Logout</a>
        <!-- added full localhost:8080 link as it is no longer needed to use secure protocol 8443 -->
        <hr>
        <c:if test="${not empty message}">
            <p style="font-weight: bold;">${message}</p>
        </c:if>
        <c:if test="${not empty worker}">
            <p style="font-weight: bold;">${worker}</p>
        </c:if>
        <form action="add" method="POST">
            <label>ID:</label>
            <input type="text" name="id" value="" /><br><br>
            
            <label>Full Name:</label>
            <input type="text" name="name" value="" /><br><br>
            
            <label>Salary:</label>
            <input type="text" name="salary" value="" /><br><br>
            
            <input type="submit" name="button" value="Add To DB" /><br><br>
        </form>
        <hr><br>
        
        <a href="index.html">Go Back</a>
    </body>
</html>
