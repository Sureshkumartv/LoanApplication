$(document).ready(function(){
$('.preview_btn').click( function () {
  var tab = $(this);
  console.log(tab);
  var contentId = tab.attr("id");
  var cur_pos=contentId;
  var loadattr=$("#"+cur_pos).attr("load");
    //This check if the tab is active
	if($("#li_"+cur_pos).hasClass("disabled")){
		return false;
	}
       if(!loadattr || loadattr =='n'){
		  loadCurrentPage(cur_pos);
	  }
});
});

 	
     
function loadCurrentPage(cur_pos) {
	showLoadinDiv();
	$cur_posdiv=$("#"+cur_pos);
	var curLi=$("#li_"+cur_pos);
	curLi.removeClass("disabled");
	var formData = new FormData();
	  formData.append("cur_pos",cur_pos);
	  formData.append("lead_id",lead_id);
	 // console.log(formData)	  ;
	  $.ajax({type: "POST", url: base_url+"application/loadpage", cache: false,contentType: false, processData: false,data: formData ,
		success: function(data){
         $cur_posdiv.attr("load","y");
         console.log(data);
		 $cur_posdiv.html(data);
		 defaultFunctions();
		 }
		 ,error: function(data)
		 {
		 	alert("load error");
		 	console.log(data);
		 } 
	  });  
}