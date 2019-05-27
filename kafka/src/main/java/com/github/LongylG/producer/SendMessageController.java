package com.github.LongylG.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private Producer producer;

    @GetMapping("/send")
    public String send(String value) {
        producer.send(value);
        return "success";
    }

}
