package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceInterfaceImpl implements ChallengeServiceInterface {
    @Autowired
    ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerationsIdAndSubmissions_Id_UserId(accelerationId,userId);
    }

    @Override
    public Challenge save(Challenge object) {
        return challengeRepository.save(object);
    }
}
