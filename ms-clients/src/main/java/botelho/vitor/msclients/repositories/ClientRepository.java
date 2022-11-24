package botelho.vitor.msclients.repositories;

import botelho.vitor.msclients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCpf(String cpf);

    Integer countByCpfOrEmail(String cpf, String email);

}
