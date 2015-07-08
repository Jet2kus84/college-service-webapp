<%-- 
    Document   : studentLogin
    Created on : Jun 10, 2015, 3:12:21 AM
    Author     : Jet2kus84
--%>

<%@page import="edu.depaul.djohn.entity.Password"%>
<%@page import="edu.depaul.djohn.sessionbeans.PasswordSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="collegeService.css">
        <title>Student Login</title>
    </head>
    <body>
        <h1 align="center">Sign-in To Student Account</h1>
 	<%
 		PasswordSessionBean pwd = 
                        (PasswordSessionBean) session.getAttribute("PasswordSessionBean");
                
 		if(pwd != null ) {
                    for(Password p : pwd.findAll(Password.class, "PASSWORD")) {
			String username = p.getActivePassword()[0];
			String password = p.getActivePassword()[1];
		
			//redirect user
			if(username.equalsIgnoreCase("student") && 
                                password.equalsIgnoreCase("stu2015")) {
				response.sendRedirect("student.html");
			}
			else {
                            out.println(
                            "<fieldset id=\"login\"><legend><b><font size=\"4\">Enter Password</font></b></legend>" 
                            + "<form action=\"processLogin.jsp\" method=\"POST\">" +
                            "<table border=\"1\"><tr><td>Username:" +
                            "</td><td><input type=\"text\" name=\"username\"></td>" 
                            + "</tr><tr><td>Password:</td><td><input type=\"text\" name=\"password\"></td></tr>"
                            + "</table><input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">"
                            + "</form></fieldset>"
                                        );
                            break;
			}
                    }
                }
                else {
 			out.println(
 			"<fieldset id=\"login\"><legend><b><font size=\"4\">Enter Password</font></b></legend>" 
 			+ "<form action=\"processLogin.jsp\" method=\"POST\">" +
                        "<table border=\"1\"><tr><td>Username:" +
                        "</td><td><input type=\"text\" name=\"username\"></td>" 
                        + "</tr><tr><td>Password:</td><td><input type=\"text\" name=\"password\"></td></tr>"
 			+ "</table><input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">"
 			+ "</form></fieldset>"
                                    );
 		}
 	%>
    </body>
</html>
