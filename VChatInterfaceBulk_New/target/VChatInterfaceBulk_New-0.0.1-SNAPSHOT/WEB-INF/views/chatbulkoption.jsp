<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentBulkOption</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">
	
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
				<div>
					<div class="card2">
						<div class="card-body">
							<div class="p-10">
								<form class="form-horizontal m-t-10" action="bulkoption" method="post" style="">
									<!-- <div class="form-group"> -->
										<%-- <h4 class="page-title" align="center"><mark> ${objSrcName} - Bulk Un-Subscription </mark></h4> --%>
										</br>
										<div class="form-group">
											<label class="col-md-2 blckcolor" for="bulkType">Bulk Request <span class="required"> </span></label>
												<select required id="bulkType" name="bulkType" class="col-md-2" style="height:30px;">
												<option value="">Select Type</option>
												<option value="chatidopt">ChatId Wise Update</option>
												<option value="statuswiseopt">Status Wise Update</option>
												<option value="priorityopt">Priority Update</option>
												<option value="chatiddeleteopt">Chat Id Delete</option>
											</select>
										</div>
										
										<div class="form-group">
											<label class="col-md-2 blckcolor" for="hub">Agent Hub  <span class="required"> </span></label>
											<select required id="hub" name="hub" class="col-md-2" style="height:30px;">
												<option value="">Select Hub</option>
												<option value="North">North</option>
												<option value="East">East</option>
												<option value="West">West</option>
												<option value="South">South</option>
												<option value="Upeast">UpEast</option>
											</select>
										</div>
										
										<div class="form-group" style="display: none" id="agentType">
											<label class="col-md-2 blckcolor" for="agentType">Agent Type  <span class="required"> </span></label>
											<select id="agentType" name="agentType" class="col-md-2" style="height:35px;">
												<option value="">Please Choose</option>
												<option value="login">Login</option>
												<option value="logout">Logout</option>
												<option value="flogout">Flogout</option>
											</select>
										</div>
										
										<div class="form-group" style="display: none" id="agentPriority">
											<label class="col-md-2 blckcolor" for="agentPriority">Agent Priority <span class="required"> </span></label>
											<select id="agentPriority" name="agentPriority" class="col-md-2">
												<option value="">Please Choose</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="11">11</option>
											</select>
										</div>
										
										<div class="form-group" style="display: none" id="chatid">
											<label class="control-label col-md-2 blckcolor" style="vertical-align: 31px;" for="chatId">ChatId (Bparty Id's with comma separated)  <span class="required"> </span></label>
											<textarea rows="4" cols="50" name="chatId" class="col-md-2" placeholder="Please Enter Bparty Chatids with comma separated"></textarea>														
										</div>
										
										
										<div class="form-group" style="display: none" id="statusFromUpdate">
											<label class="col-md-2 blckcolor" for="statusFrom">Status From  <span class="required"> </span></label>
											<select id="statusFrom" name="statusFrom" class="col-md-2">
												<option value="">Please Choose</option>
												<option value="alogout">Alogout</option>
												<option value="flogout">Flogout</option>
											</select>
										</div>
										<div class="form-group" style="display: none" id="statusToUpdate">
											<label class="col-md-2 blckcolor" for="statusTo">Status To  <span class="required"> </span></label>
											<select id="statusTo" name="statusTo" class="col-md-2">
												<option value="">Select Hub</option>
												<option value="login">Login</option>
												<option value="logout">Logout</option>
											</select>
										</div>
										
										
										<div class="form-group" align="center" style="padding-left:80px;">
											<button class="btn addnew-db" style="margin-top: -0px;">
												Submit</button>
										</div>
									<!-- </div> -->
								</form>
							</div>
							<input type="hidden" id="snackbar" value="${objRes}">
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	 
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>

	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/form-advanced.init.js"></script>
	
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
	<script>
		$(document).ready(function() {
		    $('#datatable').DataTable( {
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false        
		    } );
		} );
	</script>
	<script type="text/javascript">
	$(function () {
        $("#bulkType").change(function () {
            if ($(this).val() == "chatidopt") {
                $("#agentType").show();
            } else {
            	$("#agentType").hide();
            }
            if ($(this).val() == "priorityopt") {
                $("#agentPriority").show();
            } else {
                $("#agentPriority").hide();
            }
            
            if ($(this).val() == "chatiddeleteopt" || $(this).val() == "priorityopt" || $(this).val() == "chatidopt"){
                $("#chatid").show();
            } else {
                $("#chatid").hide();
            }
            
            if ($(this).val() == "statuswiseopt") {
                $("#statusFromUpdate").show();
                $("#statusToUpdate").show();
            } else {
                $("#statusFromUpdate").hide();
                $("#statusToUpdate").hide();
            }
        });
    });
	
	
/* chatidopt
	agentType
	chatid

statuswiseopt
	statusFromUpdate
	statusToUpdate
	
priorityopt
	agentPriority
	chatid
 */	
	
	</script>
	</body>
</html>