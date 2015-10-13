<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.10.2.js"></script>
 <script>
 /* $("#country").change(
			function() {
				$('#states').html('');
				var state = {
					"country" : $("#country").val()
				};
				$.ajax({
					url : "senddata",
					data : JSON.stringify(state),
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function(res) {
						console.log(res.districts.length);
						for ( var i = 0; i < res.districts.length; i++) {
							console.log(" " + res.districts[i]);
							$('#states').append(
									'<option value=' + res.districts[i] + '>'
											+ res.districts[i]
											+ '</option>');
						}
					}
				});
			});
});
 
  */
 
 
 
 
 
 
    $(document).ready(function() {
        $('#country').change(function(event) {  
        var $country=$("select#country").val();
           $.get('ActionServlet',{countryname:$country},function(responseJson) {  
        	 
           var $select = $('#states');   
          
               $select.find('option').remove();                          
               $.each(responseJson, function(key, value) {               
                   $('<option>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });    
</script>

</head>
<body>
 <h1>AJAX calls to Servlet using JQuery and JSON</h1>
Select Country:
<select id="country">
<option>Select Country</option>
<option value="India">India</option>
<option value="US">US</option>
</select>
<br/>
<br/>
Select State:
<select id="states">
<option>Select State</option>
</select>
</body>
</html>