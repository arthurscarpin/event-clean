package com.github.arthurscarpin.eventclean.core.usecases;

import com.github.arthurscarpin.eventclean.core.entities.Event;

import java.util.List;

public interface SearchEventUseCase {

    List<Event> execute();
}
