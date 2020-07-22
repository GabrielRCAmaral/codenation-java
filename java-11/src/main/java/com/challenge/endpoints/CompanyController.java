package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.impl.CompanyService;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id){
        return this.companyService.findById(id).get();
    }

    @GetMapping
    public List<Company> findByAccelerationIdOrUserId(@RequestParam(required = false,name="accelerationId") Long accelerationId,@RequestParam(required = false,name="userId") Long userId){
        List<Company> list = Optional.ofNullable(accelerationId).isPresent() ? this.companyService.findByAccelerationId(accelerationId)
                : (Optional.ofNullable(userId).isPresent() ? this.companyService.findByUserId(userId)
                : new ArrayList<>());
        return list;
    }
}
