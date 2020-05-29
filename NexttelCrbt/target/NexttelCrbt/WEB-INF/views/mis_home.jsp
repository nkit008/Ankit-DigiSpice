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
<link rel="stylesheet" type="text/css" href="resources/mis/css/themes.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css"/>
<link href="resources/css/style.css" rel="stylesheet"/>
<link href="resources/css/sidemenu.css" rel="stylesheet"/>
<link href="resources/css/sidebar.css" rel="stylesheet"/>

	<link rel="stylesheet" type="text/css" href="resources/mis/css/jquery.ui.datepicker.css">
	<link rel="stylesheet" type="text/css" href="resources/mis/css/jquery.ui.core.css">




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
            <h4 class="page-title">MIS</h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">MIS Reports</li>
              <li class="breadcrumb-item active" aria-current="page">MIS</li>
            </ol>
          </div>
        </div>
       
       <form class="card" action="mis" method="post" name="form1" id="misForm">
        <div class="row">
          <div class="col-lg-12">
              <div class="card-header">
                <h3 class="card-title">MIS Report</h3>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    From<input type="text" id="datepicker" name="fromDate" style="margin-left: 5px; 
                    margin-right: 5px; padding-right: 5px; vertical-align:-3px; border: 1px solid #a0a0a0; width: 220px; margin-left: 10px;" required/>
                    
                  </div>
                  <div class="col-md-6 col-lg-6">
                    To <input type="text" id="datepicker2" name="toDate" style="margin-right: 5px; 
                    padding-right: 5px; border: 1px solid #a0a0a0; vertical-align:-3px; width: 220px; margin-left: 10px;" required/>
                    </div>
                   
                  </div>
                  
                  
                 <div class="row">
                   <!-- <div class="col-md-6 col-lg-6" style="padding-top:15px;"> 
                   Service Name <select name="accessService" style="width: 150px">
				<option value="CrbtMis">CRBT Nexttel</option>
                    </select>
                  </div>
                   -->
                   
                   <div class="col-md-6 col-lg-6" style="padding-left:42px; padding-top:15px;">
                     <div class=" mt-2 mb-0">
                       &nbsp;
                 	</div>
                    </div>
                   
                  <div class="col-md-6 col-lg-6" style="padding-left:42px; padding-top:15px;">
                     <div class=" mt-2 mb-0">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="submit" class="btn btn-danger" onclick="resetvalue()">Clear</button>
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
        
      </div>
      <!--Sidebar-right-->
      
      <!--/Sidebar-right-->
      
      <jsp:include page="footer.jsp" ></jsp:include>
     <!-- Template end here-->
      
  
<input type="hidden" id="res"/>
<input type="hidden" id="snackbar" value="${msg}"/>
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/sidemenu.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>

<script type="text/javascript" src="resources/mis/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="resources/mis/js/jquery.ui.core.js"></script>
<script type="text/javascript"  src="resources/mis/js/jquery.ui.datepicker.js"></script>

<script type="text/javascript">
				$(function() {
					$("#datepicker").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});

				$(function() {
					$("#datepicker2").datepicker({
						showOn : 'button',
						buttonImage : 'resources/mis/images/calendar.gif',
						buttonImageOnly : true
					});
				});
</script>
<script>
function myFunction(form) {
  window.open('mis', 'formpopup', 'width=700,height=500,resizeable,scrollbars');
  form.target = 'formpopup';
  
}
	
function resetvalue()
{
	$('#misForm').find('input:text').val('');
	event.preventDefault();
}
</script>
</body>
</html>