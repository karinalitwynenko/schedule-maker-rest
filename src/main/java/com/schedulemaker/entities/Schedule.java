package com.schedulemaker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView
    private String username;
    @JsonView
    private int hour;
    @JsonView
    private String activity;
    @JsonView
    private int day; // day of the week (0-6)

    @ManyToOne
    @JoinColumn(name="username", referencedColumnName="username", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

}
