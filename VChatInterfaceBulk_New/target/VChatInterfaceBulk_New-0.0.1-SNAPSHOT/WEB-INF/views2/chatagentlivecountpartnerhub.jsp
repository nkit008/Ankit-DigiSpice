<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="resources/css/component.css">

<!-- <script>
	function setEditValue(a,b) {
		
		$.ajax({
		    url: "",
		    data: {'partnerName':a,'hub':b},
		    success: function(msg){
		        console.log(msg);
		        test = msg; 
		    },
		});
	} -->
	
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
				<%-- <div class="col-sm-12">
					<div class="page-title-box">
						<h2 class="page-title" align="center"><i class="mdi mdi-music-note"></i>${objSrcName}</h2>
					</div>
				</div> --%>
				<!-- <div class="col-md-3"></div> -->
				<%-- <div class="col-md-6">
					<div class="card">
						<div class="card-body">
							<div class="p-10">
								<form class="form-horizontal m-t-10" action="agentlivecount" method="post" style="border:2px dotted; black">
									<!-- <div class="form-group"> -->
										<h4 class="page-title" align="center"><mark> ${objSrcName} - Bulk Un-Subscription </mark></h4>
										</br>
										<div class="form-group">
											<label class="col-md-3" for="hub">Require Hub  <span class="required"> </span></label>
											<select required id="hub" name="hub" class="col-md-4">
												<option value="">Select Hub</option>
												<option value="North">North</option>
												<option value="East">East</option>
												<option value="West">West</option>
												<option value="South">South</option>
												<option value="Upeast">UpEast</option>
											</select>
											<button class="btn addnew-db" style="margin-top: -0px;">Submit</button>
										</div>
								</form>
							</div>
							<input type="hidden" id="snackbar" value="${objRes}">
						</div>
					</div>
				</div> --%>
				<!-- <div class="col-md-3"></div> -->
				
				<!-- ################ -->
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<div class="x_content">
								<h4 class="page-title" align="center"><mark>Partner Circle Wise </mark></h4>
								<table id="datatable1" class="display nowrap"  style="width:100%;">
										<thead>
											<tr>
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
													<td>${listValue.login} </td>
													<td>${listValue.busy} </td>
													<td>${listValue.free} </td>
													<td>${listValue.logout} </td>
													<td>${listValue.aLogout} </td>
													<td>${listValue.bLogout} </td>
													<td>${listValue.fLogout} </td>
													<td>${listValue.sLogout} </td>
													<td>${listValue.vLogout} </td>
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
				
			</div>
		</div>
	</div>
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