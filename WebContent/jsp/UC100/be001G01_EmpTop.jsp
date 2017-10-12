<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FLM Tours</title>
</head>
<body>
<div id="page">
<%@include file="/jsp/UC100/be000G01_EmpHeader.jsp" %>
      <div class="box-management">
        <h3>商品管理</h3>
        <table class="tg">
          <tr>
            <th class="tg-58iv">パッケージツアー</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">登録</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">変更/削除</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
          <tr>
            <th class="tg-58iv">フライト</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">登録</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">変更/削除</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
          <tr>
            <th class="tg-58iv">ホテル</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">登録</a></td>
              <td class="tg-58iv"><a href="#" class="bt-samp31">変更/削除</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
        </table>
      </div>

      <div class="box-member">
        <h3>メンバー管理</h3>
        <table class="tg">
          <tr>
            <td class="tg-58iv"><a href="#" class="bt-samp31">登録</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">検索</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
        </table>
      </div>


      <div class="box-buy">
        <h3>商品販売</h3>
        <table class="tg">
          <tr>
            <th class="tg-58iv">パッケージツアー</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">購入</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
          <tr>
            <th class="tg-58iv">フライト</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">購入</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
          <tr>
            <th class="tg-58iv">ホテル</th>
            <td class="tg-58iv"><a href="#" class="bt-samp31">購入</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">一覧</a></td>
          </tr>
        </table>
      </div>

      <div class="box-aggregate">
        <h3>受注集計</h3>
        <table class="tg">
          <tr>
            <td class="tg-58iv"><a href="#" class="bt-samp31">月別</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">年別</a></td>
            <td class="tg-58iv"><a href="#" class="bt-samp31">商品別</a></td>
          </tr>
        </table>
      </div>
<%--@include file="footer-cust.jsp" --%>
</div>

</body>
</html>