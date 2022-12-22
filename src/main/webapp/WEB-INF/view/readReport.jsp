<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>記録を見る</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="parts/nav.jsp"></c:import>
	<div class="nav-top">
		<div class="container">
			<h1>みんなの登山記録</h1>
			<table class="table table-top">
				<thead class="table-secondary">
					<tr>
						<th>ユーザー名</th>
						<th>登った日</th>
						<th>登った山</th>
						<th>地域</th>
						<th>標高</th>
						<th>コメント</th>
					</tr>
				</thead>
				<c:if test="${reportList != null}">
					<c:forEach items="${reportList}" var="report">
						<tbody class="read-td">
							<tr>
								<td><c:out value="${report.userName}" />さん</td>
								<td><c:out value="${report.date}" /></td>
								<td><c:out value="${report.name}" /></td>
								<td><c:out value="${report.erea}" /></td>
								<td><c:out value="${report.elevation}" />m</td>
								<td><c:out value="${report.note}" /></td>
							</tr>
						</tbody>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>
