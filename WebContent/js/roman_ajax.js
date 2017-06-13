$(document).ready(function() {
	$('#arabicInput').keyup(function() {
		$.ajax({
			url : 'RomanNumeralServlet',
			data : {
				arabic : $('#arabicInput').val()
			},
			success : function(response) {
				if (response == "null") {
					$('#romanOutput').html("");
				} else if (response == "NaN") {
					$('#romanOutput').html("<p><font color='red'>Enter a number between 1 and 3999.</font></p>")
				} else {
					$('#romanOutput').html("<p>As Roman numeral: " +response + "</p>");
				}
			},
			error : function() {
				$('#romanOutput').html("<p><font color='red'>Server error.</font></p>");
			}
		});
	});
});