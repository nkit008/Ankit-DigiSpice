<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>View UnSuscribe Details</title>
                     
			<link href="resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">                     
              <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
              <link href="resources/css/icons.css" rel="stylesheet" type="text/css">
              <link href="resources/css/style.css" rel="stylesheet" type="text/css">
			<link href="resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">              
              <link href="resources/css/jquery-confirm.css" rel="stylesheet" type="text/css">
              
              
           
    
              

    </head>
    <body>
      <div id="wrapper">

<jsp:include page="header.jsp"/>        
        

<div class="wrapper">
        <div class="container-fluid">
              
            <div class="row" >
                <div class="col-lg-12">
                    <div class="card m-b-20">
                        <div class="card-body">
						<h6 id="msg" style="text-align: center;color:#f4ad42;font-weight: bold;">${msg}</h6>
                            <h4 class="mt-0 header-title">User UnSubscription Details</h4>
                            

                            <form class="" action="unSubscribeNumber" method="post">
                                <div class="form-group">
                                    <label>Mobile Number</label>
                                    <input type="text" class="form-control" id="mobile" name="mobile" style="" required placeholder=""/>

                                </div>
                                
                                <div class="form-group">
                                    <div>
                                        <button type="submit" class="btn btn-primary waves-effect waves-light">
                                            Submit
                                        </button>
                                        
                                    </div>
                                </div>
                                
                            </form>
                            
                            
                            
              <div id ="unsubNumber">
					<c:if test="${not empty unsubDetails}">
                      <table id="example" class="display nowrap" style="width:100%">
		                <thead>
		                  <tr>
		                  	<th>SUBS DATE</th>
		                    <th>RENEW DATE</th>
		                    <th>BILLING DATE</th>
		                    <th>UNSUB DATE</th>
		                    <th>PACK_NAME</th>
		                    <th>AMOUNT (IN RP)</th>
		                    <th>ACT SOURCE</th>
		                    <th>UNSUB SOURCE</th>
		 	               </tr>
		                </thead>
		                <tbody>
                	
                		<c:forEach var="open" items="${SubscriptionList}">
		                <tr style="text-align: center;">
		                	<td>${open['SUB_DATE']}</td>
		                    <td>${open['RENEW_DATE']}</td>
		                    <td>${open['BILLING_DATE']}</td>
		                    <td>${open['UNSUB_DATE']}</td>
		                    <td>${open['PACK_TYPE']}</td>
							<td>${open['AMOUNT']}</td>
		                    <td>${open['ACT_SOURCE']}</td>
		                    <td>${open['UNSUB_SOURCE']}</td>
		                 </tr>
		                  
		                  </c:forEach>
                </tbody>
              </table>
              </c:if>
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




<c:if test="${not empty unsubDetails}">
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

    </body>

</html>
