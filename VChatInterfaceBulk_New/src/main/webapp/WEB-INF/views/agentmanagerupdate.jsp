<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentManagerUpdate</title>
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

</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class="container" align="center">
				</br>
				
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="p-20">
								<form class="form-horizontal m-t-10" action="updateProfileReq" method="post" style="border:1px dotted; black">
									<div class="form-group">
										<h4 class="page-title" align="center"><mark> Agent Update </mark></h4>
										</br>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3 blckcolor" for="hub" style="text-align:right;padding-right:40px;">Hub  <span class="required">* </span></label>
												<input type="text" value="${hub}" name="hub" id="hub"  class="col-md-4" required="required" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												<!-- <select required id="hub" name="hub" class="col-md-4">
													<option value="">Select Hub</option>
													<option value="North">All</option>
													<option value="">Select Hub</option>
													<option value="North">North</option>
													<option value="East">East</option>
													<option value="West">West</option>
													<option value="South">South</option>
													<option value="Upeast">UpEast</option> 
												</select> -->
											</div>					
											
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="reqType" style="text-align:right;padding-right:40px;">Request Type <span class="required">* </span></label>
												<select required id="reqType" name="reqType" class="col-md-4">
													<option value="">Click to Choose...</option>
													<option value="chatidChange">Chat Id Change</option>
													<option value="circleChange">Circle Change</option>
													<option value="delete">Deletion</option>
													<option value="locationChange">Location Change</option>
													<!-- <option value="numberChange">Number Change</option> -->
													<option value="typeChange">Type Change</option>				
												</select>													
											</div>
											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3 blckcolor" for="vender" style="text-align:right;padding-right:40px;">Vender  <span class="required">* </span></label>
												<input type="text" value="${vender}" name="vender" id="vender"  class="col-md-4" required="required" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												<!--  <select required name="vender" id="vender" class="col-md-4">
													<option value="">Choose Vender</option>
												</select>-->
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="userNumber" style="text-align:right;padding-right:40px;">Existing Number <span class="required">* </span></label>		
												<input type="text" value="${userNumber}" name="userNumber" id="userNumber"  class="col-md-4"
												placeholder="Please Enter 10 Digits ANI" required="required" autocomplete="off" readonly  style="background-color: #cca5bc;"/>	
											</div>
											
											<div class="form-group" style="display: none" id="agentType">
												<div class="form-group"> 
													<label class="control-label no-padding-right col-md-3 blckcolor" for="usertype" style="text-align:right;padding-right:40px;">Existing Type <span class="required">* </span></label>
													<input type="text" value="${usertype}"  class="col-md-4" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												</div>	
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3 blckcolor" for="newAgentType" style="text-align:right;padding-right:40px;">Type <span class="required">* </span></label>
													<select name="newAgentType" id="newAgentType" class="col-md-4">
														<option value="">Choose Type</option>
														<option value="Agent">Agent</option>
														<option value="FL">FL</option>
														<option value="Night Shift">Night Shift</option>
													</select>
												</div>	
											</div>
											
											<div class="form-group" style="display: none" id="agentLocation">
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3 blckcolor" for="userLoc" style="text-align:right;padding-right:40px;">Agent Existing Location<span class="required">* </span></label>
													<input type="text" value="${userLoc}"  class="col-md-4" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												</div>
												<div class="form-group">	
													<label class="control-label no-padding-right col-md-3 blckcolor" for="newLocation" style="text-align:right;padding-right:40px;">Agent Location<span class="required">* </span></label>												
													<select name="newLocation" id="newLocation" class="col-md-4">
														<option value="">Choose Agent Circle</option>
													</select>
												</div>	
											</div>
											
											<div class="form-group" style="display: none" id="agentCircle">
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3 blckcolor" for="userCir" style="text-align:right;padding-right:40px;">Existing Circle<span class="required">* </span></label>
													<input type="text" value="${userCir}" class="col-md-4" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												</div>	
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3 blckcolor" for="newCircle" style="text-align:right;padding-right:40px;">New Circle <span class="required">* </span></label>
													<select name="newCircle" id="newCircle" class="col-md-4">
														<option value="">Choose Circle</option>
													</select>
												</div>	
											</div>
											
											<div class="form-group" style="display: none" id="newAni">
												<label class="control-label col-md-3 blckcolor" for="newAni" style="text-align:right;padding-right:40px;">New Number <span class="required">* </span></label>		
												<input type="text" name="newAni" id="newAni" class="col-md-4"
												placeholder="Please Enter 10 Digits ANI" minlength="10" maxlength="10" autocomplete="off"/>	
											</div>
											
											<div class="form-group" style="display: none" id="newChatid">
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3 blckcolor" for="userChat" style="text-align:right;padding-right:40px;">Existing ChatId<span class="required">* </span></label>
													<input type="text" value="${userChat}"  class="col-md-4" autocomplete="off" readonly  style="background-color: #cca5bc;"/>
												</div>	
												<div class="form-group">										
													<label class="control-label col-md-3 blckcolor" for="newChatid" style="text-align:right;padding-right:40px;">New ChatId <span class="required">* </span></label>		
													<input type="text" name="newChatid" id="newChatid" class="col-md-4"
													placeholder="Please Enter 5 Digits ChatId" minlength="5" maxlength="7" autocomplete="off"/>
												</div>		
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="userRemarks" style="text-align:right;padding-right:40px;vertical-align: 40px;">Remarks <span class="required">* </span></label>		
												<textarea rows="4" cols="50" name="userRemarks" class="col-md-4" placeholder="Please Enter User Descritpion" required="required" autocomplete="off"></textarea>	
											</div>
											
											<div class="form-group" align="center">
												<button class="btn addnew-db" style="margin-top: -0px;">
													Submit</button>
												<button class="btn addnew-db" style="margin-top: -0px;" onclick="location.href='agentmanagerrecords'">Back</button>		
											</div>
												
									</div>
								</form>
							</div>
							<input type="hidden" id="snackbar" value="${success}">
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
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
			
			
			/* $('#hub').change(function(event) { */
				
				var hub = $("select#hub").val();
				$.getJSON('ajaxAction', {
					hubName : 'North'
				}, function(jsonResponse) {
					/* var select = $('#vender');
					select.find('option').remove();
					$.each(jsonResponse.venderMap, function(key, value) {				
						$('<option>').val(value).text(key).appendTo(select);
					}); */
					/* var select1 = $('#priority');
					select1.find('option').remove();
					$.each(jsonResponse.priorityMap, function(key, value) {
						$('<option>').val(key).text(value).appendTo(select1);
					}); 
					var select2 = $('#newAgentType');
					select2.find('option').remove();
					$.each(jsonResponse.typeMap, function(key, value) {
						$('<option>').val(key).text(value).appendTo(select2);
					}); */
					var select3 = $('#newCircle');
					select3.find('option').remove();
					$.each(jsonResponse.agentLocationMap, function(key, value) {
						$('<option>').val(key).text(value).appendTo(select3);
					});
					var select4 = $('#newLocation');
					select4.find('option').remove();
					$.each(jsonResponse.agentLocationMap, function(key, value) {
						$('<option>').val(key).text(value).appendTo(select4);
					});
				});
			/* }); */
		});
	</script>
	
	<script type="text/javascript">
	$(function(){
        $("#reqType").change(function () {
            if ($(this).val() == "chatidChange") {
                $("#newChatid").show();
            } else {
                $("#newChatid").hide();
            }
            
            if ($(this).val() == "circleChange") {
                $("#agentCircle").show();
            } else {
                $("#agentCircle").hide();
            }
            
            if ($(this).val() == "locationChange") {
                $("#agentLocation").show();
            } else {
                $("#agentLocation").hide();
            }
            
            if ($(this).val() == "numberChange") {
                $("#newAni").show();
            } else {
                $("#newAni").hide();
            }
            
            if ($(this).val() == "typeChange") {
                $("#agentType").show();
            } else {
                $("#agentType").hide();
            }
        });
    });
	</script>
	
</body>
</html>