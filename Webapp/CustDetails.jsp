<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>CustDetails</title>
<style type="text/css">
.table{
	margin-left: 25%;
}
</style>

</head>
<body style="background-color: #9abafc">
<% ResultSet rs=(ResultSet)session.getAttribute("custdetails"); %>
<% if(rs.isBeforeFirst()) { %>
<center><h3 style="margin-top: 3%">Personal Details</h3></center><br>
<table class="table" style="width: 50%;">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Contact No.</th>
      <th scope="col">Email Id</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
<% while(rs.next()) { %>
<tbody>
    <tr>
      <td><%= rs.getString(1) %></td>
      <td><%= rs.getString(2) %></td>
      <td><%= rs.getString(3) %></td>
      <td><%= rs.getString(4) %></td>
      <% session.setAttribute("cont", rs.getString(2));
      %>
    </tr>
  </tbody>
</table>
<center><button><a href="CustBookDetails.jsp" style="color: black;">Booking Details</a></button></center>
<br>

<% } %>
<% } else { %>
	<p style="color: red; position: absolute;margin-top: 15%; margin-left: 40%;">Data Not Found...!! </p>

<%@include file="CustLogin.html" %>
<% } %>
</body>
</html>