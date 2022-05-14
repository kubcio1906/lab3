package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@Controller
public class UsersController {
    @Autowired
    UserService userService;




    @RequestMapping("/api/users/{id}")
    @ResponseBody
    public UserEntity getOneUser(@PathVariable int id){


        return userService.getOne(id);
    }


    @RequestMapping(
            value = "/api/user/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity createUser(@RequestBody UserEntity user) {userService.create(user);

        return user;
    }

    @RequestMapping(
            value = "/api/users/{id}/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public UserEntity updateUser(@RequestBody UserEntity user,@PathVariable int id) {userService.update(id,user);

        return user;
    }

    @RequestMapping("/api/users/{id}/remove")
    @ResponseBody
    public String delete(@PathVariable int id){


        return userService.delete(id);
    }
    @RequestMapping("/api/users")
    @ResponseBody
    public HashMap<Integer,UserEntity> showAll(){

    return userService.showAll();

    }

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public InfoEntity show(@RequestParam  int pageNumber,@RequestParam int pageSize) {


        return userService.show(pageNumber,pageSize);
    }
//localhost:8080/api/users/?pageNumber=1&pageSize=20



}
