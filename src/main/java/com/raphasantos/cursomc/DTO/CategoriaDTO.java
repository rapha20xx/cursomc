package com.raphasantos.cursomc.DTO;

import com.raphasantos.cursomc.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = -1954242865756889773L;

    private Long id;

@NotEmpty(message = "Preenchimento obrigatório")
@Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String name;

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        name = obj.getName();
    }
}
