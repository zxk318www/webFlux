package com.webflux.demo.base.service;

import com.webflux.demo.base.dao.UserRepository;
import com.webflux.demo.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: webflux
 * @description:
 * @author: Zhangxike
 * @create: 2019-09-26 14:50
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user){
        return userRepository.save(user).onErrorResume(e->userRepository.findByUsername(user.getUsername()))
                .flatMap(originalUser -> {
                    user.setId(originalUser.getId());
                    return userRepository.save(user);}
                    );
    }

    public Mono<Long> deleteByUsername(String username){
        return userRepository.deleteByUsername(username);
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> findAll(){
        return userRepository.findAll();
    }
}

