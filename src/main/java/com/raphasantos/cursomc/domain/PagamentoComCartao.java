package com.raphasantos.cursomc.domain;

import com.raphasantos.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = -2612024439359791134L;

    private Integer NumeroDeParcelas;

    public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido , Integer numeroDeParcelas) {
        super(id, estado, pedido);
        NumeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return NumeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        NumeroDeParcelas = numeroDeParcelas;
    }
}
