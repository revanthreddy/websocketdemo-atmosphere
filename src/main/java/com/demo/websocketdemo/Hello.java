/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.websocketdemo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.logging.Level;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author rev
 */
public class Hello {
    public static void main(String[] args){
        Device device = new Device();
       
        
        device.setDeviceName("hello");
         try {
            ObjectMapper deviceMapper = new ObjectMapper();
            String newDevice = deviceMapper.writeValueAsString(device);
            String username = "rev@ni.com";
            String nodeUrl = "http://localhost:3000/"+username+"/devices";
            
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
