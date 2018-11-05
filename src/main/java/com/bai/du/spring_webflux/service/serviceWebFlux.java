package com.bai.du.spring_webflux.service;

import com.bai.du.spring_webflux.pojo.user;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class serviceWebFlux {
    public static Map<String,user> mapOne=new HashMap<String,user>();
    static{
        mapOne.put("1",new user("张1",15,"女",1));
        mapOne.put("2",new user("张2",15,"男",2));
        mapOne.put("3",new user("张3",15,"女",3));
        mapOne.put("4",new user("张4",15,"男",4));
        mapOne.put("5",new user("张5",15,"女",5));
        mapOne.put("6",new user("张6",15,"男",6));
        mapOne.put("7",new user("张7",15,"女",7));
    }

    /**
     * 模拟查询所有用户
     * @return
     */
    public static Flux<user> findAll(){
        Collection<user> values = serviceWebFlux.mapOne.values();
        return Flux.fromIterable(values);
    }
    /**
     *模拟查询一个特定用户
     */
    public static Mono<user> findOne(String id){
        user user = serviceWebFlux.mapOne.get(id);
        return Mono.just(user);
    }
    /**
     * 模拟删除一个用户
     */
    public static Mono<user> delOne(String id){
        user user = serviceWebFlux.mapOne.remove(id);
        return Mono.just(user);
    }

}
