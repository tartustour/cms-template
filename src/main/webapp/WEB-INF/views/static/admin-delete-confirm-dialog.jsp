<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="deleteItemConfirmDialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">
					<spring:message code="label.confirmDialog.title" />
				</h4>
			</div>
			<div class="modal-body">
				<p id="modal-body"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"
					onclick="closeConfirmDialog ();">
					<spring:message code="label.confirmDialog.close" />
				</button>
				<button type="button" class="btn btn-primary"
					onclick="deleteConfirmDialog ();">
					<spring:message code="label.confirmDialog.delete" />
				</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script
	src="<c:url value="/resources/application/confirmdialog/confirmDialog.js" />"></script>

