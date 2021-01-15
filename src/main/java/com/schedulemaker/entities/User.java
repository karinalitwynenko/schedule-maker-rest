package com.schedulemaker.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
