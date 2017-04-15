<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" type = "text/css" href = "../css/bootstrap.min.css"/>
	<title>图书管理系统</title>
</head>
<body>
	<%
	HttpSession session = request.getSession(false);
	if(session!=null && session.getAttribute("account")!=null) {%>
	<div class = "text-right">
		<a href = "/libtest/cancel.do">注销</a>
	</div>
	<%}else{%>
	<div class = "text-right">
		<a href = "/libtest/jsp/login.jsp">登陆</a>
	</div>
	<%} %>
	<h1 class = "text-center">图书查询系统</h1>
    <form class = "form-horizontal" action = "#" method = "post">
        <div class ="form-group">
            <div class = "col-lg-4 col-lg-offset-4">
                <input type="text" class = "form-control" name="search">
            </div>
        </div>
        <div class = "form-group">
            <div class = "radio col-lg-3 col-lg-offset-5">
                <label class = "radio-inline"><input type="radio" name="search" value = "bn">书名</label>
                <label class = "radio-inline"><input type="radio" name="search" value = "author">作者</label>
                <label class = "radio-inline"><input type="radio" name="search" value = "ISBN">ISBN</label>
            </div>
        </div>
        <div class = "form-group">
            <div class = "col-lg-1 col-lg-offset-5">
                <input type="submit" class = "form-control" value = "提交">
            </div>
        </div>
    </form>
    <div class = "container">
        <div class = "row">
	        <div class = "col-lg-6 col-lg-offset-4">
	            <ul class = "nav nav-pills "> 
	                <li><a href="/libtest/html/borrow.html">借书</a></li>
	                <li><a href="/libtest/html/back.html">还书</a></li>
	                <li><a href="/libtest/jsp/add.jsp">添加图书</a></li>
	                <li><a href="/libtest/jsp/delete.jsp">删除图书</a></li>
	            </ul>
	        </div>
        </div>
    </div>
</body>
</html>