package com.schedulemaker.entities;

import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
