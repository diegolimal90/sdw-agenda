package br.com.sdweb.agenda.entrypoint.controller;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.EventResponse;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.ResponseHttpModel;
import br.com.sdweb.agenda.entrypoint.mapper.AgendaMapper;
import br.com.sdweb.agenda.in.EventIn;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.SaveEventRequest;
import br.com.sdweb.agenda.entrypoint.mapper.IncluiAgendaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/event")
@RequiredArgsConstructor
public class AgendaController {

    private final EventIn saveEvent;
    private final EventIn findEvent;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> saveEvent(@Valid @RequestBody SaveEventRequest httpmodel){
        var agenda = saveEvent.saveEvent(IncluiAgendaMapper.to(httpmodel));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agenda.getId())
                .toUri()).build();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseHttpModel<EventResponse>> findAllEvent(){
        var agendas = findEvent.findEventAll();
        ResponseHttpModel<EventResponse> responseHttpModel = ResponseHttpModel.<EventResponse>builder()
                .status("Request Success.")
                .code(HttpStatus.OK.value())
                .timestamp(System.currentTimeMillis())
                .data(agendas
                        .stream()
                        .map(AgendaMapper::from)
                        .toList()
                )
                .build();
        return ResponseEntity.ok(responseHttpModel);
    }
}
