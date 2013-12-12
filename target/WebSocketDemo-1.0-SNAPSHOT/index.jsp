<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="jquery/jquery-2.0.3.js"></script>
        <script type="text/javascript" src="jquery/jquery.atmosphere.js"></script>
        
        <script type=text/javascript>
            

$(document).ready(function(){
            webSocketCode();
    
});

//setInterval(function(){
//    displayChannelData();
//}, 1000);

function webSocketCode(){
    var socket = $.atmosphere;
     /*Websocket code*/
    var request = { url: '/WebSocketDemo/data-socket' ,
        contentType : "application/json",
        method : 'POST',
        data : "deviceName=device1" ,
        transport : 'websocket'
        };
    
    
    
    request.onOpen = function(response) {
//        content.html($('<p>', { text: 'Atmosphere connected using ' + response.transport }));
//        input.removeAttr('disabled').focus();
//        status.text('Choose name:');
            //alert('conn opened');
    };

    request.onMessage = function (response) {
        
        var message = response.responseBody;
        $("#random").append("<p> "+message+" </p>");
        //alert(message);
    };

    request.onClose = function(response) {        
        logged = false;
    }

    request.onError = function(response) {
//        content.html($('<p>', { text: 'Sorry, but there\'s some problem with your '
//            + 'socket or the server is down' }));
            console.log('failed with '+response);
    };
    
    socket.subscribe(request);
}


            
        </script>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="random"></div>
    </body>
</html>
