<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/libtest/css/bootstrap.css">
	<title>delete</title>
</head>
<body>
	<div class = "text-right">
        <a href="/libtest/cancel.do">注销</a>
    </div>
	<h1 class = "text-center">删除图书</h1>
	<form class = "form-horizontal" action = "#" method = "post">
		<div class = "form-group">
			<label class = "control-label col-lg-2 col-lg-offset-3" for = "bkid">图书ID：</label>
			<div class = "col-lg-3">
				<input type="text" name="id" class = "form-control" id = "bkid">
			</div>
		</div>
		<div class = "form-group">
			<div class = "col-lg-1 col-lg-offset-5">
				<input type="submit" value = "确认" class = "form-control">
			</div>
			<div class = "col-lg-1 col-lg-offset-1">
				<input type="reset" name="取消" class = "form-control">
			</div>
		</div>
	</form>
</body>
</html>