package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class userResource {
    private  UserDaoService service;

    public userResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User>retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user=service.findOne(id);
        if(user==null){
            //created the custom exception to handle uesr not found
            throw new UserNotFoundException("id: "+id);
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user ){
        User savedUser=service.save(user);
        // in this step we created the location URI : http://localhost:8080/users/{id}
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();//we appended the id dynamically at given uri http://localhost:8080/{id}
        return ResponseEntity.created(location).build();// we added location header inside the ResponseEntity and returned back response Entity
    }
}
