<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Complain System</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-datepicker.min.css">



</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- Template start here-->
<form action="addNewPhysicalDamage" method="post" onsubmit="return validate()">
<div class="wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">New Complain</a></li>
              <li class="breadcrumb-item active">Report physical damage</li>
            </ol>
          </div>
          <h4 class="page-title">Report physical damage</h4>
        </div>
      </div>
    </div>
   
     
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>Prison ID <span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="prison_id" name="prison_id" required="required" autocomplete="off" autofocus="autofocus">
                      </div>                
                    <div class="form-group">
                      <label>Name of prison<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="prison_name" name="prison_name" required="required" autocomplete="off">
                      <span class="font-13 text-muted"></span></div>

                    <div class="form-group">
                      <label>Complain logged by<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="comp_loggby" name="comp_loggby" required="required" autocomplete="off">
                      </div>
                    <div class="form-group">
                      <label>Designation<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="designation" name="designation" required="required" autocomplete="off">
                      </div>
                    <div class="form-group mb-0">
                      <label>Contact number<span class="sta-red">*</span>&#x00A0;&#x00A0;&#x00A0;&#x00A0;<span class="text-danger" style="font-weight:bold" id="phone1"></span></label>
                      <input type="text" class="form-control" id="phone" name="phone" required="required" autocomplete="off">
                      </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                    <div class="form-group">
                      <label>E-mail ID<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="mail" name="mail" required="required" autocomplete="off">
                      </div>
                      
                      
                      
                    <div class="form-group">
                      <label>Damage Item<span class="sta-red">*</span></label>
                      <select class="form-control" id="damage_item" name="damage_item" required="required" autocomplete="off">
                      <option value="Biometric">Biometric</option>
                      <option value="Calling Card">Calling Card</option>
                      <option value="Cables">Cables</option>
                      <option value="CPU">CPU</option>
                      <option value="Kiosk">KIOSK</option>
                      <option value="Kiosk Fan">KIOSK Fan</option>
                      <option value="Modem">Modem</option>
                      <option value="Monitor">Monitor</option>
                      <option value="Porta Cabin Fan">Porta Cabin Fan</option>
                      <option value="Porta Cabin">Porta Cabin</option>
                      <option value="Phone Handle">Phone Handle</option>
                      <option value="Router">Router</option>
                       <option value="Speaker">Speaker</option>
                       <option value="Touch Panel">Touch Panel</option>
                       <option value="UPS">UPS</option>
                    </select>
                      </div>
                    <div class="form-group">
                      <label>Serial number<span class="sta-red">*</span></label>
                      <input type="text" class="form-control" id="serial_no" name="serial_no" required="required" autocomplete="off">
                      </div>
                    
                    <div class="form-group mb-0">
                      <label>Damage description<span class="sta-red">*</span> </label>
                      <input type="text" class="form-control" id="damage_desc" name="damage_desc" required="required" autocomplete="off">
                      </div>
                      
                      
                      <div class="form-group mb-0" style="padding-top:45px;"><label>&nbsp; </label>
                     <button class="btn btn-light mb-0" type="submit">Submit </button>
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
</form>
<!-- Template end here -->
<input type="hidden" id="snackbar" value="${msg}">
<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->

<!-- jQuery  --><script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/app.js"></script>



<script type="text/javascript" src="assets/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="assets/js/form-advanced.js"></script>
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
function validate()
{
	
var x= document.getElementById("phone").value;

if(x.length>=10 && x.length<14)
	{
	return true;
	}
	
else
	{
	document.getElementById("phone1").innerHTML="**Number should have 10 digits";
	return false;
	}
	}
</script>

<script type="text/javascript">

	$(document).ready(function(){
		
		$("#prison_id").change(function (){
			
			var id = $("#prison_id").val();
			
			$.ajax({
				url:"getDetailsByPrisonId",
				dataType: 'json',
				data : 'prisonId=' + id, 
				method:"GET",
				success: function(ni)
				{
					$('#prison_name').val(ni.prison_name);
					$('#comp_loggby').val(ni.complain_logg_by);
					$('#designation').val(ni.designation);
					$('#phone').val(ni.phone);
					$('#mail').val(ni.mail);
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