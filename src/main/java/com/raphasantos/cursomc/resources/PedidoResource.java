package com.raphasantos.cursomc.resources;

import com.raphasantos.cursomc.domain.Pedido;
import com.raphasantos.cursomc.domain.Produto;
import com.raphasantos.cursomc.services.PedidoService;
import com.raphasantos.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido obj = pedidoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
