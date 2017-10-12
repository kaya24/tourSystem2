<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/tourSystem/css/common.css">

<c:if test="${empty CommonLoginMember}">
	<link rel="stylesheet" href="/tourSystem/css/menubar-cust.css">
</c:if>
<c:if test="${CommonLoginMember.role == 'Customer'}">
	<link rel="stylesheet" href="/tourSystem/css/menubar-cust.css">
</c:if>
<link rel="stylesheet" href="/tourSystem/css/button.css">
<link rel="stylesheet" href="/tourSystem/css/table.css">

<c:if test="${CommonLoginMember.role == 'Employee'}">
	<link rel="stylesheet" href="/tourSystem/css/menubar-emp.css">
</c:if>