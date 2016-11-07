<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/admin/cruise/list" />"><spring:message
					code="label.projectName" /></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <spring:message code="label.service" /> <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/admin/insight/list" />"><spring:message
									code="label.insight" /></a></li>
						<li class="divider"></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <spring:message code="label.administration" />
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/admin/user/list" />"><spring:message
									code="label.users" /></a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/admin/athority/list" />"><spring:message
									code="label.athority" /></a></li>
						<li class="divider"></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav pull-right">
				<li><a href="<c:url value="/logout"/>"><spring:message
							code="label.logout" /></a></li>
			</ul>
		</div>
		<!--/.navbar-collapse -->
	</div>
</div>
