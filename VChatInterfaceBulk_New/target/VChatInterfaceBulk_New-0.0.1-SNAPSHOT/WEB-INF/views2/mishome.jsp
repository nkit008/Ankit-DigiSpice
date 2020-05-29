<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>CCI</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"	crossorigin="anonymous">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/responsive.bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/daterangepicker.min.css" rel="stylesheet" type="text/css">


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
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="card">
						<div class="card-body">
							<div class="x_content">
								<form class="form-horizontal m-t-10" action="misAction" method="post"  style="border:1px dotted; black">
									<h4 class="page-title" align="center"><mark> Voice Changer MIS </mark></h4></br>
									<div class="form-group">
										<div class='col-md-6'>
											<div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
											    <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>&nbsp;
											    <span></span> <b class="caret"></b>											    
											</div>
										</div>
									</div></br></br>
									<input type="hidden"  name="fromDate" id="sdate">
									<input type="hidden"  name="toDate" id="edate">
									
									<div class="form-group">			
										<div class='col-md-4' align="center">
											<button class="btn addnew-db">Submit</button>
											<button class="btn btn-warning" type="reset"><i class="ace-icon fa fa-close bigger-110"></i>Reset</button>
										</div>
									</div>
								</form>	
								<input type="hidden" id="snackbar" value="${objRes}">
							</div>
						</div>
					</div>	
				</div>	
				<div class="col-md-2"></div>	
			</div>
		</div>
	</div>
	<!-- end page-wrapper -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- End Footer -->
	<input type="hidden" id="snackbar" value="${success}">
	
	<script src="resources/js/jquery-3.3.1.min.js"></script>
	<script src="resources/js/custom-file-input.js"></script>
	
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
	<script src="resources/js/app.js"></script>
	
	<script src="resources/js/dataTables.bootstrap.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	
	<script src="resources/js/bootstrap-datepicker.min.js"></script>
	<script src="resources/js/bootstrap-colorpicker.min.js"></script>
	
	<script src="resources/js/jquery.form-advanced.init.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/moment.min.js"></script>
	<script src="resources/js/daterangepicker.min.js"></script>
	
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
		        /* "scrollX": true */
		    	"bPaginate": true,
		        "bLengthChange": false,
		        "bFilter": true,
		        "bInfo": true,
		        "scrollY": 200,
		        "scrollX": true 
		        
		    } );
		} );
	</script>
	
	<script type="text/javascript">
		var s_date;
		var e_date; 
		var camp;
		
		$(function() {
		    var start = moment().subtract(1, 'days');
		    var end = moment();
		
		    function cb(start, end) {
		        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
		       
				$('#sdate').val(start.format('YYYY-MM-DD'));
				$('#edate').val(end.format('YYYY-MM-DD'));
		    }
		    $('#reportrange').daterangepicker({
		        startDate: start,
		        endDate: end,
		        ranges: {
		           'Today': [moment(), moment()],
		           'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
		           'Last 7 Days': [moment().subtract(6, 'days'), moment()],
		           'Last 30 Days': [moment().subtract(29, 'days'), moment()],
		           'This Month': [moment().startOf('month'), moment().endOf('month')],
		           'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		        }
		    }, cb);
		    cb(start, end);
		});
	</script>
	
	<!-- <script type="text/javascript">
	function getContextPath() {
		return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	}
	
	function addPlaylist()
	{
		event.preventDefault();
		window.location.href=getContextPath()+"/addNewPlaylist";
		
	}
	</script> -->
</body>
</html>