<%-- 
    Document   : paymentConfirm
    Created on : Aug 24, 2018, 12:24:07 AM
    Author     : HienTam68
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Confirm</title>
    </head>
    <body>
         <form action="NewPayment">
            <h1><span>NEW</span><lable>Payment</lable></h1>
            <div class="inset">
                <input type="hidden" value="<%=request.getParameter("id")%>" name="id"/>
                <input type="hidden" value="<%=request.getParameter("name")%>" name="name"/>
                <div>Partner Name: <%=request.getParameter("partnerName")%> </div><br>
                <input type="hidden" value="<%=request.getParameter("partnerName")%>" name="partnerName"/>

                <div>Bill ID: <%=request.getParameter("billId")%></div><br>
                <input type="hidden" value="<%=request.getParameter("billId")%>" name="billId"/>

                <div>Account ID: <%=request.getParameter("accountId")%></div><br>
                <input type="hidden" value="<%=request.getParameter("accountId")%>" name="accountId"/>

                <div>Partner's PIN Code: <%=request.getParameter("accountPin")%></div><br>
                <input type="hidden" value="<%=request.getParameter("accountPin")%>" name="accountPin"/>
                <div>Transaction Name: <%=request.getParameter("transactionName")%></div><br>
                <input type="hidden" value="<%=request.getParameter("transactionName")%>" name="name"/>
                <div>Payment Amount: <%=request.getParameter("transactionAmount")%> (VND)</div><br>
                <input type="hidden" value="<%=request.getParameter("transactionAmount")%>" name="transactionAmount"/>
                <div>Fee Payer: <%=request.getParameter("feePayer")%></div><br>
                <%
                    int transactionAmount = Integer.parseInt(request.getParameter("transactionAmount"));
                    int fee;
                    if (transactionAmount > 5000000) {
                        fee = transactionAmount / 200;
                    } else if (transactionAmount > 1000000) {
                        fee = transactionAmount / 100;
                    } else if (transactionAmount > 500000) {
                        fee = transactionAmount / 67;
                    } else if (transactionAmount > 100000) {
                        fee = transactionAmount / 50;
                    } else {
                        fee = 10000;
                    }
                    String finalFee = Integer.toString(fee);
//                    request.setAttribute("id", request.getParameter("id"));
//                    request.setAttribute("partnerId", request.getParameter("partnerId"));
//                    request.setAttribute("billId", request.getParameter("billId"));
//                    request.setAttribute("accountId", request.getParameter("accountId"));
//                    request.setAttribute("accountPin", request.getParameter("accountPin"));
//                    request.setAttribute("transactionAmount", request.getParameter("transactionAmount"));
//                    request.setAttribute("name", request.getParameter("transactionName"));
//                    request.setAttribute("fee", finalFee);
%>
                <div>Payment Fee: <%=finalFee%></div><br>
                <input type="hidden" value="<%=finalFee%>" name="fee"/>
                <%
                    String receiveAmount;
                    String sendAmount;
                    String feePayer = request.getParameter("feePayer");
                    if (feePayer.equals("2")) {
                        receiveAmount = Integer.toString(transactionAmount - fee);
                        sendAmount = Integer.toString(transactionAmount);
                    } else {
                        receiveAmount = Integer.toString(transactionAmount);
                        sendAmount = Integer.toString(transactionAmount + fee);

                    }
//                    request.setAttribute("receiveAmount", receiveAmount);
//                    request.setAttribute("sendAmount", sendAmount);
%>
                <div>Receive Amount: <%=receiveAmount%></div><br>
                <input type="hidden" value="<%=receiveAmount%>" name="receiveAmount"/>
                <div>Send Amount: <%=sendAmount%></div><br>
                <input type="hidden" value="<%=sendAmount%>" name="sendAmount"/>
                <input type="submit" value="Submit"/>
            </div><br>
        </form>
    </body>
</html>
