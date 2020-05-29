<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/css/aksStyleSheet.css">
        <link rel="stylesheet" type="text/css" href="resources/css/css.css">
        <link rel="stylesheet" href="resources/css/text.css" type="text/css" />
        <%--<link rel="stylesheet" type="text/css" href="resources/css/aksStyleSheet.css">--%>

        <link rel="stylesheet" type="text/css" href="resources/css/alternative.css">
        <link rel="stylesheet" type="text/css" href="resources/css/maven-base.css">
        <link rel="stylesheet" type="text/css" href="resources/css/text.css">
        <link rel="stylesheet" type="text/css" href="resources/css/site.css">

        <link rel="stylesheet" type="text/css" href="resources/css/teststyles.css">
        <script type="text/JavaScript" src="resources/js/prototypeAjax.js"></script>
        <html:base/>

    </head>
    <body style="background-image:url(resources/images/page_bg.jpg)">
    <center>

        <table border="0" cellpadding="0" cellspacing="0" valign="top" align="center"  bgcolor="white"  class="background1">

            <tbody>
                <tr height="100">
                    <td><jsp:include page="header.jsp" flush="true"/></td>
                </tr>
                <tr height="25">
                    <td><jsp:include page="menu.jsp" flush="true"/></td>
                </tr>
                <tr>
                    <td valign="top">
                        <table border="0" cellpadding="4"  valign="top" cellspacing="0" align="center" width="95%"  bgcolor="white">
                            <html:form action="/SearchSong" method="post">

                                <html:errors/>
                                <tr>
                                    <td colspan="2" valign="top">
                                        <table border="0" cellspacing="0" width="98%" cellpadding="0" bgcolor="#FFFFFF">

                                            <tr>

                                                <td  align="right">
                                                    Category:
                                                </td>
                                                <td align="left">
                                                    <html:select property="category" onclick="javascript:getSubCat(this);">
                                                        <html:option value="ALL"/>
                                                        <html:options property="categoryList"/>
                                                    </html:select>
                                                </td>
                                                <td  align="right">
                                                    Sub Category:
                                                </td>
                                                <td align="left">
                                                    <html:select property="subCategory">
                                                        <html:option value="ALL"/>
                                                    </html:select>
                                                </td>

                                                <td  align="right">
                                                    &nbsp;Search By*:
                                                </td>
                                                <td align="left">
                                                    <html:select property="searchBy" >
                                                        <html:option value="ALL">ALL</html:option>
                                                        <html:option value="album">Album</html:option>
                                                        <html:option value="singer">Artist</html:option>
                                                        <html:option value="tone_name">Song Name</html:option>
                                                        <html:option value="tone_code">Tone ID</html:option>
                                                    </html:select>
                                                </td>

                                                <td align="right">
                                                    &nbsp;Search Text*:
                                                </td>
                                                <td align="left">
                                                    <html:text style="background-color:white;color: black;" property="searchString" maxlength="100" size="10" />
                                                </td>

                                                <td align="right">&nbsp;<html:image src="images/submit_button.jpg"><html:submit/></html:image></td>
                                                </tr>

                                            </table>
                                    </html:form>


                            <tr>
                                <td>

                            <tr><td colspan="2" valign="top" align="left" width="99%" bgcolor="#FFFFFF" style="padding-left:20px" height="250">


                                    <c:choose>
                                        <%--c:when test="${not empty requestScope['searchData']}"--%>

                                        <c:when test="${requestScope['searchData'] != null && requestScope['searchData'] !='[]'}">


                                            <h2 class="BoldText14">Search Results</h2>


                                            <display:table size="40" name="requestScope.searchData" pagesize="20" export="false" class="mars"  requestURI="SearchSong.do"  style="width:99%;align:center">

                                                <display:column title="SONG ID" property="SONG_ID" style="align:left" />
                                                <display:column title="SONG NAME" property="SONG_NAME" style="align:left" />
                                                <display:column title="ALBUM NAME" property="ALBUM_NAME" style="align:left"/>
                                                <display:column title="ARTIST NAME" property="ARTIST_NAME" style="align:left" />
                                                <display:column title="CATEGORY" property="CATEGORY" style="align:left" />
                                                <display:column title="SUB CATEGORY" property="SUB_CATEGORY" style="align:left" />

                                                <%--display:column title="MOOD" property="MOOD"  />
                                                                        <display:column title="CONTENT PROVIDER" property="CONTENT_PROVIDER" />
                                                                        <display:column title="CREATE DATE" property="CREATE_DATE" /--%>


                                                <display:column title="Set RBT" property="download_icon"  style="align:left" />

                                                <%--<display:column title="Listen" property="LINK" style="align:left" />
                                                <display:column  title="Set" value="Set" href="resources/<%=href%>" paramId="sId" paramProperty="SongCode"/>
                                                <display:column title="Gift" value="Gift" href="resources/searchpopulategift.do?c=gift" paramId="sId" paramProperty="SongCode"/>--%>
                                            </display:table>

                                        </c:when>






                                        <c:otherwise>
                                            <table><tr><td height="10" align="center"> <h4><font color="red" face='arial'>No matching records found.</font></h4></td></tr></table>
                                                        </c:otherwise>
                                                    </c:choose>

                                </td></tr>

                    </td>
                </tr>

        </table></td></tr>
<tr height="30">
    <td><jsp:include page="footer.jsp"  flush="true"/></td>
</tr></table>
</center>
</body>
</html:html>
<script type="text/javascript">

    <c:if test="${subcat == null }">
    getSubCat(document.SearchSongForm.category);
    </c:if>
</script>
