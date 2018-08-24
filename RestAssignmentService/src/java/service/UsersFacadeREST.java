/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("entity.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "RestAssignmentServicePU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Users entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Users find(@PathParam("username") String username) {
        return super.find(username);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("checkLogin")
    @Consumes({"application/xml", "application/json"})
    public String checkLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        List<Users> user = (List<Users>) em.createNamedQuery("Users.checkLogin")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        
        if (user.isEmpty()) {
            return "false";
        }     
        return "true";
    }
    
    @GET
    @Path("findUser")
    @Consumes({"application/xml", "application/json"})
    public Users findUsername (@QueryParam("username") String username) {
        Users user = (Users) em.createNamedQuery("Users.findByUsername")
                .setParameter("username", username)               
                .getSingleResult();
        return user;
    }
    
    
    @GET
    @Path("findById")
    @Consumes({"application/xml", "application/json"})
    public List<Users> findById(@QueryParam("id") Integer id) {        
        List<Users> user = (List<Users>) em.createNamedQuery("Users.findById")
                .setParameter("id", id)               
                .getResultList();
        
        if (user.isEmpty()) {
            return null;
        }     
        return user;
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
