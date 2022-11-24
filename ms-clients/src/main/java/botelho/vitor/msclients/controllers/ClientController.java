package botelho.vitor.msclients.controllers;

import botelho.vitor.msclients.dtos.ClientDTO;
import botelho.vitor.msclients.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/clients")
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> insertClient(@RequestBody @Valid ClientDTO clientDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(clientDTO.getCpf()).toUri();
        clientDTO = service.insert(clientDTO);
        return ResponseEntity.created(uri).body(clientDTO);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<ClientDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf));
    }
}
