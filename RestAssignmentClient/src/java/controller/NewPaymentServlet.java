/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Transactions;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TransactionJerseyClient;
import service.UsersJerseyClient;

/**
 *
 * @author HienTam68
 */
public class NewPaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String partnerName= (String) request.getParameter("partnerName");
        String billId = (String) request.getParameter("billId");
        String accountId = (String) request.getParameter("accountId");
        String accountPin = (String) request.getParameter("accountPin");
        String transactionAmount = (String) request.getParameter("transactionAmount");
        String fee = (String) request.getParameter("fee");
        String receiveAmount = (String) request.getParameter("receiveAmount");
        String sendAmount = (String) request.getParameter("sendAmount");
        String transactionName = (String) request.getParameter("name");

        UsersJerseyClient userClient = new UsersJerseyClient();
        TransactionJerseyClient transactionClient = new TransactionJerseyClient();
        Users u = (Users) userClient.findUsername(Users.class,name);
        Users up = (Users) userClient.findUsername(Users.class,partnerName);        
        Transactions t = new Transactions();
        t.setBillid(billId);
        t.setReceiveamount(Integer.parseInt(receiveAmount));
        t.setReceiverid(up.getId());
        t.setSendamount(Integer.parseInt(sendAmount));
        t.setSenderid(u.getId());
        t.setTransactionamount(Integer.parseInt(transactionAmount));
        t.setTransactiondate(new Date());
        t.setTransactionfee(Integer.parseInt(fee));
        t.setTransactionname(transactionName);
        transactionClient.create_XML(t);
        int uCurBal = u.getBalance();
        int upCurBal = up.getBalance();
        u.setBalance(uCurBal + Integer.parseInt(receiveAmount));
        up.setBalance(upCurBal - Integer.parseInt(sendAmount));
        userClient.edit_XML(u, u.getId().toString());
        userClient.edit_XML(up, up.getId().toString());
        request.setAttribute("id", id);
        request.setAttribute("name", u.getUsername());
        request.setAttribute("pass", u.getPassword());
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
        }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
