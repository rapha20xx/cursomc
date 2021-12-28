package com.raphasantos.cursomc.DTO;

import com.raphasantos.cursomc.domain.Cliente;
import com.raphasantos.cursomc.services.validation.ClienteUpdate;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 2528800389740673207L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty
    @Email(message = "Preenchimento obrigatório")
    private String email;

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
