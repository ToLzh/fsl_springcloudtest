package com.example.websockettest.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{pageCode}")
public class WebSocket {
    private static final String loggerName=WebSocket.class.getName();

    public static Map<String, List<Session>> electricSocketMap = new ConcurrentHashMap<String, List<Session>>();

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("pageCode") String pageCode, Session session) {
        System.out.println("test===============");
        List<Session> sessions = electricSocketMap.get(pageCode);
        if(null==sessions){
            List<Session> sessionList = new ArrayList<>();
            sessionList.add(session);
            electricSocketMap.put(pageCode,sessionList);
        }else{
            sessions.add(session);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("pageCode") String pageCode,Session session) {
        if (electricSocketMap.containsKey(pageCode)){
            electricSocketMap.get(pageCode).remove(session);
        }
    }

    /**
     * 发送消息
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session) {
        try {
            session.getBasicRemote().sendText("这是推送测试数据！您刚发送的消息是："+message);
        } catch (IOException e) {
            System.out.println("连接已关闭");
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
    }


}
