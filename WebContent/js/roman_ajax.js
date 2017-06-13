$(document).ready(function() {
	$('#arabicInput').keyup(function() {
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