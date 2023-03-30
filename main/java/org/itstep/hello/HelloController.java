package org.itstep.hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//MVC, MVVC
@RestController
public class HelloController {

    private static HelloRepo helloRepo = new HelloRepo();

    //Endpoint
    @GetMapping("/hello")
    public List<Hello> hello(){
        return helloRepo.hello();
    }

    //localhost:8080/hello/world
    @GetMapping("/hello/{name}")
    public Hello helloName(@PathVariable String name) {
        return helloRepo.helloName(name);
    }

    //localhost:8080/привет/мир
    @GetMapping("/{hello}/{name}")
    public Hello helloR(@PathVariable String hello, @PathVariable String name) {
        return new Hello(hello, name);
    }

    //localhost:8080/hello2?message=привет&name=мир
    @GetMapping("/hello2")
    public Hello helloP(@RequestParam String message, @RequestParam String name) {
        return new Hello(message, name);
    }

    @PostMapping("/hello") //REST
    @ResponseStatus(HttpStatus.CREATED)
    public void changeName(@RequestBody Hello hello){
        helloRepo.changeName(hello.getId(), hello.getName());
    }
    //@RequestHeader - тоже используется

    @DeleteMapping("/hello/{id}")
    public void deleteName(@PathVariable long id){
        helloRepo.deleteName(id);
    }
}