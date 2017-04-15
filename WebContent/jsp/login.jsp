<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" type = "text/css" href = "http://localhost:8080/libtest/css/bootstrap.min.css"/>
	<title>登陆</title>
	<style type = "text/css">
		.top-align{
			margin-top:15%;
		}
	</style>
</head>
	<body>
		<form class = "form-horizontal top-align top-align" action = "/libtest/login.do" method = "post">
			<div class = "form-group">
				<label class = "col-lg-1 col-lg-offset-4 control-label " >账&nbsp;&nbsp;号：</label>
				<div class = "col-lg-2">
					<input class = "form-control" type = "text" name = "account" value = "" placeholder = "请输入账号"/>
				</div>
			</div>
			<div class = "form-group">
				<label class = "col-lg-1 col-lg-offset-4 control-label">密&nbsp;&nbsp;码：</label>
				<div class = "col-lg-2">
					<input class = "form-control" type = "password" name = "password" />
					<%if(getServletContext().getAttribute("error") != null) {%>
					<span class = "help-block text-center" style = "color :red;">账号名或密码错误！</span>
					<%} %>
				</div>
			</div>
			<div class = "form-group">
				<div class = "col-lg-offset-6 col-lg-1">
					<button type = "submit" class = "btn btn-default" >登陆</button>
				</div>
			</div>
		</form>
	</body>
</html>