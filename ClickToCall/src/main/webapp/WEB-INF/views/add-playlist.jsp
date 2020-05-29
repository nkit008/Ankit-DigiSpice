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
                    
          <h4 class="page-title">Add New Playlist</h4>
          
          
                   
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
            
            <form action="uploadNewPlaylist" method="post" enctype="multipart/form-data">
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                  
                    <div class="form-group">
                      <label>Title</label>
                      <div>
                    <input type="text" name="playlistTitle" id="playlistTitle" class="form-control" style="" required="required" autocomplete="off" autofocus="autofocus"></select>
                     </div></div>
                      
                    
                      <div class="form-group">
                      <label>Banner <span style="font-weight:bold;color:red">(Please Upload ZIP File)</span></label><br>

                    <input type="file" name="banner" id="banner" class="inputfile inputfile-6" style="display:none;" data-multiple-caption="{count} files selected" multiple/>
					<label for="banner"><span></span> <strong> Choose a file&hellip;</strong></label>
					<br/><a href="downloadBannerFileSample">Click here for Sample File</a>
                      </div>

                  
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                  
                    <div class="form-group">
                      <label>Description</label><br>

                    <textarea class="form-control"  name="playlistDesc" id="playlistDesc"  required="required" autocomplete="off"></textarea>
                      </div>
                      
                      <div class="form-group mb-0" style="padding-top:15px;">
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

<jsp:include page="footer.jsp"></jsp:include>
<input type="hidden" id="snackbar" value="${error}">

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

function goBack()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/home";
	
}
</script>
</body>
</html>