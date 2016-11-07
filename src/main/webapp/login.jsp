<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title><spring:message code="label.projectName" /></title>
<meta charset="utf8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link type="image/x-icon" rel="shortcut icon"
	href="<c:url value="/resources/client/images/favicon.ico" />" />

<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/3.1.1/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">
		<form class="form-signin" method="POST"
			action="<c:url value="/j_spring_security_check" />">
			<h2 class="form-signin-heading">
				<spring:message code="label.login.title" />
			</h2>

			<input type="text" name="j_username" class="form-control"
				placeholder="<spring:message code="label.login.placeholder.login" />"
				autofocus> <input type="password" name="j_password"
				class="form-control"
				placeholder="<spring:message code="label.login.placeholder.password" />">
			<label class="checkbox"> <input type="checkbox"
				name="_spring_security_remember_me" value="remember-me"> <spring:message
					code="label.login.remember" />
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<spring:message code="label.login.signIn" />
			</button>
		</form>
	</div>
	<script src="<c:url value="/resources/assets/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/bootstrap/3.0.0/js/bootstrap.js" />"></script>
</body>
</html>