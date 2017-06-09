$(document).ready(function() {
	$('#arabicInput').keyup(function() {
		var input = $('#arabicInput').val();
	//	$('#romanOutput').text(input);/*
		$.ajax({
			url : 'RomanNumeralServlet',
			data : {
				arabic : $('#arabicInput').val()
			},
			success : function(responseText) {
				$('#romanOutput').text(responseText);
			}
		});
	});
});