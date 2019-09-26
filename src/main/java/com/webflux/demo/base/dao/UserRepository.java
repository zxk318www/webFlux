package com.webflux.demo.base.dao;

import com.webflux.demo.base.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @program: webflux
 * @description:
 * @author: Zhangxike
 * @create: 2019-09-26 14:47
 **/
public interface UserRepository extends ReactiveCrudRepository<User,String> {
    Mono<User> findByUsername(String username);
    Mono<Long> deleteByUsername(String username);
}
