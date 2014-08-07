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
        <title>Library System - Add Book</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div id="wrap">

            <div id="header">
                <h1> <a href="home.jsp"> Book Information </a> </h1>
            </div>

            <div id="menu">  </div>

            <div id="content">
                <h2> Book Form </h2>
                <form action="${pageContext.request.contextPath}/AddBookServlet" method="post" id="general-form">
                    <fieldset>
                        <legend> Add Book </legend>
                        <ol>
                            <li> <label for="title"> Title: </label>
                                <input type="text" id="title" name="title"/> </li>
                            <li> <label for="author"> Author: </label>
                                <input type="text" id="author" name="author"/> </li>
                            <li> <label for="edition"> Edition: </label>
                                <input type="text" id="edition" name="edition"/> </li>
                            <li> <label for="publisher"> Publisher: </label>
                                <input type="text" id="publisher" name="publisher"/> </li>
                            <li> <label for="publicationYear"> Publication year: </label>
                                <input type="text" id="publicationYear" name="publicationYear"/> </li>
                            <li> <label for="type"> Type: </label>
                                <select id="type" name="type">
                                    <option> General works </option>
                                    <option> Philosophy and psychology </option>
                                    <option> Religion </option>
                                    <option> Social sciences </option>
                                    <option> Language </option>
                                    <option> Science (including mathematics) </option>
                                    <option> Technology and applied Science </option>
                                    <option> Arts and recreation </option>
                                    <option> Literature </option>
                                    <option> History, geography, and biography </option>
                                </select> </li>
                        </ol>
                    </fieldset>
                    <input type="submit" value="Add"/>
                </form>
                <div style="clear: both"></div>
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
