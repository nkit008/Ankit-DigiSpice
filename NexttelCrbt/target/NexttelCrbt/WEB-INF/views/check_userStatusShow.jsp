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
  

    
	<jsp:include page="header.jsp"></jsp:include>    
    
   <!-- Template start here-->   
    

<div class=" app-content my-3 my-md-5">
      <div class="side-app"> 
        <div class="mb-5">
          <div class="page-header  mb-0">
            <h4 class="page-title">Status </h4>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Customer Care</li>
              <li class="breadcrumb-item active" aria-current="page">Check Status</li>
            </ol>
          </div>
        </div>
       
        <div class="row">
          <div class="col-lg-12">
            <form  class="card" action="checkUserStatusAction" method="post">
              <div class="card-header">
                <div style="width:90%; float:left;"><h3 class="card-title">Show User Status</h3></div>
               <div>  <button type="submit" onclick="goBack()" style="background-color:#53127F;" class="btn btn-primary"><i  style=" font-size:17px; padding-right:5px;"class="angle fa fa-angle-left"></i>Back</button></div>
              </div>
              <div class="card-body">
       	<c:if test="${fn:length(subData) gt 0}">
                
              <div class="row">
              <h3>Subscription Detail</h3>
              <div class="table-responsive">
              <table id="datatable" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>Mobile Number</th>
                    <th>Language</th>
                    <th>Status</th>
       				<th>Subs Date</th>
       				<th>Renew Date</th>
                    <th>Billing Date</th>
                    <th>Pack Type</th>
                    <th>Activation Source</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${subData}">
                <tr style="text-align:center;">
                	<td>${open['MOBILE_NUMBER']}</td>
                    <td>${open['LANGUAGE']}</td>
                    <td>${open['STATUS']}</td>
                    <td>${open['SUB_DATE']}</td>
                    <td>${open['RENEW_DATE']}</td>
                    <td>${open['BILLING_DATE']}</td>
                    <td>${open['PACK_TYPE']}</td>
                    <td>${open['ACT_SOURCE']}</td>
				 </tr>
                  </c:forEach>
                  </tbody>
              </table>
                
              </div>
              </div>
             
              
              <div class="row">
              &#x00A0;
              </div>
              </c:if>
              
           
           <c:if test="${fn:length(crbtSubData) gt 0}">    
              <div class="row">
              <h3>Tone Download Details</h3>
              <div class="table-responsive">
              <table id="datatable1" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>Mobile Number</th>
                    <th>Language</th>
                    <th>Status</th>
       				<th>Subs Date</th>
       				<th>Renew Date</th>
                    <th>Billing Date</th>
                    <th>Pack Type</th>
                    <th>Tone Name</th>
                    <th>Activation Source</th>
                    <th>Delete Tone</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${crbtSubData}">
                <tr style="text-align:center;">
                	<td>${open['MOBILE_NUMBER']}</td>
                    <td>${open['LANGUAGE']}</td>
                    <td>${open['STATUS']}</td>
                    <td>${open['SUB_DATE']}</td>
                    <td>${open['RENEW_DATE']}</td>
                    <td>${open['BILLING_DATE']}</td>
                    <td>${open['PACK_TYPE']}</td>
					<td>
                    <a class="btn-detail" style="color: green;font-weight: bold;text-decoration: underline;" href="#" onclick="set('${open['RBT_NAME']}')">${open['RBT_NAME']}
                    </a></td>
                    <td>${open['ACT_SOURCE']}</td>
                    <td style="text-align:center;">
                    <a class="btn-detail" style="color: red;" href="#" onclick="delTone('${open['TONE_CODE']}')">
                    <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
                    </td>
				 </tr>
                  </c:forEach>
                  </tbody>
              </table>
                
              </div>
              </div>
              </c:if>
              
              <c:if test="${fn:length(unsubData) gt 0}">
              <div class="row">
              <h3>User Unsubcription Details</h3>
              <div class="table-responsive">
              <table id="datatable3" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>Mobile Number</th>
                    <th>Language</th>
       				<th>Sub Date</th>
       				<th>Renew Date</th>
                    <th>Billing Date</th>
                    <th>Unsub Date</th>
                    <th>Status</th>
                    <th>Act Source</th>
                    <th>Unsub Source</th>
                    <th>Amount</th>
                    <th>Pack Type</th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="open" items="${unsubData}">
                <tr style="text-align:center;">
                	<td>${open['MOBILE_NUMBER']}</td>
                    <td>${open['LANGUAGE']}</td>
                    <td>${open['SUB_DATE']}</td>
                    <td>${open['RENEW_DATE']}</td>
                    <td>${open['BILLING_DATE']}</td>
                    <td>${open['UNSUB_DATE']}</td>
                    <td>${open['STATUS']}</td>
                    <td>${open['ACT_SOURCE']}</td>
                    <td>${open['UNSUB_SOURCE']}</td>
                    <td>${open['AMOUNT']}</td>
                    <td>${open['PACK_TYPE']}</td>
                    <%-- <a class="btn-detail" style="color: green;"  href="#" onclick="set('${open['RBT_NAME']}')"> --%>
                    
				 </tr>
                  </c:forEach>
                  </tbody>
              </table>
                
              </div>
              </div>
              
              </c:if>
              </div>
              
            </form>
          </div>
        </div>
        
        
        
     
        
        
      </div>
	</div>

	<!-- Template end here-->
      <jsp:include page="footer.jsp" ></jsp:include>
<input type="hidden" value="${status}" id="s1"></input>
<input type="hidden" value="${mobile}" id="d1"></input>     
      
  </div>
</div>


<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content" style="margin-top: 62px;width: 182%;margin-left: -31%;"> 

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Tone Details</h4>
        <button type="button" class="close" onclick="form_reset()" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
             <div class="table-responsive">
              <table id="datatable2" class="display nowrap table table-condensed table-striped table-hover" style="width:100%;">
                <thead>
                  <tr>
                  	<th>Song Id</th>
       				<th>Song Name</th>
       				<th>Album Name</th>
                    <th>Artist Name</th>
                    <th>Category</th>
                    <th>Sub Category</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="open" items="${tonedata}">
                <tr style="text-align:center;">
                	<td>${open['SONG_ID']}</td>
                	<td>${open['SONG_NAME']}</td>
                	<td>${open['ALBUM_NAME']}</td>
                	<td>${open['ARTIST_NAME']}</td>
                	<td>${open['CATEGORY']}</td>
                	<td>${open['SUB_CATEGORY']}</td>
                </tr>
                </c:forEach>
                </tbody>
              </table>
                
              </div>
     
            
                        <!-- end row --></div>
        </div>
      </div>
      <!-- end col --></div>
      </div>

     
      

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
$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x,
		callback: function(){}
		});
});
</script>

<c:if test="${fn:length(tonedata) gt 0}">
	<script type="text/javascript">
		$(document).ready(function(){
			$('#myModal').modal('show');
		});
	</script>
</c:if>

<script type="text/javascript">
$(document).ready(function() {
    $('#datatable').DataTable( {
        "scrollX": true
    } );
});
</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#datatable2').DataTable( {
        "scrollX": true
    } );
});
</script>
<script type="text/javascript">
$(document).ready(function() {
    $('#datatable1').DataTable( {
        "scrollX": true
    } );
});
</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#datatable3').DataTable( {
        "scrollX": true
    } );
});
</script>

<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function set(a)
{
	var s = $("#s1").val();
	var m = $("#d1").val();
	event.preventDefault();
	window.location.href=getContextPath()+"/getToneDetails?textString="+a+"&status="+s+"&mobile="+m;
	
}


function delTone(a)
{
	
	var m = $("#d1").val();
	
	$.confirm({
	    title: 'Confirm!',
	    content: 'Do you really want to delete tone?',
	    buttons: {
	        confirm: function () {
	window.location.href=getContextPath()+"/delToneAction?msisdn="+m+"&toneCode="+a;
	        },
	        cancel: function () {
	            
	        }
	    }
	});
	
	event.preventDefault();
	
}

function goBack()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/checkStatus";
}
</script>
</body>
</html>