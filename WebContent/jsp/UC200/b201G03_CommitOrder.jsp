<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピングカート</title>
</head>
<body>
<div id="page">
	<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>

<form method="post" action="/tourSystem/FrontCont">
	<input type="hidden" name="BUTTON_ID" value="">
	<input type="hidden" name="itemCode" value="">

<table>
  <tr>
    <th>商品コード</th>
    <th>商品名</th>
    <th>料金</th>
    <th>予約人数</th>
    <th>小計</th>
    <th>削除</th>
  </tr>
  <tr>
    <td>a</td>
    <td>b</td>
    <td>c</td>
    <td>d</td>
    <td>e</td>
    <td>
    <button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='';
      this.form.itemCode.value='<c:out value="${ShoppingCart.itemCode}"></c:out>';">
      削除
      </button>
    </td>
  </tr>
</table>

</form>

</div>
</body>
</html>