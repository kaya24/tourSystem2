<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パッケージツアー商品検索（管理）</title>
</head>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>
		<div class="demo demo5">
			<div class="heading">
				<span>パッケージツアー商品検索（管理）</span>
			</div>
		</div>


		<form name="search" method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value="">
			<table>
				<tr>
					<th>商品コード</th>
					<td><input type="text" name="tourCode" required
						value="${B301RegistPackageTour.tourCode}"></td>
					<td><button class="bt-samp31" type="submit"
							onclick="this.form.BUTTON_ID.value='B301RegistSearch';">
							検索</button></td>
				</tr>
			</table>
		</form>

		<form name="regist" method="post" action="/tourSystem/FrontCont">
			<table>
				<tr>
					<th>商品コード</th>
					<td>※自動割当</td>
				</tr>
				<tr>
					<th>ツアー名</th>
					<td><c:out value="${B301RegistPackageTour.tourName}"></c:out></td>
				</tr>
				<tr>
					<th>地区</th>
					<td><c:out value="${B301RegistPackageTour.destinationName}"></c:out></td>
				</tr>

				<tr>
					<th>日数</th>
					<td><c:out value="${B301RegistPackageTour.date}"></c:out></td>
				</tr>

				<tr>
					<th>ホテル商品コード</th>
					<td><input type="text" required></td>
				</tr>

			</table>

			<%--ボタン配置 --%>
			<table>
				<tr>
					<td>
						<button class="bt-samp31" type="submit"
							onclick="this.form.BUTTON_ID.value='B601DetailViewCart';">
							登録</button>
					</td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>