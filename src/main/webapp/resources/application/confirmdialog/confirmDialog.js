var confirmDialogDeleteUrl;

function closeConfirmDialog() {
	$("#deleteItemConfirmDialog").modal('hide');
};
function deleteConfirmDialog() {
	$("#deleteItemConfirmDialog").modal('hide');
	document.location.href = confirmDialogDeleteUrl;
};

function confirmDialog(prompt, deleteUrl) {
	document.getElementById("modal-body").innerHTML = prompt;
	confirmDialogDeleteUrl = deleteUrl;
	$("#deleteItemConfirmDialog").modal("show");
}