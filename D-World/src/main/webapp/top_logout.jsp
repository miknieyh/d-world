<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
		<div class="h-75 d-flex justify-content-around mt-1">
			<div class="mt-2">
				<a href="index.jsp"><img src="resources/img/logo.png" alt="logo"></a>
			</div>
			<div class="w-25 ">
				<div class="imb-3 h-25 mt-3"></div>
			</div>

			<div class="d-flex">
				<div class="mt-5">
					<a href="join.jsp"><button type="button" class="btn btn-dark">회원가입</button></a>
					<a href="index.jsp"><button type="button" class="btn btn-dark">로그인</button></a>
				</div>

			</div>

		</div>
		<nav class="h-50 bg-black  ">
			<ul class="nav justify-content-start">

				<div class="w-25"></div>
				<div class="navh">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="index.jsp">새일기</a></li>
					<ul class="bg-white pa nav flex-column p-4">
						<li><a href="index.jsp">공유일기</a></li>
						<li><a href="index.jsp">비밀일기</a></li>
						<li><a href="index.jsp">공개일기</a></li>
					</ul>
				</div>
				<div class="navh ms-5">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="index.jsp">공개일기</a></li>
				</div>

				<div class="navh ms-5">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="index.jsp">내 책장</a></li>
					<ul class="bg-white pa nav flex-column p-4">
						<li><a href="index.jsp">공유일기</a></li>
						<li><a href="index.jsp">비밀일기</a></li>
						<li><a href="index.jsp">모아보기</a></li>
					</ul>
				</div>


			</ul>
		</nav>

	</header>
	<div class="empty3"></div>
</body>
</html>