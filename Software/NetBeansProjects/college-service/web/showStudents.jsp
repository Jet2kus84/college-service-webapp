<%-- 
    Document   : showStudents
    Created on : Jun 11, 2015, 7:12:03 PM
    Author     : Jet2kus84
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="edu.depaul.djohn.entity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.depaul.djohn.service.Crud"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="collegeService.css">
        <title>Students Enrolled</title>
    </head>
    <body id="addRemove">
        <h1 align="center">Show Students</h1> <hr>
        
    <div align="center">
    <sql:query var="result" dataSource="jdbc/se554-db">
            SELECT * FROM STUDENT WHERE STUDENTID = STUDENTID
        </sql:query>
            
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
            
    </div>
        <footer>
	<p align="center"> 
		<a href="index.html">Home</a><br>
                <a href="professor.html">Back</a><br>
	</p>
	</footer>
    </body>
</html>
