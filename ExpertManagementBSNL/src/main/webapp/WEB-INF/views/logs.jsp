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

<link href="${pageContext.request.contextPath}/resources/css/jquery-confirm.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/component.css" rel="stylesheet" type="text/css" />

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
<c:choose>
		 <c:when test="${loginObj.role eq 'admin'}">
			<jsp:include page="admin_header.jsp"/>
		</c:when>
		<c:otherwise>
		<jsp:include page="user_header.jsp"/>
		</c:otherwise>
		</c:choose> 

<div class="wrapper2" style="padding-top:20px;">


<div>
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">
Download By:</div>
<div class="fright2"><select class="inpt"  id="dwnld_option" name="dwnld_option" autocomplete="off" required="required">
		<option value="chatid_wise">ChatId Wise</option>
    	<option value="aParty_ani">AParty ANI</option>
    	</select>
    	</div>
</div>
</div>
</div>

<div id="chatid_wise" class="option_div">
<form action="downlodByChatId" method="post">
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Enter ChatId:</div>
<div class="fright2"><input type="text"  id="chatId" name="chatId"  class="inpt" placeholder="Enter ChatID" autocomplete="off" required></div>
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


<div id="aParty_ani" class="option_div">
<form action="downlodByANI" method="post"  id="aniBasedRetrive">
<div class="row">
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="row rsp">
<div class="fleft2">Enter AParty ANI:</div>
<div class="fright2"><input type="text"  id="ani" name="ani" class="inpt" autocomplete="off" placeholder="Enter ANI"></div>
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


</div>

<table id="log" class="display nowrap" style="width:100%;">
				<thead style="color:#fff;background-color:#212529;border-color:#32383e">
					<tr>
						<th>Call Date_Time</th>
						<th>ANI</th>
						<th>A_Chat ID</th>
						<th>A_Circle</th>
						<th>B_ANi</th>
						<th>B_Chat ID</th>
						<th>B_Circle</th>
						<th>Duration</th>
						<th>CLI</th>
						<th>Reason</th>
						<th>Call Status</th>
						<th>Category</th>
						<th>Disconnected By</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="data" items="${records}">
					<tr>
						<td>${data.logDateTime}</td>
						<td>${data.ani}</td>
						<td>${data.aChatid}</td>
						<td>${data.aCircle}</td>
						<td>${data.bAni}</td>
						<td>${data.bChatid}</td>
						<td>${data.bCircle}</td>
						<td>${data.duration}</td>
						<td>${data.cli}</td>
						<td>${data.reason}</td>
						<td>${data.callStatus}</td>
						<td>${data.category}</td>
						<td>${data.disconnect}</td>
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
		  $('#log').DataTable({
		    	"scrollX": true,
		    	dom: 'lBfrtip',
		        buttons: [
		            
		            'excelHtml5',
		            
		            'pdfHtml5'
		        ] 
		    });
		  
		  $('#dwnld_option').change(function(){
			
			  $('.option_div').hide();
			    $('#' + $(this).val()).show();
		  
		  });
		  
		  $('.option_div').hide();
		  $('#' + $('#dwnld_option').val()).show();
		  
		  
		  var frmvalidator = new Validator("aniBasedRetrive");
		  frmvalidator.addValidation("ani","numeric","ANI should be digit");
		  frmvalidator.addValidation("ani","maxlen=10",
			"Max length for ANI is 10");
			frmvalidator.addValidation("ani","minlen=10",
			"Min length for ANI is 10");
		  
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
</body>
</html>
