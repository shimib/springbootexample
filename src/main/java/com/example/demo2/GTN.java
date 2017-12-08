package com.example.demo2;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GTN {

    private final int numberToGuess = ((int) (Math.random() * 100)) + 1;
    @RequestMapping(value="/guess", method = RequestMethod.POST, consumes = "text/plain")
    public String guess(@RequestBody  String numberString) {
        int number = Integer.parseInt(numberString);
        return (number > numberToGuess) ? "Too large" :
                (number < numberToGuess) ? "Too small" :
                        "You got it";
    }


}
