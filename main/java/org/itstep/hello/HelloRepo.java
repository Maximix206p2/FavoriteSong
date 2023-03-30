package org.itstep.hello;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

public class HelloRepo {
    //Data
    private static List<Hello> list = new LinkedList<>();
    {
        list.add(new Hello());
    }

    public List<Hello> hello(){
        return list;
    }

    public Hello helloName(String name) {
        Hello hello = new Hello("Hello ", name);
        list.add(hello);
        return hello;
    }

    //Post
    public void addHello(String message, String name){
        Hello hello = list.get((int) id);
        hello.setName(name);
    }

    //Put
    public void changeName(long id, String name){
        Hello hello = list.get((int) id);
        hello.setName(name);
    }

    //Delete
    public void deleteName(long id){
        Hello hello = list.get((int) id);
        hello.setName("world");
    }
}
