function app_consents_valid(divname) {

	var formname = "form_" + divname;
	var requiredIndicator = "#" + formname + " .required";
	console.log(divname + "::" + requiredIndicator);
	var datavalid = true;
	$(requiredIndicator).each(function() {
		if ($(this).is(':checked') == false) {
			datavalid = false;
			if ($(this).hasClass("firstdiv")) {
				$('#first').css('border', '1px solid red');
			}else{
				$('#last').css('border', '1px solid red');
			}
			
		}else{
			if ($(this).hasClass("firstdiv")) {
				$('#first').css('border', '1px solid');
			} else {
				$('#last').css('border', '1px solid');
			}
		}
		

	});
	if (co_borrower_status == "on") {
		var corequiredIndicator = "#" + formname + " .co_required";
		// alert("fr");
		$(corequiredIndicator).each(function() {

			if ($("#co_borrower_credit_check").is(':checked') == false) {
				$('#first').css('border', '1px solid red');
				datavalid = false;
			} else {
				$('#first').css('border', '1px solid');
			}

			if ($("#co_auth-to-recevie1").is(':checked') == false) {
				$('#last').css('border', '1px solid red');
				datavalid = false;

			} else {
				$('#last').css('border', '1px solid');
			}

		});

	}
	// alert(datavalid);
	return datavalid;
}

$(document).ready(function() {
	if (co_borrower_status == "on") {
		$("#co-bor-consent2").show();
		$("#co-bor-consent1").show();
	} else {
		$("#co-bor-consent2").hide();
		$("#co-bor-consent1").hide();
	}
});