<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<div id="page">
	<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>

 <div class="demo demo5">
            <div class="heading"><span>ログイン</span></div>
 </div>

<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">

	<div style="color:red; font-weight:bold;">
	<c:out value="${requestScope.errorMessage}"></c:out>
	</div>

<table>
  <tr>
    <th>ログイン</th>
    <td><input type="text" name="memberCode" size="40" required></td>
  </tr>
  <tr>
    <th>パスワード</th>
    <td><input type="text" name="password" size="40" required></td>
  </tr>
  <tr>
  	<th></th>
    <td align="center">
    <button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='b101_Login';">
      ログイン
    </button>
    </td>
  </tr>
</table>

</form>

</div>
</body>
</html>