package com.schedulemaker.services;

import com.schedulemaker.entities.Schedule;
import com.schedulemaker.entities.ScheduleRepository;
import com.schedulemaker.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getByUsername(String username) {
        return scheduleRepository.findAllByUsername(username);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(long id) {
        scheduleRepository.deleteById(id);
    }
}