package com.github.arthurscarpin.eventclean.infrastructure.beans;

import com.github.arthurscarpin.eventclean.core.gateway.EventGateway;
import com.github.arthurscarpin.eventclean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway gateway) {
        return new CreateEventUseCaseImpl(gateway);
    }

    @Bean
    public SearchEventUseCase searchEventUseCase(EventGateway gateway) {
        return new SearchEventUseCaseImpl(gateway);
    }

    @Bean
    public SearchByIdentifierUseCase searchByIdentifierUseCase(EventGateway gateway) {
        return new SearchByIdentifierUseCaseImpl(gateway);
    }
}
