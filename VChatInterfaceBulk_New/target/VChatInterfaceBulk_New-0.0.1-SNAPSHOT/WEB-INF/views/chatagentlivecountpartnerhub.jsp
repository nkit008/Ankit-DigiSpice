<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-PartnerLiveCount</title>
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
			<div class="container" align="center"></div>
		</div>
	</div>
				
				
				
				<!-- ################ -->
                <div style="width:100%;">
					<div class="card bgcrd">
						<div class="card-body">
							<div class="x_content">
								<h4 class="page-title" align="center"><mark>Partner Circle Wise </mark></h4>
								<table id="datatable1" class="display dtb"  style="width:100%;text-align:center;">
										<thead>
											<tr class="trb">
												<th>Circle</th>
												<th>Login</th>
												<th>Busy</th>
												<th>Free</th>
												<th>Logout</th>
												<th>ALogout</th>
												<th>BLogout</th>   
												<th>FLogout</th>
												<th>SLogout</th>
												<th>VLogout</th>
										 	</tr>
										</thead>
										<tbody>	
											<c:forEach var="listValue" items="${objCircleResp}">
												<tr>
													<td>${listValue.circle} </td>
													<c:choose>
														<c:when test="${empty listValue.login}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.login} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.busy}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.busy} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.free}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.free} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.logout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.logout} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.aLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.aLogout} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.bLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.bLogout} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.fLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.fLogout} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.sLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.sLogout} </td>
														</c:otherwise>					
													</c:choose>
													<c:choose>
														<c:when test="${empty listValue.vLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.vLogout} </td>
														</c:otherwise>					
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
				<!-- ################### -->
				
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
		    $('#datatable1').DataTable( {
				scrollX: true,
				scrollY:        '40vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false        
		    } );
		    $('#datatable2').DataTable( {
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