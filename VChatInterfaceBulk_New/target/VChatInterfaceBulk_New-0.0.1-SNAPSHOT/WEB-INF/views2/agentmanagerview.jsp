<%@page import="javax.servlet.http.HttpSession"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous"> -->

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<!-- <link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"> -->
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

<script type="text/javascript">
	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	}
	
	function getValue(number){
		var ani="";
		//ani=document.getElementById("number").value */
		alert("hiiii##############");
		ani=number;
		//window.location.href("agentmanagerrecordsbyani?ani="+ani);
		 //event.preventDefault();
		window.location.href=getContextPath()+"/agentmanagerrecordsbyani?ani="+ani;  
	}
</script>


<script>
	function setEditValue(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v) {
		
		
		
		document.getElementById("operator").value = "";
		document.getElementById("reqType").value = "";
		document.getElementById("partnerName").value = "";
		document.getElementById("number").value = "";
		document.getElementById("newNumber").value = "";
		document.getElementById("allocatedCircle").value = "";
		document.getElementById("chatId").value = "";
		document.getElementById("location").value = "";
		document.getElementById("state").value = "";
		document.getElementById("type").value = "";
		
		document.getElementById("document").value = "";
		document.getElementById("documentNumber").value = "";
		document.getElementById("agentName").value = "";
		document.getElementById("age").value = "";
		document.getElementById("languages").value = "";		
		
		document.getElementById("partnerRemarks").value = "";
		document.getElementById("adminRemarks").value = "";
		document.getElementById("documentPath").value = "";
		document.getElementById("certificatePath").value = "";
		document.getElementById("id").value = "";
		
		if(!!a){document.getElementById("operator").value = a;}
		if(!!b){document.getElementById("reqType").value = b;}
		if(!!c){document.getElementById("partnerName").value = c;}
		if(!!d){document.getElementById("number").value = d;}
		if(!!e){document.getElementById("newNumber").value = e;}
		
		if(!!f){document.getElementById("allocatedCircle").value = f;}
		
		/* $('#allocatedCircle').val = f; */
		if(!!g){document.getElementById("chatId").value = g;}
		if(!!h){document.getElementById("location").value = h;}
		if(!!i){document.getElementById("state").value = i;}
		if(!!j){document.getElementById("type").value = j;}
		
		if(!!k){document.getElementById("document").value = k;}
		if(!!l){document.getElementById("documentNumber").value = l;}
		if(!!m){document.getElementById("agentName").value = m;}
		if(!!n){document.getElementById("age").value = n;}
		if(!!o){document.getElementById("languages").value = o;}
		

		if(!!p){document.getElementById("partnerRemarks").value = p;}
		if(!!q){document.getElementById("adminRemarks").value = q;}
		
		
		
		if(!!s){document.getElementById("documentPath").value = s;}
		if(!!t){document.getElementById("certificatePath").value = t;}
		if(!!u){document.getElementById("id").value = u;}
		
		//alert(b);
		
		if(b == "Create")
			{
				$("#chatId1").show();
				$("#allocatedCircle1").show();
				$("#location1").show();
				$("#newNumber1").show();
				$("#type1").show();
				$("#state1").show();
				$("#chatId1").show();
				
			}
		
		if(b == "delete")
		{
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#location1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			$("#state1").hide();
			
		}
		
		if(b == "chatidChange")
			{
				$("#chatId1").show();
				
				$("#allocatedCircle1").hide();
				$("#location1").hide();
				$("#newNumber1").hide();
				$("#type1").hide();
				$("#state1").hide();
			}
		if(b == "circleChange")
		{
			$("#allocatedCircle1").show();
			
			$("#chatId1").hide();
			$("#location1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			$("#state1").hide();
		}
		if(b == "locationChange")
		{
			$("#location1").show();
			
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#newNumber1").hide();
			$("#type1").hide();
			$("#state1").hide();
		}
		if(b == "numberChange")
		{
			$("#newNumber1").show();
			$("#newNumber2").show();
			
			$("#state1").hide();
			$("#chatId1").hide();
			$("#allocatedCircle1").hide();
			$("#type1").hide();
			$("#location1").hide();
		}
		if(b == "typeChange")
		{
			$("#type1").show();
			
			$("#state1").hide();
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
						<!-- <div class="float-right">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
								<li class="breadcrumb-item"><a href="javascript:void(0);">home</a></li>
								<li class="breadcrumb-item active">Open Complains</li>
							</ol>
						</div> -->
						<h4 class="page-title">Partner Request Status</h4>
					</div>
				</div>
		    </div>
		
			<div class="row">
				
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
										class="form-horizontal form-label-left" id="edit_form" method="post" onsubmit="return validation()">
										
										<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Agent Request Status</p>
										
											<div class="form-group">
												<label class="control-label col-md-3" for="operator">Operator  <span class="required">* </span></label>		
												<input type="text" name="operator" id="operator" class="col-md-4"
												 autocomplete="off" readonly/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="reqType">Request Type  <span class="required">* </span></label>		
												<input type="text" name="reqType" id="reqType" class="col-md-4"
												 required="required"  autocomplete="off" readonly/>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="partnerName">Partner Name  <span class="required">* </span></label>		
												<input type="text" name="partnerName" id="partnerName" class="col-md-4"
												 required="required" autocomplete="off" readonly/>	
											</div>
											<div class="form-group" id="newNumber2" style="margin-left: 177px;">
												<label class="control-label col-md-3" for="number">Number  <span class="required">* </span></label>		
												<input type="text" name="number" id="number" class="col-md-4"
												placeholder="" required="required" autocomplete="off" readonly/><span Style="float: right;margin-right:113px;">
												<a  href='' onclick="this.href='agentmanagerrecordsbyani?ani='+document.getElementById('number').value"  target="_blank">View Record</a></span>
												<!-- <a  href='' onclick="getValue(document.getElementById('number').value)" target="_blank">View Record</a></span> -->	
											</div>
											<div class="form-group" id="newNumber1">
												<label class="control-label col-md-3" for="newNumber">New Number  <span class="required">* </span></label>		
												<input type="text" name="newNumber" id="newNumber" class="col-md-4"
												placeholder="" autocomplete="off" readonly/>	
											</div>
											<div class="form-group" id="allocatedCircle1">
												<label class="control-label col-md-3" for="allocatedCircle">Allocated Circle  <span class="required">* </span></label>		
												<!-- <input type="text" name="allocatedCircle" id="allocatedCircle" class="col-md-4"
												placeholder="" autocomplete="off"/> -->	
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
												<label class="control-label col-md-3" for="chatId">Chat Id  <span class="required">* </span></label>		
												<input type="text" name="chatId" id="chatId" class="col-md-4"
												placeholder="" autocomplete="off"/>	
											</div>
											<div class="form-group" id="location1">
												<label class="control-label col-md-3" for="location">Location  <span class="required">* </span></label>		
												<!-- <input type="text" name="location" id="location" class="col-md-4"
												placeholder="" autocomplete="off" readonly/> -->
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
											<div class="form-group" id="state1">
												<label class="control-label col-md-3" for="state">State  <span class="required">* </span></label>		
												<input type="text" name="state" id="state" class="col-md-4"
												placeholder="" autocomplete="off" readonly/>	
											</div>
											<div class="form-group" id="type1">
												<label class="control-label col-md-3" for="type">Type  <span class="required">* </span></label>		
												<select name="type" id ="type" class="col-md-4">	
												<option value="AGENT">AGENT</option>
												<option value="FL">FL</option>
												<option value="NIGHT-SHIFT">NIGHT-SHIFT</option>
												<option value="FIND-PROFESSIONAL">FIND-PROFESSIONAL</option>
												</select>
											</div>
													
												<input type="hidden" name="document" id="document" value="document"/>	
												<input type="hidden" name="documentNumber" id="documentNumber" value="documentNumber"/>		
												<input type="hidden" name="agentName" id="agentName" value="agentName"/>		
												<input type="hidden" name="age" id="age" value="age"/>	
												<input type="hidden" name="languages" id="languages" value ="languages"/>
												<input type="hidden" name="documentPath" id="documentPath" value="documentPath"/>
												<input type="hidden" name="certificatePath" id="certificatePath" value="certificatePath"/>	
											
											<div class="form-group">
												<label class="control-label col-md-3" for="partnerRemarks">Partner Remarks  <span class="required">* </span></label>		
												<textarea name="partnerRemarks" id="partnerRemarks" class="col-md-4" readonly="readonly"></textarea>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="adminRemarks">Admin Remarks  <span class="required">* </span></label>		
												<textarea  required name="adminRemarks" id="adminRemarks" class="col-md-4"></textarea>	
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="status">Status  <span class="required">* </span></label>		
												<select id="status" name="status" class="col-md-4">
													<option value="-1" selected="selected">Click to Choose...</option>
													<option value="approve">Approve</option>
													<option value="reject">Reject</option>										
												</select>
											</div>
											<input type="hidden" id="id" value="id" name="id">
											<!-- <div class="form-group">
												<label class="control-label col-md-3" for="documentPath">AgentDocImage  <span class="required">* </span></label>
												
												<input type="text" name="documentPath" id="documentPath" class="col-md-4"
												 autocomplete="off"/>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3" for="certificatePath">PartnerCertImage <span class="required">* </span></label>		
												<input type="text" name="certificatePath" id="certificatePath" class="col-md-4"
												 autocomplete="off"/>	
											</div>  -->
											
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
    
    <div class="wldth" align="center">
					<div class="col-md-12">
						<div class="card bgcrd">
							<div class="card-body">
								<div class="x_content">
									<!-- <table id="datatable" class="table table-striped table-bordered"  style="width:100%;"> -->
									<table id="datatable" class="display dtb">
											<thead>
												<tr class="trb">										
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
													<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin')}">
														<th>Action</th>
													</c:if>	
												</tr>
											</thead>
											<tbody>	
												<c:forEach var="listValue" items="${objList}">
													<tr>
													<td>${listValue.operator} </td>
														<td>${listValue.reqType}</td>
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
														<c:if test="${(userObj.role eq 'Admin') || (userObj.role eq 'admin')}">
														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																<a href="" class="green" data-toggle="modal"
																	data-target="#EditModal"
																	onclick="setEditValue('${listValue.operator}','${listValue.reqType}','${listValue.partnerName}',
																	'${listValue.number}','${listValue.newNumber}','${listValue.allocatedCircle}','${listValue.chatId}','${listValue.location}'
																	,'${listValue.state}','${listValue.type}','${listValue.document}','${listValue.documentNumber}','${listValue.agentName}',
																	'${listValue.age}','${listValue.languages}','${listValue.partnerRemarks}','${listValue.adminRemarks}',
																	'${listValue.status}','${listValue.documentPath}','${listValue.certificatePath}','${listValue.id}','${listValue.hub}')">
																	Action
																</a>
															</div>
														</td>	
															<!-- <td>
																<button type="button" class="btn btn-info btn-xs">Action</button>
															</td> -->
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
	
	
	<!-- <script src="resources/js/dataTables.bootstrap.min.js"></script> -->
	<!-- <script src="resources/js/jquery.form-advanced.init.js"></script> -->
	<!-- <script src="resources/js/custom-file-input.js"></script> -->
	
	
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
		       
		       
		    	/* "bPaginate": true,
		        
		        "bFilter": true,
		        "bInfo": true, */
		       /*  "scrollY": 200, */
		        //
		        /*"pagingType": "full_numbers" */
		        
		    } );
		} );
	</script>
	
	<script type="text/javascript">
	
	function validation()
	{
		var x = $('#chatId').val();
		if(x.length != 5)
			{
				alert("ChatId length should be equal to 5");
				return false;
			}
		
		var y = $("#status").val();
		if(y == -1)
		{
			return false; 
		}
	}
	
	</script>
</body>
</html>