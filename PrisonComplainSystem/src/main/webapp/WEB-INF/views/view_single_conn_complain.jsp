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
              <li class="breadcrumb-item active">Connectivity Complain</li>
            </ol>
          </div>
          <h4 class="page-title">Connectivity Complain</h4>
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
                 	 <th>(#) Id</th>
                    <th>Prison ID</th>
                    <th>Name of Prison</th>
                    <th>Category</th>
                    <th>Complain Description</th>
                    <th>Complain logged by</th>
                    <th>Designation</th>
                    <th>Contact Number</th>
                    <th>Email</th>
                    <th>Type of Connectivity</th>
                    <th>Assign to</th>
                    <th>Action Taken</th>
                    <th>Observation Detail</th>
                    <th>Repair/Replace</th>
                    <th>status</th>
                    <th>Date of Visit</th>
                    <th>Created at</th>
                    <th>Created by</th>
                    <th>Updated at</th>
                    <th>Updated by</th>
                    <c:if test="${userObj.user_role eq 'spice_admin'}">
                    <th>Action</th>
                    </c:if>
                  </tr>
                </thead>
                <tbody>
                
                
                <tr style="text-align: center;">
                	<td><a href="view_complain_history?id=${openData.id}">${openData.id}</a></td>
                    <td>${openData.prison_id}</td>
                    <td>${openData.prison_name}</td>
                    <td>${openData.catagory}</td>
                    <td>${openData.complain_desc}</td>
                    <td>${openData.complain_logg_by}</td>
                    <td>${openData.designation}</td>
                    <td>${openData.phone}</td>
                    <td>${openData.mail}</td>
                    <td>${openData.type_of_connectivity}</td>
                    <td>${openData.assign_to}</td>
                    <td>${openData.action_taken}</td>
                    <td>${openData.observation_detail}</td>
                    <td>${openData.repair_replace}</td>
                    <td>${openData.status}</td>
                    <td>${openData.date_of_visit}</td>
                    <td>${openData.created_at}</td>
                    <td>${openData.created_by}</td>
                    <td>${openData.updated_at}</td>
                    <td>${openData.updated_by}</td>
                    <c:if test="${userObj.user_role eq 'spice_admin'}">
                    <td><button type="button" class="btn btn-dribbble" data-toggle="modal" data-target="#myModal">
  Update
</button>
</td></c:if>
<%-- <input type="text" name="sno1" id="sno1" value="${open.id}"> --%>
                  </tr>
                  
                  
                </tbody>
              </table>
              
              
              <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Update complains</h4>
        <button type="button" class="close" onclick="form_reset()" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="editSingleConnComplain" method="post" id="editform">
            <div class="row">
             <input type="hidden" name="sno" id="sno" value="${sno}">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>Assigned to<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="assign_to" name="assign_to" required="required" autocomplete="off" autofocus="autofocus">
                      <span class="font-13 text-muted"></span></div>
                    <div class="form-group">
                      <label>Observation details<span class="sta-red">*</span> </label>
                     <textarea cols="" rows="" class="form-control" id="observation_detail" name="observation_detail" required="required" autocomplete="off"></textarea>
                     
                      
                      </div>
                    
                    <div class="form-group">
                      <label>Repair/Replace<span class="sta-red">*</span></label>
                     <select class="form-control" id="repair_replace" name="repair_replace" required="required">
                      <option selected="selected " disabled="disabled">Select</option>
                      <option value="repair">Repair</option>
                      <option value="replace">Replace</option>
                    </select>
                      </div>
                      
                
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                      
                    <div class="form-group">
                      <label>Status<span class="sta-red">*</span></label>
                      <select class="form-control"  id="status" name="status" required="required">
                      <option selected="selected " disabled="disabled">Select</option>
                      <option value="open">Open</option>
                       <option value="close">Close</option>
                        </select>
                      </div>
                    
                    <div class="form-group">
                      <label>Date of visit<span class="sta-red">*</span></label>
                      <div>
                      <div>
                  <div class="input-group">
                  <input type="text" class="form-control" name="date_of_visit" placeholder="mm/dd/yyyy" id="datepicker-autoclose" required="required" autocomplete="off">
                    <div class="input-group-append bg-custom b-0"><span class="input-group-text"><i class="mdi mdi-calendar"></i></span></div>
                  </div>
                  <!-- input-group --></div>
                  
                  <!-- input-group --></div>
                                            
                      </div>
                    <div class="form-group mb-0">
                      <label>Action Taken<span class="sta-red">*</span></label>
                      <input type="text" placeholder="" data-mask="99-99-9999" class="form-control" id="action_taken" name="action_taken" required="required" autocomplete="off">
                      </div>
                      
                     <div class="form-group mb-0" style="padding-top:15px;">
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
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
	window.location.href=getContextPath()+"/viewconnectioncomplain";
	
}
</script>



</body>

</html>