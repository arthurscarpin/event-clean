package com.github.arthurscarpin.eventclean.infrastructure.presentation;

import com.github.arthurscarpin.eventclean.core.entities.Event;
import com.github.arthurscarpin.eventclean.core.usecases.CreateEventUseCase;
import com.github.arthurscarpin.eventclean.core.usecases.SearchByIdentifierUseCase;
import com.github.arthurscarpin.eventclean.core.usecases.SearchEventUseCase;
import com.github.arthurscarpin.eventclean.infrastructure.dto.EventDTO;
import com.github.arthurscarpin.eventclean.infrastructure.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventUseCase;

    private final SearchEventUseCase searchEventUseCase;

    private final SearchByIdentifierUseCase searchByIdentifierUseCase;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> save(@RequestBody EventDTO request) {
        Event event = createEventUseCase.execute(EventMapper.fromDTOToDomain(request));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Event saved successfully into database");
        response.put("eventData", EventMapper.fromDomainToDTO(event));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EventDTO>> findAll() {
        List<Event> events = searchEventUseCase.execute();
        return ResponseEntity.ok(events.stream().map(EventMapper::fromDomainToDTO).toList());
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<EventDTO> findByIdentifier(@PathVariable String identifier) {
        Event event = searchByIdentifierUseCase.execute(identifier);
        return ResponseEntity.ok(EventMapper.fromDomainToDTO(event));
    }
}
