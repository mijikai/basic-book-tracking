<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.library.model.Book" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Library System - Search Result</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="wrap">

            <div id="header">
                <h1> <a href="home.jsp"> Book Information </a> </h1>
            </div>

            <div id="menu">  </div>

            <div id="content">
                <h2> Search Result </h2>
             <j:forEach  var="Book" items="${bookList}" varStatus="lineInfo">
                 <table summary="list of found books">
                    <tr>
                        <th> Title: </th>
                        <td> <j:out value="${Book.title}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Author: </th>
                        <td> <j:out value="${Book.author}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Edition: </th>
                        <td> <j:out value="${Book.edition}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Publisher: </th>
                        <td> <j:out value="${Book.publisher}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Publication year: </th>
                        <td> <j:out value="${Book.publicationYear}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Type: </th>
                        <td> <j:out value="${Book.type}"></j:out></td> 
                    </tr>
                    <tr>
                        <th> Action: </th>
                        <td>
                            <form action="${pageContext.request.contextPath}/EditBookServlet" method="post">
                                <input type="hidden" name="title" value="${Book.title}"/>
                                <input type="hidden" name="author" value="${Book.author}"/>
                                <input type="hidden" name="edition" value="${Book.edition}"/>
                                <input type="hidden" name="publisher" value="${Book.publisher}"/>
                                <input type="hidden" name="publicationYear" value="${Book.publicationYear}"/>
                                <input type="hidden" name="type" value="${Book.type}"/>
                                <input type="submit" name="edit" value="Edit" />
                                <input type="submit" name="delete" value="Delete"/>
                            </form>
                        </td>
                     </tr>
                </table>
             </j:forEach>   
            </div>

            <div id="sidebar">
                <h3> Navigation </h3>
                <ul>
                    <li> <a href="${pageContext.request.contextPath}/home.jsp"> Home </a> </li>
                    <li> <a href="${pageContext.request.contextPath}/DisplayBookServlet">Book List</a> </li>
                    <li> <a href="${pageContext.request.contextPath}/AddBookServlet">Add Book</a> </li>
            <j:choose>
                <j:when test="${sessionScope.login}">
                    <li> <a href="${pageContext.request.contextPath}/AuthenticateServlet"> Logout </a> </li>
                </j:when>
                <j:otherwise>
                    <li> <a href="${pageContext.request.contextPath}/login.jsp"> Login </a> </li>
                </j:otherwise>
            </j:choose>
                </ul>
            </div>

            <div style="clear: both;"></div>
            <div id="footer"> </div>

        </div>
    </body>
</html>
