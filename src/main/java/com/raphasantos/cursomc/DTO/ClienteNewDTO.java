package com.raphasantos.cursomc.DTO;

import com.raphasantos.cursomc.services.validation.ClienteInsert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ClienteInsert
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = -4483699017449160075L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty
    @Email(message = "Preenchimento obrigatório")
    private String email;

    @NotEmpty(message="Preenchimento obrigatório")
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @NotEmpty
    private String senha;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Long cidadeId;
}
