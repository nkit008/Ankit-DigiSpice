<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-ManageUser</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery-confirm.css" rel="stylesheet" type="text/css">

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
				<h4 class="page-title " align="center"> Manage Users</h4>
				
				<!-- ################ -->
				
				<!-- ################### -->
				
				
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->
    
    
    
    
                <div style="width:80%;margin-left:10%;">
					<div class="card bgcrd">
						<div class="card-body">
							<div class="x_content">
								<table id="datatable1" class="display nowrap"  style="width:100%;font-size:12px;text-align:center;">
										<thead>
											<tr class="trb">
												<th>Partner Name</th>
												<th>UserName</th>
												<th>Password</th>
												<th>Hub</th>
												<th>Role</th>
												<th>Change Password/Delete</th>
										 	</tr>
										</thead>
										<tbody>	
												<c:forEach var="listValue" items="${objCircleResp}">
												<tr>
															<td>${listValue.partnerName} </td>
															<td>${listValue.userName}</td>
															<td>${listValue.password} </td>
															<td>${listValue.hub}</td>
															<td>${listValue.role}</td>
															<td><input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal" value="Change Password" onclick="changePassword('${listValue.partnerName}','${listValue.userName}','${listValue.password}')"> / <input type="button" class="btn-warning" data-toggle="modal" data-target="#EditModal1" value="Delete" onclick="delUserModel('${listValue.partnerName}','${listValue.userName}','${listValue.role}','${listValue.password}')"></td>
												</tr>
											</c:forEach>
										</tbody> 	
								</table>
								
							</div>
						</div>
					</div>
					
					
					
					<div class="row" align="center">
					<div class="col-md-12">			
						<div class="modal" id="EditModal" role="dialog">
								<div class="modal-dialog modal-lg"  style="margin-top:6%;">
								 
									<div class="modal-content">
										<!-- <div class="modal-body"> -->
										<form action="resetpasswordAction"
											class="form-horizontal form-label-left" id="edit_form" method="post">
											
											<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Change Password</p>
											
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="partnerName" style="text-align:right;padding-right:40px;">Partner Name</label>		
													<input type="text" name="partnerName" id="partnerName" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
												
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="userName" style="text-align:right;padding-right:40px;">User Name</label>		
													<input type="text" name="userName" id="userName" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="newPassword" style="text-align:right;padding-right:40px;">New Password</label>		
													<input type="password" name="newPassword" id="newPassword" class="col-md-4" required="required"/>	
												</div>
												<div class="form-group" style="margin-top:-10px;">
											<label class="col-md-1 blckcolor" for="reqType" ></label>
												<input type="checkbox"  onclick="myFunction()" style="vertical-align:-2px;">Show Password
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="confirmPassword" style="text-align:right;padding-right:40px;">Confirm Password</label>		
													<input type="text" name="confirmPassword" id="confirmPassword" class="col-md-4" required="required"/>	
												</div>
												
												
												<div class="form-group" align="center">
													<button class="btn addnew-db" style="margin-top: -0px;" id="btnSubmit">
														Submit</button>
												</div>					
										</form>
									</div>
								</div>			
							
							</div>
						</div>
					</div>
					
					
					
					
					
					
					<div class="row" align="center">
					<div class="col-md-12">			
						<div class="modal" id="EditModal1" role="dialog">
								<div class="modal-dialog modal-lg"  style="margin-top:6%;">
								 
									<div class="modal-content">
										<!-- <div class="modal-body"> -->
										<form action="resetpasswordAction"
											class="form-horizontal form-label-left" id="edit_form" method="post" onsubmit="return deleteUser()">
											
											<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Delete User</p>
											
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="delpartnerName" style="text-align:right;padding-right:40px;">Partner Name</label>		
													<input type="text" name="delpartnerName" id="delpartnerName" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
												
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="deluserName" style="text-align:right;padding-right:40px;">User Name</label>		
													<input type="text" name="deluserName" id="deluserName" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
													<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="deluserRole" style="text-align:right;padding-right:40px;">User Role</label>		
													<input type="text" name="deluserRole" id="deluserRole" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
												
												<div class="form-group">
													<label class="control-label col-md-3 blckcolor" for="deluserPassword" style="text-align:right;padding-right:40px;">User Password</label>		
													<input type="text" name="deluserPassword" id="deluserPassword" class="col-md-4" readonly style="background-color: #f7f5f5;"/>	
												</div>
												
												<div class="form-group" align="center">
													<button class="btn addnew-db" style="margin-top: -0px;">
														Delete</button>
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
	<input type="hidden" id="snackbar" value="${msg}">
	 
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>

	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/form-advanced.init.js"></script>
	
	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<script type="text/javascript" src="resources/js/jquery-confirm.js"></script>

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
		    $('#datatable1').DataTable( {
				scrollX: true,
				/* scrollY:        '50vh', */
				scrollCollapse: true,
				bLengthChange: false,
				paging:         true        
		    } );
		} );
	</script>
	
	<script type="text/javascript">
	
	function changePassword(a,b,c)
	{
		$('#partnerName').val(a);
		$('#userName').val(b);
		$('#newPassword').val("");
		$('#confirmPassword').val("");
		
	}
	</script>
	
	<script type="text/javascript">
	
	function delUserModel(a,b,c,d)
	{
		
		$('#delpartnerName').val(a);
		$('#deluserName').val(b);
		$('#deluserRole').val(c);
		$('#deluserPassword').val(d);
		
	}
	</script>
	
	<script type="text/javascript">
	function deleteUser()
	{
		
		var userName = $('#deluserName').val();
		var partnerName = $('#delpartnerName').val();
		var userRole = $('#deluserRole').val();
		var userPassword = $('#deluserPassword').val();
		
	        	$.confirm({
	        	    title: 'Confirm!',
	        	    content: 'Are you Sure?',
	        	    buttons: {
	        	        confirm: function () {
	        				event.preventDefault();
	        	window.location.href=getContextPath()+"/deleteUser?pName=" + partnerName +"&userName=" +userName + "&userRole=" + userRole + "&password=" +userPassword;
	        	            return false;
	        	        },
	        	        cancel: function () {
	        	            
	        	        }
	        	    }
	        	});
	        	
	        	return false;
	}
	</script>
	
<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
</script>

<script>
function myFunction() {
  var x = document.getElementById("newPassword");
  if (x.type === "password") {
	  x.type = "text";  
  } else {
	  x.type = "password";    
  }
}
</script>
	
	</body>
</html>