<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>Promotion Status</title>
                     
              <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
              <link href="resources/css/icons.css" rel="stylesheet" type="text/css">
              <link href="resources/css/style.css" rel="stylesheet" type="text/css">
              <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-datepicker.min.css">
              
              
           
    
              

    </head>
    <body>
      <div id="wrapper">
      
      
<jsp:include page="header.jsp"></jsp:include>
        
        
        



<%
    ArrayList infoArrayList = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    DecimalFormat df = new DecimalFormat("###.###");
    try {
        if (session.getAttribute("promotionData") != null) {
            infoArrayList = (ArrayList) session.getAttribute("promotionData");
        } else {
            System.out.println("promotionData ResultSet is null");
        }
    } catch (Exception e) {
        response.sendRedirect("/index.jsp");
    }
%>        
        
        
<div class="wrapper">
        <div class="container-fluid">
              
            <div class="row" >
                <div class="col-lg-12">
                    <div class="card m-b-20">
                        <div class="card-body">

                            <h4 class="mt-0 header-title">User Subscription Status </h4>
                            

                            <form class="" action="promotionstatusAction" method="post">
					<div class="form-group">
                      <label>From Date<span class="sta-red">*</span></label>
                      
                      <div>
                      <div>
                  <div class="input-group">
                    <input type="text" class="form-control" name="fromDate" placeholder="mm/dd/yyyy" id="datepicker-autoclose" required="required" autocomplete="off">
                    <div class="input-group-append bg-custom b-0"><span class="input-group-text"><i class="mdi mdi-calendar"></i></span></div>
                  </div>
                  <!-- input-group --></div>
                  
                  <!-- input-group --></div>
                                            
                      </div>
                                    
					
                   
                                
					<div class="form-group">
                      <label>To Date<span class="sta-red">*</span></label>
                      
                      <div>
                      <div>
                  <div class="input-group">
                    <input type="text" class="form-control" name="toDate" placeholder="mm/dd/yyyy" id="datepicker-autoclose2" required="required" autocomplete="off">
                    <div class="input-group-append bg-custom b-0"><span class="input-group-text"><i class="mdi mdi-calendar"></i></span></div>
                  </div>
                  <!-- input-group --></div>
                  
                  <!-- input-group --></div>
                                            
                      </div>
                                
                                
                                
                              
                                <div class="form-group">
                                    <div>
                                        <button type="submit" class="btn btn-primary waves-effect waves-light">
                                            Submit
                                        </button>
                                        
                                    </div>
                                </div>
                            </form>
                            
                            
                            
                    <div>
                    <!-- <div style="overflow: scroll; height: 490px; margin: 0px auto; margin-top: 20px;"> -->
                        <table  border="1" bgcolor="black" align="center" >
                            <thead>
                                <tr bgcolor="#FFFFFF" >
                                    <th height="31" align="center"  bgcolor="#999999" class="table_text" rowspan="2" ><b>Date</b></th>
                                    <th height="31" align="center"  bgcolor="#999999" class="table_text" rowspan="2"><b>Source</b></th>
                                    <th height="31" align="center" bgcolor="#999999" class="table_text"  rowspan="2" ><b>Description</b></th>
                                    <th style="text-align:center;"  bgcolor="#999999" class="table_text" colspan="24" ><b>Hours</b></th>
                                    <th height="31" align="center" bgcolor="#999999" class="table_text"  rowspan="2" ><b>Total</b></th>
                                </tr>

                                <tr bgcolor="#FFFFFF" >

                                    <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>00-01</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>01-02</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>02-03</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>03-04</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>04-05</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>05-06</b></th>
                                <th   style="width: 50px;" bgcolor="#999999"  colspan="1"><b>06-07</b></th>
                                <th   style="width: 50px;" bgcolor="#999999"  colspan="1"><b>07-08</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>08-09</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>09-10</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>10-11</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>11-12</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>12-13</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>13-14</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>14-15</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>15-16</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>16-17</b></th>
                                <th  style="width: 50px;"  bgcolor="#999999" colspan="1"><b>17-18</b></th>
                                <th  style="width: 50px;" bgcolor="#999999"  colspan="1"><b>18-19</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>19-20</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>20-21</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>21-22</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>22-23</b></th>
                                <th style="width: 50px;" bgcolor="#999999"  colspan="1"><b>23-00</b></th>
                            </tr>

                        </thead>
                        <tbody>

                        <%      for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);

                        %>


                        <tr  bgcolor="#FFFFFF" >
                            <% if (i % 3 == 0) {%>
                            <td width="15%" align="center" bgcolor="#C3FDB8" rowspan="9"> <%=hm.get("DATE_TIME")%></td>
                            <% }%>

                            <td bgcolor="#C3FDB8" align="center" rowspan="3"> <%=hm.get("ACT_SOURCE")%> </td>


                            <td height="31"  align="center" bgcolor="#efefef"> Total Received </td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR0")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR1")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR2")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR3")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR4")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR5")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR6")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR7")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR8")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR9")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR10")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR11")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR12")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR13")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR14")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR15")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR16")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR17")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR18")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR19")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR20")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR21")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR22")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR23")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("total")%></td>

                        </tr>
                        <tr  bgcolor="#FFFFFF" >
                            <td height="31"  align="center" bgcolor="#efefef"> Total Success </td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR0_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR1_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR2_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR3_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR4_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR5_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR6_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR7_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR8_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR9_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR10_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR11_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR12_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR13_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR14_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR15_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR16_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR17_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR18_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR19_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR20_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR21_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR22_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR23_succ")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("total_succ")%></td>

                        </tr>
                        <tr  bgcolor="#FFFFFF" >
                            <td height="31"  align="center" bgcolor="#efefef"> Total Failure </td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR0_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR1_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR2_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR3_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR4_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR5_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR6_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR7_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR8_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR9_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR10_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR11_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR12_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR13_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR14_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR15_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR16_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR17_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR18_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR19_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR20_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR21_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR22_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("HR23_fail")%></td>
                            <td align="center" bgcolor="#efefef" ><%=hm.get("total_fail")%></td>
                        </tr>

                        <% }%>




                        </tr>


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

     <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery.slimscroll.min.js"></script>
		<script src="resources/js/app.js"></script>
		
		<script type="text/javascript" src="resources/js/bootstrap-colorpicker.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="resources/js/form-advanced.js"></script>
	<script type="text/javascript" src="resources/js/form-advanced2.js"></script>
<script type="text/javascript" src="resources/js/gen_validatorv4.js"></script>



     
    </body>

</html>
