<%-- 
    Document   : payment
    Created on : Aug 24, 2018, 12:23:56 AM
    Author     : HienTam68
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Payment</title>
    </head>
    <body>
        <form action="paymentConfirm.jsp" method="GET">
            <h1><span>NEW</span><lable>Payment</lable></h1>
            <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
            <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>

            <label for="id">Partner Name:</label>
            <input type="text" name="partnerName" placeholder="" maxlength="10" required/>
            <br>
            <label for="billId">Bill ID:</label>
            <input type="text" placeholder="" name="billId" maxlength="10" required/>
            <br>
            <label for="accountId">Account ID:</label>
            <input type="text" name="accountId" placeholder="" maxlength="20" required/>
            <br>
            <label for="accountPin">Partner's PIN Code:</label>
            <input type="text" name="accountPin" placeholder="" maxlength="4" required/>
            <br>
            <label for="id">Transaction Name:</label>
            <input type="text" name="transactionName" placeholder="" maxlength="10" required/>
            <br>
            <label for="transactionAmount">Payment Amount:</label>
            <input type="text" name="transactionAmount" placeholder="" required/>
            <br>
            <label for="feePayer">Fee Payer:</label>
            <select name="feePayer">
                <option value="1">sender</option>
                <option value="2">receiver</option>
            </select>
            <br>
            <%
                String id = request.getParameter("id");
                request.setAttribute("id", request.getParameter("id"));
            %>
            <input type="submit" value="Next step"/>
            <a href="menu.jsp?id=<%=request.getParameter("id")%>&name=<%=request.getParameter("name")%>">Cancel</a>                        
        </form>       
    </body>
</html>
