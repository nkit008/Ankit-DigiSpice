<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>Indosat</title>


			<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">                     
              <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
              <link href="resources/css/icons.css" rel="stylesheet" type="text/css">
              <link href="resources/css/style.css" rel="stylesheet" type="text/css">
			<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">              
              <link href="resources/css/jquery-confirm.css" rel="stylesheet" type="text/css">
           
    
              

    </head>
    <body>
      <div id="wrapper">
        
	<jsp:include page="header.jsp"></jsp:include>       

<div class="wrapper">
        <div class="container-fluid">
              
            <div class="row" >
                <div class="col-lg-12">
                    <div class="card m-b-20">
                        <div class="card-body">

                            <h4 class="mt-0 header-title">User Subscription Status </h4>
                            

                            <form action="fetchSubsDetails" method="post">
                                <div class="form-group"	>
                                    <label>Mobile Number</label>
                                    <input type="text" class="form-control" id="mobile" name="mobile" style="width:30%" required placeholder=""/>
                             </div>
                             
                             
                                <!-- <div class="form-group"	> 
                                    <label>Select Service</label>
                                    <select class="form-control" name="service" id="service" required="required">
                      					<option disabled="disabled" selected="selected">Select Service</option>
                      					<option>INDOMUSIK</option>
                      					<option>IBADAH</option>
                       
 				                   </select>
                             </div>-->
                              
                                <div class="form-group">
                                    <div>
                                        <button type="submit" class="btn btn-primary waves-effect waves-light">
                                            Submit
                                        </button>
                                        
                                    </div>
                                </div>
                            </form>
                            
                            <h6 id="msg" style="text-align: center;color:#f4ad42;font-weight: bold;">${msg}</h6>
           
                            <div id ="tablepack">
					<c:if test="${not empty SubscriptionList}">
                      <table id="example" class="display nowrap" style="width:100%">
		                <thead>
		                  <tr>
		                  	<th>SERVICE</th>
		                    <th>STATUS</th>
		                    <th>SUBSCRIPTION DATE</th>
		                    <th>RENEW_DATE</th>
		                    <th>BILLING_DATE</th>
		                    <th>SERVICE_NAME</th>
		                    <th>PACK</th>
		                    <th>ACTIVATION SOURCE</th>
		                    <th>UNSUBSCRIBE</th>
		 	               	<th>BILLING DETAILS</th>
		 	               </tr>
		                </thead>
		                <tbody>
                	
                		<c:forEach var="open" items="${SubscriptionList}">
		                <tr style="text-align: center;">
		                	<td>${open['MAIN_SERVICE_NAME']}</td>
		                    <td>${open['STATUS']}</td>
		                    <td>${open['SUB_DATE']}</td>
		                    <td>${open['RENEW_DATE']}</td>
		                    <td>${open['BILLING_DATE']}</td>
							<td>${open['SERVICE_NAME']}</td>
		                    <td>${open['PACK_TYPE']}</td>
		                    <td>${open['ACT_SOURCE']}</td>
		                    <td><a onclick="return showConfWindow('${open['MOBILE_NUMBER']}','${open['MAIN_SERVICE_NAME']}','${open['SERVICE_NAME']}')">unsubscribe</a></td>
		                    <td><a onclick="return ShowBilling('${open['MOBILE_NUMBER']}','${open['MAIN_SERVICE_NAME']}')">Billing Details</a></td>
		                 </tr>
		                  
		                  </c:forEach>
                </tbody>
              </table>
              </c:if>
              </div>




                            <div id ="packDetails">
				      <table id="example1" class="display nowrap" style="width:100%">
		                <thead>
		                  <tr style="text-align:center;">
		                  	<th>SERVIC NAME</th>
		                    <th>SUBSCRIPTION DATE</th>
		                    <th>RENEW_DATE</th>
		                    <th>BILLING_DATE</th>
		                    <th>SERVICE_NAME</th>
		                    <th>PACK NAME</th>
		                    <th>AMOUNT(IN RP)</th>
		 	               	<th>SOURCE</th>
		 	               </tr>
		                </thead>
		                <tbody>
		                </tbody>
		               </table>
              </div>
              
                        </div>
                    </div>
                </div> <!-- end col -->

                 <!-- end col -->
            </div> <!-- end row -->

        </div> <!-- end container -->
    </div>
<!-- end wrapper -->
                
<jsp:include page="footer.jsp"></jsp:include>       

      </div>

     <script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
     <script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="resources/js/app.js"></script>
	<script type="text/javascript" src="resources/js/jquery-confirm.js"></script>


<script type="text/javascript">

var x = document.getElementById('mobile').value;

</script>

<c:if test="${not empty SubscriptionList}">
<script>
$(document).ready(function() {
    $('#example').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
} );
</script>
</c:if>

<c:if test="${forHiding == 'no data'}">
<script>
$(document).ready(function() {
	$('#packDetails').hide();
} );
</script>
</c:if>


<script type="text/javascript">
function ShowBilling(Mobile_Number, MAIN_SERVICE_NAME)
{
	$.confirm({
		title: 'Confirm!',
		content: 'Showing billing details for '+Mobile_Number,
		buttons: {
		confirm: function(){
			
			$.ajax({
				url:"showDetails",
				dataType: 'json',
				data : {'mobile': Mobile_Number, 'main_service': MAIN_SERVICE_NAME}, 
				method:"POST",
				success: function(ni)
				{
					var trHtml='';
					
					$('#tablepack').hide();
					$('#packDetails').show();
					$.each(ni, function(key, val){
						trHtml +='<tr style="text-align:center;"><td>' +val['MAIN_SERVICE_NAME']+'</td><td>'+
						val['SUB_DATE']+'</td><td>'+
						val['RENEW_DATE']+'</td><td>'+
						val['BILLING_DATE']+'</td><td>'+
						val['SERVICEDESCRIPTION']+'</td><td>'+
						val['PACK_VALIDITY']+'</td><td>'+
						val['AMOUNT']+'</td><td>'+
						val['ACT_SOURCE']+'</td></tr>';
						$('#example1 tbody').append(trHtml);
					});
				    $('#example1').DataTable( {
				    	"scrollX": true,
				    	scrollY:        '40vh',
				        scrollCollapse: true,
				        paging:         false
				    } );
				
				    document.getElementById("msg").innerHTML="Billing Details of "+  Mobile_Number;
					return false;
					
				},
				
				error : function() { 
					//alert("No Details found for this Number");
					return false;
				}
			
			});
			
			event.preventDefault();
			
		},
		cancel: function(){
			//$.alert('wrong!');
		}
		
		}
	});
}
</script>
<script type="text/javascript">
function showConfWindow(Mobile_Number, MAIN_SERVICE_NAME, service)
{
	$.confirm({
		title: 'Confirm!',
		content: 'Are you sure to unsuscribe '+Mobile_Number+' for service '+service+'!',
		buttons: {
		confirm: function(){
			
			event.preventDefault();
			window.location.href=getContextPath()+"/unSubs?mainService=" + MAIN_SERVICE_NAME + "&service=" + service + "&ani=" + Mobile_Number;
			return false;
		},
		
		cancel: function(){
			//$.alert('wrong!');
			//return false;
		}	
		}
	});
}
</script>
<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}
</script>

</body>

</html>
