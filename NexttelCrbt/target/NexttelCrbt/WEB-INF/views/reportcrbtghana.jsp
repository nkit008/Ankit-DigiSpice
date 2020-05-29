	<div
		style="overflow: scroll; height: 400px; width: 845px; margin: 0px auto; margin-top: 20px;">
		



<table border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"
			align="center" width="1200" style="padding-bottom: 0px">
			
			<tr>
			<th class="tg-c3ow">Date</th>
			<th class="tg-c3ow" colspan="2">KPI</th>
			</tr>
  <tr>
  
    <th class="tg-c3ow" rowspan="12">Browsing</th>
     <td class="tg-c3ow" rowspan="3">CALLS</th>
    <td class="tg-0pky">Total Calls</th>

    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>${data.total_calls}</td>
		</tr>
	</table></th>
	</c:forEach>
    

    </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Calls</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Non Subscribed User Calls</td>
    
    <c:forEach items="${reportdata}" var="data">
<th class="tg-c3ow">
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>${data.date}</td>
		</tr>
	</table></th>
	</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3">MOU</td>
    <td class="tg-0pky">Total MOU</td>
    <c:forEach items="${reportdata}" var="data">
	<th class="tg-c3ow">
    <table width="100%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>${data.date}</td>
		</tr>
	</table></th>
	</c:forEach>
    
</tr>
  <tr>
    <td class="tg-0pky">Subscribed User MOU</td>
    
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Non -Subscribed User MOU</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
    
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
 
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3">Pulse (in Mins)</td>
    <td class="tg-0pky">Total Pulses</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Subscribed User Pulses</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Non -Subscribed User Pulses</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3">Unique Callers</td>
    <td class="tg-0pky">Total Unique Callers</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unique subscribed callers</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unique Non -Subscribed callers</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="7">Downloads</td>
    <td class="tg-c3ow" rowspan="3">Shuffle First Song</td>
    <td class="tg-0pky">Tone_30 (Monthly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Tone_10 (Weekly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
        <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_2 (Daily)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
 
  </tr>
  <tr>
    <td class="tg-c3ow" rowspan="3">Shuffle Second Song</td>
    <td class="tg-0pky">Tone_15 (Monthly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_5 (Weekly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_1 (Daily)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
    
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow">Shuffle<br>  Third Song</td>
    <td class="tg-0pky">Free Tones</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" colspan="3">Total Tone Downloads</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="7">Renewals</td>
    <td class="tg-0pky" rowspan="3">Shuffle First Song</td>
    <td class="tg-0pky">Tone_Renewal_30 (Monthly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_Renewal_10 (Weekly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_Renewal_2 (Daily)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="3">Shuffle Second Song</td>
    <td class="tg-0pky">Tone_Renewal_15 (Monthly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_Renewal_5 (Weekly)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone_Renewal_1 (Daily)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Shuffle<br>&nbsp;&nbsp;Third Song</td>
    <td class="tg-0pky">Free Renewals</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" colspan="3">Total Tone Renewals</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="13">Subscriptions Renewals &amp; Un-Subscriptions</td>
    <td class="tg-0pky" rowspan="5">Subscriptions</td>
    <td class="tg-0pky">SUB_50</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">SUB_20</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">SUB_4</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Free Subscriptions</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Subscriptions</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="5">Renewals</td>
    <td class="tg-0pky">Resub_50</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Resub_20</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  
  </tr>
  <tr>
    <td class="tg-0pky">Resub_4</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Free Re-subscriptions</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Total Re-subscriptions</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" rowspan="2">Un-Subscriptions</td>
    <td class="tg-0pky">Voluntary unsubscription</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Involuntary un-subscription</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky" colspan="2">Gross Adds</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" colspan="2" rowspan="11">Mode<br>  of Subscription</td>
    <td class="tg-0pky">Subscription Mode - IVR</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - CCI</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - OBD</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - SMS</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>

  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - IBD</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - *Copy</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - GIFT</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    </th>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - WEB</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - WAP</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - USSD</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Mode - Others</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-c3ow" colspan="2" rowspan="5">Modes<br>&nbsp;&nbsp;of Unsubscription</td>
    <td class="tg-0pky">Unsubscribe Mode - IVR</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode - USSD</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode- WEB</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode-CCI</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Unsubscribe Mode- SMS</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-c3ow" colspan="2" rowspan="5">Revenue</td>
    <td class="tg-0pky">Browsing Revenue (GHS)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Tone Download Revenue (in GHS)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Subscription Revenue (in GHS)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Gross Revenue (in GHS)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0pky">Gross Revenue (in USD)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-baqh" colspan="2" rowspan="2">Subscribers</td>
    <td class="tg-0lax">Active subscribers in the system</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0lax">Billed Subscribers</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-baqh" colspan="2" rowspan="7">Product Performance</td>
    <td class="tg-0lax">Average Call/Unique Caller</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>

  </tr>
  <tr>
    <td class="tg-0lax">Average MOU/Unique Caller</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">Average MOU/Call</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">No. of tones/subscriber</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">Unique caller/Active subscribers in the system</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    </th>
  </tr>
  <tr>
    <td class="tg-0lax">Service penetration(in %)</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    </th>
  </tr>
  <tr>
    <td class="tg-0lax">ARPU</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-baqh" colspan="2" rowspan="7">Grace<br>  &amp; On-Hold subscriber Classification</td>
    <td class="tg-0lax">Subscribes moved from Active to Grace</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">Subscribes moved from Grace to Active</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
    
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">Subscribers in 1-7 days Grace</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
    
  </tr>
  <tr>
    <td class="tg-0lax">On-Hold in 8-14 Days Retry</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0lax">On-Hold in 15-21 Days Retry</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
  <tr>
    <td class="tg-0lax">On-Hold in 22-30 Days Retry</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
 
  </tr>
  <tr>
    <td class="tg-0lax">Total Base</td>
    <c:forEach items="${reportdata}" var="data">
    <th class="tg-c3ow">
	    <table width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>${data.date}</td>
			</tr>
		</table></th>
		</c:forEach>
  </tr>
</table>





	</div>