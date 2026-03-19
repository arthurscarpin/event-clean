package com.github.arthurscarpin.eventclean.infrastructure.mapper;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.infrastructure.persistence.EventEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EventEntityMapper {

    public static EventEntity fromDomainToEntity(Event domain) {
        return EventEntity.builder()
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

    public static Event fromEntityToDomain(EventEntity entity) {
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getIdentifier(),
                entity.getStartDateTime(),
                entity.getEndDateTime(),
                entity.getLocation(),
                entity.getCapacity(),
                entity.getOrganizer(),
                entity.getType()
        );
    }
}
