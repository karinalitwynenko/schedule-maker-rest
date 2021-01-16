package com.schedulemaker.controllers;

import com.schedulemaker.entities.Schedule;
import com.schedulemaker.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @CrossOrigin
    @GetMapping("/schedule/{id}")
    public List<Schedule> getByUser(@PathVariable("id") long id) {
        return scheduleService.getByUser(id);
    }

    @CrossOrigin
    @PostMapping("/schedule")
    public boolean addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }
}
