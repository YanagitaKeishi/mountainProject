<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<title>百名山リスト</title>
</head>
<body>
	<c:import url="parts/nav.jsp"></c:import>
	<div class="container nav-top">
		<h1>百名山リスト</h1>
		<div class="form-inline">
			<form action="" class="list-form">
				<select name="erea" class="form-select w-50">
					<option selected disabled><c:out value="${selectErea}" /></option>
					<option>全エリア</option>
					<option>北海道</option>
					<option>東北</option>
					<option>北関東</option>
					<option>尾瀬</option>
					<option>上州</option>
					<option>日光</option>
					<option>足尾</option>
					<option>上信越</option>
					<option>秩父</option>
					<option>奥秩父</option>
					<option>南関東</option>
					<option>北アルプス</option>
					<option>美々原</option>
					<option>霧ヶ峰</option>
					<option>蓼科山</option>
					<option>八ヶ岳</option>
					<option>御嶽山</option>
					<option>中央アルプス</option>
					<option>南アルプス</option>
					<option>北陸</option>
					<option>近畿</option>
					<option>中国</option>
					<option>四国</option>
					<option>九州</option>
				</select>
				<div class="list-elevation mx-4">
					<input class="mx-2" type="radio" name="elevation" value="high"
						<c:if test="${not empty high}">checked</c:if>>高い順
					<input class="mx-2" type="radio" name="elevation" value="low"
						<c:if test="${not empty low}">checked</c:if>>低い順 
					<input class="mx-2" type="radio" name="elevation" value="erea"
						<c:if test="${not empty erea}">checked</c:if>>エリア順
					<input class="mx-2" type="submit" value="検索">
				</div>
			</form>
		</div>
		<a href="mountainList">選択をクリア</a>
		<p>山名をクリックすると登った山の記録ができるよ！</p>
		<table class="table table-hover">
			<thead class="table-secondary">
				<tr>
					<th>山名</th>
					<th>地域</th>
					<th>標高</th>
				</tr>
			</thead>
			<c:forEach items="${mountainList}" var="mountain">
				<tbody  class="listName">
					<tr>
						<td>
							<a href="report?id=${mountain.id}"><c:out value="${mountain.name}" /></a>
						</td>
						<td><c:out value="${mountain.erea}" /></td>
						<td><c:out value="${mountain.elevation}" />m</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>
