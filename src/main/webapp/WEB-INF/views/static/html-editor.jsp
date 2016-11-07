<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
   String requestURL = request.getRequestURL().toString();
   String servletPath = request.getServletPath();
   String appPath = requestURL.substring(0, requestURL.indexOf(servletPath));
%>

<c:set var="domain" value="<%=appPath%>" />

<c:set var="galleryId" value="${param.galleryId}" />

<c:url value="/admin/json/gallery-file-list" var="galleryFileListUrl">
	<c:param name="galleryId" value="${galleryId}" />
</c:url>

<c:url value="/admin/json/code-template-list" var="codeTemplateListUrl" />

<script>
	tinymce
			.init({
				mode : "specific_textareas",
				editor_selector : "mceEditor",
				plugins : [
						"advlist autolink lists link image charmap print preview anchor",
						"searchreplace visualblocks code fullscreen",
						"insertdatetime template table contextmenu paste" ],
				toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
				image_advtab: true,
				height : 400,
				relative_urls : false,
				remove_script_host : false,
				document_base_url : "${domain}",
				templates: "${codeTemplateListUrl}"
				<c:if test="${not empty galleryId}">
				,image_list : "${galleryFileListUrl}"
				</c:if>
			});
</script>
