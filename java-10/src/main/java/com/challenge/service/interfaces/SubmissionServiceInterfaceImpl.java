package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionServiceInterfaceImpl implements SubmissionServiceInterface {
    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        if(submissionRepository.findHigherScoreByChallengeId(challengeId)==null)
            return BigDecimal.ZERO;
        return submissionRepository.findHigherScoreByChallengeId(challengeId);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId,accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return submissionRepository.save(object);
    }
}
