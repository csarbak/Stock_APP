package com.wiley.schoolJPA.controller;

import com.wiley.schoolJPA.dao.UserRepo;
import com.wiley.schoolJPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> allUsers() {
        return userRepo.findAll();
        //return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

 User user = userRepo.findById(id).orElse(null);
        return userRepo.findById(id).orElseThrow(RuntimeException::new);
//        if (user == null) {
//            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<User>(user, HttpStatus.OK);
//        }
    }

    @PostMapping("/add")

    public ResponseEntity addNewUser(@RequestBody User user) throws URISyntaxException {
        User savedClient = userRepo.save(user);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
        //return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok().build();
        //return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User client) {
        User currentClient = userRepo.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setfName(client.getfName());
        currentClient.setlName(client.getlName());
        currentClient.setPriceMax(client.getPriceMax());
        currentClient = userRepo.save(client);

        return ResponseEntity.ok(currentClient);
//        if(!userRepo.existsById(user.getId())){
//            return new ResponseEntity<User>(user, HttpStatus.FORBIDDEN);
//        }
//        userRepo.save(user);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
