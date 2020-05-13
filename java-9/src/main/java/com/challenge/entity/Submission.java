package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @NotNull
    @Column(name="score")
    private float score;

    @Column(name="created_at")
    @CreatedDate
    @NotNull
    private Timestamp creadAt;

    public void setId(SubmissionId id) {
        this.id = id;
    }

    public SubmissionId getId() {
        return id;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public Timestamp getCreadAt() {
        return creadAt;
    }

    public void setCreadAt(Timestamp creadAt) {
        this.creadAt = creadAt;
    }

}
