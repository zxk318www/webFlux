package com.webflux.demo.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: webflux
 * @description: 用户
 * @author: Zhangxike
 * @create: 2019-09-26 11:10
 **/
@Data
@AllArgsConstructor
@Document
public class User {

    /**
     * 注解属性id为ID
      */
    @Id
    private String id;

    /**
     * 注解属性username为索引，并且不能重复
     */
    @Indexed(unique = true)
    private String username;
    private String name;
    private String phone;
    private Date birthday;
}
