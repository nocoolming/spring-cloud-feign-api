package org.ming.api;

import org.ming.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class UserClientApplication {
    @Autowired
    HelloClient client;

    @RequestMapping("/")
    public String hello() {
        return client.hello();
    }

    @GetMapping("users")
    List<User> users() {
        return client.users();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);

    }

    @FeignClient("UserService")
    interface HelloClient {
        @RequestMapping(value = "/", method = GET)
        String hello();

        @RequestMapping(value = "/users", method = GET)
        List<User> users();
    }


}
