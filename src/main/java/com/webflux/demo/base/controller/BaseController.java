package com.webflux.demo.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: webflux
 * @description:
 * @author: Zhangxike
 * @create: 2019-09-25 15:53
 **/
@RestController
public class BaseController {

    @GetMapping("/index")
    public Mono<String> index(){
        return Mono.just("This is a WebFlux project");
    }
}
