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
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</head>

<body>



<jsp:include page="header.jsp"></jsp:include>
				




<!-- Page Content-->
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <!--<div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">New Complain</a></li>
              <li class="breadcrumb-item active">Hardware Complain</li>
            </ol>
          </div>-->
          <h4 class="page-title">Upload MultiModel</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    
    
    <!--end row-->
    
    <!--End row-->
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="uploadMultimodel" method="post" enctype="multipart/form-data">
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                  
                    <div class="form-group">
                      <label>Multimodel</label><br>

                     <input type="file" name="artwork" id="artwork" class="inputfile inputfile-6" style="display:none;" data-multiple-caption="{count} files selected" multiple />
					<label for="artwork"><span></span> <strong> Choose a file&hellip;</strong></label>
                      </div>
                    
                    
                    
                  
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                    
 					<div class="form-group mb-0" style="padding-top:32px;">
                     <button class="btn btn-light mb-0" style="background-color:#44a2d2; color:#fff; padding:5px 20px 5px 20px;" type="submit">Upload</button>
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
<!-- end page-wrapper -->

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->
<input type="hidden" id="snackbar" value="${success}">

<script src="resources/js/custom-file-input.js"></script>

<!-- jQuery  --><script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/app.js"></script>
<!--datepicker -->
<script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/jquery.form-advanced.init.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>

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
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function addPlaylist()
{
	window.location.href=getContextPath()+"/addNewPlaylist";
}
</script>
</body>
</html>