package com.raphasantos.cursomc.DTO;

import com.raphasantos.cursomc.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = -1954242865756889773L;

    private Long id;
    private String name;

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        name = obj.getName();
    }
}
