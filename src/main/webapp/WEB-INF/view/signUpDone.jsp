<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>登録完了</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
</head>
<body>
<div class="signUpDone">
	<h1>登録完了しました。</h1>
	<p>登録完了後、再度ログインをしてください</p>
	<p><a href="login" class="btn btn-primary">ログインする</a></p>
</div>
</body>
</html>
