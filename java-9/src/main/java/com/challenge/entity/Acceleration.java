package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=100)
    @Column(name="name",length = 100)
    private String  name;

    @NotNull
    @Size(max=50)
    @Column(name="slug",length = 50)
    private String  slug;

    @Column(name="created_at")
    @CreatedDate
    @NotNull
    private Timestamp creadAt;

    @ManyToOne
    @JoinColumn(name="challenge_id")
    private Challenge challenge;

    @OneToMany
    private Set<Candidate> candidates;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {

    }

    public void setCreadAt(Timestamp creadAt) {
        this.creadAt = creadAt;
    }

    public Timestamp getCreadAt() {
        return creadAt;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

}
