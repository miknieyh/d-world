<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header style="height:100%;">
		<div class="h-75 d-flex justify-content-around mt-1">
			<div class="">
				<a href="main"><img src="resources/img/logo.png" alt="logo" ></a>
			</div>
			<div class="w-25 ">
				<div class="h-25"></div>
			</div>

			<div class="d-flex">
				<div class="mt-5">
					<a href="join.jsp"><button type="button" class="btn btn-dark">내정보</button></a>
					<a href="index.jsp"><button type="button" class="btn btn-dark">로그아웃</button></a>
				</div>

			</div>

		</div>
		<nav class="bg-black"style="height: 100px;">
			<ul class="nav justify-content-start">

				<div class="w-25"></div>
				<div class="navh">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="#">새일기</a></li>
					<ul class="bg-white pa nav flex-column p-4">
						<li><a href="main?flag=write_group">공유일기</a></li>
						<li><a href="main?flag=write_my">비밀일기</a></li>
						<li><a href="#">공개일기</a></li>
					</ul>
				</div>
				<div class="navh ms-5">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="#">공개일기</a></li>
				</div>

				<div class="navh ms-5">
					<li class="nav-item mt-4"><a class="nav-link fw-bolder"
						aria-current="page" href="#">내 책장</a></li>
					<ul class="bg-white pa nav flex-column p-4">
						<li><a href="#">공유일기</a></li>
						<li><a href="#">비밀일기</a></li>
						<li><a href="#">모아보기</a></li>
					</ul>
				</div>


			</ul>
		</nav>

	</header>
</body>
</html>