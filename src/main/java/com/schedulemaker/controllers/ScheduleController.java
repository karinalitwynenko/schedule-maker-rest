package com.schedulemaker.controllers;

import com.schedulemaker.entities.Schedule;
import com.schedulemaker.services.ScheduleService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;

@RestController
@AllArgsConstructor(access = PACKAGE)
public class ScheduleController {
    @NonNull
    private final ScheduleService scheduleService;

    @GetMapping("/schedules/{username}")
    public List<Schedule> getByUsername(@PathVariable("username") String username) {
        return scheduleService.getByUsername(username);
    }

    @PostMapping("/schedules")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/schedules")
    public Schedule updateSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable("id") long id) {
        scheduleService.deleteSchedule(id);
    }

}
