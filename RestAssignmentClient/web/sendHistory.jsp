<%-- 
    Document   : sendHistory
    Created on : Aug 24, 2018, 12:24:30 AM
    Author     : HienTam68
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send History</title>
    </head>
    <body>
        <form action="SendHistory">
        <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
        <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>
         <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>                
                <td>Fee</td>
                <td>Date</td>
                <td>Received Amount:</td>
                <td>Bill ID</td>
            </tr>
            <c:forEach items="${ListTransaction}" var="u">
                <tr>
                <td><c:out value="${u.id}"/></td>
                <td><c:out value="${u.transactionname}"/></td>                
                <td><c:out value="${u.transactionfee}"/></td>
                <td><c:out value="${u.transactiondate}"/></td>
                <td><c:out value="${u.receiveamount}"/></td>
                <td><c:out value="${u.billid}"/></td>
                </tr>
            </c:forEach> 
        </table>                    
            <a href="menu.jsp?id=<%=request.getParameter("id")%>&name=<%=request.getParameter("name")%>">Back to Menu</a>
        </form>
    </body>
</html>
