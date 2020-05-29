<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-Login_Status_Report</title>
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

<script>
	function setValue(a,b,c,d) {
		document.getElementById("bAni").value = a;
		document.getElementById("loginStatus").value = b;
		document.getElementById("userHub").value = d; 
		document.getElementById("priorityFlag").value = c;
	}
</script>


<script>
	function setValue1(a,b,c,d,e) {
		document.getElementById("bAni").value = a;
		document.getElementById("loginStatus").value = b;
		document.getElementById("userHub").value = d; 
		document.getElementById("priorityFlag").value = c;
		document.getElementById("chatIdNo").value = e;
	}
</script>		

<style type="text/css">

button.dt-button
{
    margin-left: 31px;
    margin-top: 0px;
}

</style>

</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper" style="width:100%;font-size: 12px;">
		<div class="container-fluid" >
			<div class="container" align="center">
              <div class="row">
              <div class="col-md-3"></div>
              <div class="col-md-3"></div>
              <div class="col-md-3"></div>
              <div class="col-md-3"></div>
              </div>  
                
				<div>
					<div class="" >
						<div class="card-body">
							<div class="p-10">
								<form class="form-horizontal m-t-10" action="chatloginstatus" method="post">
									<!-- <div class="form-group"> -->
										<%-- <h4 class="page-title" align="center"><mark> ${objSrcName} - Bulk Un-Subscription </mark></h4> --%>
										</br>
										
										<div class="form-group">
											<label class="col-md-2 blckcolor" for="hub">Login Hub  <span class="required"> </span></label>
											<select required id="hub" name="hub" class="col-md-2" style="height:30px;">
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
										
										<div class="form-group" >
											<label class="col-md-2 blckcolor" for="reqType" >Request  Type <span class="required"> </span></label>
												<select required id="reqType" name="reqType" class="col-md-2" style="height:30px;">
												<option value="">Select Type</option>
												<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">												
													<option value="chatidopt">Chat Id Wise</option>
												</c:if>	
												<option value="hubwiseopt">Hub Wise</option>
											</select>
										</div>
										
										
										
										<div class="form-group" style="display: none" id="chatid">
											<label class="col-md-2 blckcolor" for="chatId">New ChatId  <span class="required"> </span></label>		
											<input type="text" name="chatId" id="chatId" class="col-md-2" style="height:35px;"
											placeholder="Please Enter ChatId" minlength="5" maxlength="8" autocomplete="off"/>	
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
			</div>
			
		</div>
	</div>
	<!-- end page-wrapper -->
    
    
    
    
    <div style="width:100%; margin-left:0px; " >	
			
				<div>
					<div class="card bgcrd"   >
						<div class="card-body">
							<div class="x_content">
								<!-- <h4 class="page-title whtcolor" align="center" > Records </h4> -->
								<table id="datatable" class="display dtb" style="text-align:center;">
										<thead>
											<tr  class="trb">
												<th width="2%">ANI</th>
												<th>Circle</th>
												<th>Chatid</th>
												<th>Login Status</th>
												<th>Updated By</th>
												<th>Status</th>
												<th>Login/ Logout (min)</th>
												<th>Agent Location</th> 
												<th> Last_Call_time  </th>
												<th>Login/logout_date</th>
												<th>Priority</th>
												<th>Partner Name</th>
												<%-- <c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'Limit') || (userObj.role eq 'limit')}"> --%>
													<th>Action</th>
												<%-- </c:if> --%>	
											</tr>
										</thead>
										<tbody>	
											<c:forEach var="listValue" items="${objResp}">
												<tr>
													<td>${listValue.bAni} </td>
													<td>${listValue.bCircle} </td>
													<td>${listValue.bChatid} </td>
													<td>${listValue.loginStatus} </td>
													<td>${listValue.updateStatus} </td>
													<td>${listValue.status} </td>
													<td>${listValue.mnt} </td>
													<td>${listValue.agentCircle} </td>
													<td>${fn:substring(listValue.lastCallTime,0,19)}</td>
													<td>${fn:substring(listValue.loginLogoutDatetime,0,19)}</td>
													<td>${listValue.priorityFlag} </td>
													<td>${listValue.centerName} </td>
													<c:if test="${(userObj.role eq 'Limit') || (userObj.role eq 'limit')}">																
														<c:if test="${(listValue.loginStatus eq 'FLOGOUT')}">
															<td>--</td>	
														</c:if>
														<c:if test="${(listValue.loginStatus ne 'FLOGOUT')}">
															<td>
																<div class="hidden-sm hidden-xs action-buttons">
																	<%-- <a class="green" data-toggle="modal" data-target="#EditModal" onclick="setValue('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}')"><span style="background-color: red;color:#ffffff;padding:10px;">Edit</span></a> --%>
																	<input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal" onclick="setValue('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}')" value="Edit" /><!-- <span style="background-color: red;color:#ffffff;padding:10px;">Edit</span></a> -->
															    </div>
															</td>
														</c:if>
													</c:if>		
													<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin')  || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
													<c:choose>
													<c:when test="${not empty chatIdOptions}">
													<td>
													<div class="hidden-sm hidden-xs action-buttons">
															<%-- <a class="green" data-toggle="modal" data-target="#EditModal" onclick="setValue1('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}','${listValue.bChatid}')"> <span style="background-color: red;color:#ffffff;padding:10px;">Edit</span> </a> --%>
															<input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal" onclick="setValue1('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}','${listValue.bChatid}')" value="Edit" /> <!-- <span style="background-color: red;color:#ffffff;padding:10px;">Edit</span> </a> -->
													</div>
													</td>
												</c:when>
												<c:otherwise>
														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																<%-- <a class="green" data-toggle="modal" data-target="#EditModal" onclick="setValue('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}')"> <span style="background-color:red;color:#ffffff;padding:10px;">Edit</span> </a> --%>
																<input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal" onclick="setValue('${listValue.bAni}','${listValue.loginStatus}','${listValue.priorityFlag}','${listValue.hub}')" value="Edit"/><!--  <span style="background-color:red;color:#ffffff;padding:10px;">Edit</span> </a> -->
															</div>
														</td>
												</c:otherwise>
													
													
												
														</c:choose>
													</c:if>
												</tr>
											</c:forEach>
										</tbody> 	
								</table>
								<input type="hidden" id="snackbar" value="${objRes}">
								
							</div>
						</div>	
					</div>
				</div>
				<div class="row" align="center">
					<div class="col-md-12">			
						<div class="modal" id="EditModal" role="dialog">
								<div class="modal-dialog modal-lg"  style="margin-top:6%;">
								 
									<div class="modal-content">
										<!-- <div class="modal-body"> -->
										<form action="edituser"
											class="form-horizontal form-label-left" id="edit_form" method="post">
											
											<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Agent Request Status</p>
											
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="userHub" style="text-align:right;padding-right:40px;">User Hub </label>		
													<input type="text" name="userHub" id="userHub" class="col-md-4" readonly style="background-color: #cca5bc;"/>	
												</div>
												
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="bAni" style="text-align:right;padding-right:40px;">Ani <span class="required">* </span></label>		
													<input type="text" name="bAni" id="bAni" class="col-md-4" autocomplete="off" readonly style="background-color: #cca5bc;"/>	
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="loginStatus" style="text-align:right;padding-right:40px;">Login Status  <span class="required">* </span></label>		
													<select name="loginStatus" id="loginStatus"  class="col-md-4"> 
														<option value="">Please Choose</option>
														<option value="FLOGOUT">FLOGOUT</option>
														<option value="LOGIN">LOGIN</option>
														<option value="LOGOUT">LOGOUT</option>
													</select>
													
													
													
													<input type="hidden" name="chatIdNo" id="chatIdNo" class="col-md-4" autocomplete="off"/>	
												</div>
												<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin')  || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
													<div class="form-group">
														<label class="control-label col-md-3 blckcolor" for="priorityFlag" style="text-align:right;padding-right:40px;">Priority Flag </label>		
														<select name="priorityFlag" id="priorityFlag"  class="col-md-4"> 
															<option value="">Please Choose</option>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
														</select>
													</div>
												</c:if>
												<c:if test="${(userObj.role eq 'limit') || (userObj.role eq 'Limit')}">
													<input type="hidden" name="priorityFlag" id="priorityFlag" class="col-md-4" autocomplete="off"/>
												</c:if>
												
												<div class="form-group" align="center">
													<button class="btn addnew-db" style="margin-top: -0px;">
														Submit</button>
												</div>					
										</form>
									</div>
								</div>			
							
							</div>
						</div>
					</div>
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

	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js" type="text/javascript"></script>
	 <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js" type="text/javascript"></script> -->
 	 	
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
	
	<script type="text/javascript">
	$(function () {
        $("#reqType").change(function () {
            if ($(this).val() == "chatidopt") {
                $("#chatid").show();
            } else {
                $("#chatid").hide();
            }
        });
    });
	</script>
	</body>
</html>