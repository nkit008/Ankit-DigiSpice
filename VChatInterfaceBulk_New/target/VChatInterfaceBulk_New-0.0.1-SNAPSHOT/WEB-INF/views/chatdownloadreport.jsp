<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-Outdial Logs Report</title>
<meta name="viewport" content="width=device-width,initial-scale=1">


<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">
<link rel="stylesheet" type="text/css" href="resources/css/buttons.dataTables.min.css">

	
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
					<div class="">
						<div class="card-body">
							<div class="p-10">
								<form class="form-horizontal m-t-10" action="outdiallogs" method="post" >
									<!-- <div class="form-group"> -->
										<%-- <h4 class="page-title" align="center"><mark> ${objSrcName} - Bulk Un-Subscription </mark></h4> --%>
										</br>
										<div class="form-group">
											<label class="col-md-2 blckcolor" for="hub">Report Hub  <span class="required"> </span></label>
											 <select required id="hub" name="hub" class="col-md-2" style="height:30px;">
												<option value="">Select Hub</option>
												<option value="North">North</option>
												<option value="East">East</option>
												<option value="West">West</option>
												<option value="South">South</option>
												<option value="Upeast">UpEast</option>
											</select>
										</div>
										<!-- <div class="form-group" style="display: none" id="datatype"> -->
										<div class="form-group">
											<label class="col-md-2 blckcolor" for="dataType">Data Type  <span class="required"> </span></label>
											<select id="dataType" name="dataType" class="col-md-2" style="height:30px;">
												<option value="">Select Type</option>
												<option value="byChatId">Chat Id</option>
												<option value="byNumber">User Number</option>	
											</select>	
										</div>
										<!-- <div class="form-group" style="display: none" id="chatid"> -->
										<div class="form-group">
											<label class="control-label col-md-2 blckcolor" for="number">Value  <span class="required"> </span></label>		
											<input type="text" name="number" id="number"  style="height:30px;" class="col-md-2"
											placeholder="Please Enter 5 Digits ChatId" minlength="5" maxlength="10" autocomplete="off"/>	
										</div>
										
										<div class="form-group" align="center">
											<button class="btn addnew-db" style="margin-top: -0px; margin-left:80px;">
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
				<div class="col-md-12">
				</div>
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->
    
    
    
    
    <div class="" style="background-color:#FFF; margin-bottom:20px; width:100%; ">
								<div class="card-body bgcrd">
									<div class="x_content">
										<table id="datatable" class="display dtb"  style="width:100%; text-align:center;font-size:11px;">
												<thead>
													<tr  class="trb">
														<th>Date_Time</th>
														<th>ANI</th>
														<th>A_Gender</th>
														<th>A_Chatid</th>
														<th>B_Ani</th>
														<th>B_Circle</th>
														<th>B_Chatid</th>
														<th>Category</th>
														<th>Duration</th>
														<th>Call_Value</th>
														<th>Call_Code</th>
														<th>Reason</th>
														<th>DNIS</th>
														<th>Disconnect</th>
														<th>Flow</th>
														<th>Status</th>								
													</tr>
												</thead>
												<tbody>	
													<c:forEach var="listValue" items="${objResp}">
														<tr>
															<td>${listValue.dateTime} </td>
															<td>${listValue.ani} </td>
															<td>${listValue.aGender} </td>
															<td>${listValue.aChatid} </td>
															<td>${listValue.bAni} </td>
															<td>${listValue.bCircle} </td>
															<td>${listValue.bChatid} </td>
															<td>${listValue.category} </td>
															<td>${listValue.duration} </td>
															<td>${listValue.callValue} </td>
															<td>${listValue.callCode} </td>
															<td>${listValue.reason} </td>
															<td>${listValue.dnis} </td>
															<td>${listValue.disconnect} </td>
															<td>${listValue.flow} </td>
															<td>${listValue.status} </td>
														</tr>
													</c:forEach>		
												</tbody> 	
										</table>
										<input type="hidden" id="snackbar" value="${objRes}">
									</div>
								</div>
							<!-- </div> -->	
						</div>

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	 	
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/dataTables.buttons.min.js" type="text/javascript"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>

	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/form-advanced.init.js"></script>
	
	<script src="resources/js/vfs_fonts.js"></script>
	<script src="resources/js/jszip.min.js"></script>
	<script src="resources/js/buttons.html5.min.js"></script>
 	 	
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
		    	dom: 'lBfrtip',
		        buttons: [
		        	'excelHtml5',
		        ],
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false        
		    } );
		} );
	</script>
	</body>
</html>