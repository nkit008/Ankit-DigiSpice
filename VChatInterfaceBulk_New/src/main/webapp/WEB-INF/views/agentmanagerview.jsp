<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-AgentManagerView</title>
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

<script type="text/javascript">
	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	}
</script>


<script>
	function setEditValue(a,b,c,d,e,f,g,h,j,k,l,m,n,o,p,q,r,s,t,u) {
		document.getElementById("hub").value = ""; 
		document.getElementById("reqType").value = "";
		document.getElementById("partnerName").value = "";
		document.getElementById("number").value = "";
		document.getElementById("newNumber").value = "";
		document.getElementById("allocatedCircle").value = "";
		document.getElementById("chatId").value = "";
		document.getElementById("location").value = "";
		document.getElementById("type").value = "";
		document.getElementById("document").value = "";
		document.getElementById("documentNumber").value = "";
		document.getElementById("agentName").value = "";
		document.getElementById("age").value = "";
		document.getElementById("languages").value = "";		
		document.getElementById("partnerRemarks").value = "";
		document.getElementById("adminRemarks").value = "";
		document.getElementById("id").value = "";
		document.getElementById("documentPath").value = "";
		document.getElementById("certificatePath").value = "";
		document.getElementById("insertDate").value = "";
		
		if(!!a){document.getElementById("hub").value = a;}
		if(!!b){document.getElementById("reqType").value = b;}
		if(!!c){document.getElementById("partnerName").value = c;}
		if(!!d){document.getElementById("number").value = d;}
		if(!!e){document.getElementById("newNumber").value = e;}
		if(!!f){document.getElementById("allocatedCircle").value = f;}
		if(!!g){document.getElementById("chatId").value = g;}
		if(!!h){document.getElementById("location").value = h;}
		if(!!j){document.getElementById("type").value = j;}
		if(!!k){document.getElementById("document").value = k;}
		if(!!l){document.getElementById("documentNumber").value = l;}
		if(!!m){document.getElementById("agentName").value = m;}
		if(!!n){document.getElementById("age").value = n;}
		if(!!o){document.getElementById("languages").value = o;}
		if(!!p){document.getElementById("partnerRemarks").value = p;}
		if(!!q){document.getElementById("adminRemarks").value = q;}
		if(!!r){document.getElementById("id").value = r;}
		if(!!s){document.getElementById("documentPath").value = s;}
		if(!!t){document.getElementById("certificatePath").value = t;}
		if(!!u){document.getElementById("insertDate").value = u;}
		
		
		//alert(j);
		
		if(b == "Create")
			{
				$("#chatId1").show();
				$("#allocatedCircle1").show();
				$("#location1").show();
				$("#newNumber1").hide();
				$("#type1").show();
				/* $("#state1").show(); */
				
			}
		
		if(b == "delete")
		{
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#location1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			/* $("#state1").hide(); */
			
		}
		
		if(b == "chatidChange")
			{
				$("#chatId1").show();
				
				$("#allocatedCircle1").hide();
				$("#location1").hide();
				$("#newNumber1").hide();
				$("#type1").hide();
				/* $("#state1").hide(); */
			}
		if(b == "circleChange")
		{
			$("#allocatedCircle1").show();
			
			$("#chatId1").hide();
			$("#location1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			/* $("#state1").hide(); */
		}
		if(b == "locationChange")
		{
			$("#location1").show();
			
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			/* $("#state1").hide(); */
		}
		if(b == "numberChange")
		{
			$("#newNumber1").show();
			$("#newNumber2").show();
			
			/* $("#state1").hide(); */
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#type1").hide();
			$("#location1").hide();
		}
		if(b == "typeChange")
		{
			$("#type1").show();
			
			/* $("#state1").hide(); */
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#newNumber1").hide();
			$("#location1").hide();
		}
		
		/* window.scrollTo(300, 5000); */
	}
</script>


</head>

<body>
	<jsp:include page="header_new.jsp"></jsp:include>

	<!-- Page Content-->
	<div class="wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="page-title-box">
						<h4 class="page-title">Partner Request Status</h4>
					</div>
				</div>
		    </div>
			<div class="row"></div>	
		</div>
	</div>		
			<div class="row" align="center">
				<div class="col-md-12">			
					<div class="modal" id="EditModal" role="dialog">
							<div class="modal-dialog modal-lg">
							 
								<div class="modal-content">
									<!-- <div class="modal-body"> -->
									<form action="agentmanagerupdateAction"
										class="form-horizontal form-label-left" id="edit_form" method="post" onsubmit="return validation()">
										
										<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Agent Request Status</p>
										
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="hub" style="text-align:right;padding-right:40px;">Hub <span class="required">* </span></label>		
												<input type="text" name="hub" id="hub" class="col-md-4"
												 autocomplete="off" readonly style="background-color: #cca5bc;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="reqType" style="text-align:right;padding-right:40px;">Request Type <span class="required">* </span></label>		
												<input type="text" name="reqType" id="reqType" class="col-md-4"
												 required="required"  autocomplete="off" readonly style="background-color: #cca5bc;"/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="partnerName" style="text-align:right;padding-right:40px;">Partner Name <span class="required">* </span></label>		
												<input type="text" name="partnerName" id="partnerName" class="col-md-4"
												 required="required" autocomplete="off" readonly style="background-color: #cca5bc;"/>	
											</div>
											<div class="form-group" id="newNumber2" style="margin-left: 177px;">
												<label class="control-label col-md-3 blckcolor" for="number" style="text-align:right;padding-right:40px;">Number <span class="required">* </span></label>		
												<input type="text" name="number" id="number" class="col-md-4"
												placeholder="" required="required" autocomplete="off" readonly style="background-color: #cca5bc;"/><span Style="float: right;margin-right:113px;">
												<a  href='' onclick="this.href='agentmanagerrecordsbyani?ani='+document.getElementById('number').value+'&hub='+document.getElementById('hub').value"  target="_blank">View Record</a></span>
											</div>
											<div class="form-group" id="newNumber1">
												<label class="control-label col-md-3 blckcolor" for="newNumber" style="text-align:right;padding-right:40px;">Requested New Number <span class="required">* </span></label>		
												<input type="text" name="newNumber" id="newNumber" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #cca5bc;"/>	
											</div>
											<div class="form-group" id="allocatedCircle1">
												<label class="control-label col-md-3 blckcolor" for="allocatedCircle" style="text-align:right;padding-right:40px;">Requested Circle<span class="required">* </span></label>		
												<select name="allocatedCircle" id ="allocatedCircle" class="col-md-4">
						                            <option>Choose option</option>
						                            <option value="HUTCH_AP">HUTCH_AP</option>
													<option value="HUTCH_AS">HUTCH_AS</option>
													<option value="HUTCH_ASAM">HUTCH_ASAM</option>
													<option value="HUTCH_BANG">HUTCH_BANG</option>
													<option value="HUTCH_BHR">HUTCH_BHR</option>
													<option value="HUTCH_DEL">HUTCH_DEL</option>
													<option value="HUTCH_GUJ">HUTCH_GUJ</option>
													<option value="HUTCH_HAR">HUTCH_HAR</option>
													<option value="HUTCH_KER">HUTCH_KER</option>
													<option value="HUTCH_KOL">HUTCH_KOL</option>
													<option value="HUTCH_MP">HUTCH_MP</option>
													<option value="HUTCH_MUM">HUTCH_MUM</option>
													<option value="HUTCH_ORS">HUTCH_ORS</option>
													<option value="HUTCH_PUN">HUTCH_PUN</option>
													<option value="HUTCH_PUNE">HUTCH_PUNE</option>
													<option value="HUTCH_RAJ">HUTCH_RAJ</option>
													<option value="HUTCH_TN">HUTCH_TN</option>
													<option value="HUTCH_UPE">HUTCH_UPE</option>
													<option value="HUTCH_UPW">HUTCH_UPW</option>
						                          </select>
											</div>
											<div class="form-group" id="chatId1">
												<label class="control-label col-md-3 blckcolor" for="chatId" style="text-align:right;padding-right:40px;">Requested ChatId <span class="required">* </span></label>		
												<input type="text" name="chatId" id="chatId" class="col-md-4" minlength="5" maxlength="5" placeholder="" autocomplete="off"/>	
											</div>
											<div class="form-group" id="location1">
												<label class="control-label col-md-3 blckcolor" for="location" style="text-align:right;padding-right:40px;">Requested Location <span class="required">* </span></label>		
												<select  name="location" id ="location" class="col-md-4">
													<option value="HUTCH_AS">HUTCH_AS</option>
													<option value="HUTCH_AP">HUTCH_AP</option>
													<option value="HUTCH_ASAM">HUTCH_ASAM</option>
													<option value="HUTCH_BANG">HUTCH_BANG</option>
													<option value="HUTCH_BHR">HUTCH_BHR</option>
													<option value="HUTCH_CHN">HUTCH_CHN</option>
													<option value="HUTCH_DEL">HUTCH_DEL</option>
													<option value="HUTCH_GUJ">HUTCH_GUJ</option>
													<option value="HUTCH_HAR">HUTCH_HAR</option>
													<option value="HUTCH_HP">HUTCH_HP</option>
													<option value="HUTCH_JK">HUTCH_JK</option>
													<option value="HUTCH_KER">HUTCH_KER</option>
													<option value="HUTCH_KOL">HUTCH_KOL</option>
													<option value="HUTCH_MP">HUTCH_MP</option>
													<option value="HUTCH_MUM">HUTCH_MUM</option>
													<option value="HUTCH_NE">HUTCH_NE</option>
													<option value="HUTCH_ORS">HUTCH_ORS</option>
													<option value="HUTCH_PUN">HUTCH_PUN</option>
													<option value="HUTCH_PUNE">HUTCH_PUNE</option>
													<option value="HUTCH_RAJ">HUTCH_RAJ</option>
													<option value="HUTCH_TN">HUTCH_TN</option>
													<option value="HUTCH_UPE">HUTCH_UPE</option>
													<option value="HUTCH_UPW">HUTCH_UPW</option>
												</select>													
											</div>
<!-- 										<div class="form-group" id="state1">
												<label class="control-label col-md-3 blckcolor" for="state" style="text-align:right;padding-right:40px;">State  <span class="required">* </span></label>		
												<input type="text" name="state" id="state" class="col-md-4"
												placeholder="" autocomplete="off" readonly style="background-color: #cca5bc;"/>	
											</div>
 -->										<div class="form-group" id="type1">
												<label class="control-label col-md-3 blckcolor" for="type" style="text-align:right;padding-right:40px;">Requested Type <span class="required">* </span></label>		
												<select name="type" id ="type" class="col-md-4">	
													<option value="Agent">Agent</option>
													<option value="FL">FL</option>
													<option value="Night Shift">Night Shift</option>
												</select>
											</div>
													
												<input type="hidden" name="document" id="document" value="document"/>	
												<input type="hidden" name="documentNumber" id="documentNumber" value="documentNumber"/>		
												<input type="hidden" name="agentName" id="agentName" value="agentName"/>		
												<input type="hidden" name="age" id="age" value="age"/>	
												<input type="hidden" name="languages" id="languages" value ="languages"/>
												<input type="hidden" name="documentPath" id="documentPath" value="documentPath"/>
												<input type="hidden" name="certificatePath" id="certificatePath" value="certificatePath"/>	
												<input type="hidden" name="insertDate" id="insertDate" value="insertDate"/>
												
											
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="partnerRemarks" style="text-align:right;padding-right:40px;vertical-align: 16px;">Partner Remarks <span class="required">* </span></label>		
												<textarea name="partnerRemarks" id="partnerRemarks" class="col-md-4" readonly="readonly" style="background-color: #cca5bc;"></textarea>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="adminRemarks" style="text-align:right;padding-right:40px;vertical-align: 16px;">Admin Remarks <span class="required">* </span></label>		
												<textarea  required name="adminRemarks" id="adminRemarks" class="col-md-4"></textarea>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 blckcolor" for="status" style="text-align:right;padding-right:40px;">Status  <span class="required">* </span></label>		
												<select id="status" name="status" class="col-md-4" required>
													<option value="">Click to Choose...</option>
													<option value="approve">Approve</option>
													<option value="reject">Reject</option>										
												</select>
											</div>
											<input type="hidden" id="id" value="id" name="id">
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
	<!-- end page-wrapper -->
    
    <div class="" style="width:100%">
					<div class="">
						<div class="card bgcrd">
							<div class="card-body">
								<div class="x_content">
									<table id="datatable" class="display dtb">
											<thead>
												<tr class="trb">
													<th>Hub</th>										
													<th>Request Type</th>
													<th>Request InsertDate</th>
													<th>Requested Name</th>
													<th>Number</th>
													<th>New Number</th>
													<th>Requested Circle</th>
													<th>Requested ChatId</th>
													<th>Requested Location</th>
													<th>Requested Type</th>
													<th>Document</th>
													<th>Document Number</th>
													<th>Agent Name</th>
													<th>Age</th>
													<th>Languages</th>
													<th>Partner Remarks</th>
													<th>Admin Remarks</th>
													<th>Status</th>
													<th>Agent ID Proof Image</th>
													<th>Declaration Form</th>
													
													<c:choose>
														<c:when test="${empty reqType}">
															<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
																<th>Action</th>
															</c:if>
														</c:when>
													</c:choose>		
															
												</tr>
											</thead>
											<tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>
														<td><p class="text-capitalize">${listValue.hub}</p> </td>
														<td><p class="text-capitalize">${listValue.reqType}</p></td>
														<td>${fn:substring(listValue.insertDate,0,19)}</td>
														<td>${listValue.partnerName} </td>
														<td>${listValue.number} </td>
														<td>${listValue.newNumber} </td>
														<td>${listValue.allocatedCircle} </td>
														<td>${listValue.chatId} </td>
														<td>${listValue.location} </td>
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
														
														<c:choose>
															<c:when test="${empty reqType}">
																<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin') || (userObj.role eq 'superadmin') || (userObj.role eq 'SuperAdmin')}">
																	<td>
																		<div class="hidden-sm hidden-xs action-buttons">
																			<input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal" 
																				onclick="setEditValue('${listValue.hub}','${listValue.reqType}','${listValue.partnerName}',
																				'${listValue.number}','${listValue.newNumber}','${listValue.allocatedCircle}','${listValue.chatId}','${listValue.location}',
																				'${listValue.type}','${listValue.document}','${listValue.documentNumber}','${listValue.agentName}',
																				'${listValue.age}','${listValue.languages}','${listValue.partnerRemarks}','${listValue.adminRemarks}',
																				'${listValue.id}','${listValue.documentPath}','${listValue.certificatePath}','${listValue.insertDate}')" value="Action"/>																		
																		</div>
																	</td>	
																</c:if>	
															</c:when>
														</c:choose>	
															
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
	<!-- <script src="resources/js/form-advanced.init.js"></script> -->
	
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
		    });
		} );
	</script>
	
	<script type="text/javascript">
		function validation(){
			var x = null;
			x = $('#chatId').val();
			var var_action = $("#status").val();
			var var_type = $("#reqType").val();
			
			if(var_action=='approve'){
				if(var_type=='Create' || var_type=='chatidChange'){
					if(x.length<5){
						alert("ChatId length should be equal to 5");
						return false;
					}else{
						return true; 	
					}	
				}else{
					return true;
				}
					
			
					/* var y = $("#status").val();
					if(y == -1){
						return false; 
					} */
			}else{
				if(var_action == -1){
					return false; 
				}else{
					return true;	
				}
			}	
		}
	</script>
</body>
</html>