//package com.rest.webservices.restfulwebservices.user;
//
//import java.util.List;
//import java.net.URI;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//
//import javax.validation.Valid;
//
//@RestController
//public class UserResource {
//    @Autowired
//    private UserDaoService service;
//
//    @GetMapping("/users")
//    public List<User> retrieveAllUsers(){
//        return service.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id) {
//        User user = service.findOne(id);
//
//        if(user==null)
//            throw new UserNotFoundException("id-"+ id);
//
//
//        //"all-users", SERVER_PATH + "/users"
//        //retrieveAllUsers
//        EntityModel<User> resource = EntityModel.of(user);
//
//        WebMvcLinkBuilder linkTo =
//                linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//        resource.add(linkTo.withRel("all-users"));
//
//        //HATEOAS
//
//        return resource;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id){
//        User user =  service.deleteById(id);
//        if(user==null)
//            throw new UserNotFoundException("id-"+ id);
//    }
//
//
//    @PostMapping("/users")
//    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
//        User savedUser = service.save(user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
//        return ResponseEntity.created(location).build();
//
//    }
//}
