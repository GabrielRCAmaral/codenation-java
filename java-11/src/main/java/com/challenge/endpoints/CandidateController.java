package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.entity.User;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Candidate findById(@PathVariable("userId") Long userId,@PathVariable("companyId") Long companyId, @PathVariable("accelerationId")Long accelerationId){
        return this.candidateService.findById(userId,companyId,accelerationId).isPresent()?this.candidateService.findById(userId,companyId,accelerationId).get():new Candidate();
    }

    @GetMapping
    public List<Candidate> findByCompanyIdOrAccelerationId(@RequestParam(required = false,name="companyId")Long companyId, @RequestParam(required = false,name="accelerationId")Long accelerationId){
        List<Candidate> list = Optional.ofNullable(companyId).isPresent() ? this.candidateService.findByCompanyId(companyId)
                : (Optional.ofNullable(accelerationId).isPresent() ? this.candidateService.findByAccelerationId(accelerationId)
                : new ArrayList<>());
        return list;
    }
}
