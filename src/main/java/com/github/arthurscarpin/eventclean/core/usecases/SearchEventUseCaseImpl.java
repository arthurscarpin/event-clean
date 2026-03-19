package com.github.arthurscarpin.eventclean.core.usecases;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.core.gateway.EventGateway;

import java.util.List;

public class SearchEventUseCaseImpl implements SearchEventUseCase {

    private final EventGateway gateway;

    public SearchEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Event> execute() {
        return gateway.findAll();
    }
}
