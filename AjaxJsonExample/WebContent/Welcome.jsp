<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="jquery-1.10.2.js"></script>
<script type="text/javascript">
function Fun1()
{
	alert("fuction called");
	$(document).ready(function() {
		var X=$("#CNM").val();
		
		var Z=$("#FTEXT").val();
	
	$.ajax
	({
		type: "post",
		url: "getdata",
		data: {cmpname:X,imageurl:Z},
		  dataType: "json",
		success: function(data)
		{
			alert("in responce function")
			 $("#myDiv").html(data);
			
		 	$("#SUCCESS").slideDown("fast").delay(3000).slideUp("fast");
 
			setTimeout(function(){
						$("#Company").fadeOut("slow");
						}, 2000);
          
          $("#CNM").val('');
          $("#FTEXT").val('');
			
		},
		error: function(ResponseText)
		{
			$("#ERROR").slideDown("fast").delay(2000).slideUp("fast");
		}
	});
	});
	
}
</script>
</head>
<body>

 <div id="myDiv" style="width: 300px; height: 30px;">Click on the button below</div>
 <input id="CNM" class="form-control" placeholder="Company Name" type="text" name="cname">
 <input id="FTEXT" class="form-control" placeholder="Paste Your image URL Here" type="text" name="fname">
<button type="button" onclick="Fun1()">Change Content</button>
 <div id="SUCCESS" class="alert alert-success text-center" role="alert" style="display: none;"></div>
  <div id="ERROR" class="alert alert-success text-center" role="alert" style="display: none;">Company Registered.</div>
</body>
</html>