<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
<title>Insert title here</title>
<style type="text/css">
.table{
	margin-left: 25%;
}
</style>

</head>
<body style="background-color: #9abafc">
<% 

	String rs1=(String)session.getAttribute("cont");
	

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
	
	PreparedStatement ps=con.prepareStatement("select * from carbooking where cno=?");
	ps.setString(1, rs1);
	ResultSet rs= ps.executeQuery();
	 %>
<center><h3 style="margin-top: 3%">Booking Details</h3></center><br>
<table class="table" style="width: 50%;">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Car Type</th>
      <th scope="col">Location From</th>
      <th scope="col">Location To</th>
      <th scope="col">Start Date</th>
      <th scope="col">End Date</th>
      
    </tr>
  </thead>

<% while(rs.next()) { %>
<tbody>
    <tr>
      <th scope="row"><%= rs.getInt(1) %></th>
      <td><%= rs.getString(2) %></td>
      <td><%= rs.getString(3) %></td>
      <td><%= rs.getString(4) %></td>
      <td><%= rs.getDate(5) %></td>
       <td><%= rs.getDate(6) %></td>
    </tr>
  </tbody>
  <% } %>
</table>

<%}catch(Exception e){
	e.getMessage();
} %>
</body>
</html>