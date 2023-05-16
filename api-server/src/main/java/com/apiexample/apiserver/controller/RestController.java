package com.apiexample.apiserver.controller;

import com.apiexample.apiserver.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String to,@RequestParam String subject,@RequestParam String body)
    {

        Boolean isSuccess  = MailService.sendMail("","",to,subject,body);

        if(isSuccess)
             return String.format("Mail send Successfully to %s with subject %s and body %s",to,subject,body);
        else
             return String.format("Failed to send Email");
    }

}
