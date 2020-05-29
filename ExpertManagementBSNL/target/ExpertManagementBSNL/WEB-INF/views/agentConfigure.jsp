<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Partner Configuration</title>


<link href="${pageContext.request.contextPath}/resources/css/bootstrap-new.min.css"
        rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/navmenu.css">

 <link href="${pageContext.request.contextPath}/resources/css/bootstrap-multiselect.css"
        rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/data_table/jquery.dataTables.min.css"
	 type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/jquery-confirm.css" rel="stylesheet"
	 type="text/css" />


<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-multiselect.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-confirm.js" type="text/javascript"></script>



    
        
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/dataTables.buttons.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/jszip.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/pdfmake.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/vfs_fonts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/data_tables/buttons.html5.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>

<style>
    .form-horizontal .form-group {
    margin-right: 0px;
    margin-left: -15px;
}

.dataTables_length{
padding: 0px 25px 0px 0px;
margin-bottom:14px;
}
</style>
</head>

<body>

	<c:choose>
	 <c:when test="${loginObj.role eq 'admin'}">
			<jsp:include page="admin_header.jsp"/>
		</c:when>
		<c:otherwise>
		<jsp:include page="user_header.jsp"/>
		</c:otherwise>
		</c:choose>
<div class="wrapper">
<div class="config" align="center">Configure New Agent</div>

<div>
<form name="configureExpert" id="addNewAgent" action="configureNewAgent" method="post">
<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">ANI:</div>
<div class="fright">
<input type="text" class="inpt" id="ani" name="ani" autofocus="" autocomplete="off" placeholder="Enter ANI" required="">


</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Partner Name:
</div>
<div class="fright"><select class="inpt"  id="partner_name" autocomplete="off" name="partner_name" required="">
      <option value="" disabled selected>Select Partner Name</option>
      <c:forEach var="pname" items="${pname}">
      <option value="${pname}">${pname}</option>
      </c:forEach>
      </select>
      </div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Expert Adviser Name:</div>
<div class="fright"><input type="text" class="inpt" id="expert_name" name="expert_name" autocomplete="off" placeholder="Enter Expert Name" required=""></div>
</div>
</div>

</div>


<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Zone:
</div>
<div class="fright"><select class="inpt" id="hub" name="hub" autocomplete="off" required="">
		<option value="" disabled selected>Select zone</option>
    	<option value="east">East</option>
    	<option value="west">West</option>
    	<option value="north">North</option>
    	<option value="south">South</option>
    	</select>
    	</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Circle:
</div>
<div class="fright"><select class="inpt" id="circle" name="circle" required="">
     	<option value="" disabled selected>Select Circle</option>
     	<option value="dl">DL</option>
    	<option value="hr">Haryana</option>
		<option value="jk">J&K</option>
		<option value="pb">Punjab</option>
		<option value="upe">UPE</option>
		<option value="upw">UPW</option>
		<option value="raj">Rajasthan</option>
		<option value="hp">HP</option>
		<option value="ap">AP</option>
		<option value="kk">Karnataka</option>
		<option value="ker">Kerala</option>
		<option value="tn">TN</option>
		<option value="chn">Chennai</option>
		<option value="mp">MP</option>
		<option value="guj">Gujarat</option>
		<option value="mh">Maharashtra</option>
		<option value="cg">CG</option>
		<option value="bhr">Bihar</option>
		<option value="as">Assam</option>
		<option value="kol">Kolkata</option>
		<option value="ors">Orissa</option>
		<option value="ne">NE</option>
		<option value="wb">WB</option>
    	
    	</select></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Location:</div>
<div class="fright"><input type="text" class="inpt" id="location" name="location" placeholder="Enter location" autocomplete="off" required=""></div>
</div>
</div>

</div>


<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Agent Type:

</div>
<div class="fright"><select class="inpt" id="agent_type" name="agent_type" required="">
     	<option value="" disabled selected>Agent Type</option>
    	<option value="financial">Financial Advice</option>
    	<option value="immigration">Immigration</option>
    	<option value="relation">Relationship & Stress Management</option>
    	<option value="career">Career & Education</option>
    	<option value="health">Health Care</option>
    	</select>
    	</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Age:

</div>
<div class="fright"><input type="text" class="inpt" id="age" name="age" placeholder="Enter age" autocomplete="off" required=""></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Gender:
</div>
<div class="fright"><select class="inpt" id="gender" name="gender" placeholder="Gender" required="">
    <option value="" disabled selected>Select Gender</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    </select>
    </div>
</div>
</div>

</div>


<div class="row r1">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Language:


</div>
<div class="fright">
<div class="row">
      <div class="col-md-11 ">

        <select id="language" class="inpt" name="language" multiple style="width: 190%;">
  	<option value="assamese">Assamese</option>
  	<option value="bengali">bengali</option>
  	<option value="english">English</option>
  	<option value="gujrati">Gujarati</option>
  	<option value="hindi">Hindi</option>
  	<option value="kannada">Kannada</option>
  	<option value="malayalam">Malayalam</option>
  	<option value="manipuri">Manipuri</option>
  	<option value="marathi">Marathi</option>
  	<option value="odia">Odia</option>
  	<option value="punjabi">Punjabi</option>
  	<option value="tamil">Tamil</option>
  	<option value="telugu">Telugu</option>
  	<option value="urdu">Urdu</option>
	</select>
       <!-- <button class="btn-save btn btn-primary btn-sm dspn" >Save</button>-->

      </div>
    </div>




</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Max Calls:


</div>
<div class="fright"><select class="inpt" id="max_calls" name="max_calls" placeholder="Max Calls" required="">
     <option value="" disabled selected>Max Calls</option>
    <option value="60">60</option>
    <option value="90">90</option>
    <option value="120">120</option>
    <option value="150">150</option>
    <option value="180">180</option>
    </select>
    </select></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Adhaar Card:
</div>
<div class="fright"><input type="text" class="inpt" id="adhaar_card" name="adhaar_card" placeholder="Enter adharCard" autocomplete="off"></div>
</div>
</div>

</div>


<div class="row" align="center">

<div style="margin:0px 
auto;"><button type="submit" class="btn btn-cnf">Configure New Agent</button></div>

</div>




</form>





<form name="configureExpert" id="editNewAgent" action="editAgent" method="post">
<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">ANI:</div>
<div class="fright">
<input type="text" class="inpt" id="edit-ani" name="ani" autofocus="" autocomplete="off" placeholder="Enter ANI" required="">


</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Partner Name:
</div>
<div class="fright"><select class="inpt"  id="edit-partner_name" autocomplete="off" name="partner_name" required="">
      <option value="" disabled selected>Select Partner Name</option>
      <c:forEach var="pname" items="${pname}">
      <option value="${pname}">${pname}</option>
      </c:forEach>
      </select>
      </div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Expert Adviser Name:</div>
<div class="fright"><input type="text" class="inpt" id="edit-expert_name" name="expert_name" autocomplete="off" placeholder="Enter Expert Name" required=""></div>
</div>
</div>

</div>


<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Zone:
</div>
<div class="fright"><select class="inpt" id="edit-hub" name="hub" autocomplete="off" required="">
		<option value="" disabled selected>Select zone</option>
    	<option value="east">East</option>
    	<option value="west">West</option>
    	<option value="north">North</option>
    	<option value="south">South</option>
    	</select>
    	</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Circle:
</div>
<div class="fright"><select class="inpt" id="edit-circle" name="circle" required="">
     	<option value="" disabled selected>Select Circle</option>
     	<option value="dl">DL</option>
    	<option value="hr">Haryana</option>
		<option value="jk">J&K</option>
		<option value="pb">Punjab</option>
		<option value="upe">UPE</option>
		<option value="upw">UPW</option>
		<option value="raj">Rajasthan</option>
		<option value="hp">HP</option>
		<option value="ap">AP</option>
		<option value="kk">Karnataka</option>
		<option value="ker">Kerala</option>
		<option value="tn">TN</option>
		<option value="chn">Chennai</option>
		<option value="mp">MP</option>
		<option value="guj">Gujarat</option>
		<option value="mh">Maharashtra</option>
		<option value="cg">CG</option>
		<option value="bhr">Bihar</option>
		<option value="as">Assam</option>
		<option value="kol">Kolkata</option>
		<option value="ors">Orissa</option>
		<option value="ne">NE</option>
		<option value="wb">WB</option>
    	
    	</select></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Location:</div>
<div class="fright"><input type="text" class="inpt" id="edit-location" name="location" placeholder="Enter location" autocomplete="off" required=""></div>
</div>
</div>

</div>


<div class="row">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Agent Type:

</div>
<div class="fright"><select class="inpt" id="edit-agent_type" name="agent_type" required="">
     	<option value="" disabled selected>Agent Type</option>
    	<option value="financial">Financial Advice</option>
    	<option value="immigration">Immigration</option>
    	<option value="relation">Relationship & Stress Management</option>
    	<option value="career">Career & Education</option>
    	<option value="health">health care</option>
    	</select>
    	</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Age:

</div>
<div class="fright"><input type="text" class="inpt" id="edit-age" name="age" placeholder="Enter age" autocomplete="off" required=""></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Gender:
</div>
<div class="fright"><select class="inpt" id="edit-gender" name="gender" placeholder="Gender" required="">
    <option value="" disabled selected>Select Gender</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    </select>
    </div>
</div>
</div>

</div>


<div class="row r1">
<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Language:


</div>
<div class="fright">
<div class="row">
      <div class="col-md-11 ">

        <select id="edit-language" class="inpt-a" name="language" multiple>
  	<option value="assamese">Assamese</option>
  	<option value="bengali">bengali</option>
  	<option value="english">English</option>
  	<option value="gujrati">Gujarati</option>
  	<option value="hindi">Hindi</option>
  	<option value="kannada">Kannada</option>
  	<option value="malayalam">Malayalam</option>
  	<option value="manipuri">Manipuri</option>
  	<option value="marathi">Marathi</option>
  	<option value="odia">Odia</option>
  	<option value="punjabi">Punjabi</option>
  	<option value="tamil">Tamil</option>
  	<option value="telugu">Telugu</option>
  	<option value="urdu">Urdu</option>
	</select>
       <!-- <button class="btn-save btn btn-primary btn-sm dspn" >Save</button>-->

      </div>
    </div>




</div>
</div>
</div>

<div class="col-lg-4 col-md-4 col-sm-12">
<div class="row rsp">
<div class="fleft">Max Calls:


</div>
<div class="fright"><select class="inpt" id="edit-max_calls" name="max_calls" placeholder="Max Calls" required="">
     <option value="" disabled selected>Max Calls</option>
    <option value="60">60</option>
    <option value="90">90</option>
    <option value="120">120</option>
    <option value="150">150</option>
    <option value="180">180</option>
    </select>
    </select></div>
</div>
</div>

<div class="col-lg-4 col-md-12 col-sm-12">
<div class="row">
<div class="fleft">Adhaar Card:
</div>
<div class="fright"><input type="text" class="inpt" id="edit-adhaar_card" name="adhaar_card" placeholder="Enter adharCard" autocomplete="off"></div>
</div>
</div>

</div>


<div class="row" align="center">

<div style="margin:0px auto;"><button type="submit" class="btn btn-cnf">Update Agent Details</button></div>

</div>

</form>



</div>


<table id="agentlist" class="display nowrap" style="width:100%;text-align: center;">
				<thead style="color:#fff;background-color:#212529;border-color:#32383e">
					<tr>
						<th>ANI</th>
						<th>Chat_Id</th>
						<th>Partner Name</th>
						<th>Expert Adviser Name</th>
						<th>Zone</th>
						<th>Circle</th>
						<th>Location</th>
						<th>Agent Type</th>
						<th>Age</th>
						<th>Gender</th>
						<th>Max Calls</th>
						<th>Adhar Card</th>
						<th>Configuration date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="data" items="${records}">
					<tr>
						<td>${data.ani}</td>
						<td>${data.chatId}</td>
						<td>${data.partner_name}</td>
						<td>${data.expert_name}</td>
						<td>${data.hub}</td>
						<td>${data.circle}</td>
						<td>${data.location}</td>
						<td>${data.agent_type}</td>
						<td>${data.age}</td>
						<td>${data.gender}</td>
						<td>${data.max_calls}</td>
						<td>${data.adhaar_card}</td>
						<td>${data.configure_date}</td>
						<td><a id="editAgent" class="btn-detail" href="#" onclick="editValues('${data.ani}','${data.partner_name}','${data.expert_name}'
						,'${data.hub}','${data.circle}','${data.location}','${data.agent_type}','${data.age}','${data.gender}'
							,'${data.max_calls}','${data.adhaar_card}','${data.language}')">Edit</a> 
						 / <a class="btn-detail" href="#" style="color: green;" onclick="deleteUser('${data.ani}')">Delete</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>

<input type="hidden" id="snackbar" value="${insert_succ}">

<script type="text/javascript">

$(document).ready(function(){
	var x= document.getElementById("snackbar").value;
	
		bootbox.alert({
		message: x,
		size: 'small'
		});
});
</script>

<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>


	<script>
	$(document).ready( function () {
		
		 $('#addNewAgent').show();
		 $('#editNewAgent').hide();
		
		
	    $('#agentlist').DataTable({
	    	"scrollX": true,
	    	dom: 'lBfrtip',
	        buttons: [
	            
	            'excelHtml5',
	            
	            'pdfHtml5'
	        ] 
	    });
	    
		var frmvalidator = new Validator("addNewAgent");
		frmvalidator.addValidation("ani","numeric","ANI should be digit");
		frmvalidator.addValidation("ani","maxlen=10",
		"Max length for ANI is 10");
		frmvalidator.addValidation("ani","minlen=10",
		"Min length for ANI is 10");
		
		frmvalidator.addValidation("expert_name","maxlen=20",
		"Max length for Expert Name is 20");
		frmvalidator.addValidation("expert_name","alpha_s",
		"Expert Name Cant't contain numbers");
		
		frmvalidator.addValidation("age","numeric","Age should be digit");
		frmvalidator.addValidation("age","maxlen=2",
		"Max length for Age is 2");
		frmvalidator.addValidation("age","minlen=2",
		"Min length for Age is 2");
		
		frmvalidator.addValidation("adhaar_card","numeric","adhaar Card should contains digit");
		frmvalidator.addValidation("adhaar_card","maxlen=16",
		"Max length for Adhaar Card is 16");
		
		var frmvalidator = new Validator("editNewAgent");
		frmvalidator.addValidation("edit-ani","numeric","ANI should be digit");
		frmvalidator.addValidation("edit-ani","maxlen=10",
		"Max length for ANI is 10");
		frmvalidator.addValidation("edit-ani","minlen=10",
		"Min length for ANI is 10");
		
		frmvalidator.addValidation("edit-expert_name","maxlen=20",
		"Max length for Expert Name is 20");
		frmvalidator.addValidation("edit-expert_name","alpha_s",
		"Expert Name Cant't contain numbers");
		
		frmvalidator.addValidation("edit-age","numeric","Age should be digit");
		frmvalidator.addValidation("age","maxlen=2",
		"Max length for Age is 2");
		frmvalidator.addValidation("edit-age","minlen=2",
		"Min length for Age is 2");
		
		frmvalidator.addValidation("edit-adhaar_card","numeric","adhaar Card should contains digit");
		frmvalidator.addValidation("edit-adhaar_card","maxlen=16",
		"Max length for Adhaar Card is 16");
		
		
	} );
	
	function set(a)
	{
		document.getElementById("p_ani").value=a;
	}
	
	function editValues(a,b,c,d,e,f,g,h,i,j,k,l)
	{
		 $('#addNewAgent').hide();
		 $('#editNewAgent').show();
		 //$('#edit-language').multiselect('deselectAll', true);
		//$('#edit-language').children('option:not(:first)').remove();
		document.getElementById("edit-ani").value=a;
		document.getElementById("edit-partner_name").value=b;
		document.getElementById("edit-expert_name").value=c;
		document.getElementById("edit-hub").value=d;
		document.getElementById("edit-circle").value=e;
		document.getElementById("edit-location").value=f;
		document.getElementById("edit-agent_type").value=g;
		document.getElementById("edit-age").value=h;
		document.getElementById("edit-gender").value=i;
		document.getElementById("edit-max_calls").value=j;
		document.getElementById("edit-adhaar_card").value=k;
		
		var lang= l;
		
		$("select.inpt-a").multiselect("deselectAll", false);
		
		$.each(lang.split(","), function(i,e){
		    $("#edit-language option[value='" + e + "']").prop("selected", true);
		    $("#edit-language").multiselect("refresh");
		});
		
		
	}
	
	</script>

    <script type="text/javascript">
        $(function () {
            $('#language').multiselect({
                includeSelectAllOption: false
            });
            
        });
    </script>

<script>
function deleteUser(a)
{
	
$.confirm({
    title: 'Confirm!',
    content: 'Are you Sure?',
    buttons: {
        confirm: function () {
			event.preventDefault();
window.location.href=getContextPath()+"/deleteAgent?p_ani=" + a;
        },
        cancel: function () {
            
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
