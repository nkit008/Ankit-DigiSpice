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
		<jsp:include page="user_header.jsp"/>

<div class="wrapper2" style="padding-top:20px;">


<div>
<form action="chatidWiseSummaryPartner" method="post">
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Enter Agent ChatId:</div>
<div class="fright2"><input type="text"  id="chatid" name="chatid" class="inpt" placeholder="Enter Chat Id" autocomplete="off"
 required></div>
</div>
</div>
</div>


<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">&nbsp;</div>
<div class="fright2"><button type="submit" class="btn btn-success btn-primary" style="margin-top:4px; width:130px !important;">Submit</button></div>
</div>
</div>
</div>


</form>
</div>
</div>
<table id="summary" class="display nowrap" style="width:100%;text-align: center;">
			<thead style="color:#fff;background-color:#212529;border-color:#32383e">
					<tr>
						<th>ANI</th>
						<th>Chat Id</th>
						<th>Partner Name</th>
						<th>Agent Type</th>
						<th>Zone</th>
						<th>Circle</th>
						<th>Last Date Time</th>
						<c:if test="${loginObj.role eq 'admin'}">
						<th>Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="data" items="${records}">
					<tr>
						<td>${data.ani}</td>
						<td>${data.chat_id}</td>
						<td>${data.partner_name}</td>
						<td>${data.agent_type}</td>
						<td>${data.hub}</td>
						<td>${data.circle}</td>
						<td>${data.last_date_time}</td>
						<c:if test="${loginObj.role eq 'admin'}">
						<td>${data.action}</td> 
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>





<input type="hidden" id="snackbar" value="${insert_succ}">



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
	$(document).ready( function () {
		
		 $('#summary').DataTable({
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