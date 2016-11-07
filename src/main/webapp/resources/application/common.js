$(function() {

	if ($('#addresspicker').length) {

		var addresspickerMap = $("#addresspicker").addresspicker({
			draggableMarker : false,
			mapOptions : {
				zoom : 5,
				center : new google.maps.LatLng(0, 0),
				scrollwheel : false,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			},
			elements : {
				map : "#map",
				lat : "#latitude",
				lng : "#longitude"
			},
			autocomplete : 'default'
		});

		var gmarker = addresspickerMap.addresspicker("marker");
		gmarker.setVisible(true);
		addresspickerMap.addresspicker("updatePosition");
	}

	if ($('#ufl-link').length) {
		$("#ufl-link").click(function() {
			var link = $(this);
			if ($("#name").val().length) {
				var vHref = link.attr("href");
				var vSend = $("#name").val();
				$.post(vHref, {
					name : vSend
				}, function(data) {
					$('#ufl').val(data);
				});
			}
			return false;
		});
	}

	if ($('#date').length) {
		$('#date').datetimepicker({
			format : 'YYYY',
			pickTime : false
		});
	}
	if ($('#beginDate').length) {
		$('#beginDate').datetimepicker({
			format : 'YYYY-MM-DD',
			pickTime : false
		});
	}
	if ($('#endDate').length) {
		$('#endDate').datetimepicker({
			format : 'YYYY-MM-DD',
			pickTime : false
		});
	}

	if ($('#issueDate').length) {
		$('#issueDate').datetimepicker({
			format : 'YYYY-MM-DD',
			pickTime : false
		});
	}

	
	if ($('#arrivalTime').length) {
		$('#arrivalTime').datetimepicker({
			format : 'HH:mm',
			minuteStepping : 1,
			pickDate : false

		});
	}
	if ($('#departureTime').length) {
		$('#departureTime').datetimepicker({
			format : 'HH:mm',
			pickDate : false,
			minuteStepping : 1
		});
	}

	if ($('#dateTime').length) {
		$('#dateTime').datetimepicker({
			format : 'YYYY-MM-DD HH:mm',
			minuteStepping : 1
		});
	}

	if ($('#tab').length) {
		$('#tab a:first').tab('show');
	}

	if ($('.collapse').length) {
		$('.collapse').collapse({
			toggle : false
		});
	}

	if ($('.collapse').length) {
		$('.collapse').collapse({
			toggle : false
		});
	}
});

function selectgallery(obj,imgUrl)
{
	var img = $(obj.options[obj.selectedIndex]).attr("selimg");
	$("#showgalimg").html("<img src='"+imgUrl+img+"' width='121' height='80'>");
}
