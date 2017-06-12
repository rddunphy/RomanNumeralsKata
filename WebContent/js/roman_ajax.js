$(document).ready(function() {
	$('#arabicInput').keyup(function() {
		var input = $('#arabicInput').val();
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