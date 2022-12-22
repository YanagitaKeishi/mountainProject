<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<title>My記録</title>
</head>
<body>
<c:import url="parts/nav.jsp"></c:import> 
		<div class="container nav-top">
		<h1>これまでの登山記録</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>日付</th>
						<th>山名</th>
						<th>地域</th>
						<th>標高</th>
						<th>コメント</th>
						<th>編集／削除</th>
					</tr>
				</thead>
				<c:if test="${reportList != null}">
					<c:forEach items="${reportList}" var="report">
						<tbody  class="">
							<tr>
								<td><c:out value="${report.date}" /></td>
								<td><c:out value="${report.name}" /></td>
								<td><c:out value="${report.erea}" /></td>
								<td><c:out value="${report.elevation}" />m</td>
								<td><c:out value="${report.note}" /></td>
								<td class="my-btn"><a href="myReport?change=0&id=<c:out value="${report.id}" />" class="btn btn-primary">編集</a>
									<a href="myReport?change=1&id=<c:out value="${report.id}" />" class="btn btn-danger delete-btn">削除</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</c:if>
			</table>
		</div>
<script>
	$(document).ready(function(){
		$('.delete-btn').click(function(){
			if(!confirm('本当に削除しますか？')){
				return false;
			}else{
				alert('削除しました。')			
			}
		});
	});	
</script>
</body>
</html>
