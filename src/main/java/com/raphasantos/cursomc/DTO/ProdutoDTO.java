package com.raphasantos.cursomc.DTO;

import com.raphasantos.cursomc.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1705036612227669996L;

    private Long id;
    private String name;
    private Double preco;

    public ProdutoDTO(Produto obj){
        id= obj.getId();
        name = obj.getName();
        preco = obj.getPreco();
    }

}
