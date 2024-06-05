package com.example.demo.controller;

import com.example.demo.dao.Chat;
import com.example.demo.dao.Message;
import com.example.demo.dao.User;
import com.example.demo.service.Response;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/{id}")
    public Response getUserbyId(@PathVariable String id){
        Response response = Response.newSuccess(userService.getUserById(id));
        return response;
    }
    @GetMapping("/chat/{id}")
    public Response getChatbyId(@PathVariable String id){
        Response response = Response.newSuccess(userService.getChatById(id));
        return response;
    }
    @GetMapping("/message/{id}")
    public Response getMessagebyId(@PathVariable String id){
        Response response = Response.newSuccess(userService.getMessageById(id));
        return response;
    }

    @PostMapping("/message/{id}")
    public Response getMessagebyChatid(@PathVariable String id){
        Response response = Response.newSuccess(userService.getMessageByChat(id));
        return response;
    }
    @PostMapping("/chat/{id}")
    public Response getChatbyUserid(@PathVariable String id){
        Response response = Response.newSuccess(userService.getChatByUser(id));
        System.out.println(id);
        return response;
    }
    @PostMapping("/user")
    public Response addUser(@RequestBody User registRequest){
        boolean isCreate = userService.addNewUser(registRequest);
        if (isCreate){
            return Response.newSuccess("create successfully");

        }
        else return Response.newFail("fail to create");
    }
    @PostMapping("/chat")
    public Response addChat(@RequestBody Chat registRequest){
        boolean isCreate = userService.addNewChat(registRequest);
        if (isCreate){
            return Response.newSuccess("create successfully");

        }
        else return Response.newFail("fail to create");

    }
    @PostMapping("/message")
    public Response regist(@RequestBody Message registRequest){
        boolean isCreate = userService.addNewMessage(registRequest);
        if (isCreate){
            return Response.newSuccess("create successfully");

        }
        else return Response.newFail("fail to create");

    }
    @PostMapping("/login")
    public Response loginUser(@RequestBody LoginRequest loginRequest ){
        boolean isAuthenticated = userService.authenticate(loginRequest.getId(),loginRequest.getPassword());

        if(isAuthenticated){
            return Response.newSuccess("success");
        }
        else{
            return Response.newFail("fail");
        }

    }

    @DeleteMapping("/chat/{id}")
    public Response deleteChat(@PathVariable String id){
        boolean isDelete = userService.deleteChat(id);
        if(isDelete){
            return Response.newSuccess("delete success");
        }
        else{
            return Response.newFail("delete fail");
        }

    }

    @PutMapping("/chat/{id}")
    public Response updateChat(@PathVariable String id,@RequestBody Description description){
        Chat updateChat = userService.updateChat(id,description.getDescription());
        return Response.newSuccess(updateChat);

    }

}
