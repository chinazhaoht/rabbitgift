<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />
<title>淘淘兔</title>
</head>
<body>
<div id="all">
<div id="top">
<div id="top-left">欢迎小兔子</div>
<div id="top-right"></div>
<div id="top-clear"></div>
</div>
<div id="header">
</div>
<div id="main">
<h1>用户登录</h1>
<form:form modelAttribute="user" action="login" method="post">
<form:errors path="" />
<p>
<form:label for="login" path="login" cssErrorClass="error">登录名</form:label><br/>
<form:input path="login" /><form:errors path="login" />
</p>
<p>
<form:label for="password" path="password" cssErrorClass="error">密 码</form:label><br/>
<form:password path="password" /><form:errors path="password" />
</p>
<input type="submit" value="登录"/>
<input type="button" value="回首页" onclick="location.href='<c:url value="/" />'"/>
<input type="button" value="我要注册" onclick="location.href='<c:url value="/user/register" />'"/>
</form:form>
</div>
<%@include file="../footer.jsp" %>
</div>
</body>
</html>