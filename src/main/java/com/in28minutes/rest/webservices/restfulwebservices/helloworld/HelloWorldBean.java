package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String message;
    private String message1;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public HelloWorldBean(String message) {
        this.message=message;
    }
}
