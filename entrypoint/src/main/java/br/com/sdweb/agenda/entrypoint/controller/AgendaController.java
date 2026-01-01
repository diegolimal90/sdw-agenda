package br.com.sdweb.agenda.entrypoint.controller;

import br.com.sdweb.agenda.AgendaGateway;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.IncluirAgendaRequest;
import br.com.sdweb.agenda.entrypoint.mapper.IncluiAgendaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaGateway agendaGateway;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> cadastrarAgenda(@Valid @RequestBody IncluirAgendaRequest httpmodel){
        var agenda = agendaGateway.cadastrarAgenda(IncluiAgendaMapper.to(httpmodel));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agenda.getId())
                .toUri()).build();
    }
}
