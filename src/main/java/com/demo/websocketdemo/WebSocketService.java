/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.websocketdemo;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.atmosphere.config.service.WebSocketHandlerService;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.util.SimpleBroadcaster;
import org.atmosphere.websocket.WebSocket;
import org.atmosphere.websocket.WebSocketHandlerAdapter;

/**
 *
 * @author rev
 */
@WebSocketHandlerService(path = "/data-socket", broadcaster = SimpleBroadcaster.class)
public class WebSocketService extends WebSocketHandlerAdapter{
    static final Logger log = Logger.getLogger(WebSocketService.class);
    
    @Override
    public void onOpen(WebSocket webSocket) throws IOException {
        
            try {
                String method = webSocket.resource().getRequest().getMethod();
                log.info("method ="+method);
                String deviceName = webSocket.resource().getRequest().getHeader("deviceName");
                  webSocket.resource().getRequest().getParameter("deviceName");
                log.info("deviceName  = "+deviceName);
                
                    String broadcaster = "random-data";
                    log.info("Creating a broadcaster for " + broadcaster+" ..");
                    webSocket.resource().setBroadcaster(BroadcasterFactory.getDefault().lookup("/" + broadcaster , true));
                    log.info("Broadcaster creation complete !");
                
            } catch (Exception e) {
                log.error("ChannelWebSocketService : failed with " + e.getMessage());
            }
        

    }
}
