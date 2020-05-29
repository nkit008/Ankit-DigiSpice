<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AGHANISTAN</title>
<script type="text/javascript">
	function validationForm() {
		var mob = document.forms["login"]["mobile"].value;
		var pass = document.forms["login"]["password"].value;
		if(mob == null || mob == "") {
			alert("Username Should Not be blank");
			return false;
		}if(pass == null || pass == "") {
			alert("Password Should Not be blank");
			return false;
		}else {
			return true;
		}
	}
</script>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
  
    
<body>
<div id="login-bg">
<div style="float:left;">
<div class="l-logo"><img src="images/logo.png" width="125" height="126" /></div>
<div style="padding-top:52px; color:#2977d5; font-size:22px; font-weight:bold;"><span style="font-size:24px; color:#e00523; font-size:28px; font-weight:bold;">AWCC</span>- MIS</div>
<div style="padding-top:12px; font-size:17px;">MIS is an online application  that provides<br />

the best solutions for generating online MIS for<br />
 
various live portals.</div>

<div style=" padding-left:92px; padding-top:22px;"><div style=" padding-top:17px;float:left">Click to Login</div><div style="float:left; padding-left:12px;">


<div></div>

<a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'"><img src="images/login2.jpg" width="101" height="45" /></a>

<div id="light" class="white_content">
<div align="right"><a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'" style="color:#e00523;">Close</a></div>

<form action="login" name="login" method="post" onsubmit="return validationForm()">

<div>
<div style="float:left;width:87px;">Username</div>
<div style="float:left; padding-left:12px;"><input name="mobile" id="mobile" style="border:1px solid #CCC; width:200px; height:22px;" type="text"  /></div>
</div>

<div style="clear:both; padding-top:19px;">
<div style="float:left; width:87px;">Password</div>
<div style="float:left; padding-left:12px;"><input name="password" id="password" style="border:1px solid #CCC; width:200px; height:22px;" type="password" /></div>
</div>
<div style="clear:
both; padding-left:93px; padding-top:19px;"><!-- <img src="images/submit.jpg" width="61" height="28" /></div> -->
<input type="image" src="images/submit.jpg" alt="submit" width="61" height="28"/></div>
</form>

</div>
		<div id="fade" class="black_overlay"></div>
</div></div>
</div>
<div style="float:right"><img src="images/index.jpg" width="628" height="490" /></div>

</div>
</body>
</html>