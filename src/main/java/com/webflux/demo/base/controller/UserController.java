package com.webflux.demo.base.controller;

import com.webflux.demo.base.model.User;
import com.webflux.demo.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: webflux
 * @description:
 * @author: Zhangxike
 * @create: 2019-09-26 14:59
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public Mono<User> save(User user){
        return userService.save(user);
    }

    @DeleteMapping("/{username}")
    public Mono<Long> deleteByUsername(@PathVariable String username){
        return userService.deleteByUsername(username);
    }

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @GetMapping("")
    public Flux<User> findAll(){
        return userService.findAll();
    }
}
