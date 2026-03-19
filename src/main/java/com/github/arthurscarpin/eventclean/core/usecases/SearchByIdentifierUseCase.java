package com.github.arthurscarpin.eventclean.core.usecases;

import com.github.arthurscarpin.eventclean.core.entities.Event;

public interface SearchByIdentifierUseCase {

    Event execute(String identifier);
}
