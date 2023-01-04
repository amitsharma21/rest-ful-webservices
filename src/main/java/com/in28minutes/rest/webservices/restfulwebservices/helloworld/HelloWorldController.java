package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
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
}
