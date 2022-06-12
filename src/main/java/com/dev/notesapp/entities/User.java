package com.dev.notesapp.entities;
import com.dev.notesapp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Users")


public class User {
    public boolean getPassword;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(UserDto userDto) {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(unique = true)
    private String username;
    @Column
    private String password;


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();
}


