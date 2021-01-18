package com.schedulemaker.auth.date;

import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateServiceConfig {

    @Bean
    DateService dateService() {
        return new DateService(defaultTimeZone());
    }

    @Bean
    DateTimeZone defaultTimeZone() {
        return DateTimeZone.UTC;
    }
}