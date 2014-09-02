<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="0">

<%
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragrma","no-cache");
response.setDateHeader("Expires",0);
%>

<%@include file="themes.jsp" %>
<%@include file="easyui.jsp" %>
<%@include file="common_script.jsp" %>