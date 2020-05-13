package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    private CandidateId id;

    @NotNull
    @Column(name="status")
    private Long status;

    @Column(name="created_at")
    @CreatedDate
    @NotNull
    private Timestamp creadAt;



    public Long getStatus() {
        return status;
    }

    public void setCreadAt(Timestamp creadAt) {
        this.creadAt = creadAt;
    }

    public Timestamp getCreadAt() {
        return creadAt;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
