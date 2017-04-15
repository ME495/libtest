<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" import="common.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>add</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
</head>
<body>
	<div class="text-right">
		<a href="/libtest/cancel.do">注销</a>
	</div>
	<h1 class="text-center">添加图书</h1>
	<form class="form-horizontal" action="/libtest/add.do" method="post">
		<div class="form-group">
			<label class="control-label col-lg-1 col-lg-offset-3">书名：</label>
			<div class="col-lg-2">
				<input type="text" name="bkname" class="form-control">
			</div>
			<label class="control-label col-lg-1">作者：</label>
			<div class="col-lg-2">
				<input type="text" name="author" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-1 col-lg-offset-3">出版日期：</label>
			<div class="col-lg-2">
				<input type="text" name="pblsdate" class="form-control">
			</div>
			<label class="control-label col-lg-1">出版社：</label>
			<div class="col-lg-2">
				<input type="text" name="publisher" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-1 col-lg-offset-3">ISBN：</label>
			<div class="col-lg-2">
				<input type="text" name="isbn" class="form-control">
			</div>
			<label class="control-label col-lg-1">价格：</label>
			<div class="col-lg-2">
				<input type="text" name="price" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-1 col-lg-offset-3">藏书地点：</label>
			<div class="col-lg-2">
				<input type="text" name="place" class="form-control">
			</div>
			<label class="control-label col-lg-1">ID：</label>
			<div class="col-lg-2">
				<input type="text" name="bkid" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-1 col-lg-offset-5">
				<input type="submit" value="确认" class="form-control">
			</div>
			<div class="col-lg-1">
				<input type="reset" value="重置" class="form-control">
			</div>
		</div>
	</form>
	<%Book book = (Book)request.getAttribute("book");
		if(book!=null){
			BookManager bm = new BookManager();
			if(bm.addBook(book)){%>
	<script type="text/javascript">
		alert("添加成功");
	</script>
	<%}else{%>
	<script type="text/javascript">
		alert("添加失败");
	</script>
	<%}}%>

</body>
</html>