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
					<h1 class="text-center mt-5 mb-5">SELECT GROUP</h1>
				</div>
				<table class="table table-sm">
					<thead class="table-success">
						<tr>
							<td colspan="2" class="text-center"></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2">
								<div>
									<a href="main?flag=group_make" class="d-grid gap-2"><button
											class="btn btn-outline-primary" type="button">
											<b>그룹만들기</b>
										</button> </a>
								</div>
							</td>
						</tr>


						<c:forEach var="g" items="${gArr}" varStatus="i">
							<tr>
								<td class="w-75">
									<div>
										<a
											href="main?flag=write_gd&gname=${g.groupname}&gidx=${g.g_idx}"
											class="d-grid gap-2" style="height:75px">
											<button class="btn btn-outline-success" type="button">${g.groupname}</button>
										</a>
									</div>
								</td>
								<td><a class="d-grid gap-2"> <input
										id="myInput_${i.count}"
										value="http://localhost:8080/D-World/index.jsp?invite=${g.g_idx}">
										<button class="btn btn-success" onclick="copy_to_clipboard_${i.count}()">초대장
											링크 복사</button> 
											<script>
												function copy_to_clipboard_${i.count}() {
													var copyText = document
															.getElementById("myInput_${i.count}");
													copyText.select();
													document
															.execCommand("Copy");
													console.log('Copied!');
												}
											</script>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="empty3"></div>


			</div>
			<%@ include file="/side.jsp"%>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>