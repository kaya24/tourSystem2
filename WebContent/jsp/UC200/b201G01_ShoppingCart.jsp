<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp/UC100/css.jsp"%>
<title>ショッピングカート</title>
</head>

<script type="text/javascript" src="/tourSystem/js/calc.js"></script>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>
		<div class="demo demo5">
			<div class="heading">
				<span>ショッピングカート</span>
			</div>
		</div>

		<form name="form1" method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value="">
			<input type="hidden" name="itemCode" value="">
			<input type="hidden" name="categoryCode" value="">
			<input type="hidden" name="flag" value="">

			<div style="color: blue; font-weight: bold;">
				<c:out value="${requestScope.RemoveMessage}"></c:out>
			</div>
			<div style="color: blue; font-weight: bold;">
				<c:out value="${requestScope.NoShoppingCart}"></c:out>
			</div>

			<!-- ショッピングカートの中身 -->
			<c:if test="${!empty B201ShoppingCart}">
				<div>
					<table>
						<tr>
							<th>商品コード</th>
							<th>商品名</th>
							<th>料金(円)</th>
							<th>予約人数</th>
							<th>小計(円)</th>
							<th>削除</th>
						</tr>
						<c:forEach var="itemList" items="${B201ShoppingCart}" varStatus="status">
							<tr>
								<td><a href="/tourSystem/FrontCont?BUTTON_ID=B201CartDetailBack
								&categoryCode=<c:out value="${itemList.categoryCode}"></c:out>
								&itemCode=<c:out value="${itemList.itemCode}"></c:out>">
										<c:out value="${itemList.itemCode}"></c:out>
									</a></td>
								<td><c:out value="${itemList.itemName}"></c:out></td>
								<td class="unitPrice"><fmt:formatNumber value="${itemList.unitPrice}" /> <%--
								<c:out value="${itemList.unitPrice}"></c:out>
								--%></td>
								<td><select class="quantity" name="quantity" onchange="selChange();" style="width: 50px">
										<c:forEach var="stock" begin="1" end="${itemList.stock}" varStatus="qua">
											<option class="quant" value="${qua.index}" <c:if test="${qua.index == itemList.quantity}">selected</c:if>>
												<c:out value="${qua.index}"></c:out></option>
										</c:forEach>
									</select></td>
								<td class="subtotal"><c:out value="${itemList.unitPrice}"></c:out></td>
								<td>
									<button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='B201CartDelete';
									this.form.itemCode.value='<c:out value="${itemList.itemCode}"></c:out>'">削除</button>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<th colspan="4">合計</th>
							<td id="all"></td>
							<td></td>
						</tr>
					</table>

					<button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='B201CartPurchase';">購入</button>
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>