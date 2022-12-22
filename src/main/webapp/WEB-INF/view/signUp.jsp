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
<title>新規登録</title>
</head>
<body>
	<div class="signUp-main">
		<c:import url="parts/nav.jsp"></c:import>
		<h1 class="text-center signUp-title">新規登録</h1>
		<div class="container signUp">
			<form action="" method="post">
				<div class="signUp-form">
					<div class="signUp-error">
						<c:if test="${not empty nameError}">
							<p class="text-center text-danger">
								<c:out value="※${nameError}" />
							</p>
						</c:if>
					</div>
					<input type="text" class="form-control text-center"
						placeholder="名前" name="name" value="<c:out value="${name}" />"
						id="name">
				</div>
				<div class="signUp-form">
					<div class="signUp-error">
						<c:if test="${not empty idError}">
							<p class="text-center text-danger">
								<c:out value="※${idError}" />
							</p>
						</c:if>
					</div>
					<input type="text" class="form-control text-center"
						placeholder="ログインID(半角英数字)" name="login_id"
						value="<c:out value="${loginId}" />" id="login_id">
				</div>
				<div class="signUp-form">
					<div class="signUp-error">
						<c:if test="${not empty passError}">
							<p class="text-center text-danger">
								<c:out value="※${passError}" />
							</p>
						</c:if>
					</div>
					<input type="password" class="form-control text-center"
						placeholder="パスワード" name="login_pass" id="login_pass">
				</div>
					<div class="signUp-btn">
						<input type="submit" value="登録" class=" btn btn-primary w-100 ">
					</div>
			</form>
		</div>
	</div>
</body>
</html>
