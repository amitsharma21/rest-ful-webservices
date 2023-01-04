package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello world !!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        HelloWorldBean obj=new HelloWorldBean("Hello World");
        return obj;
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldVariableBean( @PathVariable String name){
        return new HelloWorldBean("hello world "+ name);
    }

    @GetMapping("/hello-world-internationalization")
    public String helloWorldInternationalized(){
        Locale locale =LocaleContextHolder.getLocale();
        System.out.println(locale);
        return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
//        return "Hello -world";
    }
}
