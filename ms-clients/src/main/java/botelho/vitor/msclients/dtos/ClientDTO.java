package botelho.vitor.msclients.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    private Long id;

    @CPF(message = "invalid CPF")
    private String cpf;

    @NotBlank(message = "'name' field cannot be empty")
    private String name;

    @Email(message = "invalid Email")
    private String email;

    @Positive(message = "Age cannot be a negative number")
    private Integer age;
}
