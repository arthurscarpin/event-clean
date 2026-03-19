package com.github.arthurscarpin.eventclean.core.usecases;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.core.exception.DuplicateIdentifierException;
import com.github.arthurscarpin.eventclean.core.gateway.EventGateway;

import java.util.UUID;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway gateway;

    public CreateEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(Event event) {
        Event eventSearch = gateway.findByIdentifier(event.identifier());
        if (eventSearch != null) {
            throw new DuplicateIdentifierException("An event with that identifier already exists: " + event.identifier());
        }
        return gateway.save(event);
    }
}
