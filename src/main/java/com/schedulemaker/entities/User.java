package com.schedulemaker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView
    private String login;
    @JsonView
    private String email;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Schedule> scheduleSet;

}
