package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mapping.model.SpELExpressionEvaluator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT max(submission.score) "+
            "FROM Submission submission "+
            "JOIN submission.id.challenge challenge "+
            "WHERE challenge.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query("select submission "+
            "FROM Submission submission "+
            "INNER JOIN Acceleration acceleration "+
            "ON submission.id.challenge.id = acceleration.challenge.id "+
            "where submission.id.challenge.id = :challengeId and acceleration.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);
}
