<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Complain System</title>
<meta name="viewport" content="width=device-width,initial-scale=1">


<!-- DataTables css -->
<link href="assets/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datepicker.min.css">

<!-- basic css -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- Template start here-->
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">home</a></li>
              <li class="breadcrumb-item active">view user</li>
            </ol>
          </div>
          <h4 class="page-title">View All Users</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            
            
            
              <table id="example" class="display nowrap" style="width:100%">
                <thead>
                  <tr style="text-align: center;">
                  	<th>(#) Id</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Name</th>
                    <th>User Role</th>
                    <th>Created At</th>
                    <th>Created By</th>
                    <th>Phone</th>
                    <th>Email</th>
<%--                     <c:if test="${not empty userD.updated_at}">
                    <th>Updated At</th>
                    </c:if>
                    <c:if test="${not empty userD.updated_by}">
                    <th>Updated By</th>
                    </c:if> --%>
                    <th>Active</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="userD" items="${openData}">
                <tr style="text-align: center;">
                    <td>${userD.id}</td>
                    <td>${userD.user_name}</td>
                    <td>${userD.password}</td>
                    <td>${userD.name}</td>
                    <td>${userD.user_role}</td>
                    <td>${userD.created_at}</td>
                    <td>${userD.created_by}</td>
                    <td>${userD.phone}</td>
                    <td>${userD.email}</td>
<%--                     <c:if test="${not empty userD.updated_at}">
                    <td>${userD.updated_at}</td>
                    </c:if>
                    <c:if test="${not empty userD.updated_by}">
                    <td>${userD.updated_by}</td>
                    </c:if> --%>
                    <td>${userD.active}</td>
                  </tr>
                  
                  </c:forEach>
                  
                  
                  
                </tbody>
              </table>
              
              
            </div>
          </div>
        </div>
      </div>
     </div>
      
  
    
   </div>

<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->


<input type="hidden" id="snackbar" value="${msg}">


<script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>

<!-- <script src="assets/js/jquery.min.js"></script> -->
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/waves.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>


<script type="text/javascript" src="assets/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="assets/js/form-advanced.js"></script>


<!-- Buttons examples --><!-- Responsive examples -->
<script type="text/javascript" src="assets/js/bootbox.js"></script>


<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
} );
</script>

<script type="text/javascript">
$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x, 
		callback: function(){}
		});
	
		
	
});
</script>

<script type="text/javascript">
function form_reset()
{
	document.getElementById("editform").reset();
	}


function swap(val)
{
	document.getElementById('sno').value=val;

	}
</script>
</body>

</html>