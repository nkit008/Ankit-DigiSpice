<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Complain System</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>


<!-- Page Content-->
<div class="wrapper">
  <div class="container-fluid">
  <div>&nbsp;</div>
    <div class="row" >
      <div class="col-xl-3 col-md-6"  >
        <div class="card mini-stats btm-spc software-bg"  >
          <div class="p-3 mini-stats-content" >
            <div class="mb-4 box-txt">
              
              <span class="peity-pie" data-peity='{ "fill": ["rgba(255, 255, 255, 0.8)", "rgba(255, 255, 255, 0.2)"]}' data-width="54" data-height="54"><i class="mdi  mdi-monitor" style="padding-right:7px;"></i>Software complains</span></div>
          </div>
          <div class="ml-3 mr-3">
            <div class="bg-white p-3 mini-stats-desc rounded">
              <h5 class="float-right mt-0 txtinp">${swCount}</h5>
              <h6 class="mt-0 mb-3 txtinp-blck">Complains</h6>
              <p class="text-muted mb-0" style="text-align:center;"><a href="viewsoftwarecomplain">View Details</a></p>
            </div>
          </div>
        </div>
      </div>
      
      
      
   <div class="col-xl-3 col-md-6"  >
        <div class="card mini-stats btm-spc hardware-bg"   >
          <div class="p-3 mini-stats-content" >
            <div class="mb-4 box-txt">
              
              <span class="peity-pie" data-peity='{ "fill": ["rgba(255, 255, 255, 0.8)", "rgba(255, 255, 255, 0.2)"]}' data-width="54" data-height="54"><i class="mdi  mdi-floppy" style="padding-right:7px;"></i>Hardware complains</span></div>
          </div>
          <div class="ml-3 mr-3">
            <div class="bg-white p-3 mini-stats-desc rounded">
              <h5 class="float-right mt-0 txtinp">${hwCount}</h5>
              <h6 class="mt-0 mb-3 txtinp-blck">Complains</h6>
              <p class="text-muted mb-0" style="text-align:center;"><a href="viewhardwarecomplain">View Details</a></p>
            </div>
          </div>
        </div>
      </div>   
      
      
     <div class="col-xl-3 col-md-6"  >
        <div class="card mini-stats btm-spc physical-bg"  >
          <div class="p-3 mini-stats-content " >
            <div class="mb-4 box-txt">
              
              <span class="peity-pie" data-peity='{ "fill": ["rgba(255, 255, 255, 0.8)", "rgba(255, 255, 255, 0.2)"]}' data-width="54" data-height="54"><i class="mdi  mdi-alert" style="padding-right:7px;"></i>physical damage</span></div>
          </div>
          <div class="ml-3 mr-3">
            <div class="bg-white p-3 mini-stats-desc rounded">
              <h5 class="float-right mt-0 txtinp">${physicalCount}</h5>
              <h6 class="mt-0 mb-3 txtinp-blck">Complains</h6>
              <p class="text-muted mb-0" style="text-align:center;"><a href="viewphysicalcomplain">View Details</a></p>
            </div>
          </div>
        </div>
      </div> 
      
      
<div class="col-xl-3 col-md-6"  >
        <div class="card mini-stats btm-spc connectivity"  >
          <div class="p-3 mini-stats-content" >
            <div class="mb-4 box-txt">
              
              <span class="peity-pie" data-peity='{ "fill": ["rgba(255, 255, 255, 0.8)", "rgba(255, 255, 255, 0.2)"]}' data-width="54" data-height="54"><i class="mdi  mdi-wifi" style="padding-right:7px;"></i></span>Connectivity</div>
          </div>
          <div class="ml-3 mr-3">
            <div class="bg-white p-3 mini-stats-desc rounded">
              <h5 class="float-right mt-0 txtinp">${connCount}</h5>
              <h6 class="mt-0 mb-3 txtinp-blck">Complains</h6>
              <p class="text-muted mb-0" style="text-align:center;"><a href="viewconnectioncomplain">View Details</a></p>
            </div>
          </div>
        </div>
      </div>          
     
    </div>
  
    
    
    <!-- end row -->
    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h4 class="mt-0 header-title">Latest Complains</h4>
            <div class="table-responsive mt-4">
              <table class="table table-hover mb-0">
                <thead>
                  <tr>
                    <th scope="col">(#) Id</th>
                    <th scope="col">Category</th>
                    <th scope="col">Prison Name</th>
                    <th scope="col">Logged By</th>
                    <th scope="col">Status</th>
                    <th scope="col">Phone No</th>
                    <th scope="col">Email Id</th>
                    <th scope="col">Designation</th>
                    <th scope="col" colspan="2">Created Date</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="conn_data" items="${connectData}">
                  <tr>
                    <th scope="row" style="padding-top: 18px;"><a href="view_single_complain?category=${conn_data.catagory}&id=${conn_data.id}">${conn_data.id}</a></th>
                    <td>${conn_data.catagory}</td>
                    <td><div>${conn_data.prison_name}</div></td>
                    <td>${conn_data.complain_logg_by}</td>
                    <c:if test="${conn_data.status == 'open'}">
                    <td><span style="color: #fa272c;" class="">${conn_data.status}</span></td>
                    </c:if>
                    <c:if test="${conn_data.status == 'close'}">
                    <td><span class="">${conn_data.status}</span></td>
                    </c:if>
                    <td>${conn_data.phone}</td>
                    <td>${conn_data.mail}</td>
                    <td>${conn_data.designation}</td>
                    <td>${conn_data.created_at}</td>
                  </tr>
                  </c:forEach>
                  
                  
                  
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
           
            <form action="edithomeComplain" method="post" id="editform">
            <div class="row">
             <input type="hidden" name="sno" id="sno">
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
                  
                  
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    
  </div>
  <!-- end container-fluid --></div>
<!-- end page-wrapper -->


<jsp:include page="footer.jsp"></jsp:include>
<input type="hidden" id="snackbar" value="${msg}">

<c:forEach var="code" items="${loginlist}">
<input type="hidden" name="input_role" id="input_role" value="${code.user_role}">
</c:forEach>
<!-- jQuery  --><script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/bootbox.js"></script>

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
$(document).ready(function(){

	var x= document.getElementById("input_role").value;
	if(x != "spice_admin")
		{
		$("#updateRecords").hide();
		}
});
</script>
<script type="text/javascript">
function swap(val)
{
	document.getElementById('sno').value=val;

	}
</script>
</body>
</html>