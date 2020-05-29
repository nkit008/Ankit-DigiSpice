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
              <li class="breadcrumb-item"><a href="javascript:void(0);">Update User</a></li>
              
            </ol>
          </div>
          <h4 class="page-title">Update User Details</h4>
        </div>
      </div>
    </div>
      
    
    
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
           <form action="updateUserAction" method="post"> 
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>Please Enter User Name<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="userId" name="userId" autofocus="autofocus" required="required" autocomplete="off" width="10%">
                      <span class="font-13 text-muted"></span></div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                      
                      
                      
                    <div class="form-group">
                    
                    <div class="form-group">
                     <button class="btn btn-light mb-0" type="submit" style="margin-top: 38px;">Submit </button>
                      </div>
                                           
                      
                      
                </div>
              </div>
            </div>
          </div>
          </form>
          
          <c:if test="${not empty userD}">
          
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
                    <c:if test="${not empty userD.updated_at}">
                    <th>Updated At</th>
                    </c:if>
                    <c:if test="${not empty userD.updated_by}">
                    <th>Updated By</th>
                    </c:if>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Active</th>
                    <th>Update</th>
                  </tr>
                </thead>
                <tbody>
                
                <tr style="text-align: center;">
                    <td>${userD.id}</td>
                    <td>${userD.user_name}</td>
                    <td>${userD.password}</td>
                    <td>${userD.name}</td>
                    <td>${userD.user_role}</td>
                    <td>${userD.created_at}</td>
                    <td>${userD.created_by}</td>
                    <c:if test="${not empty userD.updated_at}">
                    <td>${userD.updated_at}</td>
                    </c:if>
                    <c:if test="${not empty userD.updated_by}">
                    <td>${userD.updated_by}</td>
                    </c:if>
                    <td>${userD.phone}</td>
                    <td>${userD.email}</td>
                    <td>${userD.active}</td>
              <td><button type="button" class="btn btn-dribbble" data-toggle="modal" data-target="#myModal">
  Update
</button>

</td>

                  </tr>
                  
             
                  
                  
                </tbody>
              </table>
          </c:if>
          
          
          
          
                        <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Update User Details</h4>
        <button type="button" class="close" onclick="form_reset()" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="editUserDetailsAction" method="post" id="editform" onsubmit="return validateForm()">
            <input type="hidden" name="created_at" id="created_at" value="${userD.created_at}"/>
            <input type="hidden" name="created_by" id="created_by" value="${userD.created_by}"/>
            <div class="row">
             <input type="hidden" name="sno" id="sno">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>User Id</label>
                      <input type="text" class="form-control" id="Id" name="Id" readonly="readonly" autofocus="autofocus" value="${userD.id}">
                      <span class="font-13 text-muted"></span></div>
                    <div class="form-group">
                      <label>User Name</label>
                     <input type="text" class="form-control" id="user_name" name="user_name" required="required" autocomplete="off" value="${userD.user_name}">
                      </div>
                    
                    <div class="form-group">
                      <label>Password</label>
                      <input type="text" class="form-control" id="password" name="password" value="${userD.password}">
                      </div>
                      
                      
                      <div class="form-group">
                      <label>phone</label>
                      <input type="text" class="form-control" id="phone" name="phone" value="${userD.phone}">
                      </div>
                      
                
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                      
                    <div class="form-group">
                      <label>Name</label>
                      <input type="text" class="form-control"  id="name" name="name" required="required" value="${userD.name}">
                      </div>
                    
                    <div class="form-group">
                       <label>User Role</label>
                      <select class="form-control" id="user_role" name="user_role" required="required" autocomplete="off">
                      <option selected="selected" value="${userD.user_role}">${userD.user_role}</option>
                      <c:if test="${userD.user_role ne 'spice_admin'}">
                      <option value="Spice_Admin">Spice_Admin</option>
                      </c:if>
                      <c:if test="${userD.user_role ne 'prison_admin'}">
                      <option value="Prison_Admin">Prison_Admin</option>
                      </c:if>
                      <c:if test="${userD.user_role ne 'bsnl_admin'}">
                      <option value="BSNL_Admin">BSNL_Admin</option>
                      </c:if>
                      </select>
                      </div>
                      
                      
                    <div class="form-group mb-0">
                      <label>Active<!-- <span class="sta-red">*</span> --></label>
                      <select class="form-control" id="active" name="active" required="required" autocomplete="off">
                      <option selected="selected" value="${userD.active}">${userD.active}</option>
                      <c:if test="${userD.active ne 'true'}">
                      <option value="true">true</option>
                      </c:if>
                      <c:if test="${userD.active ne 'false'}">
                      <option value="false">false</option>
                      </c:if>
                      </select>
                      </div>
                      
                      <div class="form-group" style="margin-top: 24px;">
                      <label>Mail</label>
                      <input type="email" class="form-control" id="email" name="email" value="${userD.email}" required="required">
                      </div>
                      
                      
                     <div class="form-group mb-0" style="padding-top:15px;">
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
                      </div> 
              </div>
               
              </div>
              
              <!-- end col --></div>
              </form>
            <!-- end row --></div>
        </div>
      </div>
      <!-- end col --></div>
      </div>

     
      

    </div>
  </div>
</div>



          
        </div>
      </div>
    </div>
   </div>
 
  
</div>
</div>
<!-- template end here -->

<input type="hidden" id="snackbar" value="${msg}">

<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->

<!-- basic jQuery  -->

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
<script>
function validateForm(){
	var pass= document.getElementById("password").value;
	var x= document.getElementById("phone").value;
	
	var pass_pattern = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/;
	var text_pattern = /^\d+$/;
	
	if(!pass_pattern.test(pass))
		{
		 	alert("password should contain atleast one number and one special character and have atleast 8 characters");
	        return false;
		
		}
	
	if (!text_pattern.test(x))
		{
		document.getElementById("phone1").innerHTML="**Number should contain digits";
			return false;
		}
	
	
	if(document.getElementById("user_role").value==-1)
		{
			alert("please select role");
			return false;		
		}
	
	
	if(x.length>=10 && x.length<14)
		{
		return true;
		}
		
	else
		{
		document.getElementById("phone1").innerHTML="**Number should have 10 digits";
		return false;
		} 
	}
</script>

</body>
</html>