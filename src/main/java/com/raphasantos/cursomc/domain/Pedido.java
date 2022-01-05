package com.raphasantos.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = -1140257092660893316L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instante;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        super();
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public double getValorTotal(){
        double soma = 0.0;
        for (ItemPedido ip : itens){
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append("Pedido número: ");
        builder.append(getId());
        builder.append(", Instante: ");
        builder.append(sdf.format(getInstante()));
        builder.append(", Nome do cliente: ");
        builder.append(getCliente().getName());
        builder.append(", Situação do Pagamento: ");
        builder.append(getPagamento().getEstado().getDescricao());
        builder.append("\nDetalhes:\n");
        for (ItemPedido ip: getItens()){
            builder.append(ip.toString());
        }
        builder.append("Valor Total: ");
        builder.append(nf.format(getValorTotal()));
        return builder.toString();
    }
}
