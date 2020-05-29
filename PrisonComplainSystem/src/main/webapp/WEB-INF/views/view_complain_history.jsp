<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Complain System</title>
<meta name="viewport" content="width=device-width,initial-scale=1">



<!-- DataTables css -->
<link href="assets/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datepicker.min.css">

<!-- basic css -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">

</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- Template start here-->
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">home</a></li>
              <li class="breadcrumb-item active">View Complain History</li>
            </ol>
          </div>
          <h4 class="page-title">Complain History</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-body">
            
             <div>
            <button type="button" onclick="goBack()" style="float:left;margin-bottom:0px;" class="btn btn-dribbble">Go Back</button>
            </div>
            
              <table id="example" class="display nowrap" style="width:100%">
                <thead>
                  <tr>
                  <c:if test="${not empty id1}">
                 	 <th>(#) Id</th>
                 	 </c:if>
                 	 <c:if test="${not empty openData1.prison_id}">
                    <th>Prison ID</th>
                    </c:if>
                    <c:if test="${not empty openData1.prison_name}">
                    <th>Name of Prison</th>
                    </c:if>
                    <c:if test="${not empty openData1.catagory}">
                    <th>Category</th>
                    </c:if>
                    <c:if test="${not empty openData1.complain_desc}">
                    <th>Complain Description</th>
                    </c:if>
                    <c:if test="${not empty openData1.complain_logg_by}">
                    <th>Complain logged by</th>
                    </c:if>
                    <c:if test="${not empty openData1.designation}">
                    <th>Designation</th>
                    </c:if>
                    <c:if test="${not empty openData1.phone}">
                    <th>Contact Number</th>
                    </c:if>
                    <c:if test="${not empty openData1.mail}">
                    <th>Email</th>
                    </c:if>
                    <c:if test="${not empty openData1.hw_name}">
                    <th>Hardware</th>
                    </c:if>
                    <c:if test="${not empty openData1.issue_arr_date}">
                    <th>Date of Issue</th>
                    </c:if>
                    <c:if test="${not empty openData1.damage_item}">
                    <th>Damaged Item</th>
                    </c:if>
                    <c:if test="${not empty openData1.serial_no}">
                    <th>Serial No</th>
                    </c:if>
                    <c:if test="${not empty openData1.damage_desc}">
                    <th>Damage Description</th>
                    </c:if>
                    <c:if test="${not empty openData1.type_of_connectivity}">
                    <th>Type of Connectivity</th>
                    </c:if>
                    <c:if test="${not empty openData1.assign_to}">
                    <th>Assign to</th>
                    </c:if>
                    <c:if test="${not empty openData1.action_taken}">
                    <th>Action Taken</th>
                    </c:if>
                    <c:if test="${not empty openData1.observation_detail}">
                    <th>Observation Detail</th>
                    </c:if>
                    <c:if test="${not empty openData1.repair_replace}">
                    <th>Repair/Replace</th>
                    </c:if>
                    <c:if test="${not empty openData1.status}">
                    <th>status</th>
                    </c:if>
                    <c:if test="${not empty openData1.date_of_visit}">
                    <th>Date of Visit</th>
                    </c:if>
                    <c:if test="${not empty openData1.complain_close_date}">
                    <th>Complain Close Date</th>
                    </c:if>
                    <%-- <c:if test="${not empty openData1.created_at}">
                    <th>Created at</th>
                    </c:if>
                    <c:if test="${not empty openData1.created_by}">
                    <th>Created by</th>
                    </c:if> --%>
                    <c:if test="${not empty openData1.updated_at}">
                    <th>Updated at</th>
                    </c:if>
                    <c:if test="${not empty openData1.updated_by}">
                    <th>Updated by</th>
                    </c:if>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach var="openData" items="${list}">
                <tr style="text-align: center;">
 					
                    <c:if test="${not empty id}">               
                	<td>${id}</td>
                    </c:if>
                    <c:if test="${not empty openData.prison_id}">
                    <td>${openData.prison_id}</td>
                    </c:if>
                    <c:if test="${not empty openData.prison_name}">
                    <td>${openData.prison_name}</td>
                    </c:if>
                    <c:if test="${not empty openData.catagory}">
                    <td>${openData.catagory}</td>
                    </c:if>
                    <c:if test="${not empty openData.complain_desc}">
                    <td>${openData.complain_desc}</td>
                    </c:if>
                    <c:if test="${not empty openData.complain_logg_by}">
                    <td>${openData.complain_logg_by}</td>
                    </c:if>
                    <c:if test="${not empty openData.designation}">
                    <td>${openData.designation}</td>
                    </c:if>
                    <c:if test="${not empty openData.phone}">
                    <td>${openData.phone}</td>
                    </c:if>
                    <c:if test="${not empty openData.mail}">
                    <td>${openData.mail}</td>
					</c:if>
                    <c:if test="${not empty openData.hw_name}">
                    <td>${openData.hw_name}</td>
					</c:if>
                    <c:if test="${not empty openData.issue_arr_date}">
                    <td>${openData.issue_arr_date}</td>
					</c:if>
                    <c:if test="${not empty openData.damage_item}">
                    <td>${openData.damage_item}</td>
					</c:if>
                    <c:if test="${not empty openData.serial_no}">
                    <td>${openData.serial_no}</td>
					</c:if>
                    <c:if test="${not empty openData.damage_desc}">
                    <td>${openData.damage_desc}</td>      
                    </c:if>
                    <c:if test="${not empty openData.type_of_connectivity}">
                    <td>${openData.type_of_connectivity}</td>
                    </c:if>
                    <c:if test="${not empty openData.assign_to}">
                    <td>${openData.assign_to}</td>
                    </c:if>
                    <c:if test="${not empty openData.action_taken}">
                    <td>${openData.action_taken}</td>
                    </c:if>
                    <c:if test="${not empty openData.observation_detail}">
                    <td>${openData.observation_detail}</td>
                    </c:if>
                    <c:if test="${not empty openData.repair_replace}">
                    <td>${openData.repair_replace}</td>
                    </c:if>
                    <c:if test="${not empty openData.status}">
                    <td>${openData.status}</td>
                    </c:if>
                    <c:if test="${not empty openData.date_of_visit}">
                    <td>${openData.date_of_visit}</td>
                    </c:if>
                    <c:if test="${not empty openData.complain_close_date}">
                    <td>${openData.complain_close_date}</td>
                    </c:if>
                    <%-- <c:if test="${not empty openData.created_at}">
                    <td>${openData.created_at}</td>
                    </c:if>
                    <c:if test="${not empty openData.created_by}">
                    <td>${openData.created_by}</td>
                    </c:if> --%>
                    <c:if test="${not empty openData.updated_at}">
                    <td>${openData.updated_at}</td>
                    </c:if>
                    <c:if test="${not empty openData.updated_by}">
                    <td>${openData.updated_by}</td>
                    </c:if>
                  </tr>
                  </c:forEach>
                  
                </tbody>
              </table>
              

              <c:if test="${empty openData1}">
              <p style="text-align: center;color:grey;font-size: 16px;">No Data Available</p>
              </c:if>
              
            </div>
          </div>
        </div>
      </div>
     </div>
      
  
    
   </div>
    

<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->


<input type="hidden" id="snackbar" value="${msg}">

<script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>

<!-- <script src="assets/js/jquery.min.js"></script> -->
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/waves.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>


<script type="text/javascript" src="assets/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="assets/js/form-advanced.js"></script>




<!-- Buttons examples --><!-- Responsive examples -->
<script type="text/javascript" src="assets/js/bootbox.js"></script>


<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
    	"scrollX": true,
    	scrollY:        '40vh',
        scrollCollapse: true,
        paging:         false
    } );
} );
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

<script type="text/javascript">
function form_reset()
{
	document.getElementById("editform").reset();
	}
</script>


<script type="text/javascript">
function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}

function goBack()
{
	event.preventDefault();
	window.location.href=getContextPath()+"/view_single_complain?category=${cat}&id=${id}";
	
}
</script>



</body>

</html>