package org.ming.api;

import org.ming.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @PostMapping("create")
    User create(User user) {
        return client.create(user);
    }


    @FeignClient("UserService")
    interface HelloClient {
        @RequestMapping(value = "/", method = GET)
        String hello();

        @RequestMapping(value = "/users", method = GET)
        List<User> users();

        @RequestMapping(value = "/all", method = GET)
        List<User> all();

        @RequestMapping(value = "/create", method = POST)
        User create(@RequestBody User user);
    }

}
