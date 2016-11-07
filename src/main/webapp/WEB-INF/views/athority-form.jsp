<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<jsp:include page="static/admin-header.jsp" flush="true" />

<body>
	<jsp:include page="static/admin-menu.jsp" flush="true" />
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
								<c:url value="/admin/athority/save" var="saveUrl" />
								<form:form id="athority" method="post" modelAttribute="athority"
									action="${saveUrl}" cssClass="form-horizontal">
									<form:hidden path="athorityId" />
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="name" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="name" cssClass="col-lg-2 control-label">
											<spring:message code="label.name" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="name" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="athorityRole" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="athorityRole" cssClass="col-lg-2 control-label">
											<spring:message code="label.athority" />
										</form:label>
										<div class="col-lg-6">
											<select id="athorityRole" name="athorityRole" class="form-control">
												<c:forEach var="item" items="${athorities}">
													<spring:message code="${item.name}" var="athorityRoleValue" />
													<c:if test="${athority.athorityRole == item.identifier}">
														<option value="${item.identifier}" selected="selected">${athorityRoleValue}</option>
													</c:if>
													<c:if test="${athority.athorityRole != item.identifier}">
														<option value="${item.identifier}">${athorityRoleValue}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-lg-offset-2">
										<button type="submit" class="btn btn-primary">
											<spring:message code="label.save" />
										</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="static/admin-footer.jsp" flush="true" />
</body>
</html>