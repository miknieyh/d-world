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
				<div>
					<h1 class="text-center mt-5 mb-5">JOIN GROUP</h1>
				</div>
				<form action="groupmake" method="get">
					<table class="table table-sm">
						<thead class="table-warning">
							<tr>
								<td colspan="2">공유일기 그룹 만들기</td>
							</tr>
						</thead>
						<tbody>
							<tr height="200px" style="vertical-align: middle;">
								<td class="p-3 ps-5">그룹이름</td>
								<td class="col-8">
									<div class="d-flex">
										<input type="text" name="groupname" class="form-control w-75">
									</div>

								</td>
							</tr>

							<tr>
								<td colspan="2">
									<div class="d-grid col-6 mx-auto">
										<button class="btn btn-outline-warning" type="submit">만들기</button>
									</div>
								</td>
							</tr>

						</tbody>
					</table>
				</form>


				<div class="empty3"></div>

			</div>
			<%@ include file="/side.jsp" %>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>