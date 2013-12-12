/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.websocketdemo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
//import org.atmosphere.cpr.BroadcasterListenerAdapter;
//import org.atmosphere.cpr.BroadcasterListenerAdapter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author rev
 */
@Path("data-ws")
public class DataService {
    
    static final Logger log = Logger.getLogger(DataService.class);
    
    @GET
    @Path("/{keyName}")
    @Produces("application/json")
    public String hello(){
        return "hello";
    }
    
    @GET
    @Path("/numbers")
    public Response triggerRandomdata(){
        
        double[][] d = new double[2][2];
        
        d[0][0] = 1;
        d[0][1] = 2;
        d[1][0] = 3;
        d[1][1] = 4;
        
        broadcastToOpenWebSocket(d, "random-data");
        return Response.status(Response.Status.OK).entity("random data triggered").build();
    }
    
    private void broadcastToOpenWebSocket(Object objToBeWritten, String socketName) {       
            log.info("In broadcastToOpenWebSocket");
            ObjectMapper mapper = new ObjectMapper();
            Broadcaster x = BroadcasterFactory.getDefault().lookup("/" + socketName);
            
            log.info("Finished searching the broadcaster.");
            try {
                log.info("In try of broadcastToOpenWebSocket");
                if (x != null) {
                    log.info("found the broadcaster with "+x.getID());
                    Future f = null;
                    if (objToBeWritten instanceof String) {
                        x.broadcast(objToBeWritten);
                        log.info("broadcasting done : "+f.isDone());
                    } else {
//                        x.addBroadcasterListener(new BroadcasterListenerAdapter(){
//                            @Override    
//                            public void onComplete(Broadcaster b) {
//                                log.info("finished broadcast");
//                            }
//
//                        }).broadcast(mapper.writeValueAsString(objToBeWritten));
                        
                        f = x.broadcast(mapper.writeValueAsString(objToBeWritten));
                        log.info("broadcasting done : "+f.isDone());
                    }
                }else{
                    log.error("Could not find a broadcaster with "+socketName);
                }
            } catch (Exception e) {
                log.error("broadcastValues() : failed with " + e.getMessage());
            }
        
    }
    
    
    @POST
    @Path("/devices")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response newDevice(Device newDevice){
        
        
        
        broadcastToNodeJS(newDevice);
        
        
        return Response.status(Response.Status.OK).entity("random data triggered").build();
    }

    private void broadcastToNodeJS(Device device) {
        try {
            ObjectMapper deviceMapper = new ObjectMapper();
            String newDevice = deviceMapper.writeValueAsString(device);
            
            String nodeUrl = "http://localhost:3000/devices";
            
            Client client = Client.create();
            ClientResponse response = null;
            WebResource webResource = null;
            
            webResource = client.resource(nodeUrl);
            response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, newDevice);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
}
