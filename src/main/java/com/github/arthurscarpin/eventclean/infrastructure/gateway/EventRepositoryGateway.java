package com.github.arthurscarpin.eventclean.infrastructure.gateway;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.core.gateway.EventGateway;
import com.github.arthurscarpin.eventclean.infrastructure.mapper.EventEntityMapper;
import com.github.arthurscarpin.eventclean.infrastructure.mapper.EventMapper;
import com.github.arthurscarpin.eventclean.infrastructure.persistence.EventEntity;
import com.github.arthurscarpin.eventclean.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repository;

    @Override
    public Event save(Event event) {
        EventEntity domain = EventEntityMapper.fromDomainToEntity(event);
        EventEntity newEvent = repository.save(domain);
        return EventEntityMapper.fromEntityToDomain(newEvent);
    }

    @Override
    public Event findByIdentifier(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(EventEntityMapper::fromEntityToDomain)
                .orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll().stream()
                .map(EventEntityMapper::fromEntityToDomain)
                .toList();
    }
}
