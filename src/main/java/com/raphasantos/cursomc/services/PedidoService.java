package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Pedido;
import com.raphasantos.cursomc.repositories.PedidoRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
