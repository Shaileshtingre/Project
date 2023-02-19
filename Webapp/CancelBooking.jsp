<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int rs=(Integer)session.getAttribute("cancelbooking"); %>
	
<% if(rs>0) { %>
<p style="color: red; position: absolute;margin-top: 15%; margin-left: 40%;">Booking Cancel Successfully...!! </p>

<%@include file="CancelBooking.html" %>

<% } else { %>

<p style="color: red; position: absolute;margin-top: 15%; margin-left: 40%;">Data Not Found...!! </p>

<%@include file="CancelBooking.html" %>

<% } %>
</html>