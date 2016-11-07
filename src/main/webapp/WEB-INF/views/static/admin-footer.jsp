<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<hr>
	<footer>
		<p>
			<spring:message code="label.footer" />
		</p>
	</footer>
</div>



<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/bootstrap/3.1.1/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/application/datetimepicker/js/moment.min.js" />"></script>
<script src="<c:url value="/resources/application/datetimepicker/js/bootstrap-datetimepicker.min.js" />"></script>
<script src="<c:url value="/resources/application/common.js" />"></script>

