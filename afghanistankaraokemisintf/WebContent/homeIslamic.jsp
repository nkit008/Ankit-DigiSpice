<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIS</title>
<style>
body {
	background: url("images/bgpick.jpg") no-repeat center
		center fixed; /*your background image*/
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	/*this sets the image to fullscreen covering the whole screen*/
}
</style>
</head>
<style type="text/css">

table.reference
{
border:1px solid #c3c3c3;
border-collapse:collapse;
}

table.reference th
{
border:1px solid #c3c3c3;
padding:6px;
}

table.reference td 
{
border:1px solid #c3c3c3;
padding:6px;
}
</style>

<link rel="stylesheet" type="text/css" href="css/style.css" />
  <!--styles and js start here for datepicker-->
	<link rel="stylesheet" type="text/css" href="css/themes.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.ui.datepicker.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.ui.core.css">
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery.ui.core.js"></script>
	
	<script type="text/javascript" src="js/jquery.ui.datepicker.js"></script>
	<link type="text/css" href="css/demos.css" rel="stylesheet" />
	<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			showOn: 'button',
			buttonImage: 'images/calendar.gif',
			buttonImageOnly: true
		});
		
		$("#datepicker1").datepicker({
			showOn: 'button',
			buttonImage: 'images/calendar.gif',
			buttonImageOnly: true
		});
		
	});
	</script>
	
		<script type="text/javascript">	
		function pagerefresh() {

		window.document.form1.action = "${pageContext.request.contextPath}/pageChange?accesspage="
				+ window.document.form1.accessService.value;
		window.document.form1.method = "post";
		window.document.form1.submit();
	}
	</script>
<body>

<jsp:include page="header.jsp"></jsp:include>


<!--Template start here-->
<table width="845" border="0"  cellpadding="0" cellspacing="0"  align="center" >
  
  <tr>
    <td width="2535" colspan="3" align="left" valign="top"    >&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3" align="left" valign="top" >&nbsp;</td>
  </tr>
  <tr>
 <td colspan="3" align="left" valign="top"  class="mid" ><div id="login-wrapper" style=" width:843px; margin-left:12px;">
<div style="color:#4a59ad; font-size:14px; margin:0px; padding-top:16px; color:#3d3d3d;text-align: center;"><span style="color:#0244b4;">USSD ISLAMIC</span><span style="color:#f00027;"> MIS</span></div>&nbsp;
<div></div>
<form action="home" id="home" method="post" name="form1">
<div align="center" style="font-size:12px; padding-top:32px; padding-bottom:32px;"><strong>Select Service</strong> 
  <select class="list spcr2" name="accessService" style="width:231px; border:1px solid #d9d9d9;" onchange="pagerefresh()">
  <option value="islamic" selected="selected">USSD_ISLAMIC</option>
  	<option value="awcc">AWCC KARAOKE</option>
  	<option value="KAR">APP KARAOKE</option>
  	<option value="info">USSD_INFO</option>
  </select>
</div>
<div>
  <div class="to" style="font-size:12px; float:left;">From <input type="text" name="sdate" id="datepicker" style="margin-right:5px;">
  </div>
  <div  style="font-size:12px; margin-left:53px; margin-right:190px;float:right;">To <input type="text" name="edate" id="datepicker1" style="margin-right:5px;">
  </div>
   <div  style="font-size:12px; margin-left:43px; float:right;"><input type="image" src="images/submit.jpg" style="margin-right:26px;margin-bottom:26px;margin-top: -26px;" alt="Submit">
  </div>
</div>
</form>

</td>
  </tr>
  <tr>
    <td colspan="3" align="left" valign="top"  >&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3" align="left" valign="top"  >&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3" align="left" valign="top"  >&nbsp;</td>
  </tr>
  </table>
  <div style="clear: both; padding-top: 42px;" align="center">
  <a href="downloadIslamic.jsp" style="text-decoration: none; color: #153f99;">USSD ISLAMIC MIS REPORT</a><img src="images/excel.jpg" width="16" height="16" align="absmiddle" style="padding-left:9px;">
  </div>
  
<!--Template end here-->
<c:if test="${sessionScope.result eq 'a'}">
 <div>
<jsp:include page="excelIslamic.jsp"></jsp:include>
</div>
</c:if>
</body>
</html>