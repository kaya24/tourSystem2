<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員登録</title>
</head>
<body>
<div id="page">
	<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>

 <div class="demo demo5">
            <div class="heading"><span>会員登録</span></div>
 </div>

<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">

	<div style="color:red; font-weight:bold;">
	<c:out value="${requestScope.errorMessage}"></c:out>
	</div>

<table>
  <tr>
    <th>メンバーコード</th>
    <td><input type="text" name="memberName" size="40" value="CM9999"></td>
  </tr>
  <tr>
    <th>権限</th>
    <td><input type="text" name="memberName" size="40" value="Customer"></td>
  </tr>
  <tr>
  	<th>氏名</th>
    <td><input type="text" name="memberName" size="40" value="ikoma"></td>
  </tr>
    <tr>
  	<th>パスワード</th>
    <td><input type="text" name="password" size="40" value="ikoma"></td>
  </tr>

</table>
    <button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='B901RegistEntry';">
    登録
    </button>

</form>

</div>
</body>
</html>