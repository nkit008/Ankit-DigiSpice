<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Click to Call</title>
<meta name="viewport" content="width=device-width,initial-scale=1">



<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<!-- <link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"> -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/component.css">

<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- Page Content-->
<div class="wrapper pdspc" style="margin-bottom:35px;">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
      <div class="form-group mb-0" style="padding-top:15px;float:right;">
                      <button type="button" onclick="goBack()" style="float:right;margin-bottom:24px;" class="btn btn-dribbble">Go Back</button>
                   </div>
     
        <div class="page-title-box">
          <!--<div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">New Complain</a></li>
              <li class="breadcrumb-item active">Hardware Complain</li>
            </ol>
          </div>-->
          <h4 class="page-title">View Music</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    
    
    <!--end row-->
    
    <!--End row-->
  
 <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            
            
            <div class="table-responsive">
              <table id="datatable" class="table table-bordered">
                <thead>
                  <tr>
                  	<!-- <th>&#x00A0;</th> -->
                    <th>(#) Id</th>
                    <th>Playlist Name</th>
                    <th>Song code</th>
                    <th>MultiModel Code</th>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Album</th>
                    <th>Active</th>
                    <th>Created By</th>
                    <th>Updated By</th>
					<th>Created At</th>
                    <th>Updated At</th>
                    <th>Action</th>
                  </tr>
                </thead>
                
                <tbody>
                <c:forEach var="open" items="${playlist}">
                <c:set var="create" value="abc_#{open.created_by}"></c:set>
                <c:set var="update" value="abc_#{open.updated_by}"></c:set>
                <tr>
                    <!-- <td><input name="check" id="check" type="checkbox" value=${open.id}></td> -->
                    <td>${open.id}</td>
                    <td>${open.playlist_name}</td>
                    <td>${open.code}</td>
                    <td>${open.mm_code}</td>
                    <td>${open.title}</td>
                    <td>${open.artist}</td>
                    <td>${open.albums}</td>
                    <td>${open.active}</td>
                    <td>${mapitems[create]}</td>
                    <td>${mapitems[update]}</td>
                    <td>${open.created_at}</td>
                    <td>${open.updated_at}</td>
                    <c:if test="${not empty open}">
                    <td><button type="button" onclick="swap(${open.id},${open.active})" data-toggle="modal" data-target="#myModal" class="btn btn-dribbble">Update</button>
                    </c:if>
                  </tr>
                  </c:forEach>
                  
                  
                  
                  
                </tbody>
              </table>
              
                            <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal body -->
       <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="removeMusic1" method="post" id="editform" enctype="multipart/form-data">
            <div class="row">
             <input type="hidden" name="sno" id="sno">
             <input type="hidden" name="status" id="status">
              <p style="text-align:center;font-size:18px;">Are you sure want to Update music?</p>
                            
            </div>
            
            <div class="row" style="margin-bottom: -23px;padding-top: 12px;">
            <div class="col-md-6">
                <div class="p-20">
                <div class="form-group">
             <button class="btn btn-success mb-0" type="submit">Submit</button>
            </div>
            </div>
            </div>
            <div class="col-md-6">
                <div class="p-20">
           
                            <div class="form-group" style="float:right">
             <button class="btn btn-danger mb-0" type="submit" data-dismiss="modal">Cancel</button>
            </div>
            </div>
            </div>
            </div>
              </form>
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
          
        </div>
        
      </div>
 </div>
      
      
      
      <!-- <div class="row" style="padding-left:19px;">
      
      <button type="button" class="btn" style="background-color:#44a2d2; color:#fff !important;" onclick="removeSelect()"> Remove Selected</button>
      
      
      
      
      
      
      </div>
       -->
      
   </div>
  
  
</div>
<!-- end page-wrapper -->

<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->
<input type="hidden" id="snackbar" value="${success}">

<script src="resources/js/custom-file-input.js"></script>

<!-- jQuery  --><script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/app.js"></script>
<!--datepicker -->
<!-- <script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
 --><script src="resources/js/jquery.form-advanced.init.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>

<!-- <script src="resources/js/dataTables.responsive.min.js"></script> -->
<!-- Datatable init js -->
<!-- <script src="resources/js/jquery.table-datatable.js"></script> -->
<!-- App js -->
<script src="resources/js/jquery.dataTables.min.js"></script>

<!-- <script src="resources/js/dataTables.bootstrap4.min.js"></script> -->
<script type="text/javascript">
function swap(val,val1)
{
	document.getElementById('sno').value=val;
	document.getElementById('status').value=val1;
	
}
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
<script>
$(document).ready(function() {
    $('#datatable').DataTable( {
        "scrollX": true
    } );
} );
</script>
<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function goBack()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/home";
	
}
</script>
</body>
</html>