<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">

		<tr>
			<td>작성자</td>
			<td>${board_view.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board_view.content }</td>
		</tr>
		<tr>
			<td><a href="list">목록보기</a></td>
		</tr>

	</table>
</body>
</html>