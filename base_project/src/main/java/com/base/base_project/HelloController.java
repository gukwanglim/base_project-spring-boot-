package com.base.base_project;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.base.base_project.model.User;
import com.base.base_project.repositroy.UserRepositroy;

@RestController
public class HelloController {

    @Autowired
    private UserRepositroy userRepositroy;
    
    @GetMapping("/hello/{id}")
    public User getUser(@PathVariable int id) {
        User user = userRepositroy.findById(id)
            .orElseThrow(new Supplier<IllegalArgumentException>() {
                @Override
                public IllegalArgumentException get() {
                    return new IllegalArgumentException("해당 유저는 존재하지 않습니다. id : " + id);
                }
            });
        
        return user;
    }
}
