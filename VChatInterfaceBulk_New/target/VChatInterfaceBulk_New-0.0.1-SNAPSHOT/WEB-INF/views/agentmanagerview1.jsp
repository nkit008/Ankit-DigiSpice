<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentManagerView1</title>
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
	function setEditValue(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u) {
		alert("hiiii");
		
		document.getElementById("id").value = a;
		document.getElementById("operator").value = b;
		document.getElementById("reqType").value = c;
		document.getElementById("partnerName").value = d;
		document.getElementById("number").value = e;
		document.getElementById("newNumber").value = f;
		document.getElementById("allocatedCircle").value = g;
		document.getElementById("chatId").value = h;
		document.getElementById("location").value = i;
		document.getElementById("state").value = j;
		document.getElementById("type").value = k;
		document.getElementById("document").value = l;
		document.getElementById("documentNumber").value = m;
		document.getElementById("agentName").value = n;
		document.getElementById("age").value = o;
		document.getElementById("languages").value = p;
		document.getElementById("partnerRemarks").value = q;
		document.getElementById("adminRemarks").value = r;
		document.getElementById("status").value = s;
		document.getElementById("documentPath").value = t;
		document.getElementById("certificatePath").value = u;
		
		/* window.scrollTo(300, 5000); */
	}
</script>


</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class="container" align="center">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="x_content">
								<h4 class="page-title" align="center"><mark> Partner Request Status </mark></h4>
								<table id="datatable" class="table table-striped table-bordered"  style="width:100%;">
										<thead>
											<tr>										
												<th>Id</th>
												<th>Operator</th>
												<th>Request Type</th>
												<th>Request InsertDate</th>
												<th>Partner Name</th>
												<th>Number</th>
												<th>New Number</th>
												<th>Allocated Circle</th>
												<th>Chat Id</th>
												<th>Location</th>
												<th>State</th>
												<th>Type</th>
												<th>Document</th>
												<th>Document Number</th>
												<th>Agent Name</th>
												<th>Age</th>
												<th>Languages</th>
												<th>Partner Remarks</th>
												<th>Admin Remarks</th>
												<th>Status</th>
												<th>AgentDocImage</th>
												<th>PartnerCertImage</th>
												<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
													<th>Action</th>
												</c:if>	
											</tr>
										</thead>
										<tbody>	
											<c:forEach var="listValue" items="${objList}">
												<tr>
													<td>${listValue.id} </td>
													<td>${listValue.operator} </td>
													<td>${listValue.reqType} </td>
													<td>${listValue.insertDate} </td>
													<td>${listValue.partnerName} </td>
													<td>${listValue.number} </td>
													<td>${listValue.newNumber} </td>
													<td>${listValue.allocatedCircle} </td>
													<td>${listValue.chatId} </td>
													<td>${listValue.location} </td>
													<td>${listValue.state} </td>
													<td>${listValue.type} </td>
													<td>${listValue.document} </td>
													<td>${listValue.documentNumber} </td>
													<td>${listValue.agentName} </td>
													<td>${listValue.age} </td>
													<td>${listValue.languages} </td>
													<td>${listValue.partnerRemarks} </td>
													<td>${listValue.adminRemarks} </td>
													<td>${listValue.status} </td>
													<td><a href="userDoc/${listValue.documentPath}" target="_blank"> ${listValue.documentPath} </a></td>
													<td><a href="venderCert/${listValue.certificatePath}" target="_blank"> ${listValue.certificatePath} </a></td>
													<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
													<td>
														<div class="hidden-sm hidden-xs action-buttons">
															<a class="green" data-toggle="modal"
																data-target="#EditModal"
																onclick="setEditValue('${listValue.id}','${listValue.operator}','${listValue.reqType}','${listValue.partnerName}',
																'${listValue.number}','${listValue.newNumber}','${listValue.allocatedCircle}','${listValue.chatId}','${listValue.location}'
																,'${listValue.state}','${listValue.type}','${listValue.document}','${listValue.documentNumber}','${listValue.agentName}',
																'${listValue.age}','${listValue.languages}','${listValue.partnerRemarks}','${listValue.adminRemarks}',
																'${listValue.status}','${listValue.documentPath}','${listValue.certificatePath}')">
																<i>Action</i>
															</a>
														</div>
													</td>	
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
			</div>
		</div>
	</div>		
			<div class="row" align="center">
				<div class="col-md-12">			
					<div class="modal" id="EditModal" role="dialog">
							<div class="modal-dialog modal-lg">
							 
								<div class="modal-content">
									<!-- <div class="modal-body"> -->
									<form action="agentmanagerupdateAction"
										class="form-horizontal form-label-left" id="edit_form" method="post">
										
										<p>Agent Request Status</p>
										
											<input type="hidden" id="id" value="id" name="id">
										
											<div class="form-group">
												<label class="control-label col-md-3" for="operator">Operator  <span class="required">* </span></label>		
												<input type="text" name="operator" id="operator" class="col-md-4"
												 autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="reqType">Request Type  <span class="required">* </span></label>		
												<input type="text" name="reqType" id="reqType" class="col-md-4"
												 required="required"  autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="partnerName">Partner Name  <span class="required">* </span></label>		
												<input type="text" name="partnerName" id="partnerName" class="col-md-4"
												 required="required" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="number">Number  <span class="required">* </span></label>		
												<input type="text" name="number" id="number" class="col-md-4"
												placeholder="" required="required" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="newNumber">New Number  <span class="required">* </span></label>		
												<input type="text" name="newNumber" id="newNumber" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="allocatedCircle">Allocated Circle  <span class="required">* </span></label>		
												<input type="text" name="allocatedCircle" id="allocatedCircle" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="chatId">Chat Id  <span class="required">* </span></label>		
												<input type="text" name="chatId" id="chatId" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="location">Location  <span class="required">* </span></label>		
												<input type="text" name="location" id="location" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="state">State  <span class="required">* </span></label>		
												<input type="text" name="state" id="state" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #f7f5f5;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="type">Type  <span class="required">* </span></label>		
												<input type="text" name="type" id="type" class="col-md-4"
												placeholder="" autocomplete="off" readonly="readonly" style="background-color: #f7f5f5;"/>	
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3" for="partnerRemarks">Partner Remarks  <span class="required">* </span></label>		
												<textarea name="partnerRemarks" id="partnerRemarks" class="col-md-4" readonly="readonly" style="background-color: #f7f5f5;"></textarea>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="adminRemarks">Admin Remarks  <span class="required">* </span></label>		
												<textarea  required name="adminRemarks" id="adminRemarks" class="col-md-4"></textarea>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="status">Status  <span class="required">* </span></label>		
												<!-- <input type="text" name="status" id="status" class="col-md-4" autocomplete="off" /> -->
												<select required id="status" name="status" class="col-md-4">
													<option value="">Click to Choose...</option>
													<option value="approve">Approve</option>
													<option value="reject">Reject</option>										
												</select>
											</div>
											
											<div class="form-group" align="center">
												<button class="btn addnew-db" style="margin-top: -0px;">
													Submit</button>
											</div>
									</form>
								</div>
							</div>			
							
						
						</div>
					<!-- </div>	
				</div> -->
			</div>
		</div>
	<!-- </div>
</div> -->	
	<!-- end page-wrapper -->

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