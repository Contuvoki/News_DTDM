<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="Model.TinTuc"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
</head>
<body>
	<%@ include file="HomePage.jsp"%>>
		<%TinTuc tt =(TinTuc) request.getAttribute("tintuc"); %>
	<h1 style="text-align: center" ><%=tt.getHeader() %></h1>



	<p style="margin-left: 50%"><%=tt.getContent() %></p>
	
		

	<p style="margin-left: 75%"><b>Tác giả:</b> <%=tt.getUserName() %></p>
</body>
</html>