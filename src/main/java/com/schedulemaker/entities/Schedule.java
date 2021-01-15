package com.schedulemaker.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView
    private long userId;
    @JsonView
    private int hour;
    @JsonView
    private String activity;
    @JsonView
    private int day; // day of the week (0-6)
}
