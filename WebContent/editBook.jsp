<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.library.model.Book" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Library System - Edit Information</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="wrap">

            <div id="header">
                <h1> <a href="home.jsp"> Book Information </a> </h1>
            </div>

            <div id="menu">  </div>

            <div id="content">
                <h2> Update Information </h2>
                    <form action="${pageContext.request.contextPath}/EditBookServlet" method="post" id="general-form">
                    <fieldset>
                        <legend> Basic Information </legend>
                        <ol>
                            <li> <label for="newTitle"> Title: </label>
                                <input type="text" id="newTitle" name="newTitle" value="${requestScope.title}"/> </li>
                            <li> <label for="newAuthor"> Author: </label>
                                <input type="text" id="newAuthor" name="newAuthor" value="${requestScope.author}"/> </li>
                            <li> <label for="newEdition"> Edition: </label>
                                <input type="text" id="newEdition" name="newEdition" value="${requestScope.edition}"/> </li>
                            <li> <label for="newPublisher"> Publisher: </label>
                                <input type="text" id="newPublisher" name="newPublisher" value="${requestScope.publisher}"/> </li>
                            <li> <label for="newPublicationYear"> Publication year: </label>
                                <input type="text" id="newPublicationYear" name="newPublicationYear" value="${requestScope.publicationYear}"/> </li>
                            <li> <label for="newType"> Type: </label>
<% String[] arr = {"General works", "Philosophy and psychology", "Religion", "Social sciences", "Language", "Science (including mathematics)", "Technology and applied Science", "Arts and recreation", "Literature", "History, geography, and biography"}; %>
                                <select id="newType" name="newType" value="${requestScope.type}">
                                <% for(int i = 0; i < arr.length; i++) { %>
                                    <option <% if(arr[i].equals(request.getAttribute("type"))) out.print(" selected=\"true\""); %> >
                                        <%= arr[i] %>
                                    </option> <% } %>
                                </select> </li>
                        </ol>
                    </fieldset>
                    <input type="hidden" name="title" value="${requestScope.title}"/>
                    <input type="hidden" name="author" value="${requestScope.author}"/>
                    <input type="hidden" name="edition" value="${requestScope.edition}"/>
                    <input type="hidden" name="publisher" value="${requestScope.publisher}"/>
                    <input type="hidden" name="publicationYear" value="${requestScope.publicationYear}"/>
                    <input type="hidden" name="type" value="${requestScope.type}"/>
                    <input type="submit" value="Update" name="update"/>
                </form>
                <div style="clear: both;"></div>
        <j:choose>
            <j:when test="${requestScope.error}">
                <p class="error"> Edition or year not whole number. </p>
            </j:when>
        </j:choose>
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
