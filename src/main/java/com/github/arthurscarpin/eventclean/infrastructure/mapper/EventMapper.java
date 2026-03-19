package com.github.arthurscarpin.eventclean.infrastructure.mapper;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.infrastructure.dto.EventDTO;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class EventMapper {

    public static EventDTO fromDomainToDTO(Event domain) {
        return EventDTO.builder()
                .id(domain.id())
                .name(domain.name())
                .description(domain.description())
                .identifier(domain.identifier())
                .startDateTime(domain.startDateTime())
                .endDateTime(domain.endDateTime())
                .location(domain.location())
                .capacity(domain.capacity())
                .organizer(domain.organizer())
                .type(domain.type())
                .build();
    }

    public static Event fromDTOToDomain(EventDTO dto) {
        return new Event(
                dto.id(),
                dto.name(),
                dto.description(),
                UUID.randomUUID().toString(),
                dto.startDateTime(),
                dto.endDateTime(),
                dto.location(),
                dto.capacity(),
                dto.organizer(),
                dto.type()
        );
    }

}
