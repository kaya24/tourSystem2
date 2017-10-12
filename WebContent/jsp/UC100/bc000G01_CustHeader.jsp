<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--デフォルトヘッダー--%>
<c:if test="${empty CommonLoginMember}">
	<!--ヘッダー部分-->
	<div id="header">
		<div id="boxA">
			<a href="/tourSystem/FrontCont?BUTTON_ID=BC000Logo"> FLMTours </a>
		</div>
		<div id="nav">
			<ul>
				<li>ようこそ、FLMToursへ</li>
				<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000Login">ログイン</a></li>
				<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000Logout">セッションリセット</a></li>
				<li><a href="/tourSystem/FrontCont?BUTTON_ID=BE001PackageRegist">パッケージ商品登録</a></li>
				<li><a href="/tourSystem/FrontCont?BUTTON_ID=BE001OrderCheck">注文内容確認</a></li>
			</ul>
		</div>
	</div>
	<ul id="dropmenu">
		<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC001PackageTour">パッケージツアー</a></li>
		<li><a href="#">航空券</a></li>
		<li><a href="#">ホテル</a></li>
		<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000ShoppingCart">ショッピングカート</a></li>
	</ul>
</c:if>

<c:if test="${!empty CommonLoginMember}">
	<%--顧客用ヘッダー--%>
	<c:if test="${CommonLoginMember.role == 'Customer'}">
		<!--ヘッダー部分-->
		<div id="header">
			<div id="boxA">
				<a href="/tourSystem/FrontCont?BUTTON_ID=BC001CustTop"> FLMTours </a>
			</div>
			<div id="nav">
				<ul>
					<li>こんにちは <c:out value="${CommonLoginMember.memberName}"></c:out>さん
					</li>
					<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000Logout">ログアウト</a></li>
					<li><a href="/tourSystem/FrontCont?BUTTON_ID=BE001OrderCheck">注文内容確認</a></li>
				</ul>
			</div>
		</div>
		<ul id="dropmenu">
			<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC001PackageTour">パッケージツアー</a></li>
			<li><a href="#">航空券</a></li>
			<li><a href="#">ホテル</a></li>
			<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000ShoppingCart">ショッピングカート</a></li>
		</ul>
	</c:if>

	<%--従業員用ヘッダー--%>
	<c:if test="${CommonLoginMember.role == 'Employee'}">
		<div id="page">
			<!--ヘッダー部分-->
			<div id="header">
				<div id="boxA">販売管理システム</div>
				<div id="boxB">
					<table>
						<tr>
							<td>ログイン日時</td>
							<td>：</td>
							<td>YYYY-MM-DD-何時何分何秒</td>
						</tr>
						<tr>
							<td>従業員コード</td>
							<td>：</td>
							<td>999999</td>
						</tr>
						<tr>
							<td>従業員氏名</td>
							<td>：</td>
							<td>山田太郎</td>
						</tr>
					</table>
				</div>
				<div id="nav">
					<ul>
						<li><a href="#">メインメニュー</a></li>
						<li><a href="/tourSystem/FrontCont?BUTTON_ID=BE001OrderCheck">注文内容確認</a></li>
						<li><a href="/tourSystem/FrontCont?BUTTON_ID=BC000Logout">ログアウト</a></li>
					</ul>
				</div>
			</div>
		</div>
	</c:if>
</c:if>

