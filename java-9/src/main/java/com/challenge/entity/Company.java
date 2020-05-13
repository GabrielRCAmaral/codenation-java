package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=100)
    @Column(name="name",length = 100)
    private String name;

    @NotNull
    @Size(max=50)
    @Column(name="slug",length = 50)
    private String slug;

    @Column(name="created_at")
    @CreatedDate
    @NotNull
    private Timestamp creadAt;

    @OneToMany
    private Set<Candidate> candidates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Timestamp getCreadAt() {
        return creadAt;
    }

    public void setCreadAt(Timestamp creadAt) {
        this.creadAt = creadAt;
    }

}
