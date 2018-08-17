/*
package com.wen.mall.listener;

import com.wen.mall.message.SocketSessionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

public class STOMPConnectEventListener implements ApplicationListener<SessionConnectedEvent> {

    @Autowired
    SocketSessionRegistry socketSessionRegistry;

    @Override
    public void onApplicationEvent(SessionConnectedEvent sessionConnectedEvent) {
        StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(sessionConnectedEvent.getMessage());
        //login get from browser
        String agentId = stompHeaderAccessor.getNativeHeader("login").get(0);
        String sessionId = stompHeaderAccessor.getSessionId();
        socketSessionRegistry.registerSessionId(agentId,sessionId);
    }
}
*/
