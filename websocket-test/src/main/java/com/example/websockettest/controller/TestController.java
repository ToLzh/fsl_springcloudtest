package com.example.websockettest.controller;

import com.example.websockettest.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TestController {

    @Autowired
    WebSocket webScoket;


    // 每个5秒 轮询一次   秒 分 时 日 月 周 年  至少6个
    @Scheduled(cron = "*/5 * * * * ?")
    public void show() {
        System.out.println("11111111");
        if (null == webScoket.electricSocketMap.get("1")) {
            System.out.println("无连接");
        }else {
            for(Session session : webScoket.electricSocketMap.get("1")){
                if (session == null) {
                    return;
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = df.format(new Date());
                webScoket.onMessage(date,session);
            }
        }

    }

}
