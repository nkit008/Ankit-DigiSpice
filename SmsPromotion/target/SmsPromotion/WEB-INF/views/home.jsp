<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>SMS Promotion</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/icons.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resources/css/component.css">
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</head>

<body>



<jsp:include page="header.jsp"></jsp:include>
				




<!-- Page Content-->
<div class="wrapper" style="margin-top:-79px;">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="page-title-box">
          <!--<div class="float-right">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="javascript:void(0);">Complain System</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0);">New Complain</a></li>
              <li class="breadcrumb-item active">Hardware Complain</li>
            </ol>
          </div>-->
          <h4 class="page-title">Upload</h4>
        </div>
      </div>
    </div>
    <!-- end page title end breadcrumb -->
    
    
    <!--end row-->
    
    <!--End row-->
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
           
            <form action="addBase" method="post" enctype="multipart/form-data" onsubmit="return validation()">
            <div class="row">
              <div class="col-md-6">
                <div class="p-20">
                  
                    
                    <div class="form-group">
                      <label>Circle Name</label>
                      <div>
                      
                    <select class="form-control ed" style="" value="" name="circle" id="circle" required="required">
						<option value="" disabled selected>Select Circle</option>
						<c:if test="${userObj.role eq 'admin'}">
      					<option value="dl">DL</option>
      					<option value="pb">PB</option>
      					<option value="mp">MP</option>
      					<option value="ap">AP</option>
      					<option value="bh">BH</option>
      					<option value="gj">GJ</option>
      					<option value="hr">HR</option>
      					<option value="kk">KK</option>
      					<option value="mh">MH</option>
      					<option value="rj">RJ</option>
      					<option value="tn">TN</option>
      					<option value="ue">UE</option>
      					<option value="uw">UW</option>
      					<option value="as">AS</option>
      					<option value="hp">HP</option>
      					<option value="jk">JK</option>
      					<option value="kl">KL</option>
      					<option value="kr">KR</option>
      					<option value="mu">MU</option>
      					<option value="or">OR</option>
      					<option value="wb">WB</option>
      					<option value="ne">NE</option>
      					</c:if>
      					
      					<c:if test="${userObj.role eq 'ne'}">
      					<option value="ne">NE</option>
      					</c:if>
      					
      					<c:if test="${userObj.role eq 'mp'}">
      					<option value="mp">MP</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'ap'}">
      					<option value="ap">AP</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'bh'}">
      					<option value="bh">BH</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'dl'}">
      					<option value="dl">DL</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'gj'}">
      					<option value="gj">GJ</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'hr'}">
      					<option value="hr">HR</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'kk'}">
      					<option value="kk">KK</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'mh'}">
      					<option value="mh">MH</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'wb'}">
      					<option value="wb">WB</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'pb'}">
      					<option value="pb">PB</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'rj'}">
      					<option value="rj">RJ</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'tn'}">
      					<option value="tn">TN</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'ue'}">
      					<option value="ue">UE</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'uw'}">
      					<option value="ue">UW</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'as'}">
      					<option value="as">AS</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'hp'}">
      					<option value="hp">HP</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'jk'}">
      					<option value="jk">JK</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'kl'}">
      					<option value="kl">KL</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'kr'}">
      					<option value="kr">KR</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'mu'}">
      					<option value="mu">MU</option>
      					</c:if>
      					<c:if test="${userObj.role eq 'Or'}">
      					<option value="or">OR</option>
      					</c:if>
                    </select>
                     </div></div>
                     
                     <div class="form-group">
                     <label>CLI</label>
                     <div>
                     <input type="text" class="form-control ed" id="cli" name="cli">
                    </div>
                    </div>
                    <div class="form-group">
                    
                      <label>Base Upload <span style="font-weight:bold;color:red">(Please Upload Text File)</span></label><br>

                     <input type="file" name="base" id="base" class="inputfile inputfile-6" data-placeholder="Please Upload ZIP File" style="display:none;" data-multiple-caption="{count} files selected" multiple required="required"/>
					<label for="base"><span></span> <strong> Choose a file&hellip;</strong></label>
					<!-- <br/><a href="downloadArtworkSample">Click here for Sample File</a> -->
                      </div>
                    
                </div>
              </div>
              <div class="col-md-6">
                <div class="p-20">
                  
                    <div class="form-group">
                      <label>SMS Type</label>
                      <div>
                    <select class="form-control ed" style="" value="" name="smsType" id="smsType" required="required">
						<option value="" disabled selected>Select SMS Type</option>
      					<option value="text">Text</option>
      					<option value="unicode">Unicode</option>
                    </select>
                     </div></div>
                    
                    <div class="form-group">
                      <label>SMS Script</label>
                      <div>
                    <textarea name="smsScript" id="smsScript" style="width:75%;height:70px;" required="required"></textarea>
                     </div></div>
                     
                    
 					<div class="form-group mb-0" style="padding-top:15px;">
                     <button class="btn btn-light mb-0" style="background-color:#44a2d2; color:#fff; padding:5px 20px 5px 20px;" type="submit">Upload</button>
                      </div>
                  
                </div>
              </div>
          </div>
          </form>
          
          <h5 style="margin-top:12px;font-weight:bold;color:red">Instruction**</h5>
          <p><span style="margin-top:12px;font-weight:bold;color:red">*</span> In <b><mark>Base Upload</mark></b> the file extension should be .txt file and mobile number should 10 digit only(without 91)</p>
          <p style="margin-top:-14px;"><span style="font-weight:bold;color:red">*</span> SMS length should be 160 Characters</p>
      </div>
        </div>
      </div>
 </div>
   </div>
  
  
</div>
<!-- end page-wrapper -->

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- End Footer -->
<input type="hidden" id="snackbar" value="${msg}">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/custom-file-input.js"></script>

<!-- jQuery  -->
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/app.js"></script>
<!--datepicker -->
<script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/bootstrap-colorpicker.min.js"></script>
<script src="resources/js/jquery.form-advanced.init.js"></script>
<script type="text/javascript" src="resources/js/bootbox.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x, 
		callback: function(){}
		});
	
});
</script>


<!-- <script type="text/javascript">
	$(document).ready(function(){
		
		$("#circle").change(function (){
			
			var circle = $("#circle").val();
			
			$.ajax({
				url:"getCliByCircleName",
				dataType: 'json',
				data : 'cName=' + circle, 
				method:"GET",
				success: function(ni)
				{
					
					$('#cli').html("");
					$('#cli').append("<option value="+-1+">Select CLI's</option>");
					$.each(ni, function(key, val) {
					$('#cli').append("<option value="+ val +" >"+ val +"</option>"); 
		                }); 

				},
				
				error : function() { 
					alert("No previous record match for this prison id");
				}
			
			});
		});
		
	
	
	});
</script> -->
<script type="text/javascript">
function validation()
{
	
	var x=document.getElementById("cli").value;
	if(x.length > 10)
	{
		alert("Please enter Correct CLI");
		return false;
	}
	
	var type=document.getElementById("smsType").value;
	if(type == 'text')
	{
		var type=document.getElementById("smsScript").value;
		if(type.length > 160)
			{
			alert("SMS length should be less then 160");
			return false;			
			}
			
	}
	
		
}
</script>

</body>
</html>