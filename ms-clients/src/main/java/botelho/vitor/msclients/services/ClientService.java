package botelho.vitor.msclients.services;

import botelho.vitor.msclients.dtos.ClientDTO;
import org.springframework.stereotype.Service;


public interface ClientService {

    ClientDTO insert(ClientDTO client);

    ClientDTO findByCpf(String cpf);

}
