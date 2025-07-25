package com.anoxi.controller;

import com.anoxi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/welcome")
    public String welcomeMsg(){
        String welcomeMsg = messageService.welcomeMsg();

        String formattedMsg = null;

        if (welcomeMsg != null && !welcomeMsg.equals("")) {
            formattedMsg = welcomeMsg.toUpperCase();
        }

        return formattedMsg;
    }
}
