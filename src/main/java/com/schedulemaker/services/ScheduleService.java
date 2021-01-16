package com.schedulemaker.services;

import com.schedulemaker.entities.Schedule;
import com.schedulemaker.entities.ScheduleRepository;
import com.schedulemaker.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getByUser(long id) {
        return scheduleRepository.findAllByUserId(id);
    }

    public boolean addSchedule(Schedule schedule) {
        Schedule result = scheduleRepository.save(schedule);
        return result.getActivity() != null;
    }
}