package com.wiley.schoolJPA.controller;

import com.wiley.schoolJPA.dao.PersonRepo;
import com.wiley.schoolJPA.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/persons")
    public List<Person> allPersons() {
        return personRepo.findAll();
        //return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {

 Person person = personRepo.findById(id).orElse(null);
        return personRepo.findById(id).orElseThrow(RuntimeException::new);
//        if (person == null) {
//            return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<Person>(person, HttpStatus.OK);
//        }
    }

    @PostMapping("/add")

    public ResponseEntity addNewPerson(@RequestBody Person person) throws URISyntaxException {
        Person savedClient = personRepo.save(person);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
        //return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Integer id) {
        personRepo.deleteById(id);
        return ResponseEntity.ok().build();
        //return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity updatePerson(@PathVariable int id, @RequestBody Person client) {
        Person currentClient = personRepo.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setfName(client.getfName());
        currentClient.setlName(client.getlName());
        currentClient.setPriceMax(client.getPriceMax());
        currentClient = personRepo.save(client);

        return ResponseEntity.ok(currentClient);
//        if(!personRepo.existsById(person.getId())){
//            return new ResponseEntity<Person>(person, HttpStatus.FORBIDDEN);
//        }
//        personRepo.save(person);
//        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
