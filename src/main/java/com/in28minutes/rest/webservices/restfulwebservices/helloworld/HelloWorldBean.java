package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
//    @Override
//    public String toString() {
//        return "HelloWorldBean{" +
//                "message='" + message + '\'' +
//                ", message1='" + message1 + '\'' +
//                '}';
//    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

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
        this.message1=message;
    }
}
