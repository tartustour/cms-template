<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<spring:message code="label.insight" />
						</h3>
					</div>
					<div class="list-group-item">
						<div class="row">
							<div class="col-lg-12">
								<c:url value="/admin/insight/save" var="saveUrl" />
								<form:form id="insight" method="post" modelAttribute="insight"
									action="${saveUrl}" cssClass="form-horizontal">
									<form:hidden path="insightId" />
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="billPeriodBegin" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="billPeriodBegin"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.billPeriodBegin" />
										</form:label>
										<div class="col-lg-3">
											<fmt:formatDate type="date"
												value="${insight.billPeriodBegin}" pattern="yyyy-MM-dd"
												var="billPeriodBeginValue" />
											<div class='input-group date' id='beginDate'>
												<input type='text' class="form-control"
													name="billPeriodBegin" value="${billPeriodBeginValue}" />
												<span class="input-group-addon"><span
													class="glyphicon glyphicon-time"></span> </span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="billPeriodEnd" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="billPeriodEnd"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.billPeriodEnd" />
										</form:label>
										<div class="col-lg-3">
											<fmt:formatDate type="date" value="${insight.billPeriodEnd}"
												pattern="yyyy-MM-dd" var="billPeriodEndValue" />
											<div class='input-group date' id='endDate'>
												<input type='text' class="form-control" name="billPeriodEnd"
													value="${billPeriodEndValue}" /> <span
													class="input-group-addon"><span
													class="glyphicon glyphicon-time"></span> </span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="estimatedCost" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="estimatedCost"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.estimatedCost" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="estimatedCost" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="projectedCost" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="projectedCost"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.projectedCost" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="projectedCost" cssClass="form-control" />
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="estimatedUsage" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="estimatedUsage"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.estimatedUsage" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="estimatedUsage" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="projectedUsage" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="projectedUsage"
											cssClass="col-lg-2 control-label">
											<spring:message code="label.projectedUsage" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="projectedUsage" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="currency" cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="currency" cssClass="col-lg-2 control-label">
											<spring:message code="label.currency" />
										</form:label>
										<div class="col-lg-6">
											<form:input path="currency" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-6 col-lg-offset-2">
											<form:errors path="isActivePeakEnergyUsage"
												cssClass="text-danger" />
										</div>
									</div>
									<div class="form-group">
										<form:label path="isActivePeakEnergyUsage" cssClass="col-lg-2 control-label">
											<spring:message code="label.isActivePeakEnergyUsage" />
										</form:label>
										<div class="col-lg-6">
											<form:checkbox path="isActivePeakEnergyUsage" />
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