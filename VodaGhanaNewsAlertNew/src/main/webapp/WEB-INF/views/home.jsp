<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Voda Ghana | News Alert</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="resources/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="resources/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="resources/css/ace-skins.min.css" />
		<link rel="stylesheet" href="resources/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

		<style type="text/css">
		.ui-datepicker
		{
			width:19%;
		}
		</style>	
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default ace-save-state">
			<!-- top.jsp -->
			<%@ include file="top.jsp"%>
		</div>

		<div class="main-container ace-save-state" id="main-container">				
			<div class="main-content">
				<div class="main-content-inner">
					<div class="container">
						<div class="col-xs-12"></div>
					</div>
						<!-- <div class="space"></div> -->
						<div class="space-6"></div>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-sm-4"></div>
								<div class="col-sm-4">
									<div class="widget-box widget-color-blue2">
										<div class="widget-header"></div>
										<div class="widget-body">
											<div class="widget-main padding-8">
												<form action="storeValue" class="form-horizontal form-label-left" id="validation-form" method="post">
													<!-- <div class="space"></div> -->
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="category"> Select a category: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">	
															<select name="category" id="category" class="form-control input-ld" required>
																<option>${user.username}</option>
																
															</select>
														</div>	
													</div>
													<div class="form-group">
														
														<label class="col-sm-4 control-label no-padding-right" for="mainCategory"> Main Category: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">
															<select name="mainCategory" id="mainCategory" class="form-control input-ld" required>
															<option value="">Select Main Category</option>
															<c:forEach var="open" items="${serviceList}">
															<option>${open.name}</option>
															</c:forEach>
															</select>
														</div>	
														
													</div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="subCategory"> Sub Category: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">
															<select name="subCategory" id="subCategory" class="form-control input-ld">
																<option value="NA">Select Sub Category</option>
															</select>
														</div>	
													</div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="bulkMode"> Upload Type: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">
															<select name="bulkMode" id="bulkMode" class="form-control input-ld">
																<option value="single">Single </option>
																<!-- <option value="bulk" disabled>Bulk </option> -->
															</select>
														</div>	
													</div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="datepicker">Date: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">
															<input type="text" name="datepicker" id="datepicker" autocomplete="off" required="required">
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="<!-- alertsms -->" > SMS Alert: </label>
														<div class="col-md-8 col-sm-6 col-xs-12">
															<textarea rows="4" cols="34" maxlength="160" name="alertsms" id="alertsms" placeholder="Enter text(less than or equals to 160 characters) here..." required></textarea>
														</div>
													</div>
													<div class="clearfix form-actions">
														<div class="col-md-offset-3 col-md-9">
															<button class="btn btn-info" type="submit">
																<i class="ace-icon fa fa-check bigger-110"></i>Submit
															</button>
															&nbsp;
															<button class="btn" type="reset">
																<i class="ace-icon fa fa-undo bigger-110"></i>Reset
															</button>
														</div>
													</div>											
													
												</form>	
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-4"></div>
							</div>

							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->	
				</div><!-- /.page-content -->
			</div>
		</div><!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120">
						<span class="blue bolder">DigiSpice</span>
						
					</span>
				</div>
			</div>
		</div>

		<input type="hidden" id="snackbar" value="${msg}">
		
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
		
		<script src="resources/js/jquery-2.1.4.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		
		<%-- <script src="resources/js/safaricom.js"></script> --%>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="resources/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="resources/js/bootbox.js"></script>


		<script type="text/javascript">
			history.pushState(null, null, document.URL);
			window.addEventListener('popstate', function () {
				history.pushState(null, null, document.URL);
			});
		</script>
		
		<script>
			$(function() {
				$("#datepicker").datepicker({ minDate: 0});
			});
		</script>
		<script> 
			var x= document.getElementById("snackbar").value;
			if(x)
				alert(x);
		</script>
	</body>
</html>
