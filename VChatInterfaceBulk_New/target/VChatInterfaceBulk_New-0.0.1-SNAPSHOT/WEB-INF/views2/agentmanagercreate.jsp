<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
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
				<%-- <div class="col-sm-12">
					<div class="page-title-box">
						<h2 class="page-title" align="center"><i class="mdi mdi-music-note"></i>${objSrcName}</h2>
					</div>
				</div> --%>
				</br>
				
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="p-20">
								<form class="form-horizontal m-t-10" action="agentmanagercreate" method="post" style="border:1px dotted; black" enctype="multipart/form-data">
									<div class="form-group">
										<h4 class="page-title" align="center"><mark> New Addition </mark></h4>
										</br>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="hub">Hub  <span class="required">* </span></label>
												<select required id="hub" name="hub" class="col-md-4">
												<option value="">Select Hub</option>
													<c:choose>
												<c:when test="${userObj.role eq 'limit'}">
												<c:forEach var="hubName" items="${userHUbList}">
												<option value="${hubName}">${hubName}</option>
												</c:forEach>
												</c:when>
												<c:otherwise>
												<option value="North">North</option>
												<option value="East">East</option>
												<option value="West">West</option>
												<option value="South">South</option>
												<option value="Upeast">UpEast</option>
												</c:otherwise>
												</c:choose>
												</select>
											</div>
											<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin')}">
												<div class="form-group">
													<label class="control-label no-padding-right col-md-3" for="vender">Vender  <span class="required">* </span></label>
													<select required name="vender" id="vender" class="col-md-4">
														<option value="">Choose Vender</option>
													</select>
												</div>
											</c:if>	
											
											<!-- <div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="priority">Priority  <span class="required">* </span></label>
												<select required name="priority" id="priority" class="col-md-4">
													<option value="">Choose Priority</option>
												</select>
											</div> -->
											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="type">Type  <span class="required">* </span></label>
												<select required name="type" id="type" class="col-md-4">
													<option value="">Choose Type</option>
												</select>
											</div>
											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentCircle">Agent Circle  <span class="required">* </span></label>
												
												<select required name="agentCircle" id="agentCircle" class="col-md-4">
													<option value="">Choose Agent Circle</option>
												</select>
											</div>
											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="circle">Circle <span class="required">* </span></label>
												<select required name="circle" id="circle" class="col-md-4">
													<option value="">Choose Circle</option>
												</select>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3" for="ani">New Number  <span class="required">* </span></label>		
												<input type="text" name="ani" id="ani" class="col-md-4"
												placeholder="Please Enter 10 Digits ANI" required="required" minlength="10" maxlength="10" autocomplete="off"/>	
											</div>
											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentDoc">Agent Document <span class="required">* </span></label>		
												<select required id="agentDoc" name="agentDoc" class="col-md-4">
													<option value="">Click to Choose...</option>
													<option value="aadharcard">Aadhar Card</option>
													<option value="pancard">Pan Card</option>
													<option value="voterid">Voterid Card</option>
													<option value="other">Other</option>												
												</select>	
											</div>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentDocNo">Agent Document Number <span class="required">* </span></label>		
												<input type="text" name="agentDocNo" id="agentDocNo" class="col-md-4"
													placeholder="Please Enter the valid Number"  required="required" autocomplete="off"/>	
											</div>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentDocImage">Agent Document Image <span class="required">* </span></label>
												<input type="file" name="agentDocImage" id="agentDocImage" required="required" accept=".jpg" class="col-md-4">	
											</div>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentName">Agent Name <span class="required">* </span></label>		
												<input type="text" name="agentName" id="agentName" class="col-md-4"
													placeholder="Please Enter Agent Name"  required="required" autocomplete="off"/>	
											</div>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentAge">Agent Age <span class="required">* </span></label>		
												<input type="text" name="agentAge" id="agentAge" class="col-md-4"
													placeholder="Please Enter Agent Age" minlength="2" maxlength="2"  required="required" autocomplete="off"/>	
											</div>
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="agentLang">Agent Languages <span class="required">* </span></label>		
												<select required id="agentLang" name="agentLang" class="col-md-4" multiple>
													<option value="">Click to Choose...</option>
													<option value="hin">Hindi</option>
													<option value="eng">English</option>
													<option value="pun">Punjabi</option>
													<option value="kas">Kashmiri</option>												
												</select>	
											</div>
 											
											<div class="form-group">
												<label class="control-label no-padding-right col-md-3" for="venderCertificateImage">Vender Certificate Image <span class="required">* </span></label>
												<input type="file" name="venderCertificateImage" id="venderCertificateImage" required="required" accept=".jpg" class="col-md-4">	
											</div>
										
										<div class="form-group" align="center">
											<button class="btn addnew-db" style="margin-top: -0px;">
												Submit</button>
										</div>
												
									</div>
								</form>
							</div>
							<%-- <input type="hidden" id="agentVenderAjaxResp" value="${agentVenderAjax}">
							<input type="hidden" id="agentPriorityAjaxResp" value="${agentPriorityAjax}">
							<input type="hidden" id="agentTypeAjaxResp" value="${agentTypeAjax}">
							<input type="hidden" id="agentCircleAjaxResp" value="${agentCircleAjax}">
							<input type="hidden" id="agentLocationAjaxResp" value="${agentLocationAjax}"> --%>
							    
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
	
	<!-- <script type="text/javascript">
		$('#amountSelect').hide();
	</script> -->
	<!-- <script type="text/javascript">
		$('#packType').change(function() {
			var value=null;
			value=$(this).val();
			/* alert('selected value is ' + value); */ 
		  if(value=='autoRenew'){
			  $('#amountSelect').show();
			  $('#autoRenew1').show();
			  $('#oneTime1').hide();
			  
		  }else if(value=='oneTime'){
			  $('#amountSelect').show();
			  $('#oneTime1').show();
			  $('#autoRenew1').hide();
			  
		  }else{
			  $('#amountSelect').hide();
			  $('#autoRenew1').hide();
			  $('#oneTime1').hide();
		  }
		});
	</script> -->
	
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


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- <script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function addPlaylist()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/addNewPlaylist";
	
}
</script> -->
</body>
</html>