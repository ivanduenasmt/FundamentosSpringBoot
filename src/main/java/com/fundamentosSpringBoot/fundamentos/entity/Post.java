package com.fundamentosSpringBoot.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    private Uzer uzer;

    public Post() {
    }

    public Post(String description, Uzer user) {
        this.description = description;
        this.uzer = uzer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uzer getUser() {
        return uzer;
    }

    public void setUser(Uzer user) {
        this.uzer = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", uzer=" + uzer +
                '}';
    }
}