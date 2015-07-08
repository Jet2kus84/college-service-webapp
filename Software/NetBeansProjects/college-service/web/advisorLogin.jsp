<%-- 
    Document   : login
    Created on : Jun 9, 2015, 9:45:54 PM
    Author     : Deonte Johnson
--%>

<%@page import="edu.depaul.djohn.entity.Password"%>
<%@page import="edu.depaul.djohn.sessionbeans.PasswordSessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="collegeService.css">
        <title>Login</title>
    </head>
    <body>
            <h1 align="center">Sign-in To Advisor Account</h1>
 	<%
 		PasswordSessionBean pwd = 
                        (PasswordSessionBean) session.getAttribute("PasswordSessionBean");
                
 		if(pwd != null ) {
                    for(Password p : pwd.findAll(Password.class, "PASSWORD")) {
                        //if(p.getPasswordExcepted()) {
			String username = p.getActivePassword()[0];
			String password = p.getActivePassword()[1];
		
			//redirect user
			if(p.getType().equalsIgnoreCase("Advisor")) {
				response.sendRedirect("admin_add_remove.html");
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
