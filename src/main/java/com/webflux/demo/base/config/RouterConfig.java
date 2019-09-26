package com.webflux.demo.base.config;

import com.webflux.demo.base.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @program: webflux
 * @description:
 * @author: Zhangxike
 * @create: 2019-09-25 16:09
 **/
@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter(){
        return route(GET("/time"),timeHandler::getTime)
                .andRoute(GET("/date"),timeHandler::getDate)
                .andRoute(GET("/times"),timeHandler::sendTimePerSec);
    }
}
