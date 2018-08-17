package com.wen.mall.control;

import com.wen.mall.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/message")
public class MessageController {
    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    /*@Autowired
    private MessageSender messageSender;*/

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public void send(){
        logger.info("开始发送消息...");
        /*messageSender.send();*/
    }


}
