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

<style type="text/css">

.card
{
padding-top:5px;
}

.inputfile-6 + label span
{
width:196px;
}

.page-title
{
margin-top:-23px;
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
          <h4 class="page-title">View Playlist</h4>
        </div>
      </div>
    </div>



    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            
            
            <div class="table-responsive">
              <table id="datatable" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>(#) Id</th>
                    <th>Title</th>
                    <th>Description</th>
       				<th>Active</th>
                    <th>Created by</th>
                    <th>Updated by</th>
                    <th>Created at</th>
                    <th>Updated at</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${playlist}">
                <c:set var="create" value="abc_#{open.created_by}"></c:set>
                <c:set var="update" value="abc_#{open.updated_by}"></c:set>
                <tr>
                
                	<td>${open.id}</a></td>
                    <td>${open.title}</td>
                    <td>${open.desc}</td>
                    <td>${open.active}</td>
                    <td>${mapitems[create]}</td>
                    <td>${mapitems[update]}</td>
                    <td>${open.created_at}</td>
                    <td>${open.updated_at}</td>
                    <c:if test="${not empty open}">
                    
					<td><button type="button" onclick="swap(${open.id},'${open.title}','${open.desc}','${open.active}')" class="btn btn-dribbble" data-toggle="modal" data-target="#myModal">
  Update
</button>

</td>
</c:if>
 </tr>
                  
                  </c:forEach>
                  
                  
                  
                </tbody>
              </table>
              
              
              <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Update playlist</h4>
        <button type="button" class="close" onclick="form_reset()" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="updateplaylist" method="post" id="editform" enctype="multipart/form-data">
            <div class="row">
             <input type="hidden" name="sno" id="sno">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>Title</label>
                      <input type="text" class="form-control" id="title" name="title" readonly="readonly">
                      <span class="font-13 text-muted"></span></div>
                    <div class="form-group">
                      <label>Active<span class="sta-red">*</span></label>
                     <select class="form-control" id="active" name="active" required="required">
                      <option value="true">True</option>
                      <option value="false">False</option>
                    </select>
                      </div>
                      
                      <div class="form-group mb-0" style="padding-top:15px;">
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
                      </div>
                      
                
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                      
                    <div class="form-group">
                      <label>Description<span class="sta-red">*</span></label>
                      <textarea cols="" rows="" class="form-control" id="desc" name="desc" required="required" autocomplete="off"></textarea>
                      </div>
                    
                      <div class="form-group">
                      <label>Banner <span style="font-weight:bold;color:red">(Please Upload ZIP File)</span></label><br>

                    <input type="file" name="banner" id="banner" class="inputfile inputfile-6" style="display:none;" data-multiple-caption="{count} files selected" multiple=""/>
					<label for="banner"><span></span> <strong> Choose a file&hellip;</strong></label>
					<br/><a href="downloadBannerFileSamplePlaylist">Click here for Sample File</a>
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
</div>












<jsp:include page="footer.jsp"></jsp:include>
<input type="hidden" id="snackbar" value="${msg}">

<script src="resources/js/custom-file-input.js"></script>

<!-- jQuery  --><script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/app.js"></script>
<!--datepicker -->
<!-- <script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script> -->
<script src="resources/js/jquery.form-advanced.init.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>

<script src="resources/js/jquery.dataTables.min.js"></script>

<!-- <script src="resources/js/dataTables.bootstrap4.min.js"></script> -->

<script type="text/javascript">
function form_reset()
{
	document.getElementById("editform").reset();
	}


function swap(val,val1,val2,val3)
{
	document.getElementById('sno').value=val;
	document.getElementById('title').value=val1;
	document.getElementById('desc').value=val2;
	document.getElementById('active').value=val3;
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