$(document).ready(function() {
	$('#searchItem').keyup(function() {
		$.ajax({
			url : 'search',
			type : 'GET',
			data : {
				searchItem : $('#searchItem').val()
			},
			success : function(result) {
				var output = "";
				console.log(typeof result);
				if(typeof result !== "object") {
					document.location.href = "/MovieBookingWeb/index";
				} else {
					if($.isEmptyObject(result)) {
						output = '<div class="jumbotron jumbotron-fluid nomatch">' +
								 '<div class="container">' +
								 '<h2 class="display-4">Sorry! No matching movies.</h2>' + 
								 '</div></div>'
					}
				
					$.each(result, function(prop, value){
						
						output += '<li class="card movie">' + 
						'<img class="card-img-top" src="' + value.image_url + '" alt="Dr.Seuss The Grinch">' + 
						'<label class="movie-name">' + value.name + '</label>' + 
						'<form method="get" action="showtimes">' + 
						'<input type="hidden" value="' + value.name + '" name="movieName" />' + 
						'<input type="submit" value="SHOWTIMES" class="showtime-btn btn" />' + 
						'</form></li>'
					}) 
					
					$(".movies").html(output);
				}
			}
		});
	});
	
});
