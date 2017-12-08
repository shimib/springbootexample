package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private MessageDAO dao;

    @RequestMapping(value="hello", method= RequestMethod.POST, consumes = "application/json")
    public String hello(@RequestBody Message m) {

        dao.save(m);

        System.out.println("JSON: " + m.getMsg());
        dao.flush();
        List<Message> msgs = dao.findAll();
        System.out.println("COUNT: " + msgs.size());
        return "<html><body><h1>HELLO WORLD</h1></body></html>";
    }

}
