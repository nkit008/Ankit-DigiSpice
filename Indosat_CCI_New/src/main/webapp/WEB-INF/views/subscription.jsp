<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>Indosat</title>
                     
              <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
              <link href="resources/css/icons.css" rel="stylesheet" type="text/css">
              <link href="resources/css/style.css" rel="stylesheet" type="text/css">
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
                            <h4 class="mt-0 header-title">User Activate Subscription </h4>
                            

                            <form class="" action="subscribeNumber" method="post" onsubmit="return validation()">
                                <div class="form-group"	>
                                    <label>Mobile Number</label>
                                    <input type="text" class="form-control" id="mobile" name="mobile" style="" required placeholder=""/>                              </div>

                                
								<div class="form-group"	>
                                    <label>Service Name</label>
                                    
                                    <select class="form-control" id="serviceName" name="service_name" onchange="getPackType()">
                                    	<option value="-1">Select Service Name</option>
                                  		<option>Indomusik</option>	                        
                                  		<option>IBADAH</option>                       
                                  	</select>
                                    
                                    
                                    
                                </div>
                                
                <div class="form-group"	>
                                    <label>Pack Type</label>
                                     <select class="form-control" id="packType" name="packType">
                                     <option value='-1'>Select Pack Type</option>
                                                    
                                </select>
                       </div>
                                <div class="form-group">
                                    <div>
                                        <button type="submit" class="btn btn-primary waves-effect waves-light">
                                            Submit
                                        </button>
                                        
                                    </div>
                                </div>
                            </form>

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

     <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
     <script src="resources/js/app.js"></script>

<script type="text/javascript">

function getPackType()
{
		var id = $("#serviceName").val();
		$.ajax({
			url:"showPackType",
			dataType: 'json',
			data: 'serivce_name='+ id, 
			method:"POST",
			success: function(ni)
			{
				var option="<option value='-1'>Select Pack Type</option>";
				$.each(ni, function(key, val){
					option+="<option value='"+key+"'>"+val+"</option>"
				});
				$('#packType').empty();
				$('#packType').append(option);
			},
			
			error : function() { 
				alert("No Pack Type found for this Service");
				
			}
		});
}
</script>

<script type="text/javascript">
function validation()
{
	alert("b");
	var servicename=document.getElementById("serviceName").value;
	var packtype=document.getElementById("packType").value;
	
	if(servicename === "-1")
	{
		alert("Please select Service Name");
		return false;
	}
	
	if(packtype === "-1")
	{
		alert("Please select Pack Type");
		return false;
	}
}
</script>
     
</body>

</html>
