package com.example.demo2;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Demo2Application {
   /* @Bean
    public ViewResolver hbViewResolver() {
        HandlebarsViewResolver vr = new HandlebarsViewResolver();
        vr.setPrefix("templates/");
        //vr.getHandlebars().set
        return vr;
    }
*/
    // @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public ExecutorService getES() {
        return Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
}
