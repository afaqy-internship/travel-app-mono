package com.afaqy.internship.flightbooking.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FlightConfiguration {

    public FlightConfiguration() {
        log.info("Starting Flight Module");
    }

}
