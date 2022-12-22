<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員情報</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="parts/nav.jsp"></c:import> 
	<div class="container nav-top myinfo">
	<h1 class="text-center">アカウント</h1>
	<c:if test="${not empty info}">
		<h5 class="text-center">変更内容を保存しました。</h5>
	</c:if>
		<div class="">
			<form action="myInfo?id=<c:out value="${user.id}" />" method="post">
				<label for="name" class="col-form-label">名前</label> 
				<c:if test="${not empty nameError}">
					<p class="myinfo-error">
						<c:out value="※${nameError}" />
					</p>
				</c:if>
				<input type="text" class="form-control mb-2" 
						name="name" id="name"
						value="<c:if test="${not empty name}"><c:out value="${name}" /></c:if><c:if test="${name == null}"><c:out value="${user.name}" /></c:if>"> 					
				<label for="login_id" class="col-form-label">ログイン用ID</label> 
				<c:if test="${not empty idError}">
					<p class="myinfo-error">
						<c:out value="※${idError}" />
					</p>
				</c:if>
				<input type="text" class="form-control mb-2" 
						name="login_id" id="login_id"
						value="<c:if test="${not empty loginId}"><c:out value="${loginId}" /></c:if><c:if test="${empty loginId}"><c:out value="${user.loginId}" /></c:if>">						
				<div class="myinfo-btn">
					<input type="submit" value="保存" class="btn btn-primary">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
