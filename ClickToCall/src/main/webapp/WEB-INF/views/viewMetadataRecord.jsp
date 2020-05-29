<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Click to Call</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/component.css">
<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

<style type="text/css">

.card
{
padding-top:15px;
}
</style>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="wrapper">
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
          <h4 class="page-title">View MetaData Info</h4>
        </div>
      </div>
    </div>



    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            
            
            <div class="table-responsive">
              <table id="datatable" class="display nowrap table table-condensed table-striped table-hover">
                <thead>
                  <tr>
                  	<th>(#) Id</th>
                    <th>Playlist name</th>
                    <th>total_metafile_records</th>
       				<th>total_musicfile_inserted</th>
       				<th>total_musicfile_updated</th>
                    <th>total_mm_assign</th>
                    <th>total_mm_update</th>
                    <th>total_unassign_mm</th>
                    <th>total_free_mm</th>
                    <th>Created by</th>
                    <th>Created at</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${playlist}">
                <c:set var="create" value="abc_#{open.created_by}"></c:set>
                <c:set var="update" value="abc_#{open.updated_by}"></c:set>
                
                <tr>
                	<td>${open.id}</a></td>
                    <td>${open.playlist_name}</td>
                    <td>${open.total_metafile_records}</td>
                    <td>${open.total_musicfile_inserted}</td>
                    <td>${open.total_musicfile_updated}</td>
                    <td>${open.total_mm_assign}</td>
                    <td>${open.total_mm_update}</td>
                    <td><a href="viewunassignCode?uid=${open.uid}">${open.total_unassign_mm}</a></td>
                    <td>${open.total_free_mm}</td>
                    <td>${mapitems[create]}</td>
                    <td>${open.created_at}</td>

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
</div>

<jsp:include page="footer.jsp"></jsp:include>
<input type="hidden" id="snackbar" value="${msg}">
<script src="resources/js/jquery.min.js"></script>

<!-- <script src="resources/js/custom-file-input.js"></script> -->

<!-- jQuery  -->


<!-- <script src="resources/js/app.js"></script> -->

<!--datepicker -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>

<!-- App js -->
<script src="resources/js/jquery.dataTables.min.js"></script>
 
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
    });
    
});
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