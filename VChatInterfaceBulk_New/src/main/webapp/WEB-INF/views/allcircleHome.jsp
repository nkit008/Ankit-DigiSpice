<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>VChatInterface-home</title>
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
				<h5 class="page-title " align="center"><b> Circle Wise Live Agent Count</b></h5>
				
				<!-- ################ -->
				
				<!-- ################### -->
				
				
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->
                <div style="width:100%;">
					<div class="card bgcrd">
						<div class="card-body">
							<div class="x_content">
								<table id="datatable1" class="display dtb"  style="width:100%;font-size:10px;text-align:center;">
										<thead>
											<tr class="trb">
												<th>Circle</th>
												<th>Total Count</th>
												<th>Login</th>
												<th>Busy</th>
												<th>Free</th>
												<th>Logout</th>
												<th>ALogout</th>
												<th>BLogout</th>   
												<th>FLogout</th>
												<th>SLogout</th>
												<!-- <th>VLogout</th> -->
										 	</tr>
										</thead>
										<tbody>	
											<%-- <c:set var="totalLogin" value="${0}"/>
											<c:set var="totalbusy" value="${0}"/>
											<c:set var="totalfree" value="${0}"/>
											<c:set var="totallogout" value="${0}"/>
											<c:set var="totalalogout" value="${0}"/>
											<c:set var="totalblogout" value="${0}"/>
											<c:set var="totalflogout" value="${0}"/>
											<c:set var="totalslogout" value="${0}"/> --%>

											<c:forEach var="objList" items="${objCircleResp}">
												
												<c:forEach var="listValue" items="${objList}">
												<tr>
													<c:set var="total" value="${0}"/>
													<td>${listValue.circle} </td>
													<c:set var="total" value="${listValue.login + listValue.logout + listValue.aLogout + listValue.bLogout + listValue.fLogout + listValue.sLogout}" />
													<td><b>${total}</b> </td>
													<c:choose>
														<c:when test="${empty listValue.login}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.login} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalLogin" value="${totalLogin + listValue.login}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.busy}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.busy}</td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalbusy" value="${totalbusy + listValue.busy}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.free}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.free} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalfree" value="${totalfree + listValue.free}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.logout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.logout} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totallogout" value="${totallogout + listValue.logout}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.aLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.aLogout} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalalogout" value="${totalalogout + listValue.aLogout}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.bLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.bLogout} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalblogout" value="${totalblogout + listValue.bLogout}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.fLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.fLogout} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalflogout" value="${totalflogout + listValue.fLogout}" /> --%>
													<c:choose>
														<c:when test="${empty listValue.sLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.sLogout} </td>
														</c:otherwise>					
													</c:choose>
													<%-- <c:set var="totalslogout" value="${totalslogout + listValue.sLogout}" /> --%>
<%-- 													<c:choose>
														<c:when test="${empty listValue.vLogout}">
															<td>0</td>
														</c:when>
														<c:otherwise>
															<td>${listValue.vLogout} </td>
														</c:otherwise>					
													</c:choose>
 --%>												
													
												</tr>
											</c:forEach>
											</c:forEach>
													
										</tbody>
										<%-- <tr>
											<td><mark><b>Total</b></mark></td>
											<td><mark><b>${totalLogin}</b></mark></td>
											<td><mark><b>${totalbusy}</b></mark></td>
											<td><mark><b>${totalfree}</b></mark></td>
											<td><mark><b>${totallogout}</b></mark></td>
											<td><mark><b>${totalalogout}</b></mark></td>
											<td><mark><b>${totalblogout}</b></mark></td>
											<td><mark><b>${totalflogout}</b></mark></td>
											<td><mark><b>${totalslogout}</b></mark></td>
										</tr> --%>	 	
								</table>
								<input type="hidden" id="snackbar" value="${objRes}">
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
		    $('#datatable1').DataTable( {
				scrollX: true,
				scrollY:        '130vh',
				scrollCollapse: true,
				bLengthChange: false,
				paging:         false,
				"searching": false
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