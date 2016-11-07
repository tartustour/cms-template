<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title><spring:message code="client.label.error404.title" /></title>
<meta charset="utf8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link type="image/x-icon" rel="shortcut icon"
	href="<c:url value="/resources/client/images/favicon.ico" />" />

<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/3.1.1/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<spring:message code="client.label.error404.message" />
			</div>
		</div>
	</div>
</body>
</html>