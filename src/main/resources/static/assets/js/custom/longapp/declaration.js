function app_declaration_valid(divname) {

	var datavalid = true;
	var fouusinput = false;

	return datavalid;
}
$(document).ready(function() {
	if (co_borrower_status == "on") {
		$("#co").show();

	} else {
		$("#co").hide();
	}
	if ($("#isBankruptcy").is(':checked') == true) {
		console.log('checking is Yes borr')
		$(".declarationborr").show();
	} else {
		console.log('checking is No borr')
		$(".declarationborr").hide();
	}
	if ($("#coIsBankruptcy").is(':checked') == true) {
		console.log('checking is Yes coborr')
		$(".declarationcoborr").show();
	} else {
		console.log('checking is No coborr')
		$(".declarationcoborr").hide();
	}
	
	
	$('#isBankruptcy').on('change',	function() {
				console.log('isBankruptcy changed'
						+ $("#isBankruptcy").is(':checked'));
				if ($("#isBankruptcy").is(':checked') == true) {
					$('.declarationborr').show();
				} else {
					$(".declarationborr").hide();
				}
			});
	$('#coIsBankruptcy').on('change',	function() {
		console.log('coIsBankruptcy changed'
				+ $("#coIsBankruptcy").is(':checked'));
		if ($("#coIsBankruptcy").is(':checked') == true) {
			$('.declarationcoborr').show();
		} else {
			$(".declarationcoborr").hide();
		}
	});
});