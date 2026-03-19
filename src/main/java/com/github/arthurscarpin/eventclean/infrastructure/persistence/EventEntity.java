package com.github.arthurscarpin.eventclean.infrastructure.persistence;

import com.github.arthurscarpin.eventclean.core.enums.TypeEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String organizer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEvent type;
}
