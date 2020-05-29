<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentManagerRecords</title>
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
	<!-- <div class="wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="page-title-box">
						<h4 class="page-title" align="center"><mark>All Live Agents</mark></h4>
					</div>
				</div>
		    </div>
			<div class="row"></div>	
		</div>
	</div> -->
	
	
	<div class="wrapper">
		<div class="container-fluid">
			<div class="container" align="center">
				<h5 class="page-title " align="center"><mark><b> All Live Agents</b></mark></h5>
			</div>
		</div>
	</div>
	
	<!-- end page-wrapper -->
    
    
    <div class="" style="width:100%;">
					<div class="">
						<div class="card bgcrd">
							<div class="card-body">
								<div class="x_content">
									<!-- <h4 class="page-title" align="center"><mark> Agent Records </mark></h4> -->
									<!-- <table id="datatable" class="table table-striped table-bordered"  style="width:100%;"> -->
									<table id="datatable" class="display  dtb"  style="width:100%;">
											<thead>											
												<tr class="trb">										
													<th>Hub</th> 
													<th>Partner Name</th>
													<th>Mobile No</th>
													<th>Chat Id</th>
													<th>Agent Name</th>
													<th>Age</th>
													<th>Languages</th>
													<th>Type</th>
													<th>Allocated Circle</th>
													<th>Location</th>
													<th>Agent Document</th>
													<th>Document Number</th>
													<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
														<th>Agent ID Proof Image</th>
														<th>Declaration Form</th>
													</c:if>	
													<th>#</th>
												</tr>
											</thead>
											 <tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>			
														<td><p class="text-capitalize">${listValue.hub}</p> </td>
														<td>${listValue.centerName} </td>
														<td>${listValue.bAni} </td>
														<td>${listValue.bChatid} </td>
														<td>${listValue.agentName} </td>
														<td>${listValue.agentAge} </td>
														<td>${listValue.agentLang} </td>
														<td>${listValue.agentCategory} </td>
														<td>${listValue.bCircle} </td>
														<td>${listValue.agentCircle} </td>
														<td>${listValue.userDoc} </td>
														<td>${listValue.userDocNo} </td>
														<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
															<c:choose>
																<c:when test="${listValue.userDocPath eq 'NA'}">	
																	<td>${listValue.userDocPath} </td>
																</c:when>
																<c:otherwise>
																	<td><a href="userDoc/${listValue.userDocPath}" target="_blank"> ${listValue.userDocPath} </a></td>
																</c:otherwise>
															</c:choose>
															
															<c:choose>
																<c:when test="${listValue.certificatePath eq 'NA'}">	
																	<td>${listValue.certificatePath} </td>
																</c:when>
																<c:otherwise>
																	<td><a href="venderCert/${listValue.certificatePath}" target="_blank"> ${listValue.certificatePath} </a></td>
																</c:otherwise>
															</c:choose>
															
														</c:if>
														<c:choose>
															<c:when test="${empty listValue.bChatid}">
																<td> 
																	<button type="button" class="btn btn-warning btn-sm" onclick="location.href='agentmanagerupdate/${listValue.hub}/${listValue.bAni}/${listValue.centerName}/0/${listValue.agentCategory}/${listValue.bCircle}/${listValue.agentCircle}'">Update</button>
																</td>	
															</c:when>
															<c:otherwise>
																<td>
																	<button type="button" class="btn btn-warning btn-sm" onclick="location.href='agentmanagerupdate/${listValue.hub}/${listValue.bAni}/${listValue.centerName}/${listValue.bChatid}/${listValue.agentCategory}/${listValue.bCircle}/${listValue.agentCircle}'">Update</button>
																</td>	
															</c:otherwise>
														</c:choose>
																
													
														
														<%-- <td>${listValue.partnerName} </td>
														<td>${listValue.mobileNo} </td>
														<td>${listValue.chatId} </td>
														<td>${listValue.agentName} </td>
														<td>${listValue.agentAge} </td>
														<td>${listValue.agentLang} </td>
														<td>${listValue.agentType} </td>
														<td>${listValue.circle} </td>
														<td>${listValue.location} </td>
														<td>${listValue.userDoc} </td>
														<td>${listValue.userDocNo} </td>
														<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
															<td><a href="userDoc/${listValue.userDocPath}" target="_blank"> ${listValue.userDocPath} </a></td>
															<td><a href="venderCert/${listValue.certificatePath}" target="_blank"> ${listValue.certificatePath} </a></td>
														</c:if> 
														<c:choose>
															<c:when test="${empty listValue.chatId}">
																<td> 
																	<button type="button" class="btn btn-warning btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}/${listValue.partnerName}/0/${listValue.agentType}/${listValue.circle}/${listValue.location}'">Update</button>
																</td>	
															</c:when>
															<c:otherwise>
																<td>
																	<button type="button" class="btn btn-warning btn-xs" onclick="location.href='agentmanagerupdate/${listValue.mobileNo}/${listValue.partnerName}/${listValue.chatId}/${listValue.agentType}/${listValue.circle}/${listValue.location}'">Update</button>
																</td>	
															</c:otherwise>
														</c:choose>	 --%>
													</tr>
												</c:forEach>		
											</tbody>  	
										
									</table>
									<input type="hidden" id="snackbar" value="${objRes}">
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
				scrollY:        '65vh',
				scrollCollapse: true,
				//bLengthChange: false,
				paging:         false
		    });
		} );
	</script>
</body>
</html>