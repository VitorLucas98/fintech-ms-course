package botelho.vitor.msclients.controllers.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
