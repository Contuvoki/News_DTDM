<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdn.ckeditor.com/4.11.4/full/ckeditor.js"></script>
<script type="text/javascript" src="./lib/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>





	<div>
		<form id="idForm" action="servDangBai" method="post">
		
	
			<label for="fname"><h3>Tiêu đề bài viết</h3></label> <input
				type="text" id="fname" name="txtHeader" placeholder="Nhập tiêu đề">

			<textarea style="font-size: 75%; text-align: left;" rows="30"
				cols="140" name="txtContent">

			</textarea>

			<button type="submit" class="btn btn-success">Đăng</button>
			<a href="HomePage.jsp"><button type="button" class="btn btn-warning">Hủy</button></a>
		</form>
	<script type="text/javascript">
				CKEDITOR.replace('txtContent');
		</script>

	</div>



</body>

</html>
