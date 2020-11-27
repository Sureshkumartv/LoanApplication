function app_assets_valid(divname){
	var formname = "form_" + divname;
	var requiredIndicator = "#" + formname + " .assetsrequired";
	console.log(divname + "::" + requiredIndicator);
	var datavalid=true;
	var fouusinput = false; 
	var selected = $(".accountOwner option:selected").val();
	console.log('accountOwner selected :' + selected);

	if (selected == "borr") {
	$(requiredIndicator).each(function() {
		if($( this ).val()==""){
		 	$( this ).addClass('has-error');
			//$( this ).attr("placeholder", placeholder);
			$( this ).css('background','#ffd4d4');
			if(!fouusinput){
				fouusinput=true;
				$( this ).focus();
			}
			datavalid=false;
			//return false;
		} else {
			$(this).css('background','');
		}
	});
	}else if(selected == "coborr"){
		var requiredCoIndicator = "#" + formname + " .assetscorequired";
		$(requiredCoIndicator).each(function() {
			if($( this ).val()==""){
			 	$( this ).addClass('has-error');
				//$( this ).attr("placeholder", placeholder);
				$( this ).css('background','#ffd4d4');
				if(!fouusinput){
					fouusinput=true;
					$( this ).focus();
				}
				datavalid=false;
				//return false;
				
				console.log('calling ' + $(this).attr("name"));
			} else {
				$(this).css('background','');
			}
		});
	}
console.log('datavalid '+datavalid);
	return datavalid;
}

function app_add_assets_valid(divname)
{
		var datavalid=true;
	var fouusinput=false;
	if(!(($("#1_asset_1_account_name_citi").is(':checked') == true)||($("#1_asset_1_account_name_wells").is(':checked') == true)||($("#1_asset_1_account_name_chase").is(':checked') == true)||($("#1_asset_1_account_name_bofa").is(':checked') == true)||($("#1_asset_1_account_name_other").is(':checked') == true)))
{
	datavalid=false;


}
		     	if(($("#1_asset_1_account_name_citi").is(':checked') == true)||($("#1_asset_1_account_name_wells").is(':checked') == true)||($("#1_asset_1_account_name_chase").is(':checked') == true)||($("#1_asset_1_account_name_bofa").is(':checked') == true)||($("#1_asset_1_account_name_other").is(':checked') == true))
 {
   $(".required62").each(function () {

        if ($(this).val() == "") {
            $(this).addClass('has-error');
         ;
            $(this).css('background','#ffd4d4');
			 
            if (!fouusinput) {
                fouusinput = true;
                $(this).focus();
            }
            datavalid = false;
            // return false;
        } else {
            $(this).css('background','');
        }
    });
// alert("calling this");

}
	return datavalid;
}
if(($("#1_asset_1_account_name_citi").is(':checked') == true)||($("#1_asset_1_account_name_wells").is(':checked') == true)||($("#1_asset_1_account_name_chase").is(':checked') == true)||($("#1_asset_1_account_name_bofa").is(':checked') == true)||($("#1_asset_1_account_name_other").is(':checked') == true))
 {
 		$("#btn_add_asset_app_assets").show();
 	// alert("inside");
 			$("#btn_next_app_assets").hide();
	$("#btn_prev_app_assets").hide();

 }
function button_asset_click(btnid){
	$("#btn_add_asset_app_assets").hide();
	// var str = $( "#btn_add_asset_app_assets" ).text();

	// alert("clicked"+btnid);
	try{
	var nextBtnObj=$("#"+btnid);
	nextBtnObj.hide();

	 var cur_pos=btnid.replace("btn_add_asset_","");

	
	// alert(cur_pos);
	var curLi=$("#li_"+cur_pos);
	var curTabName=curLi.find("span")[0].innerHTML;
	var nextLi=curLi.next();
	var next_pos = "";
	if(cur_pos == "app_confirmation"){
	  next_pos ="app_confirmation";	
	}else{
	next_pos = nextLi.attr("id").replace("li_","");
	}
	 
	var validationFun=cur_pos+"_valid";
	// alert(validationFun);
	var validdata=true;
	validdata=app_add_assets_valid('app_assets');
	if(validdata){
	
	  var curForm=$("#"+cur_pos).find("form");
	 // console.log(curForm);

	  var formData = new FormData(curForm[0]);

	
	  formData.append("cur_pos",cur_pos);
	  formData.append("next_pos",cur_pos);
	  formData.append("lead_id",lead_id);
	
		for (var value of formData.values()) {
   console.log(value); 
}
					
						

	   $.ajax({
			   type: "POST", url: base_url+"application/submitapp", cache: false,  contentType: false, processData: false,
			   data: formData, dataType: "json",
			   success: function(data){
$("#btn_add_asset_app_assets").html("Add");
			   		
			   			$("#btn_next_app_assets").show();
	$("#btn_prev_app_assets").show();
			 // $("input[type='hidden']").remove();
			 	$("#assetid").val('');
			 	$("#1_asset_1_account_name_citi").prop("checked", false);
							$("#1_asset_1_account_name_wells").prop("checked", false)
							$("#1_asset_1_account_name_chase").prop("checked", false);
$("#1_asset_1_account_name_bofa").prop("checked", false);
			 	$("#1_asset_1_account_name_other").prop("checked", false);
			 		$("#1_asset_1_account_type").val('');
						$("#1_asset_1_account_balance").val('');
			   	console.log(data);
				  // nextBtnObj.show();
				   if(data.lead_id == "")
				   {
				     appLoading.html("Their is error while submitting application. please contact us");
					 curLi.addClass("active");
				   }else{
					   if(lead_id == ""){
						 window.location=base_url+"application/curapp";  
					   }else{
						lead_id=data.lead_id;
						if(app_tab_pos!="app_confirmation"){
						  app_tab_pos=next_pos;
						}
						console.log(data.assets);
						var json = data.assets;
						$('#location tbody>tr').remove();
						var tr=null;
  for (var i = 0; i < json.length; i++) {
    tr = $('<tr>');
    	if(json[i].DD0109=="Citi Bank")
						{
									 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank1.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
                       
					 "</div>"+
					"</div>");
						}
							if(json[i].DD0109=="Wells Fargo Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://localhost:8980/themes/tech/assets/images/bank2.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
                       
					 "</div>"+
					
					"</div>");
						}
	                  if(json[i].DD0109=="Chase Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank3.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					"</div>");
						}
						if(json[i].DD0109=="Bank Of America")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank4.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>" +json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}
						if(json[i].DD0109=="Other")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank-other.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109 +"</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}

    // tr.append("<td class='text-center'>" + json[i].DD0109 + "</td>");
    // tr.append("<td class='text-center'>" + json[i].DD0111 + "</td>");
    // tr.append("<td><span class='jsondata text-center' id='"+json[i].id+"'><i
	// class='fa fa-pencil'> </i> </span></td></tr></tbody>");
   
    tr.append("</tr>");
    $('#det').first().append(tr);
  }                    
						 
					   } 
					   
				   } 
			  },error : function(data){
				   nextBtnObj.show();
				 }
			
			});
	
	}
	else{
			nextBtnObj.show();
	}
 }catch(ex){
		console.log(ex);
 }
 return false;
}

function button_delete_click(btnid){
	alert("inside");
	$("#btn_delete_asset_app_assets").hide();
	// var str = $( "#btn_add_asset_app_assets" ).text();

	// alert("clicked"+btnid);
	try{
	var nextBtnObj=$("#"+btnid);
	nextBtnObj.hide();

var cur_pos=btnid.replace("btn_delete_asset_","");
	 
	// alert(validationFun);
	var validdata=true;
	if(validdata){
	
	  var curForm=$("#"+cur_pos).find("form");
	 // console.log(curForm);

	  var formData = new FormData(curForm[0]);

	
	  formData.append("cur_pos",cur_pos);
	  formData.append("next_pos",cur_pos);
	  formData.append("lead_id",lead_id);
	formData.append("call",'asset');
		for (var value of formData.values()) {
   console.log(value); 
}
					
						

	   $.ajax({
			   type: "POST", url: base_url+"application/delete", cache: false,  contentType: false, processData: false,
			   data: formData, dataType: "json",
			   success: function(data){
				   $("#btn_add_asset_app_assets").html("Add");
			   		
			   			$("#btn_next_app_assets").show();
			   			$("#btn_prev_app_assets").show();
			 // $("input[type='hidden']").remove();
			 	$("#assetid").val('');
			 	$("#1_asset_1_account_name_citi").prop("checked", false);
				$("#1_asset_1_account_name_wells").prop("checked", false)
				$("#1_asset_1_account_name_chase").prop("checked", false);
				$("#1_asset_1_account_name_bofa").prop("checked", false);
			 	$("#1_asset_1_account_name_other").prop("checked", false);
			 	$("#1_asset_1_account_type").val('');
				$("#1_asset_1_account_balance").val('');
			   // console.log(data);
				  // nextBtnObj.show();
				   if(data.lead_id == "")
				   {
				     appLoading.html("Their is error while submitting application. please contact us");
					
				   }else{
					   if(lead_id == ""){
						 window.location=base_url+"application/curapp";  
					   }else{
						lead_id=data.lead_id;
						
						// console.log(data.data);
						// console.log(data.data);
					var json = data.data;
						$('#location tbody>tr').remove();
						var tr=null;
  for (var i = 0; i < json.length; i++) {
  	    tr = $('<tr>');
  	if(json[i].DD0109=="Citi Bank")
						{
									 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='https://techniecode.com/longapp/themes/tech/assets/images/bank1.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					"</div>");
						}
							if(json[i].DD0109=="Wells Fargo Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='https://techniecode.com/longapp/themes/tech/assets/images/bank2.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}
	                  if(json[i].DD0109=="Chase Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank3.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					"</div>");
						}
						if(json[i].DD0109=="Bank Of America")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank4.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>" +json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}
						if(json[i].DD0109=="Other")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank-other.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109 +"</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}

    // tr.append("<td class='text-center'>" + json[i].DD0109 + "</td>");
    // tr.append("<td class='text-center'>" + json[i].DD0111 + "</td>");
    // tr.append("<td><span class='jsondata text-center' id='"+json[i].id+"'><i
	// class='fa fa-pencil'> </i> </span></td></tr></tbody>");
   
    tr.append("</tr>");
    $('#det').first().append(tr);
  }                    
                    
						 
					   } 
					   
				   } 
			  },error : function(data){
				   nextBtnObj.show();
				 }
			
			});
	
	}
	else{
			nextBtnObj.show();
	}
 }catch(ex){
		console.log(ex);
 }
 return false;
}

$(document).on("click", '.jsondata', function(event) { 

	$("#btn_next_app_assets").hide();
	$("#btn_prev_app_assets").hide();
	$("#btn_add_asset_app_assets").show();
	$("#btn_delete_asset_app_assets").show();
	$("#btn_add_asset_app_assets").html('Save');
	var index_id = $(this).attr("id");
	var formData1 = new FormData();
	 formData1.append("incomeid",index_id);
	  formData1.append("lead_id",lead_id);
	formData1.append("call",'asset');

	$.ajax({
			   type: "POST", url: base_url+"application/incomeapp", cache: false,  contentType: false, processData: false,
			   data: formData1, dataType: "json",
			   success: function(data){
			   	console.log(data);
				  
				   if(data.lead_id == "")
				   {
				     appLoading.html("Their is error while submitting application. please contact us");
					 curLi.addClass("active");
				   }else{
					   if(lead_id == ""){
						 window.location=base_url+"application/curapp";  
					   }else{
						lead_id=data.lead_id;
						
						console.log(data.data);
						var jsonresp = data.data;
						 	// $('#assetid').attr('disabled', false);
						 	// $("#assetid").append("<input type='hidden'
							// name='incomeid' value="+jsonresp.id);
					$("#assetid").val(jsonresp.id);
						if(jsonresp.DD0109=="Citi Bank")
						{
							$("#1_asset_1_account_name_citi").prop("checked", true);
						}
							if(jsonresp.DD0109=="Wells Fargo Bank")
						{
							$("#1_asset_1_account_name_wells").prop("checked", true);
						}
	                  if(jsonresp.DD0109=="Chase Bank")
						{
							$("#1_asset_1_account_name_chase").prop("checked", true);
						}
						if(jsonresp.DD0109=="Bank Of America")
						{
							$("#1_asset_1_account_name_bofa").prop("checked", true);
						}
						if(jsonresp.DD0109=="Other")
						{
							$("#1_asset_1_account_name_other").prop("checked", true);
						}
						$("#1_asset_1_account_type").val(jsonresp.DD0108);
						$("#1_asset_1_account_balance").val(jsonresp.DD0111);
                      


					   } 
					   
				   } 
			  },error : function(data){
				  console.log(data);
				 }
			
			});

});

$(document).ready(function(){

	$("select.accountOwner").change(function() {
		alert('ok coming');
		var selectedownerType = $(".accountOwner option:selected").val();
		console.log('--------------------------'+selectedownerType)
		if (selectedownerType == "borr") {

			$(".coborr_assets").hide();
			$(".borr_assets").show();
			$(".assets_heading").html("Borrower Assets");

		} else if (selectedownerType == "coborr") {

			$(".borr_assets").hide();
			$(".coborr_assets").show();
			$(".assets_heading").html("Co Borrower Assets");
		}

	});
	
$("#1_asset_1_account_name_citi").prop("checked", false);
							$("#1_asset_1_account_name_wells").prop("checked", false)
							$("#1_asset_1_account_name_chase").prop("checked", false);
$("#1_asset_1_account_name_bofa").prop("checked", false);
			 	$("#1_asset_1_account_name_other").prop("checked", false);
   $('input.radio-inline').change(function() { // on radio's change event
   		if(($("#1_asset_1_account_name_citi").is(':checked') == true)||($("#1_asset_1_account_name_wells").is(':checked') == true)||($("#1_asset_1_account_name_chase").is(':checked') == true)||($("#1_asset_1_account_name_bofa").is(':checked') == true)||($("#1_asset_1_account_name_other").is(':checked') == true))
 {
 		$("#btn_add_asset_app_assets").show();
 		$("#btn_next_app_assets").hide();
	$("#btn_prev_app_assets").hide();

 }
  
  });

	var formData1 = new FormData();
	 // formData1.append("incomeid",index_id);
	  formData1.append("lead_id",lead_id);
	formData1.append("call",'asset');

 $.ajax({
			   type: "POST", url: base_url+"application/loaddata", cache: false,  contentType: false, processData: false,
			   data: formData1, dataType: "json",
			   success: function(data){
			   	console.log(data);
				   // nextBtnObj.show();
				   if(data.lead_id == "")
				   {
				     appLoading.html("Their is error while submitting application. please contact us");
					 curLi.addClass("active");
				   }else{
					   if(lead_id == ""){
						 window.location=base_url+"application/curapp";  
					   }else{
						lead_id=data.lead_id;
						console.log(data.assets);
						var json = data.assets;
						$('#location tbody>tr').remove();
						var tr=null;
  for (var i = 0; i < json.length; i++) {
  	    tr = $('<tr>');
  	if(json[i].DD0109=="Citi Bank")
						{
									 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='https://techniecode.com/longapp/themes/tech/assets/images/bank1.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					"</div>");
						}
							if(json[i].DD0109=="Wells Fargo Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='https://techniecode.com/longapp/themes/tech/assets/images/bank2.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}
	                  if(json[i].DD0109=="Chase Bank")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank3.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109+ "</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					 "<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					"</div>");
						}
						if(json[i].DD0109=="Bank Of America")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank4.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>" +json[i].DD0109+ "</h4>"+
					 "<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}
						if(json[i].DD0109=="Other")
						{
							 tr.append("<div class='row'>"
					 + "<div class='col-md-9 col-xs-9'>"+
					 "<div class='ac_item'>"+
					 "<img class='hidden-xs' src='http://techniecode.com/longapp/themes/tech/assets/images/bank-other.jpg' alt='image' height='42' width='42'>"+
					 "<div class='details'>"+
					 "<h4 class='bank_name'>"+ json[i].DD0109 +"</h4>"+
					"<span class='price'> <span>"+ json[i].DD0108 +" <span>" + json[i].DD0111 +"</span>"+
					 "</div>"+
					  "</div>"+
					 "</div>"+
					 "<div class='col-md-3 col-xs-3'>"+
					"<button class='btn_sqre btn-as-edit btn-xs-ed btn_inline jsondata' id='"+json[i].id+"'' > Edit </button>"+
					 "</div>"+
					
					"</div>");
						}

    // tr.append("<td class='text-center'>" + json[i].DD0109 + "</td>");
    // tr.append("<td class='text-center'>" + json[i].DD0111 + "</td>");
    // tr.append("<td><span class='jsondata text-center' id='"+json[i].id+"'><i
	// class='fa fa-pencil'> </i> </span></td></tr></tbody>");
   
    tr.append("</tr>");
    $('#det').first().append(tr);
  }                    
						 
					   } 
					   
				   } 
			  },error : function(data){
				   nextBtnObj.show();
				 }
			
			});

$(".btn_asset").click(function(){
	// alert("clicked assets");
// $('#form_other_app_employement').append('<input type="hidden"
// name="borrower_employment_type" value="ssn">');
		  button_asset_click(this.id);
	 
	return false;
	});


$(".btn_delete").click(function(){
	// alert("clicked assets");
// $('#form_other_app_employement').append('<input type="hidden"
// name="borrower_employment_type" value="ssn">');
		  button_delete_click(this.id);
	 
	return false;
	});

});