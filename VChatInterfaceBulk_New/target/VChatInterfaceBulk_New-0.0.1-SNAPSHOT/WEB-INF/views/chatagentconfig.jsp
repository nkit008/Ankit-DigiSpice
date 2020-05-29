<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentConfiguration</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="resources/css/component.css">
<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>



</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class="container" align="center">
				</br>
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="card2">
						<div class="card-body">
							<div class="p-20">
								<form class="form-horizontal m-t-10" action="agentconfig" method="post" style="" enctype="multipart/form-data">
									<div class="form-group">
										<h4 class="page-title" align="center"> Agent Configuration </h4>
										</br>
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="hub">Hub  <span class="required"> </span></label>
											<select required id="hub" name="hub" class="col-md-4">
												<option value="">Select Hub</option>
												<option value="North">North</option>
												<option value="East">East</option>
												<option value="West">West</option>
												<option value="South">South</option>
												<option value="Upeast">UpEast</option>
											</select>
										</div>
										
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="vender">Vender  <span class="required"> </span></label>
											<select required name="vender" id="vender" class="col-md-4">
												<option value="">Choose Vender</option>
											</select>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3 blckcolor" for="ani">New Number  <span class="required"> </span></label>		
											<input type="text" name="ani" id="ani" class="col-md-4"
											placeholder="Please Enter 10 Digits ANI" required="required" minlength="10" maxlength="10" autocomplete="off"/>	
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 blckcolor" for="chatid">Chat Id  <span class="required"> </span></label>		
											<input type="text" name="chatid" id="chatid" class="col-md-4"
											placeholder="Please Enter 5 Digits Chat Id" required="required" minlength="5" maxlength="5" autocomplete="off"/>	
										</div>	
										
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="priority">Priority  <span class="required"> </span></label>
											<select required name="priority" id="priority" class="col-md-4">
												<option value="">Choose Priority</option>
											</select>
										</div>
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="type">Type  <span class="required"> </span></label>
											<select required name="type" id="type" class="col-md-4">
												<option value="">Choose Type</option>
											</select>
										</div>
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="circle">Circle <span class="required"> </span></label>
											<select required name="circle" id="circle" class="col-md-4">
												<option value="">Choose Circle</option>
											</select>
										</div>
										
										<div class="form-group">
											<label class="control-label no-padding-right col-md-3 blckcolor" for="agentCircle">Agent Location  <span class="required"> </span></label>												
											<select required name="agentCircle" id="agentCircle" class="col-md-4">
												<option value="">Choose Agent Location</option>
											</select>
										</div>
										<div class="form-group" align="center">
											<button class="btn addnew-db" style="margin-top: -0px; margin-left:25px;">
												Submit</button>
										</div>
												
									</div>
								</form>
							</div>    
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
				
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${objResp}">
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/custom-file-input.js"></script>

	<!-- jQuery  -->
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>
	<!--datepicker -->
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/jquery.form-advanced.init.js"></script>
	<script type="text/javascript" src="resources/js/bootbox.js"></script>

	<script type="text/javascript">
	$(document).ready(function(){
	       
	       var x= document.getElementById("snackbar").value;
	       
	              bootbox.alert({
	              message: x, 
	              size: 'small',
	              callback: function(){}
	              });
	       
	});
	</script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('#hub').change(function(event) {
			
			var hub = $("select#hub").val();
			$.getJSON('ajaxAction', {
				hubName : hub
			}, function(jsonResponse) {
				var select = $('#vender');
				select.find('option').remove();
				$.each(jsonResponse.venderMap, function(key, value) {				
					$('<option>').val(value).text(key).appendTo(select);
				});
				var select1 = $('#priority');
				select1.find('option').remove();
				$.each(jsonResponse.priorityMap, function(key, value) {
					$('<option>').val(key).text(value).appendTo(select1);
				});
				var select2 = $('#type');
				select2.find('option').remove();
				$.each(jsonResponse.typeMap, function(key, value) {
					$('<option>').val(key).text(value).appendTo(select2);
				});
				var select3 = $('#circle');
				select3.find('option').remove();
				$.each(jsonResponse.circleMap, function(key, value) {
					$('<option>').val(key).text(value).appendTo(select3);
				});
				var select4 = $('#agentCircle');
				select4.find('option').remove();
				$.each(jsonResponse.agentLocationMap, function(key, value) {
					$('<option>').val(key).text(value).appendTo(select4);
				});
			});
		});
	});
</script>

</body>
</html>