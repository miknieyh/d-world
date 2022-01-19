<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/top_login.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container"
		style="height: 100%; background-color: WhiteSmoke;">
		<div class="row">
			<div class="col-8" style="background-color: white;">
				<c:forEach var="b" items="${bArr}">
					<table class="table table-sm">
						<thead class="table-dark">
							<tr>
								<td><c:choose>
										<c:when test="${b.stat == 2}">
											비밀일기</c:when>
										<c:otherwise>공유일기</c:otherwise>
									</c:choose></td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<tr>
								<td>${b.writer}</td>
							</tr>
							<tr>
								<td>${b.wdate}</td>
							</tr>

							<c:forEach var="photo" items="${b.photo}">
								<tr>
									<td><img alt="photo" src="./upload/${photo}"
										style="width: 800px;"></td>
								</tr>
							</c:forEach>
							<tr>
								<td><div style="height: 120px;">${b.contents}</div>
									<br>
									<button class="btn btn-outline-dark btn-sm">자세히</button></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>


			</div>
			<%@ include file="/side.jsp" %>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>