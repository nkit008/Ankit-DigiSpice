<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>Nexttel</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="resources/css/component.css">
	
	
	
	<link rel="stylesheet" type="text/css" href="resources/mis/css/themes.css">
	<link rel="stylesheet" type="text/css"
		href="resources/mis/css/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css"
			href="resources/mis/css/jquery.ui.core.css">
			<script type="text/javascript" src="resources/mis/js/jquery-1.4.2.js"></script>
			<script type="text/javascript" src="resources/mis/js/jquery.ui.core.js"></script>
			<script type="text/javascript" src="resources/mis/js/jquery.ui.datepicker.js"></script>
	
	
<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script>
</head>
<body class="app sidebar-mini rtl">

	<jsp:include page="header_new.jsp"></jsp:include>    
    
   <!-- Template start here-->   
    
    <div class="wrapper">
    <div class="container-fluid">
 <div class="container" align="center">
				<div class="col-sm-12">
					<div class="page-title-box">
						<h2 class="page-title" align="center"><i class="mdi mdi-music-note"></i>Voice Changer MIS</h2>
					</div>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card" style="width:130%;margin-left: -15%">
						<div class="card-body" width="40%">
							<div class="p-20">
								<form class="form-horizontal m-t-10" action="misAction"
									method="post" style="border:1px dotted; black">
									<div class="form-group">
										<%-- <h4 class="page-title" align="center"><mark> ${objSrcName} - User Details </mark></h4> --%>
										</br>
										<div class="row">
                  						<div class="col-md-6 col-lg-6">
											<label>From </label>
											<input type="text" id="datepicker" name="fromDate" required="required" minlength="10" maxlength="10" autocomplete="off" style="margin-right: 10px;margin-left:9px;"/>
											</div>	
											<div class="col-md-6 col-lg-6">
											<label>To </label>
											<input type="text" id="datepicker2" name="toDate" required="required" minlength="10" maxlength="10" autocomplete="off" style="margin-right: 10px;margin-left:9px;vertical-align: 2px;"/>	
										</div>
										</div>
										<div class="form-group" align="center">
											<button class="btn addnew-db" style="margin-top: 3%;margin-left: 3%;">
												Submit</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
			</div>
			</div>


<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});

				$(function() {
					$("#datepicker2").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});
</script>
<script>
function myFunction(form) {
  window.open('mis', 'formpopup', 'width=700,height=500,resizeable,scrollbars');
  form.target = 'formpopup';
  
}
	
function resetvalue()
{
	$('#misForm').find('input:text').val('');
	event.preventDefault();
}
</script>
<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});

				$(function() {
					$("#datepicker2").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});
</script>
</body>
</html>