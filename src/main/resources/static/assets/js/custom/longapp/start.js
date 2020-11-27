function app_start_valid(divname) {
	if ($("#coBorrowerStatus").is(':checked') == true) {
		co_borrower_status = $('#coBorrowerStatus').val();
		// alert("calling this");
	} else {
		// alert("calling else");
		co_borrower_status = "";
	}
	// alert(divname);
	var datavalid = true;
	var fouusinput = false;
	// alert("app_start_valid");
	$(".required").each(function() {
		if ($(this).val() == "") {

			$(this).addClass('has-error');
			// $( this ).attr("placeholder", placeholder);
			$(this).css('background', '#ffd4d4');
			if (!fouusinput) {
				fouusinput = true;
				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
			}

			datavalid = false;

		} else {
			$(this).css('background', '');

		}

	});

	// input field validation-yns-start
	
	//Borrower Start
	$("#borrowerFirstName").val($.trim($("#borrowerFirstName").val()));
	var $regexname = /^([a-zA-Z]{2,24})$/;
	if (!$("#borrowerFirstName").val().match($regexname)) {
		// there is a mismatch, hence show the error message
		$("#borrowerFirstName").css('background-color', '#ffd4d4');

		datavalid = false;
	} else {
		
	}
	
	$("#borrowerMiddleName").val($.trim($("#borrowerMiddleName").val()));
	var $regexname = /^([a-zA-Z]{2,24})$/;
	if (!$("#borrowerMiddleName").val().match($regexname)) {
		
	} else {
		
	}
	
	$("#borrowerLastName").val($.trim($("#borrowerLastName").val()));
	var $regexname = /^([a-zA-Z]{2,24})$/;
	if (!$("#borrowerLastName").val().match($regexname)) {
		// there is a mismatch, hence show the error message
		$("#borrowerLastName").css('background-color', '#ffd4d4');

		datavalid = false;
	} else {
		
	}
	
	$("#borrowerSuffix").val($.trim($("#borrowerSuffix").val()));
	var $regexname = /^([a-zA-Z]{2,24})$/;
	if (!$("#borrowerSuffix").val().match($regexname)) {
		
	} else {
		
	}

	if (!$("#borrowerCellphone")
			.val()
			.match(
					/^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/)) {
		// there is a mismatch, hence show the error message
		$("#borrowerCellphone").css('background-color', '#ffd4d4');
		datavalid = false;
	} else {
		
	}
	
	
	
	// input field validation-yns-end

	if ($("#borrowerEmailid").hasClass("emailerror")) {
		err = 1;
		$(this).css('background', '#ffd4d4');
		if (!fouusinput) {
			fouusinput = true;
			$(this).focus();
		}
		datavalid = false;

	}
	var str = $("#borrowerEmailid").val();
	if (!str
			.match(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/)) {
		$("#borrowerEmailid").css('background', '#ffd4d4');
		$("#borrowerEmailid").focus();
		datavalid = false;
	}
	
	//Borrower end
	
	if ($("#coBorrowerStatus").is(':checked') == true) {
		// alert('coming');
		$(".start_co_required").each(function() {

			if ($(this).val() == "") {
				$(this).addClass('has-error');

				$(this).css('background', '#ffd4d4');
				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
				datavalid = false;
				// return false;
			} else {
				$(this).css('background', '');
			}
		});
		
		if ($("#coBorrowerEmailid").hasClass("emailerror")) {
			err = 1;
			$(this).css('background', '#ffd4d4');
			if (!fouusinput) {
				fouusinput = true;
				$(this).focus();
			}
			datavalid = false;

		}
		var str = $("#coBorrowerEmailid").val();
		if (!str
				.match(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/)) {
			$("#coBorrowerEmailid").css('background', '#ffd4d4');
			$("#coBorrowerEmailid").focus();
			datavalid = false;
		}
		
		
		// input field validation-yns-Start
		//Co-Borrower Start
		$("#coBorrowerFirstName").val($.trim($("#coBorrowerFirstName").val()));
		var $regexname = /^([a-zA-Z]{2,24})$/;
		if (!$("#coBorrowerFirstName").val().match($regexname)) {
			// there is a mismatch, hence show the error message
			$("#coBorrowerFirstName").css('background-color', '#ffd4d4');

			datavalid = false;
		} else {
			
		}
		
		$("#coBorrowerMiddleName").val($.trim($("#coBorrowerMiddleName").val()));
		var $regexname = /^([a-zA-Z]{2,24})$/;
		if (!$("#coBorrowerMiddleName").val().match($regexname)) {
			
		} else {
			
		}
		
		$("#coBorrowerLastName").val($.trim($("#coBorrowerLastName").val()));
		var $regexname = /^([a-zA-Z]{2,24})$/;
		if (!$("#coBorrowerLastName").val().match($regexname)) {
			// there is a mismatch, hence show the error message
			$("#coBorrowerLastName").css('background-color', '#ffd4d4');

			datavalid = false;
		} else {
			
		}
		
		$("#coBorrowerSuffix").val($.trim($("#coBorrowerSuffix").val()));
		var $regexname = /^([a-zA-Z]{2,24})$/;
		if (!$("#coBorrowerSuffix").val().match($regexname)) {
			
		} else {
			
		}

		if (!$("#coBorrowerCellphone")
				.val()
				.match(
						/^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$/)) {
			// there is a mismatch, hence show the error message
			$("#coBorrowerCellphone").css('background-color', '#ffd4d4');
			datavalid = false;
		} else {
			
		}
		
		
		
		//Co-Borrower End
		
		
		
		// input field validation-yns-end
		
	}
	console.log("start return :" + datavalid);
	return datavalid;
}

$(document).ready(
		function() {
			if ($("#coBorrowerStatus").is(':checked') == true) {
				// alert('coming function');
				$('.coborrw').show();
				$('#testNameHidden').disabled = true;
			} else {

				$('#borrowerMaritalStatus').disabled = true;
				$('.coborrw').hide();
				$('#coBorrowerFirstName').val("");
				$('#coBorrowerMiddleName').val("");
				$('#coBorrowerLastName').val("");
				$('#coBorrowerSuffix').val("");
				$('#coBorrowerEmail').val("");
			}
			$('#coBorrowerStatus').on(
					'change',
					function() {
						console.log('coBorrowerStatus changed'
								+ $("#coBorrowerStatus").is(':checked'));
						if ($("#coBorrowerStatus").is(':checked') == true) {
							$('.coborrw').show();
							$('#testNameHidden').disabled = true;
						} else {

							$("#coBorrowerStatus").val("");
							$('.coborrw').hide();
							$('#coBorrowerFirstName').val("");
							$('#coBorrowerMiddleName').val("");
							$('#coBorrowerLastName').val("");
							$('#coBorrowerSuffix').val("");
							$('#coBorrowerEmail').val("");
						}
					});

		});
