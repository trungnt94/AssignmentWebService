<%-- 
    Document   : menu
    Created on : Aug 24, 2018, 12:23:48 AM
    Author     : HienTam68
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Welcome ${name}!</h1>
        <a href="payment.jsp?id=${id}&name=${name}">Create New Transaction</a> 
        <div>
        <form action="ReceiveHistory">
            <input type="hidden" value="${id}" name="id"/>
            <input type="hidden" value="${name}" name="name"/>
            <input type="submit" value="View Receive Transaction History"/>
        </form>
        <form action="SendHistory">
            <input type="hidden" value="${id}" name="id"/>
            <input type="hidden" value="${name}" name="name"/>
            <input type="submit" value="View Send Transaction History"/>
        </form>
        </div>
    </body>
</html>
