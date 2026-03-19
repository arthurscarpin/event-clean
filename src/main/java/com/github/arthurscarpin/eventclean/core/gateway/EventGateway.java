package com.github.arthurscarpin.eventclean.core.gateway;

import com.github.arthurscarpin.eventclean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event save(Event event);

    Event findByIdentifier(String identifier);

    List<Event> findAll();
}
