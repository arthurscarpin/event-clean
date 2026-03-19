package com.github.arthurscarpin.eventclean.core.usecases;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.core.exception.ResourceNotFoundException;
import com.github.arthurscarpin.eventclean.core.gateway.EventGateway;

public class SearchByIdentifierUseCaseImpl implements SearchByIdentifierUseCase {

    private final EventGateway gateway;

    public SearchByIdentifierUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(String identifier) {
        Event event = gateway.findByIdentifier(identifier);
        if (event == null) {
            throw new ResourceNotFoundException("Event with identifier: " + identifier + " not found");
        }
        return event;
    }
}
