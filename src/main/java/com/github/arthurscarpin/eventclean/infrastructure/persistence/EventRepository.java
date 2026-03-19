package com.github.arthurscarpin.eventclean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<EventEntity> findByIdentifier(String identifier);
}
