package com.maggioni.webservice;

import com.maggioni.bean.BidService;
import com.maggioni.model.Bid;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bid")
@Stateless
public class BidRestService {
    
    @EJB
    BidService bidService;
    
   
    @GET
    @Path("/getBid")
    @Produces(MediaType.APPLICATION_JSON)
    public Bid getBid(@QueryParam("id") Long id) {       
        return bidService.getBid(id);
    }
}
