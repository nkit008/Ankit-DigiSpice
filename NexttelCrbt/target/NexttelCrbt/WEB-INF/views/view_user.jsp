<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>Nexttel</title>

<link rel="stylesheet" type="text/css" href="resources/css/latest.css" />

<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
<link href="resources/css/style.css" rel="stylesheet"/>
<link href="resources/css/sidemenu.css" rel="stylesheet"/>
<link href="resources/css/sidebar.css" rel="stylesheet"/>
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
<link href="resources/css/jquery-confirm.css" rel="stylesheet" type="text/css"/>
</head>
<body class="app sidebar-mini rtl">


<div class="page">
  <div class="page-main"> 
  

    
	<jsp:include page="header.jsp"></jsp:include>    
    
   <!-- Template start here-->   
    
    <div class=" app-content my-3 my-md-5">
      <div class="side-app"> 
        <div class="mb-5">
          <div class="page-header  mb-0">
            <h4 class="page-title">View User</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Manage User</li>
              <li class="breadcrumb-item active" aria-current="page">View User</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form method="post" class="card" action="editUser" method="post" id="editform">
              <div class="card-header">
                <h3 class="card-title">View User</h3>
              </div>
              <div class="card-body">
              
              <div class="row">
              
              <div class="table-responsive">
              <table id="datatable" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>User Id</th>
                    <th>User Name</th>
                    <th>Admin Rights</th>
       				<th>CCI Rights</th>
       				<th>CMS Rights</th>
                    <th>MIS Rights</th>
                    <th>Updated By</th>
                    <th>Updated At</th>
                    <th>Edit</th>
            		<th>Delete</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${list}">
                <%-- <c:set var="update" value="abc_#{open.updated_by}"></c:set> --%>
                
                <tr>
                	<td>${open.userId}</a></td>
                    <td>${open.first_name}</td>
                    <td>${open.admin_rights}</td>
                    <td>${open.cci_rights}</td>
                    <td>${open.cms_rights}</td>
                    <td>${open.mis_rights}</td>
                    <td>${open.updated_by}</td>
                    <td>${open.updated_at}</td>
                    <td><button type="button" onclick="swap('${open.userId}','${open.first_name}','${open.last_name}','${open.password}',
                    '${open.admin_rights}','${open.cci_rights}','${open.cms_rights}','${open.mis_rights}','${open.super_user}',
                    '${open.updated_at}','${open.updated_by}','${open.active}')" class="btn btn-dribbble" data-toggle="modal" data-target="#myModal">Edit</button></td>
                    <td><a href="deleteUser?userid=${open.userId}" onclick="return confirm('Are you sure want to delete')">Delete</a></td>
 </tr>
      
      <!-- ,
                    
                    ) -->            
                  </c:forEach>
                  
                  
                  
                </tbody>
              </table>
              
              
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Edit User</h4>
        <button type="button" class="close" onclick="form_reset()" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">User ID</label>
                      <input type="text" id="userId" name="userId" class="form-control" readonly="readonly">
                    </div>
                    <div class="form-group">
                      <label class="form-label">First Name</label>
                     <input type="text"  class="form-control" name="first_name" id="first_name">
                    </div>
                    <div class="form-group">
                      <label class="form-label">Last Name</label>
                       <input type="text" class="form-control" name="last_name" id="last_name">
                    </div>
                    <div class="form-group">
                      <label class="form-label">Password</label>
                       <input type="text" class="form-control" name="password" id="password">
                    </div>
                  </div>
                  <div class="col-md-6 col-lg-6">
                     <div class="form-group">
                      <label class="form-label">Active</label>
                       <select name="active" id="active">
                       <option value="true">True</option>
                       <option value="false">False</option>
                       </select>
                       
                    </div>                    
                    <div class="form-group">
                      <label class="form-label">Admin Rights</label>
                    <input type="radio" name="admin_rights" id="admin_rights1" value="Y" checked="checked"> yes
                    <input type="radio" name="admin_rights" id="admin_rights2" value="N" checked="checked" style="margin-left:15PX;"> No
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">CCI Rights</label>
                    <input type="radio" name="cci_rights"  id="cci_rights1" value="Y" checked="checked"> yes
                    <input type="radio" name="cci_rights" id="cci_rights2" value="N" checked="checked" style="margin-left:15PX;"> No
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">CMS Rights</label>
                    <input type="radio" name="cms_rights" value="Y" id="cms_rights1" checked="checked"> yes
                    <input type="radio" name="cms_rights" value="N" id="cms_rights2" checked="checked" style="margin-left:15PX;"> No
                    
                    </div>
                    <div class="form-group">
                      <label class="form-label">MIS Rights</label>
                    <input type="radio" name="mis_rights" value="Y" id="mis_rights1" checked="checked"> yes
                    <input type="radio" name="mis_rights" value="N" id="mis_rights2" checked="checked" style="margin-left:15PX;"> No
                  
                    </div>
                    
                    
                    
                    <div class=" mt-2 mb-0">
                    <button type="submit" class="btn btn-primary" id="mysubmit">Submit</button>
                  
                  </div>
                  
                  
                  </div>
                </div>
              </div>
           
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
            </form>
          </div>
        </div>
           
        
      </div>
      <!--Sidebar-right-->
      
      <!--/Sidebar-right-->
      
      <jsp:include page="footer.jsp" ></jsp:include>
     <!-- Template end here-->
      
  </div>
</div>
</div>

<input type="hidden" id="res"/>
<input type="hidden" id="snackbar" value="${msg}"/>
<script src="resources/js/jquery-3.2.1.min.js"></script>

<script src="resources/js/popper.min.js"></script>

<script src="resources/js/bootstrap.min.js"></script>

<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-confirm.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#datatable').DataTable( {
        "scrollX": true
    } );
});
</script>

<script type="text/javascript">
$("#mysubmit").on('click', function () {
	
	$.confirm({
	    title: 'Are you sure want to update!',
	    content: '',
	    buttons: {
	        confirm: function () {
	        	
	          $('#editform').submit();         
	        },
	        
	        cancel: function () {
	        	$('#myModal').modal('hide');   
	        }
	    }
	});	
	return false;
});
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
function swap(userid,fname,lname,pass,admin,cci,cms,mis,superuser,updatedAt,updatedBy,active)
{
	document.getElementById('userId').value=userid;
	document.getElementById('first_name').value=fname;
	document.getElementById('last_name').value=lname;
	document.getElementById('password').value=pass;
	document.getElementById('active').value=active;
	
	if(admin =='Y')
		{
			$('#admin_rights1').prop('checked', true);		
		}
	else
		{
		$('#admin_rights2').prop('checked', true);		
		}
	
	if(cci=='Y')
		{
			$('#cci_rights1').prop('checked', true);		
		}
	else
		{
			$('#cci_rights2').prop('checked', true);		
		}
	
	if(cms=='Y')
	{
		$('#cms_rights1').prop('checked', true);		
	}
else
	{
		$('#cms_rights2').prop('checked', true);		
	}
	
	
	if(mis=='Y')
	{
		$('#mis_rights1').prop('checked', true);		
	}
else
	{
		$('#mis_rights2').prop('checked', true);		
	}
}
</script>
</body>
</html>