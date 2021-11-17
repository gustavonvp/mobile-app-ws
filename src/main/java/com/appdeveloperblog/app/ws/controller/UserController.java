package com.appdeveloperblog.app.ws.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {


    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
                           @RequestParam(value = "sort", required = false) String sort)

    {
        if(sort == null) sort = "desc";
        return "get users was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "{/userId}")
    public String getUser(@PathVariable String userId) {
        return "get user was called with user id = " + userId;
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return  "updated user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }



}
