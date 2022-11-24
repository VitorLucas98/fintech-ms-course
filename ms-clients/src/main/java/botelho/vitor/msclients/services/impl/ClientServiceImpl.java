package botelho.vitor.msclients.services.impl;

import botelho.vitor.msclients.dtos.ClientDTO;
import botelho.vitor.msclients.entities.Client;
import botelho.vitor.msclients.repositories.ClientRepository;
import botelho.vitor.msclients.services.ClientService;
import botelho.vitor.msclients.services.exceptions.CpfOrEmailAlreadyRegisteredException;
import botelho.vitor.msclients.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ClientRepository repository;

    private final ModelMapper modelMapper;

    @Override
    public ClientDTO insert(ClientDTO client) {
        if (repository.countByCpfOrEmail(client.getCpf(), client.getEmail()) > 0){
            throw new CpfOrEmailAlreadyRegisteredException("CPF or email already registered in the database");
        }
        var entity = modelMapper.map(client, Client.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, ClientDTO.class);
    }

    @Override
    public ClientDTO findByCpf(String cpf) {
        var client = repository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return modelMapper.map(client, ClientDTO.class);
    }
}
