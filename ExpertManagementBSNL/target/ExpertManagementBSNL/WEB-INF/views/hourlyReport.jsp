<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hourly Report MIS</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/navmenu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/data_table/jquery.dataTables.min.css" type="text/css" />


<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/dataTables.buttons.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jszip.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/pdfmake.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/vfs_fonts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/buttons.html5.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>

<style>
    .form-horizontal .form-group {
    margin-right: 0px;
    margin-left: -15px;
}

.dataTables_wrapper{
padding: 0px 25px 0px 25px;
margin-bottom:14px;
}

.dataTables_length{
padding: 0px 25px 0px 0px;
margin-bottom:14px;
}
</style>

</head>

<body>
	<c:choose>
	 <c:when test="${loginObj.role eq 'admin'}">
			<jsp:include page="admin_header.jsp"/>
		</c:when>
		<c:otherwise>
		<jsp:include page="user_header.jsp"/>
		</c:otherwise>
		</c:choose>

<div style="margin-top:4%;">
<table id="summary" class="display nowrap" style="width:100%;text-align: center;">
			<thead style="color:#fff;background-color:#212529;border-color:#32383e">
					<tr>
						<th>Date</th>
						<th>Circle</th>
						<th>Agent Location</th>
						<th>Detail Hour</th>
						<th>Chat Id</th>
						<th>Login Logout</th>
						<th>ANI</th>
						<th>Vendor</th>
						<th>Location</th>
						<th>Status</th>
						<th>Category</th>
						<th>Total Calls</th>
						<th>Succ Calls</th>
						<th>Fail Calls</th>
						<th>Mou</th>
						<th>Originator cancel less than 20 Sec</th>
						<th>Originator cancel greater than 20 Sec</th>
						<th>No Answer</th>
						<th>Switch Off</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="data" items="${record}">
					<tr>
						<td>${data.MIS_DATE}</td>	
						<td>${data.circle}</td>
						<td>${data.agent_location}</td>
						<td>${data.MIS_HOUR}</td>
						<td>${data.chat_ids}</td>
						<td>${data.login_logout}</td>
						<td>${data.ani}</td>
						<td>${data.vendor}</td>
						<td>${data.location}</td>
						<td>${data.status}</td>
						<td>${data.category}</td>
						<td>${data.total_Calls}</td>
						<td>${data.succ_Calls}</td>
						<td>${data.fail_calls}</td>
						<td>${data.mous}</td>
						<td>${data.org_cancel_call_less_20sec}</td>
						<td>${data.org_cancel_call_gret_20sec}</td>
						<td>${data.no_answer}</td>
						<td>${data.switch_off}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>





<div class="row" align="center">
					<div class="col-md-12">			
						<div class="modal" id="EditModal" role="dialog">
								<div class="modal-dialog modal-lg"  style="margin-top:12%;width:50%;">
								 
									<div class="modal-content"">
										<!-- <div class="modal-body"> -->
										<form action="editLoginStatus"
											class="form-horizontal form-label-left" method="post" style="padding:22px;">
											
											<p style="font-size:16px;font-weight:bold;margin-top:2%;margin-bottom:3%;">Edit Status</p>
											
											
											<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12">
											<div class="row rsp">
											<div class="fleft2">B_ANI:</div>
											<div class="fright2"><input type="text"  id="p_ani" name="p_ani"  class="inpt" autocomplete="off" required></div>
											</div>
											</div>
											</div>
											
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12">
										<div class="row rsp">
										<div class="fleft2">
										Select Status:
										</div>
										<div class="fright2">
										<select class="inpt"  id="p_status" name="p_status" autocomplete="off" required="required">
										       <option value="" disabled selected>Select Status</option>
										       <option value="LOGIN">Login</option>
												<option value="LOGOUT">Logout</option>
										  </select>
										</div>
										</div>
										</div>
										</div>
												
												<div class="form-group" align="center">
										<button class="btn addnew-db" style="margin-top: -0px;color:#fff;background-color:#28a745;border-color:#28a745" id="btnSubmit">
														Submit</button>
												</div>					
										</form>
									</div>
								</div>			
							
							</div>
						</div>
					</div>



</div>

<input type="hidden" id="snackbar" value="${insert_succ}">




	<script type="text/javascript">
			function set(a,b)
			{
				document.getElementById("p_ani").value=a;
				//document.getElementById("p_status").value=b;
			}
	</script>

<script>
	$(document).ready( function () {
		
		 $('#summary').DataTable({
		    	"scrollX": true,
		    	dom: 'lBfrtip',
		        buttons: [
		            
		            'excelHtml5',
		            
		            'pdfHtml5'
		        ] 
		    });
	});
</script>

<script type="text/javascript">
$(document).ready(function(){
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x,
		size: 'small'
		});
});
</script>

<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
</body>
</html>
