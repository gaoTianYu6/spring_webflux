package com.bai.du.spring_webflux.controller;


import com.bai.du.spring_webflux.pojo.user;
import com.bai.du.spring_webflux.service.serviceWebFlux;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class controllerWebFlux {
    private final serviceWebFlux serviceWebFlux;

    public controllerWebFlux(final serviceWebFlux serviceWebFlux){
        this.serviceWebFlux=serviceWebFlux;
    }


    /**
     * 模拟返回string
     * @return
     */
    @GetMapping("/testOne")
    public Mono<String> testOne(){
        return Mono.just("hello word");
    }
    /**
     * 1模拟返回全部对象
     * 23模拟查询全部用户
     */
    @GetMapping("/testTwo")
    public Flux<user> testTwo(){
        System.out.println("我走了查询全部");
        return serviceWebFlux.findAll();
    }
    /**
     * 模拟返回全部对象
     * 模拟查询全部用户
     * 使用阻塞+流实现响应式测试
     */
    @GetMapping(value="/testThree",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<user> testThree(){
        System.out.println("我走了查询全部");
        return serviceWebFlux.findAll().delayElements(Duration.ofSeconds(2));
    }
    /**
     * 模拟查询一个用户
     */
    @GetMapping("findOne")
    public Mono<user> fondOne(String id){
      return   serviceWebFlux.findOne(id);
    }


    /**
     * 模拟删除一个用户
     */
    @DeleteMapping("delOne")
    public Mono<user> delOne(String id){
        return serviceWebFlux.delOne(id);
    }
}
