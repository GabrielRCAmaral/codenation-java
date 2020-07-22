package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userService.findById(id).get();
    }

    @GetMapping
    public List<User> findByAccelerationNameOrCompanyId(@RequestParam(required = false,name="accelerationName") String nome,@RequestParam(required = false,name="companyId") Long companyId){
        List<User> list = Optional.ofNullable(nome).isPresent() ? this.userService.findByAccelerationName(nome)
                : (Optional.ofNullable(companyId).isPresent() ? this.userService.findByCompanyId(companyId)
                : new ArrayList<>());
        return list;
    }



}
