<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
	//カンマ区切りに変換する関数
	function addFigure(str) {
		var num = new String(str).replace(/,/g, "");
		while (num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")))
			;
		return num;
	}

	jQuery(function() {
		/*初期値の計算*/
		jQuery(document).ready(function() {
			var all = 0;
			var index = document.getElementsByClassName("unitPrice"); // 各商品のpriceタグの個数を取得
			for (var i = 0; i < index.length; i++) {
				//$(".quantity").eq(i).val($(".quant").eq(i).val());
				// 小計、合計の計算
				var quantity = $('.quantity').eq(i).val();
				var price = $('.unitPrice').eq(i).text();
				price = parseInt(price.split(',').join('').trim());
				var total = quantity * price;
				$('.subtotal').eq(i).text(addFigure(total));
				all += total;
			}
			$('#all').text(addFigure(all));
		});
		/*数量変更時*/
		jQuery('.quantity').change(function() {
			window.sessionStorage.clear();
			var all = 0;
			var index = document.getElementsByClassName("unitPrice");
			for (var i = 0; i < index.length; i++) {
				var quantity = $('.quantity').eq(i).val(); //単価の取得
				var price = $('.unitPrice').eq(i).text();
				price = parseInt(price.split(',').join('').trim());
				var total = quantity * price;
				$('.subtotal').eq(i).text(addFigure(total));
				all += total;
			}
			$('#all').text(addFigure(all));
		});
	});
</script>
<title>ショッピングカート</title>

</head>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>
		<div class="demo demo5">
			<div class="heading">
				<span>ショッピングカート</span>
			</div>
		</div>

		<form method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value="">
			<input type="hidden" name="itemCode" value="">
			<input type="hidden" name="categoryCode" value="">

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
						<c:forEach var="itemList" items="${B201ShoppingCart}"
							varStatus="status">
							<tr>
								<td><a
									href="/tourSystem/FrontCont?BUTTON_ID=B201CartDetailBack
								&categoryCode=<c:out value="${itemList.categoryCode}"></c:out>
								&itemCode=<c:out value="${itemList.itemCode}"></c:out>">
										<c:out value="${itemList.itemCode}"></c:out>
								</a></td>
								<td><c:out value="${itemList.itemName}"></c:out></td>
								<td class="unitPrice"><fmt:formatNumber
										value="${itemList.unitPrice}" /> <%--
									<c:out value="${itemList.unitPrice}"></c:out>
									 --%></td>
								<td><select class="quantity" name="quantity">
										<option value="1" selected>1</option>
										<c:forEach var="stock" begin="2" end="${itemList.stock}"
											varStatus="qua">
											<option class="quant" value="${qua.index}"><c:out
													value="${qua.index}"></c:out></option>
										</c:forEach>
								</select></td>
								<td class="subtotal"><c:out value="${itemList.unitPrice}"></c:out>
								</td>
								<td><button class="bt-samp31" type="submit"
										onclick="this.form.BUTTON_ID.value='B201CartDelete';
									this.form.itemCode.value='<c:out value="${itemList.itemCode}"></c:out>'">
										削除</button></td>
							</tr>
							<%-- 合計の計算 --%>
							<c:set var="all" value="${all + itemList.unitPrice}" />
						</c:forEach>
						<tr>
							<th colspan="4">合計</th>
							<td id="all"></td>
							<td></td>
						</tr>
					</table>

					<button class="bt-samp31" type="submit"
						onclick="this.form.BUTTON_ID.value='B201CartPurchase';">
						購入</button>

				</div>
			</c:if>
		</form>
	</div>
</body>
</html>