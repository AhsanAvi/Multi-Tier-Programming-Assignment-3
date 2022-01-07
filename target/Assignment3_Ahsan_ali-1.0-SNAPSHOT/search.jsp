<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : search
    Created on : Mar 15, 2021, 12:22:20 PM
    Author     : Ahsan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='styles/main.css' type='text/css' />
        <title>Search For Workers</title>
    </head>
    <body>
        <h1 style="display: inline">Search For Workers</h1> 
        <a style="margin-left: 3em;" href="http://localhost:8080/Assignment3_Ahsan_Ali/logout">Logout</a>
        <!-- added full localhost:8080 link as it is no longer needed to use secure protocol 8443 -->
        <hr>
        
        <form action="search" method="POST">
            <label>Min. Salary</label>
            <input type="text" name="minSal" value="${minSal}" /><br><br>
            
            <label>Max. Salary</label>
            <input type="text" name="maxSal" value="${maxSal}" /><br><br>
            
            <input type="submit" name="button" value="Search Workers" /><br><br>
        </form>
        
        <hr>
        <p style="font-weight: bold">Search Results</p>
        
        <c:if test="${not empty message}">
            <p style="font-weight: bold;">${message}</p>
        </c:if>
            
        <c:if test="${not empty workers}">
            <p>${resultMessage}</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Salary</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="worker" items="${workers}" varStatus="i">
                        <tr>
                            <td>${i.count}</td>
                            <td>${worker.id}</td>
                            <td>${worker.name}</td>
                            <td>$${worker.salary}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p style="font-weight: bold">Total Workers: ${workerCounter}</p>
            <p style="font-weight: bold">Average Salary: $${averageSalary}</p>
            <c:forEach var="worker" items="${topWorker}">
                <p style="font-weight: bold">Top Worker: ${worker.name} ($${worker.salary})</p>
            </c:forEach>
        </c:if>
        <hr><br>
        <a href="index.html">Go Back</a>
    </body>
</html>
