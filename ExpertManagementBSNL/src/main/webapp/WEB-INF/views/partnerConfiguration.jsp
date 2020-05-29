<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Partner Configuration</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/navmenu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/data_table/jquery.dataTables.min.css" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/data_table/popup1.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/jquery-confirm.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-confirm.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/data_tables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/dataTables.buttons.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jszip.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/pdfmake.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/vfs_fonts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/buttons.html5.min.js" type="text/javascript"></script>


<style>
    .form-horizontal .form-group {
    margin-right: 0px;
    margin-left: -15px;
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
		
<div class="wrapper">
<div class="config" align="center">Configure New Partner</div>

<input type="hidden" id="snackbar" value="${insert_succ}">

<div style="margin-bottom:2%">
<form name="configurePartner" id="myForm" action="configureNewPartner" method="post" onsubmit="return validateForm();">
<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Partner Name</div>
<div class="fright">
<input type="text"  id="username" name="userName" class="inpt" placeholder="Enter Partner Name" autocomplete="off" autofocus required autocomplete="off">
<span id="msg" class="text-danger">${msg}</span>
</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">State</div>
<div class="fright"><select id="stateList" name="state"  class="inpt" required="">
     <option value="" disabled="" selected="">Select State</option>
     <option value="dl">DL</option>
    <option value="hr">Haryana</option>
    <option value="jk">J&amp;K</option>
    <option value="pb">Punjab</option>
    <option value="upe">UPE</option>
    <option value="upw">UPW</option>
    <option value="raj">Rajasthan</option>
    <option value="hp">HP</option>
    <option value="ap">AP</option>
    <option value="kk">Karnataka</option>
    <option value="ker">Kerala</option>
    <option value="tn">TN</option>
    <option value="chn">Chennai</option>
    <option value="mp">MP</option>
    <option value="guj">Gujarat</option>
    <option value="mh">Maharashtra</option>
    <option value="cg">CG</option>
    <option value="bhr">Bihar</option>
    <option value="as">Assam</option>
    <option value="kol">Kolkata</option>
    <option value="ors">Orissa</option>
    <option value="ne">NE</option>
    <option value="wb">WB</option>
    </select></div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Location</div>
<div class="fright">
<input type="text" class="inpt"  id="location" name="location" placeholder="Enter Location" autocomplete="off" required>
</div>
</div>
</div>

</div>


<div class="row r1">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Password</div>
<div class="fright">
<input type="text"  id="password" name="password"  class="inpt" placeholder="Enter password" autocomplete="off" required>
<span id="password1" class="text-danger"></span>
</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Confirm Password</div>
<div class="fright"><input type="text"  id="confirmpassword" name="confirmpassword" autocomplete="off" placeholder="Confirm password" class="inpt"  required="">
<p id="confirmpassword1" class="text-danger"></p>
</div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">&nbsp;</div>
<div class="fright"><button type="submit" class="btn btn-success">Configure New 

Partner</button></div>
</div>
</div>

</div>

</form>



<form name="editPartner" id="editPartnerdetail" action="editPartner" method="post" onsubmit="return validateForm1();">
<div>
<div class="row">
<input type="hidden" id="e-userId" name="userId">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Partner Name</div>
<div class="fright">
<input type="text"  id="e-username" name="userName" class="inpt" placeholder="Enter Partner Name" autocomplete="off" autofocus required autocomplete="off">
<span id="msg" class="text-danger">${msg}</span>
</div>

</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">State</div>
<div class="fright"><select id="e-stateList" name="state"  class="inpt" required="">
     <option value="" disabled="" selected="">Select State</option>
     <option value="dl">DL</option>
    <option value="hr">Haryana</option>
    <option value="jk">J&amp;K</option>
    <option value="pb">Punjab</option>
    <option value="upe">UPE</option>
    <option value="upw">UPW</option>
    <option value="raj">Rajasthan</option>
    <option value="hp">HP</option>
    <option value="ap">AP</option>
    <option value="kk">Karnataka</option>
    <option value="ker">Kerala</option>
    <option value="tn">TN</option>
    <option value="chn">Chennai</option>
    <option value="mp">MP</option>
    <option value="guj">Gujarat</option>
    <option value="mh">Maharashtra</option>
    <option value="cg">CG</option>
    <option value="bhr">Bihar</option>
    <option value="as">Assam</option>
    <option value="kol">Kolkata</option>
    <option value="ors">Orissa</option>
    <option value="ne">NE</option>
    <option value="wb">WB</option>
    </select></div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Location</div>
<div class="fright">
<input type="text" class="inpt"  id="e-location" name="location" placeholder="Enter Location" autocomplete="off" required>
</div>
</div>
</div>

</div>


<div class="row r1">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Password</div>
<div class="fright">
<input type="text"  id="e-password" name="password" class="inpt" placeholder="Enter password" autocomplete="off" required>
<span id="password1" class="text-danger"></span>
</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Confirm Password</div>
<div class="fright">
<input type="text"  id="e-confirmpassword" name="confirmpassword" autocomplete="off" placeholder="Confirm password" class="inpt" required>
<p id="e-confirmpassword2" class="text-danger"></p>
</div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">&nbsp;</div>
<div class="fright"><button type="submit" class="btn btn-success">Update Partner</button></div>
</div>
</div>

</div>


</div>
</form>











<table id="partnerlist" class="display nowrap" style="width:100%;text-align: center;">
				<thead style="color:#fff;background-color:#212529;border-color:#32383e">
					<tr>
						<th>Id</th>
						<th>Partner Id</th>
						<th>Partner Name</th>
						<th>Password</th>
						<th>State</th>
						<th>Location</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
	<c:forEach var="data" items="${records}">
					<tr>
						<td>${data.id}</td>
						<td>${data.userId}</td>
						<td>${data.userName}</td>
						<td>${data.password}</td>
						<td>${data.state}</td>
						<td>${data.location}</td>
						<td><a id="${data.status}" class="btn-detail"
							style="color: green;"  href="#"
							onclick="set('${data.userName}','${data.state}','${data.location}','${data.password}','${data.userId}')">edit</a> 
							/ <a id="${data.status}" class="btn-detail" href="#" style="color: green;"
							onclick="deleteUser('${data.userId}')">Delete</a></td>
<%-- 							<input type="button" onclick="deleteUser('${data.userId}')" value="Delete"> --%>
					</tr>
					</c:forEach>
			
				</tbody>
			</table>

</div>
</div>


	<script>
	$(document).ready( function () {
		
		 $('#myForm').show();
		 $('#editPartnerdetail').hide();
		
		 
		 $('#partnerlist').DataTable({
		    	"scrollX": true,
		    	dom: 'lBfrtip',
		        buttons: [
		            
		            'excelHtml5',
		            
		            'pdfHtml5'
		        ] 
		    });
		 

	    
	} );
	
</script>
	
	<script>
	function validateForm() {
	    var x = "";
	    var data=document.getElementById("username").value;
	    var pass=document.getElementById("password").value;
	    var pass1=document.getElementById("confirmpassword").value;
	    if(data.length < 4)
	    	{
	    	x="Name is less then 5";
	    	alert(x);
	    	 return false;
	    	}
	    
	    if(pass != pass1)
	    	{
	    	document.getElementById('confirmpassword1').innerHTML="**Password doesn't match";
	    	return false;
	    	}
	    
	    if(pass.length < 5)
    	{
    	alert("Password length Should be atleast 5");
    	
    	return false;
    	}
		
	}

</script>

<script>	
	function validateForm1() {
		
	    var x = "";
	    var e_data=document.getElementById("e-username").value;
	    
	    var e_pass=document.getElementById("e-password").value;
	    var e_pass1=document.getElementById("e-confirmpassword").value;
	    
	    if(e_data.length < 4)
	    	{
	    	x="Name is less then 5";
	    	alert(x);
	    	 return false;
	    	}
	    
	    if(e_pass != e_pass1)
	    	{
	    	document.getElementById('e-confirmpassword2').innerHTML="**Password doesn't match";
	    	return false;
	    	}
	    
	    if(e_pass.length < 5)
    	{
    	alert("Password length Should be atleast 5");
    	
    	return false;
    	}
		
	}

</script>

<script>	
	function set(a,b,c,d,e)
	{
		$('#myForm').hide();
		$('#editPartnerdetail').show();
		document.getElementById("e-username").value=a;
		document.getElementById("e-stateList").value=b;
		document.getElementById("e-location").value=c;
		document.getElementById("e-password").value=d;
		document.getElementById("e-confirmpassword").value=d;
		document.getElementById("e-userId").value=e;
	}
	
	function set1(b)
	{
		document.getElementById("partnerId").value=b;
	}
	
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

<script>
function deleteUser(a)
{
	
$.confirm({
    title: 'Confirm!',
    content: 'Are you Sure?',
    buttons: {
        confirm: function () {
			event.preventDefault();
window.location.href=getContextPath()+"/deletePartner?partnerId=" + a;
        },
        cancel: function () {
            
        }
    }
});

}
</script>



<script type="text/javascript">
function getContextPath() {
return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
</script>

</body>
</html>
