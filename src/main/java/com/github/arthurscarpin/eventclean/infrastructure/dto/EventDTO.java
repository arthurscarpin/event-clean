package com.github.arthurscarpin.eventclean.infrastructure.dto;

import com.github.arthurscarpin.eventclean.core.enums.TypeEvent;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventDTO(
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
