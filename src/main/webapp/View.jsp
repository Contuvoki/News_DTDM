<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="Model.TinTuc"%>
<%@page import="Connection.TinTucConn"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem tin tức</title>
</head>
<body>

	<%  TinTucConn tt= new TinTucConn();%>
	<% List<TinTuc> myListTT=new ArrayList<TinTuc>();%>
	<% myListTT =tt.getAllTinTuc();%>

	<%@ include file="HomePage.jsp"%>


	<%for(TinTuc t : myListTT) { %>
		<a href="servXemBai?idk=<%=t.getId()%>"> <p><%=t.getHeader()%></p></a> 
		  
  <% } %>





</body>


<script>


</script>
</html>