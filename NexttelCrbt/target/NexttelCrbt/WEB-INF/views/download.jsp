<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Title -->
<title>Nexttel</title>

<link rel="stylesheet" type="text/css" href="resources/css/latest.css" />
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/sidemenu.css" rel="stylesheet">
<link href="resources/css/sidebar.css" rel="stylesheet">
</head>
<%@page import="java.util.*"%>
<%
    HashMap<String, String> serviceName = null;
    serviceName = (HashMap<String, String>) session.getAttribute("SERVICE_TYPE");
  %>
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
            <h4 class="page-title">Download Setting </h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Customer Care</li>
              <li class="breadcrumb-item active" aria-current="page">Download Setting</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="setRbtAction" method="post" onsubmit="return validate();">
              <div class="card-header">
                <div style="width:90%; float:left;"><h3 class="card-title">Download Setting</h3></div>
               <div>  <button type="submit" onclick="goBack()" style="background-color:#53127F;" class="btn btn-primary"><i  style=" font-size:17px; padding-right:5px;"class="angle fa fa-angle-left"></i>Back</button></div>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-6 col-lg-6">
                    <div class="form-group">
                      <label class="form-label">ANI</label>
                      <input type="text" name="mobile_number" id="mobile_number" class="form-control" required/>
                      
                      
                    </div>
                    
                   
                    
					<div class="form-group">
                      <label class="form-label">Song Name</label>
                      <input type="text" class="form-control" name="rbt_name" id="rbt_name" readonly="readonly" value="${song_name}"/>
                    </div>
                    
                  </div>
                  <div class="col-md-6 col-lg-6">
                   <div class="form-group">
                      <label class="form-label">Song ID</label>
                      <input type="text" class="form-control" name="song_ID" id="song_ID" value="${song_id}" readonly="readonly"/>
                      
                      
                      
                    </div>
                                   <div class="form-group">
                      <label class="form-label">Tone Pack <span id="war_msg" style="color:red;float:right"></span></label>
                      <select class="form-control" name="pack" id="pack">
                      <option value="-1">Select Pack</option>
                      <%  for (Map.Entry map : serviceName.entrySet()) {%>
                      <option value="<%= map.getKey()%>"><%=  map.getValue()%> </option>
                       <% }%>
                      </select>
                      
                      
                    </div>     

<input type="hidden" name= "searchType" value="${searchType}"></input>
<input type="hidden" name= "searchString" value="${searchString}"></input>
<input type="hidden" name= "cat" value="${cat}"></input>
<input type="hidden" name= "subCategory" value="${subCategory}"></input>                    
                    
                    <div class="form-group" style="padding-top:30px;">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                    
                    </div>
                </div>
              </div>
            </form>
          </div>
        </div>
        
        
        <div>
        <table width="100%" border="1">
  <thead>
  <tr style="text-align:center;">
    <td>Package</td>
    <td>Validity (in Days)</td>
    <td>Subscription Charges</td>
    <td>Tone Download Charges</td>
    <td>Total Charges</td>
  </tr>
  </thead>
  <tr style="text-align:center;">
    <td>Monthly</td>
    <td>30</td>
    <td>140 FCFA</td>
    <td>150 FCFA</td>
    <td>290 FCFA</td>
  </tr>
  <tr style="text-align:center;">
    <td>Weekly</td>
    <td>7</td>
    <td>70 FCFA</td>
    <td>75 FCFA</td>
    <td>145 FCFA</td>
  </tr>
  <tr style="text-align:center;">
    <td>Daily</td>
    <td>1</td>
    <td>30 FCFA</td>
    <td>35 FCFA</td>
    <td>65 FCFA</td>
  </tr>
        </table>
</div>
     
        
        
      </div>
      <!--Sidebar-right-->
      
      
      
      
      
      
      
      <!--/Sidebar-right--> <!--footer-->
<jsp:include page="footer.jsp" />
      </div>
      
     <!-- Template end here-->
      
  </div>
</div>
<c:if test="${msg ne 'a'}">
<input type="hidden" id="snackbar" value="${msg}"/>
</c:if>
<script src="resources/js/jquery-3.2.1.min.js"></script>

<script src="resources/js/popper.min.js"></script>

<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>
<script src="resources/js/sidemenu.js"></script>
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
function validate()
	{
		var a=$('#pack').val();
		
		if(a === "-1")
			{
			$('#war_msg').text("Please Select Tone Pack");
			return false;
			}
		else
			{
			
			var t=$('#mobile_number').val().length;
			if(t > 14)
				{
				alert("Number is Incorrect");
				return false;
				}
				
			else
				{
					return true;
				}
			
			}
			
}
</script>
<script>
function goBack()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/searchSongAction?category=${cat}&searchBy=${searchType}&subcat=${subCategory}&text=${searchString}";
}
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
</script>
</body>
</html>