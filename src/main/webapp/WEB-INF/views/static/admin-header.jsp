<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title><spring:message code="label.controlPanel" /></title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/3.1.1/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/application/datetimepicker/css/bootstrap-datetimepicker.min.css" />" media="screen"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/application/select2/select2-bootstrap.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/application/select2/select2.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/application/addresspicker/css/themes/base/jquery.ui.all.css" />"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>

<script src="<c:url value="/resources/application/addresspicker/jquery.ui.addresspicker.js" />"></script>

<script src="<c:url value="/resources/application/tinymce/tinymce.min.js" />"></script>
<script src="<c:url value="/resources/application/select2/select2.min.js" />"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
