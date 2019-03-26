package org.ming.api;

import org.ming.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UserController {

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

    @GetMapping("all")
    List<User> all() {
        return client.all();
    }


    @FeignClient("UserService")
    interface HelloClient {
        @RequestMapping(value = "/", method = GET)
        String hello();

        @RequestMapping(value = "/users", method = GET)
        List<User> users();

        @RequestMapping(value = "/all", method = GET)
        List<User> all();
    }

}
