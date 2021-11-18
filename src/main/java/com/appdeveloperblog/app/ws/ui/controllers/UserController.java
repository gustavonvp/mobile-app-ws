package com.appdeveloperblog.app.ws.ui.controllers;


import com.appdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appdeveloperblog.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {


    Map<UUID, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
                           @RequestParam(value = "sort", required = false) String sort)

    {
        if(sort == null) sort = "desc";
        return "get users was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "{/userId}",  consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

//        UserRest returnValue = new UserRest();
//
//        returnValue.setEmail("test@test.com");
//        returnValue.setFirstName("Gustavo");
//        returnValue.setLastName("dePaula");

        if(true) throw new UserServiceException("A user service exception is thrown");


        if( users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        UUID userId = UUID.randomUUID();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId,returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "{/userId}",  consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable UUID userId, @RequestBody UserDetailRequestModel userDetails) {
            UserRest storedUserDetails = users.get(userId);

            storedUserDetails.setFirstName(userDetails.getFirstName());
            storedUserDetails.setLastName(userDetails.getLastName());

            users.put(userId,storedUserDetails);

            return storedUserDetails;
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.remove(id);
        ResponseEntity.noContent().build();
    }



}
