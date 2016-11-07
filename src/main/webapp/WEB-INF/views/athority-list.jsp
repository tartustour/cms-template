<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<jsp:include page="static/admin-header.jsp" flush="true" />

<body>
	<jsp:include page="static/admin-menu.jsp" flush="true" />

	<c:url value="/admin/athority/add" var="addUrl" />
	<c:url value="/admin/athority/edit?athorityId=" var="editUrl" />
	<c:url value="/admin/athority/delete?athorityId=" var="deleteUrl" />

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="list-group">
					<div class="list-group-item active">
						<h3 class="panel-title">
							<spring:message code="label.athority" />
						</h3>
					</div>
					<div class="list-group-item">
						<div class="row">
							<div class="col-lg-12">
								<a href="${addUrl}" class="btn btn-default btn-small pull-right"><span
									class="glyphicon glyphicon-plus"></span> <spring:message
										code="label.addItem" /></a>
							</div>
						</div>
						<c:if test="${not empty successMessage}">
							<div class="row">
								<div class="col-lg-12">
									<p>
									<div class="alert alert-success">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<spring:message code="${successMessage}" />
									</div>
								</div>
							</div>
						</c:if>
						<c:if test="${not empty errorMessage}">
							<div class="row">
								<div class="col-lg-12">
									<p>
									<div class="alert alert-danger">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<spring:message code="${errorMessage}" />
									</div>
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col-lg-12">
								<spring:message code="label.id" var="titleAthorityId" />
								<spring:message code="label.name" var="titleAthorityName" />
								<display:table name="athorityList"
									class="table table-condensed table-hover" uid="athorityList"
									id="athorityList" sort="external" defaultsort="1" partialList="true"
									pagesize="${pageSize}" size="${listSize}" requestURI="">
									<display:column property="athorityId" title="${titleAthorityId}"
										sortable="true" sortName="athorityId" class="col-lg-2" />
									<display:column property="name" title="${titleAthorityName}"
										sortable="true" sortName="name" class="col-lg-9" />
									<display:column title="" media="html" class="col-lg-1">
										<div class="btn-group pull-right">
											<button type="button"
												class="btn btn-default btn-small dropdown-toggle"
												data-toggle="dropdown">
												<spring:message code="label.item" />
												<span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a href="${editUrl}${athorityList.athorityId}"><span
														class="glyphicon glyphicon-edit"></span> <spring:message
															code="label.edit" /></a></li>
												<li class="divider"></li>
												<li><a href="#"
													onclick="confirmDialog ('<spring:message code="label.confirmDialog.question" /> #${athorityList.athorityId} ?', '${deleteUrl}${athorityList.athorityId}')"><span
														class="glyphicon glyphicon-remove"></span> <spring:message
															code="label.delete" /></a></li>
											</ul>
										</div>
									</display:column>
								</display:table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="static/admin-delete-confirm-dialog.jsp" flush="true" />
	<jsp:include page="static/admin-footer.jsp" flush="true" />
</body>
</html>