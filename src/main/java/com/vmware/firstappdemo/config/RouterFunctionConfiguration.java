package com.vmware.firstappdemo.config;

import com.vmware.firstappdemo.domain.User;
import com.vmware.firstappdemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;


/**
 * 路由器函数 配置
 */

@Configuration
public class RouterFunctionConfiguration {

    // 定义GET请求，返回所有用户对象
    // Flux 是 0 - N 个对象集合
    // Mono 是 0 - 1 个对象集合
    // Reactive 中的 Flux 或者 Mono 他是异步处理（非阻塞）
    // 集合对象基本上是同步处理（阻塞）
    // Flux 或 Mono 都是 Publisher
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    // 返回所有的用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
        });
    }
}
