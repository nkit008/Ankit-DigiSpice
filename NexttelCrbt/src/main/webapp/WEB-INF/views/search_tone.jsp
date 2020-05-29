<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  
 <!-- header start here-->
  <jsp:include page="header.jsp" />
    <!--Left side-menu end here-->
    
    
    
    
   <!-- Template start here-->   
    
    <div class=" app-content my-3 my-md-5">
      <div class="side-app"> 
        <div class="mb-5">
          <div class="page-header  mb-0">
            <h4 class="page-title">Search Tone </h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">neXtTunes</li>
              <li class="breadcrumb-item active" aria-current="page">Search Tone</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="searchSongAction" method="post" onsubmit="return validate();">
              <div class="card-header">
                <h3 class="card-title">Search Tone </h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">Category<span style="color:red;font-weight:bold;font-size:13px;">*</span></label>
                      <select class="form-control" id="category" name="category">
                      <option selected="selected" value="-1">Select Categories</option>
                      <option>All</option>
                      <option>Local</option>
                      </select>
                    
                    </div>
                    
                   
                    
              <div class="form-group">
                      <label class="form-label">Search by</label>
                      <select class="form-control" id="searchBy" name="searchBy">
                      <option>All</option>
                      <option value="album">Album</option>
                      <option value="singer">Artist</option>
                      <option value="tone_name">Song Name</option>
                      <option value="tone_code">Tone Id</option>
                
                      </select>
                    
                    </div>     
                    
                  </div>
                  <div class="col-md-6 col-lg-6">
                  <div class="form-group">
                      <label class="form-label">Sub Category</label>
                      <select class="form-control" id="subcat" name="subcat">
                      </select>
                     
                    </div>
                    
                    <div class="form-group">
                      <label class="form-label">Search Text<span style="color:red;font-weight:bold;font-size:13px;">*</span></label></label>
                      <input type="text" class="form-control" name="text" id="text"/>
                    </div>
                    
                    <div class="form-group" style="padding-top:30px;">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                    
                    
                    
                    
                    
                    
                    
                  
                  
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
        
        
        
     <c:if test="${fn:length(subData) gt 0}">
             <div class="table-responsive">
              <table id="datatable" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>Song Id</th>
       				<th>Song Name</th>
       				<th>Album Name</th>
                    <th>Artist Name</th>
                    <th>Category</th>
                    <th>Sub Category</th>
                    <th>Set RBT</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${subData}">
                <tr style="text-align:center;">
                	<td>${open['SONG_ID']}</td>
                    <td>${open['SONG_NAME']}</td>
                    <td>${open['ALBUM_NAME']}</td>
                    <td>${open['ARTIST_NAME']}</td>
                    <td>${open['CATEGORY']}</td>
                    <td>${open['SUB_CATEGORY']}</td>
                    <td><a href="setRbt?requestType=DWLD&song_id=${open['SONG_ID']}&song_name=${open['SONG_NAME']}&searchType=${searchType}&searchString=${searchString}&cat=${cat}&subCategory=${subCategory}&msg=a">
                    <i class="fa fa-music" aria-hidden="true"></i></a></td>

		    
		    
		                        
                    
				 </tr>
                  </c:forEach>
                  </tbody>
              </table>
                
              </div>
     
     </c:if>
        
        
      </div>
      <!--Sidebar-right-->
      
      <!--/Sidebar-right--> <!--footer-->
<jsp:include page="footer.jsp" />
      </div>
      
     <!-- Template end here-->
      
  </div>
</div>

<input type="hidden" id="res"/>
<input type="hidden" id="snackbar" value="${msg}"/>

<script src="resources/js/jquery-3.2.1.min.js"></script>

<script src="resources/js/popper.min.js"></script>

<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<script src="resources/js/jquery-confirm.js"></script>
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
$(document).ready(function() {
    $('#datatable').DataTable( {
        "scrollX": true
    } );
});
</script>
<script type="text/javascript">
function validate()
{
	if($('#category').val() == '-1')
	{
		alert("please select category");
		$('#category').focus();
		return false;
	}
	
	else if($('#text').val().length == 0)
		{
		alert("please enter Search Text");
		$('#text').focus();
		return false;
		}

}
</script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#category").change(function (){
			
			var cat = $("#category").val();
			$.ajax({
				url:"getSubCat",
				dataType: 'json',
				data : 'category=' + cat, 
				method:"GET",
				success: function(ni)
				{
					$('#subcat').html("");
					$.each(ni, function(key, val) {
						$('#subcat').append("<option value="+ val +" >"+ val +"</option>"); 
				});

				},
				
				error : function() { 
					alert("No previous record match for this prison id");
				}
			
			});
		});
		
	
	
	});
</script>
</body>
</html>