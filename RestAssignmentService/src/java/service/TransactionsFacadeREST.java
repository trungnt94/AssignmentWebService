/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Transactions;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HienTam68
 */
@Stateless
@Path("entity.transactions")
public class TransactionsFacadeREST extends AbstractFacade<Transactions> {

    @PersistenceContext(unitName = "RestAssignmentServicePU")
    private EntityManager em;

    public TransactionsFacadeREST() {
        super(Transactions.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Transactions entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Transactions entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Transactions find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transactions> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transactions> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findById")
    @Consumes({"application/xml", "application/json"})
    public List<Transactions> findById(@QueryParam("id") int id) {        
        List<Transactions> trans = (List<Transactions>) em.createNamedQuery("Transactions.findById")
                .setParameter("id", id)               
                .getResultList();
        
        if (trans.isEmpty()) {
            return null;
        }     
        return trans;
    }
    
    @GET
    @Path("findByReceiverid")
    @Consumes({"application/xml", "application/json"})
    public List<Transactions> findByReceiverid (@QueryParam("receiverid") String receiverid) {
        List<Transactions> trans = (List<Transactions>) em.createNamedQuery("Transactions.findByReceiverid")
                .setParameter("receiverid", receiverid)               
                .getResultList();
        if (trans.isEmpty()) {
            return null;
        }     
        return trans;
    }
    
    @GET
    @Path("findBySenderId")
    @Consumes({"application/xml", "application/json"})
    public List<Transactions> findBySenderId(@QueryParam("senderid") String senderid) {
        List<Transactions> trans = (List<Transactions>) em.createNamedQuery("Transactions.findBySenderid")
                .setParameter("senderid", senderid)               
                .getResultList();
        
        if (trans.isEmpty()) {
            return null;
        }     
        return trans;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
