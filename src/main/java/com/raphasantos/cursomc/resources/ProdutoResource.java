package com.raphasantos.cursomc.resources;

import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.domain.Produto;
import com.raphasantos.cursomc.services.CategoriaService;
import com.raphasantos.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
