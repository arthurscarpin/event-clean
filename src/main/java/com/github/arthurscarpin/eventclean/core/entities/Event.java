package com.github.arthurscarpin.eventclean.core.entities;

import com.github.arthurscarpin.eventclean.core.enums.TypeEvent;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String name,
        String description,
        String identifier,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        String location,
        Integer capacity,
        String organizer,
        TypeEvent type
) {
}
