<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/admin/user/save" var="saveUrl" />
<c:url value="/admin/agency/edit?agencyId=" var="editAgencyUrl" />
<c:set value="/admin/user/edit?userId=" var="redirectUrl" />

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
							<spring:message code="label.user" />
						</h3>
					</div>
					<div class="list-group-item">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="user" method="post" modelAttribute="user"
									action="${saveUrl}" cssClass="form-horizontal">
									<form:hidden path="userId" />
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="username" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="username" cssClass="col-lg-2 control-label">
											<spring:message code="label.username" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="username" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="password" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="password" cssClass="col-lg-2 control-label">
											<spring:message code="label.password" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="password" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="athority" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="athority" cssClass="col-lg-2 control-label">
											<spring:message code="label.athority" />
										</form:label>
										<div class="col-lg-6">
											<form:select path='athority.athorityId' cssClass="form-control">
												<form:options items='${athorities}' itemLabel="name"
													itemValue="athorityId" />
											</form:select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="isEnabled" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="isEnabled" cssClass="col-lg-2 control-label">
											<spring:message code="label.isEnabled" />
										</form:label>
										<div class="col-lg-6">
											<form:checkbox path="isEnabled" />
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