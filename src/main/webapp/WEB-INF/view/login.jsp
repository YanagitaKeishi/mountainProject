<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<title>ログイン</title>
</head>
<body>
<div class="login-main">
	<h1 class="text-center login-title"><a href="top">ヤマノキロク</a></h1>
	<div class="container login">
		<h2 class="text-center">ログイン</h2>
		<div class="alert-box">
			<c:if test="${noUser}">
				<p class="alert alert-info">
					記録機能のご利用はログインまたは、<a href="signUp">新規登録</a>後に可能になります。
				</p>
			</c:if>
		</div>
		<div class="login-form text-center">
			<c:if test="${not empty error}">
				<p class="text-danger">ログインIDかパスワードが正しくありません。</p>
			</c:if>
			<form action="" method="post">
				<input type="text" class="form-control login-form text-center"
					placeholder="ログインID" name="login_id"> 
				<input type="password" class="form-control login-form text-center" placeholder="パスワード"
					name="login_pass">
				<div class="login-submit">
					<input type="submit" value="GO" class=" btn btn-primary w-100">
				</div>
			</form>
		</div>
	</div>
</div>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
