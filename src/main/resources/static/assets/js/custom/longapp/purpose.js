function app_purpose_valid(divname) {
	 var formname="form_"+divname;
	var datavalid = true;
	var fouusinput = false; 
	var selected = $(".loantype option:selected").val();
	console.log('loantype selected :'+selected);
	if(selected == "1") {
		console.log('coming into 1 value div');
		var requiredIndicator = "#" + formname + " .requiredrefinance";
		console.log(divname + "::" + requiredIndicator);
		
		$(requiredIndicator).each(function() {

			if ($(this).val() == "") {
				$(this).addClass('has-error');
				;
				$(this).css('background', '#ffd4d4');

				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
				datavalid = false;
				console.log('refinance div ' + $(this).attr("name"));
				// return false;
			} else {
				$(this).css('background', '');
			}
		});
	
		/*	if ($("#noOfMortgages_2").is(':checked') == true) {
				console.log('buyingProcess checked');
				var 2requiredrefinanceIndicator = "#" + formname + " .2requiredrefinance";
				var 1requiredrefinanceIndicator = "#" + formname + " .1requiredrefinance";
				$(1requiredrefinanceIndicator).each(function() {

					if ($(this).val() == "") {
						$(this).addClass('has-error');
						;
						$(this).css('background', '#ffd4d4');

						if (!fouusinput) {
							fouusinput = true;
							$(this).focus();
						}
						datavalid = false;
						console.log('calling ' + $(this).attr("name"));
						// return false;
					} else {
						$(this).css('background', '');
					}
					
				});
				$(2requiredrefinanceIndicator).each(function() {

					if ($(this).val() == "") {
						$(this).addClass('has-error');
						;
						$(this).css('background', '#ffd4d4');

						if (!fouusinput) {
							fouusinput = true;
							$(this).focus();
						}
						datavalid = false;
						console.log('calling ' + $(this).attr("name"));
						// return false;
					} else {
						$(this).css('background', '');
					}
					
				});
		}
		*/
	}else if(selected == "0") {
		console.log('coming into Purchase  div');
		var requiredIndicator = "#" + formname + " .required";
		
		$(requiredIndicator).each(function() {

			if ($(this).val() == "") {
				$(this).addClass('has-error');
				;
				$(this).css('background', '#ffd4d4');

				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
				datavalid = false;
				console.log('calling ' + $(this).attr("name"));
				// return false;
			} else {
				$(this).css('background', '');
			}
			
		});
if ($("#buyingProcess_1").is(':checked') == true) {
		console.log('buyingProcess checked');
	var buyrequiredIndicator = "#" + formname + " .buyrequired";
		
		$(buyrequiredIndicator).each(function() {

			if ($(this).val() == "") {
				$(this).addClass('has-error');
				;
				$(this).css('background', '#ffd4d4');

				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
				datavalid = false;
				console.log('calling ' + $(this).attr("name"));
				// return false;
			} else {
				$(this).css('background', '');
			}
			
		});
			
		}
if ($("#buyingProcess_2").is(':checked') == true) {
	console.log('buyingProcess checked');
var buyrequiredIndicator = "#" + formname + " .buyrequired";
	
	$(buyrequiredIndicator).each(function() {

		if ($(this).val() == "") {
			$(this).addClass('has-error');
			;
			$(this).css('background', '#ffd4d4');

			if (!fouusinput) {
				fouusinput = true;
				$(this).focus();
			}
			datavalid = false;
			console.log('calling ' + $(this).attr("name"));
			// return false;
		} else {
			$(this).css('background', '');
		}
		
	});
		
	}
	}
	console.log("datavalid::" + datavalid);
	return datavalid;
}

$(document).ready(function() {
	$(".noOfMortgages").on("change", function() {
		$(".noOfMortgages_bank").hide();
		if (this.value == "1") {
			$(".bank1").show();
		} else if (this.value == "2") {
			$(".bank1").show();
			$(".bank2").show();
		}
	})

	$(".buyingProcess").on("change", function() {
		$(".downpayment").hide();
		$(".expdate").hide();
		$(".giftamount").hide();
		$(".purchaseprice").hide();
		$(".buying_show").hide();
		console.log(this.value);
		if (this.value == "0") {
			$(".buying_show").show();
			$(".downpayment").show();
			$(".expdate").show();
			$(".giftamount").show();
			$(".purchaseprice").show();
		} else if (this.value == "1") {
			$(".buying_show").show();
			$(".downpayment").show();
			$(".giftamount").show();
			$(".purchaseprice").show();
		}
	})

	if ($("#house_in_mind").prop('checked') == true) {
		// alert("inside");
		$("#address").show();
	} else {
		// alert("asdas");
		$("#address").hide();
	}

	$('#house_in_mind').on('change', function() {
		if ($("#house_in_mind").is(':checked') == true) {
			// alert("inside");
			$("#address").show();
		} else {
			// alert("asdas");
			$("#address").hide();
		}
	});
	$("select.loantype").change(function() {
		 
		var selectedloantype = $(".loantype option:selected").val();
		if (selectedloantype == "0") {
			$("#li_app_assets").removeClass("remove");
			$("#li_app_assets").show();
			$("#refinancepanel").hide();
			$("#purchasepanel").show();

		} else if (selectedloantype == "1") {
			$("#li_app_assets").addClass("remove");
			$("#li_app_assets").hide();
			$("#purchasepanel").hide();
			$("#refinancepanel").show();
		}

	});
	$("#borrower_comments").blur(function() {
		if (this.value.length > 500) {
			this.value = this.value.substring(0, 499);
		}
	});
});
var assertsLi=null;