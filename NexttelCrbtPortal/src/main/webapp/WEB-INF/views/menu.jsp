<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <html><head>
            <link rel="stylesheet" type="text/css" href="jqueryslidemenu.css" />
            <link rel="stylesheet" type="text/css" href="resources/css/aksStyleSheet.css"/>
            <link rel="stylesheet" type="text/css" href="resources/css/text.css"/>
            <link rel="stylesheet" type="text/css" href="resources/css/website.css" />
                 <script type="text/javascript" src="resources/jquery.min.js"></script>
            <script type="text/javascript" src="resources/jqueryslidemenu.js"></script>

             <body>
             <div id="myslidemenu" class="jqueryslidemenu">
            <ul>
                <%--<li><html:link forward="home">Home</html:link></li>
                <li><a href="faq.jsp" class="white_text">FAQ's</a></li>
                <li><html:link action="changePasswordPopulate">Change Password</html:link></li>
                --%>
                <!--IS_SUPER IS_ADMIN IS_CCIIS_CMS IS_MIS-->


     





                <li><html:link action="logoutaction">Logout</html:link></li>
                <li >&nbsp;</li>
            </ul>
            <br style="clear: left" />
        </div>
        <table width="100%">
            <tr>
                
            </tr>

        </table>
    </body>
</html>