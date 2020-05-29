<%@page import="com.digispice.indosat.daoImpl.SummaryRequestDTO"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.digispice.indosat.daoImpl.DetailedMIS"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
SimpleDateFormat sdfto = new SimpleDateFormat("yyyy-MM-dd");
DecimalFormat df = new DecimalFormat("###.###");

String fromDate="";
String toDate="";
Connection con=null;

        Calendar c = Calendar.getInstance();        
        c.add(Calendar.DAY_OF_MONTH, -1);
        
        toDate=  sdf.format(c.getTime());
        c.set(Calendar.DAY_OF_MONTH, 1);
         fromDate = sdf.format(c.getTime());
         
         System.out.println(fromDate+ "    "+toDate);	  
            ArrayList rs  = SummaryRequestDTO.cust_getRevenueMISData(fromDate, toDate);
            session.setAttribute("cust_revenueMISData", rs);
   
     SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(new java.util.Date());
     calendar.add(Calendar.DATE, -1);
    java.util.Date exlDate = calendar.getTime();
    String myDate=  sdf1.format(exlDate) ;
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-disposition", "attachment; filename=MIS-INDOMUSIC-INDONESIA_"+myDate+".xls");
    
%>
<html>
    <body>
        <table style="width: 100%"  border="1" bgcolor="black" align="center" >
            <tr bgcolor="#FFFFFF" >
                <td height="31" align="center"  bgcolor="#999999" class="table_text" colspan="1"><b>MIS</b></td>
                <td height="31" align="center"  bgcolor="#999999" class="table_text" colspan="1"><b>MIS</b></td>
                <td height="31" align="center" bgcolor="#999999" class="table_text" ><b>Description\ Date</b></td>
                <%
                            ArrayList infoArrayList = (ArrayList) session.getAttribute("cust_revenueMISData");
                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"  bgcolor="#999999" class="table_text" ><b><%=hm.get("DATE_TIME")%></b></td> <%}%>
            </tr>

            <tr  bgcolor="#FFFFFF" >
                <td width="15%" align="center" bgcolor="#C3FDB8" rowspan="12"> INDOMUSIC</td>
                <td bgcolor="#C3FDB8" align="center" rowspan="3"> CALLS </td>
                <td height="31"  align="center" bgcolor="#efefef">Total Calls</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);

                %>
                <td align="center" bgcolor="#efefef" ><%=hm.get("MRADIO_TOTAL_CALLS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center" bgcolor="#efefef" class="table_text" >Subscribed User Calls</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("MRADIO_SUBS_USERS_CALLS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center"  bgcolor="#efefef">Non Subscribed User Calls </td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);

                %>
                <td align="center" bgcolor="#efefef"><%=hm.get("MRADIO_NON_SUBS_USERS_CALLS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >
                <td align="center" rowspan="3">MOU </td>
                <td height="31" align="center"  bgcolor="ffffff" class="table_text">Total MOU</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"   bgcolor="ffffff" class="table_text"><%=hm.get("MRADIO_TOTAL_MOUS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center" >Subscribed User MOU</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center" ><%=hm.get("MRADIO_SUBS_USERS_MOU")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center"   bgcolor="ffffff" class="table_text" >Non-Subscribed User MOU</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);

                %>
                <td align="center"  bgcolor="#ffffff" class="table_text"><%=hm.get("MRADIO_NON_SUBS_USERS_MOU")%></td> <%}%>
            </tr>

            <tr bgcolor="#FFFFFF" >
                <td rowspan="3" align="center" bgcolor="#C3FDB8">Pulse (in Mins) </td>
                <td height="31" align="center" bgcolor="#efefef" >Total Pulses</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);



                %>
                <td align="center" bgcolor="#efefef"><%=hm.get("MRADIO_TOTAL_PULSES")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center"  bgcolor="#efefef" class="table_text" >Subscribed User Pulses</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("MRADIO_SUBS_USERS_PULSES")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center" bgcolor="#efefef" >Non -Subscribed User Pulses</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center" bgcolor="#efefef" ><%=hm.get("MRADIO_NON_SUBS_USERS_PULSES")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >
                <td align="center" rowspan="3"> Unique Callers</td>
                <td height="31" align="center"  bgcolor="#ffffff" class="table_text">Total Unique Callers</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"  bgcolor="#ffffff" class="table_text" ><%=hm.get("MRADIO_TOTAL_UNIQUE_CALLERS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center" >Unique subscribed callers</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center" bgcolor="#ffffff" ><%=hm.get("MRADIO_UNIQUE_SUBS_CALLERS")%></td> <%}%>
            </tr>
            <tr bgcolor="#FFFFFF" >

                <td height="31" align="center"  bgcolor="#ffffff" class="table_text">Unique Non -Subscribed callers</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td align="center"  bgcolor="#ffffff" class="table_text"><%=hm.get("MRADIO_UNIQUE_NON_SUBS_CALLERS")%></td> <%}%>
            </tr>


            
            
            
            <tr  bgcolor="#FFFFFF" >
           <td rowspan="3" align="center"  colspan="2" >Total Opted for subscription - pack wise</td>
            <td height="31" align="center"   class="table_text"> 3 Days Pack </td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  class="table_text"><%=hm.get("SUB3_REQ")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >
           <td height="31"  align="center" > 7 Days Pack</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("SUB2_REQ")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >
         <td height="31" align="center"  class="table_text" >30 Days Pack</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("SUB1_REQ")%></td> <%}%>
       </tr>

            <tr bgcolor="#FFFFFF" >
          <td rowspan="6" align="center"  bgcolor="#C3FDB8" colspan="2"> Subscriptions & Un-Subscription</td>
            <td height="31" align="center" bgcolor="#efefef"  class="table_text">3 Days Pack @2200 RP</td>
        	<%
        	    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);

	%>
	<td align="center" bgcolor="#efefef"   class="table_text"><%=hm.get("SUB3")%></td> <%}%>
    </tr>
    
    
      <tr bgcolor="#FFFFFF" >
	<td height="31" align="center"  bgcolor="#efefef"  class="table_text">7 Days Pack @5500 RP</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);
	%>
	<td align="center"  bgcolor="#efefef"  class="table_text"><%=hm.get("SUB2")%></td> <%}%>
 </tr>
 
    <tr bgcolor="#FFFFFF" >
            <td height="31" align="center"  bgcolor="#efefef" class="table_text"> 30 Days Pack @11000 RP</td>
        	<%
        	    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);

	%>
	<td align="center" bgcolor="#efefef" class="table_text"><%=hm.get("SUB1")%></td> <%}%>
    </tr>
    
 
                

 <tr bgcolor="#FFFFFF" >
	<td height="31" align="center"  bgcolor="#FFCC99" class="table_text">Voluntary Un-Subscription</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);


	%>
	<td align="center"  bgcolor="#FFCC99" class="table_text" ><%=hm.get("VOLUNTARY_UNSUBS")%></td> <%}%>
    </tr>
    <tr bgcolor="#FFFFFF" >

	<td height="31" align="center" bgcolor="#FFCC99">InVoluntary Un-subscription</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);
	%>
	<td align="center" bgcolor="#FFCC99"><%=hm.get("INVOLUNTARY_UNSUBS")%></td> <%}%>
    </tr>
     
    <tr bgcolor="#FFFFFF" >

	<td height="31" align="center" bgcolor="#FFCC99">Gross Adds</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);


	%>
	<td align="center" bgcolor="#FFCC99"><%=hm.get("GROSS_ADDS")%></td> <%}%>
    </tr>

    
         <tr bgcolor="#FFFFFF" >
           <td rowspan="7" align="center"  colspan="2"> Mode of Subscription</td>
            <td height="31" align="center"  class="table_text">IVR</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text"><%=hm.get("IVR_SUBS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center" >CCI</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("CCI_SUBS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center" class="table_text">OBD</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  class="table_text"><%=hm.get("OBD_SUBS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >


                   <td height="31" align="center"  class="table_text">SMS</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" class="table_text" ><%=hm.get("SMS_SUBS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center">IBD</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("IBD_SUBS")%></td> <%}%>
       </tr>


       <tr bgcolor="#FFFFFF" >

           <td height="31"   align="center">USSD</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("USSD_SUBS")%></td> <%}%>
       </tr>

    <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center" >Others</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("OTHERS_SUBS")%></td> <%}%>
       </tr>


<tr bgcolor="#FFFFFF" >
	<td rowspan="3" align="center" bgcolor="#C3FDB8" colspan="2"> Re-Subscription/Renewals</td>
	     <td height="31" bgcolor="#efefef" align="center" > 3 Days Pack @2200 RP</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);


	%>
	<td align="center" bgcolor="#efefef" ><%=hm.get("RESUB3")%></td> <%}%>
    </tr>
   <tr bgcolor="#FFFFFF" >

	<td height="31" align="center"  bgcolor="#efefef" class="table_text"> 7 Days Pack @5500 RP</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);


	%>
	<td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("RESUB2")%></td> <%}%>
    </tr>


    <tr bgcolor="#FFFFFF" >

    	<td height="31" align="center"  bgcolor="#efefef" class="table_text">30 Days Pack @11000 RP</td>
    	<%

    		    for (int i = 0; i < infoArrayList.size(); i++) {
    			HashMap hm = (HashMap) infoArrayList.get(i);


    	%>
    	<td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("RESUB1")%></td> <%}%>
        
        
        <tr  bgcolor="#FFFFFF" >
           <td rowspan="4" align="center"    colspan="2" >Mode of Un-Subscription</td>
            <td height="31" align="center"   class="table_text">IVR</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text"><%=hm.get("IVR_UNSUBS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"   align="center" >CCI</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("CCI_UNSUBS")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >
         <td height="31" align="center"   class="table_text" >SMS</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"    class="table_text" ><%=hm.get("SMS_UNSUBS")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >
         <td height="31" align="center"   class="table_text" >OTHERS</td>
           <%
                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
           %>
           <td align="center"    class="table_text" ><%=hm.get("OTHER_UNSUBS")%></td> <%}%>
       </tr>
       
       
       
       
       
      <tr bgcolor="#FFFFFF" >
           <td rowspan="5" align="center" bgcolor="#C3FDB8" colspan="2" > Mode of Download</td>
            <td height="31" align="center"  bgcolor="#efefef" class="table_text">IVR</td>
           <%
                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
           %>
           <td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("IVR_DWLD")%></td> <%}%>
       </tr>
       
       <tr bgcolor="#FFFFFF" >
           <td height="31"  bgcolor="#efefef" align="center" >OBD</td>
           <%
                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
           %>
           <td align="center" bgcolor="#efefef" ><%=hm.get("OBD_DWLD")%></td> <%}%>
       </tr>
       
       <tr bgcolor="#FFFFFF" >
           <td height="31" bgcolor="#efefef"  align="center" class="table_text">CCI</td>
           <%
                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
           %>
           <td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("CCI_DWLD")%></td> <%}%>
       </tr>
       
       <tr bgcolor="#FFFFFF" >
          <td height="31"  bgcolor="#efefef" align="center"  class="table_text">SMS</td>
           <%
                                 for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
            %>
           <td align="center" bgcolor="#efefef" class="table_text" ><%=hm.get("SMS_DWLD")%></td> <%}%>
       </tr>
     
         <tr bgcolor="#FFFFFF" >
          <td height="31"   align="center"  class="table_text">OTHERS</td>
           <%
                                 for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);
            %>
           <td align="center" bgcolor="#efefef" class="table_text" ><%=hm.get("OTHERS_DWLD")%></td> <%}%>
       </tr>


    <tr bgcolor="#FFFFFF" >
	<td  align="center"  rowspan="1" bgcolor="#C3FDB8" colspan="2"> Top UP</td>
       
	     <td align="center"  height="31" bgcolor="#efefef"align="center" >Top UP @4400 RP</td>
	<%

		    for (int i = 0; i < infoArrayList.size(); i++) {
			HashMap hm = (HashMap) infoArrayList.get(i);


	%>
	<td align="center" bgcolor="#efefef" ><%=hm.get("TOPUP1")%></td> <%}%>
    </tr>
  
    
    

       <tr  bgcolor="#FFFFFF" >
           <td rowspan="3" align="center"  colspan="2" >Dedications</td>
            <td height="31" align="center"   class="table_text">to On-Net Customers</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  class="table_text"><%=hm.get("ON_NET_DED")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >
           <td height="31"  align="center" >to Off-Net Customers</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("OFF_NET_DED")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >
         <td height="31" align="center"  class="table_text" >Total</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("TOTAL_DED")%></td> <%}%>
       </tr>

          <tr bgcolor="#FFFFFF" >
           <td colspan="3" align="left" bgcolor="#e3f2e1">DOWNLOADS</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#e3f2e1" class="table_text"><%=hm.get("DOWNLOADS")%></td> <%}%>
        </tr>


   <tr bgcolor="#FFFFFF" >
           <td colspan="3" align="left" bgcolor="#efefef">CRBT TONE DOWNLOAD</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("CRBT_TONE_DOWNLOAD")%></td> <%}%>
        </tr>
  
      
         <tr  bgcolor="#FFFFFF" >
           <td rowspan="8"   bgcolor="#ffcc00" align="center" colspan="2" >REVENUE</td>           
           <td height="31"  align="center"  bgcolor="#ffcc00" >3 Days Pack @2200 RP</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#ffcc00" ><%=hm.get("SUB3_REVENUE")%></td> <%}%>
       </tr>

        
        
        
        
       <tr bgcolor="#FFFFFF" >
           <td height="31"  align="center"  bgcolor="#ffcc00" >7 Days Pack @5500 RP</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#ffcc00" ><%=hm.get("SUB2_REVENUE")%></td> <%}%>
       </tr>
        
        
        
        
        
       <tr bgcolor="#FFFFFF" >
           <td height="31"  align="center"  bgcolor="#ffcc00" >30 Days Pack @11000 RP</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#ffcc00" ><%=hm.get("SUB1_REVENUE")%></td> <%}%>
       </tr>
        
        
        <tr bgcolor="#FFFFFF" >
            <td  height="31" align="center"  colspan="1" bgcolor="#FFCC00">Top Up @4400 RP</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td  height="31" align="center"  bgcolor="#FFCC00" class="table_text"><%=hm.get("TOPUP1_REVENUE")%></td> <%}%>
        </tr>

        
        
        
        
         
       <tr bgcolor="#FFFFFF" >
           <td  height="31" align="center"  colspan="1" bgcolor="#FFCC00">Download Revenue @2200 RP</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center"  bgcolor="#FFCC00" class="table_text"><%=hm.get("DOWNLOAD_REVENUE")%></td> <%}%>
        </tr>


	   <tr bgcolor="#FFFFFF" >
           <td  height="31" colspan="1" align="center"  bgcolor="#FFCC00">Dedication Revenue @2200 RP</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center"  bgcolor="#FFCC00" class="table_text"><%=hm.get("DEDICATION_REVENUE")%></td> <%}%>
        </tr>



    <tr bgcolor="#FFFFFF" >
               <td  height="31" align="center"   colspan="1" bgcolor="#E68A00">Gross Revenue (in RP)</td>
               <%

                           for (int i = 0; i < infoArrayList.size(); i++) {
                               HashMap hm = (HashMap) infoArrayList.get(i);


               %>
               <td  height="31" align="center"  bgcolor="#E68A00" class="table_text"><%=hm.get("GROSS_REVENUE_LOCAL")%></td> <%}%>
     </tr>


     <tr bgcolor="#FFFFFF" >
                <td  height="31"  align="center" colspan="1" bgcolor="#E68A00">Gross Revenue (in USD)(1 USD= 14472 RP)</td>
                <%

                            for (int i = 0; i < infoArrayList.size(); i++) {
                                HashMap hm = (HashMap) infoArrayList.get(i);


                %>
                <td  height="31" align="center"  bgcolor="#E68A00" class="table_text"><%=hm.get("GROSS_REVENUE_USD")%></td> <%}%>
      </tr>

           <tr  bgcolor="#FFFFFF" >
           <td rowspan="3" align="center" bgcolor="#C3FDB8" colspan="2">Active Subscribers</td>
            <td height="31" align="center" bgcolor="#efefef"  class="table_text">Active Subscribers in the System</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center" bgcolor="#efefef"  class="table_text"><%=hm.get("ACTIVE_SUBSCRIBERS")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31" bgcolor="#efefef"  align="center" >Billed Subscribers</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td   height="31" align="center" bgcolor="#efefef" ><%=hm.get("BILLED_SUBSCRIBERS")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >


         <td  height="31" height="45" align="center"  bgcolor="#efefef"  class="table_text">Calling Subscribers (Subcribers who called within last 30 days)</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center"  bgcolor="#efefef"  class="table_text" ><%=hm.get("CALLING_SUBSCRIBERS")%></td> <%}%>
       </tr>

         <tr  bgcolor="#FFFFFF" >
           <td rowspan="9" align="center" colspan="2" >Product KPI</td>
            <td height="31" align="center"  class="table_text">Average Call/Unique Caller</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td   height="31"align="center" class="table_text"><%=hm.get("AVG_CALL_UNIQUE")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center" >Average MOU/Unique Caller</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center"  ><%=hm.get("AVG_MOU_UNIQUE")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >


         <td height="31"  align="center" class="table_text">Average MOU/Call</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center" class="table_text" ><%=hm.get("AVG_MOU_CALL")%></td> <%}%>
       </tr>

         <tr  bgcolor="#FFFFFF" >
                <td height="31" align="center"  class="table_text">Average Download/Unique Caller</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  height="31"  class="table_text"><%=hm.get("AVG_DWLD_UNIQUE")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31"  align="center" >Average Dedication/Unique Caller</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  ><%=hm.get("AVG_DED_UNIQUE")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >


         <td height="31" align="center" class="table_text">Average RBT/Unique Caller</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td  height="31" align="center" class="table_text" ><%=hm.get("AVG_RBT_UNIQUE")%></td> <%}%>
       </tr>



<tr bgcolor="#FFFFFF" >


         <td height="45" align="center"  bgcolor="#FFCC99" class="table_text">Unique Caller/Active Subscribers in the System</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#FFCC99" class="table_text" ><%=hm.get("UNIQUE_CALLER_ACTIVE")%></td> <%}%>
       </tr>


<tr bgcolor="#FFFFFF" >


         <td height="45" align="center"  bgcolor="#FFCC99" class="table_text">Service Penetration(in%)(Total Operator Base=10000000)</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#FFCC99" class="table_text" ><%=hm.get("SERVICE_PENETRATION")%></td> <%}%>
       </tr>

<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  bgcolor="#FFCC99" class="table_text">ARPU</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#FFCC99" class="table_text" ><%=hm.get("ARPU")%></td> <%}%>
       </tr>



  <tr  bgcolor="#FFFFFF" >
           <td rowspan="6" align="center"colspan="2" bgcolor="#C3FDB8" >Grace Subscriber Classification</td>
            <td height="31" align="center" bgcolor="#efefef" class="table_text">Subscribers moved from Active to Grace</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#efefef" class="table_text"><%=hm.get("ACTIVE_TO_GRACE")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31" bgcolor="#efefef" align="center" >Subscribers moved from Grace to Active</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" bgcolor="#efefef"><%=hm.get("GRACE_TO_ACTIVE")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >


         <td height="31" align="center" bgcolor="#efefef" class="table_text">Subscribers in 1-7 days Grace with service</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("GRACE1TO7")%></td> <%}%>
       </tr>



<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  bgcolor="#efefef" class="table_text">Subscribers in 8-14 days retry</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" bgcolor="#efefef" class="table_text" ><%=hm.get("GRACE8TO14")%></td> <%}%>
       </tr>


<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  bgcolor="#efefef" class="table_text">Subscribers in 15-21 Days retry</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" bgcolor="#efefef" class="table_text" ><%=hm.get("GRACE14TO21")%></td> <%}%>
       </tr>

<tr bgcolor="#FFFFFF" >


         <td height="31" align="center" bgcolor="#efefef" class="table_text">Subscribers in 22-30 days retry</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("GRACE22TO30")%></td> <%}%>
 </tr>

 <tr  bgcolor="#FFFFFF" >
           <td rowspan="11" align="center" colspan="2" >Usage Pattern</td>
            <td height="31" align="center"  class="table_text">0-1 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text"><%=hm.get("MIN1")%></td> <%}%>
       </tr>
       <tr bgcolor="#FFFFFF" >

           <td height="31" align="center" >1-2 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center" ><%=hm.get("MIN2")%></td> <%}%>
       </tr>

       <tr bgcolor="#FFFFFF" >


         <td height="31" align="center" class="table_text">2-3 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN3")%></td> <%}%>
       </tr>



<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"   class="table_text">3-4 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  class="table_text" ><%=hm.get("MIN4")%></td> <%}%>
       </tr>


<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  class="table_text">4-5 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"  class="table_text" ><%=hm.get("MIN5")%></td> <%}%>
       </tr>

<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  class="table_text">5-6 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN6")%></td> <%}%>
 </tr>

<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"   class="table_text">6-7 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN7")%></td> <%}%>
 </tr>


 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"   class="table_text">7-8 Mins</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"   class="table_text" ><%=hm.get("MIN8")%></td> <%}%>
  </tr>



<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  class="table_text">8-9 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN9")%></td> <%}%>
 </tr>



<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"  class="table_text">9-10 Mins</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN10")%></td> <%}%>
 </tr>


<tr bgcolor="#FFFFFF" >


         <td height="31" align="center"   class="table_text">10 Mins & Above</td>
           <%

                       for (int i = 0; i < infoArrayList.size(); i++) {
                           HashMap hm = (HashMap) infoArrayList.get(i);


           %>
           <td align="center"   class="table_text" ><%=hm.get("MIN10ABOVE")%></td> <%}%>
 </tr>



 <tr  bgcolor="#FFFFFF" >
            <td rowspan="24" align="center" bgcolor="#C3FDB8" colspan="2" >Maximum Incoming Channel Utilization Percentage Per Hour (in %)</td>
             <td height="31" bgcolor="#efefef" align="center"  class="table_text">00:00 - 00:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center" bgcolor="#efefef"  class="table_text"><%=hm.get("HR0")%></td> <%}%>
        </tr>
        <tr bgcolor="#FFFFFF" >

            <td height="31" bgcolor="#efefef" align="center" >01:00 - 01:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center" bgcolor="#efefef" ><%=hm.get("HR1")%></td> <%}%>
        </tr>

        <tr bgcolor="#FFFFFF" >


          <td height="31" align="center" bgcolor="#efefef" class="table_text">02:00 - 02:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR2")%></td> <%}%>
        </tr>



 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"  bgcolor="#efefef" class="table_text">03:00 - 03:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR3")%></td> <%}%>
        </tr>


 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"  bgcolor="#efefef" class="table_text">04:00 - 04:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center" bgcolor="#efefef" class="table_text" ><%=hm.get("HR4")%></td> <%}%>
        </tr>

 <tr bgcolor="#FFFFFF" >


          <td height="31" bgcolor="#efefef" align="center"  class="table_text">05:00 - 05:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR5")%></td> <%}%>
  </tr>

 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"  bgcolor="#efefef" class="table_text">06:00 - 06:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR6")%></td> <%}%>
  </tr>


  <tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">07:00 - 07:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR7")%></td> <%}%>
   </tr>



 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"  bgcolor="#efefef"  class="table_text">08:00 - 08:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR8")%></td> <%}%>
  </tr>



 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center"  bgcolor="#efefef" class="table_text">09:00 - 09:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"   bgcolor="#efefef" class="table_text" ><%=hm.get("HR9")%></td> <%}%>
  </tr>


 <tr bgcolor="#FFFFFF" >


          <td height="31" align="center" bgcolor="#efefef" class="table_text">10:00 - 10:59</td>
            <%

                        for (int i = 0; i < infoArrayList.size(); i++) {
                            HashMap hm = (HashMap) infoArrayList.get(i);


            %>
            <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR10")%></td> <%}%>
  </tr>




  <tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">11:00 - 11:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef"  class="table_text" ><%=hm.get("HR11")%></td> <%}%>
   </tr>




 <tr bgcolor="#FFFFFF" >


            <td height="31" align="center"  bgcolor="#efefef" class="table_text">12:00 - 12:59</td>
              <%

                          for (int i = 0; i < infoArrayList.size(); i++) {
                              HashMap hm = (HashMap) infoArrayList.get(i);


              %>
              <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR12")%></td> <%}%>
    </tr>




<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"   bgcolor="#efefef" class="table_text">13:00 - 13:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"   bgcolor="#efefef" class="table_text" ><%=hm.get("HR13")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">14:00 - 14:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center" bgcolor="#efefef"  class="table_text" ><%=hm.get("HR14")%></td> <%}%>
   </tr>



<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">15:00 - 15:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR15")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center" bgcolor="#efefef" class="table_text">16:00 - 16:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"   bgcolor="#efefef" class="table_text" ><%=hm.get("HR16")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">17:00 - 17:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center" bgcolor="#efefef"  class="table_text" ><%=hm.get("HR17")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center" bgcolor="#efefef" class="table_text">18:00 - 18:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR18")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center" bgcolor="#efefef"  class="table_text">19:00 - 19:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR19")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">20:00 - 20:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR20")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">21:00 - 21:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR21")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center"  bgcolor="#efefef" class="table_text">22:00 - 22:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"  bgcolor="#efefef" class="table_text" ><%=hm.get("HR22")%></td> <%}%>
   </tr>


<tr bgcolor="#FFFFFF" >


           <td height="31" align="center" bgcolor="#efefef" class="table_text">23:00 - 23:59</td>
             <%

                         for (int i = 0; i < infoArrayList.size(); i++) {
                             HashMap hm = (HashMap) infoArrayList.get(i);


             %>
             <td align="center"   bgcolor="#efefef" class="table_text" ><%=hm.get("HR23")%></td> <%}%>
   </tr>





 </table>   
    </body>
</html>

