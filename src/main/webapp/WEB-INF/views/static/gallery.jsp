<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="galleryReferenceType" value="${param.galleryReferenceType}" />
<c:set var="galleryReferenceId" value="${param.galleryReferenceId}" />
<c:set var="galleryId" value="${param.galleryId}" />
<c:set var="galleryName" value="${param.galleryName}" />
<c:set var="redirectUrl" value="${param.redirectUrl}" />


<c:url value="/admin/gallery/add" var="addGallery">
	<c:param name="redirectUrl" value="${redirectUrl}" />
	<c:param name="galleryReferenceType" value="${galleryReferenceType}" />
	<c:param name="galleryReferenceId" value="${galleryReferenceId}" />
</c:url>
<c:url value="/admin/gallery/edit" var="editGallery">
	<c:param name="galleryId" value="${galleryId}" />
	<c:param name="redirectUrl" value="${redirectUrl}" />
	<c:param name="galleryReferenceType" value="${galleryReferenceType}" />
	<c:param name="galleryReferenceId" value="${galleryReferenceId}" />
</c:url>
<c:url value="/admin/gallery/delete" var="deleteGallery">
	<c:param name="galleryId" value="${galleryId}" />
	<c:param name="redirectUrl" value="${redirectUrl}" />
</c:url>

<c:if test="${empty galleryId}">
	<a href="${addGallery}" class="btn btn-default btn-mini pull-left"><span
		class="glyphicon glyphicon-plus"></span> <spring:message code="label.addItem" /></a>
</c:if>
<c:if test="${not empty galleryId}">
	<div class="input-group">
		<p class="form-control-static">${galleryName}</p>
		<div class="input-group-btn">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<spring:message code="label.item" />
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="${editGallery}"><span class="glyphicon glyphicon-edit"></span>
						<spring:message code="label.edit" /></a></li>
				<li class="divider"></li>
				<li><a href="#" onclick="confirmDialog ('<spring:message code="label.confirmDialog.question" /> #${galleryId} ?', '${deleteGallery}')"><span
						class="glyphicon glyphicon-remove"></span> <spring:message
							code="label.delete" /></a></li>
			</ul>
		</div>
	</div>
</c:if>