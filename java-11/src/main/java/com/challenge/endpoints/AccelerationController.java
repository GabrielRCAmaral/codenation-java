package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    AccelerationService accelerationService;

    @GetMapping("/{id}")
    public Acceleration findById(@PathVariable("id") Long id){
        return this.accelerationService.findById(id).get();
    }

    @GetMapping()
    public List<Acceleration> findByCompanyId(@RequestParam(required = false,name="companyId") Long companyId){
        return this.accelerationService.findByCompanyId(companyId);
    }


}
