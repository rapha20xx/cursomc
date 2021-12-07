package com.raphasantos.cursomc.resources;

import com.raphasantos.cursomc.domain.Cidade;
import com.raphasantos.cursomc.domain.Estado;
import com.raphasantos.cursomc.services.CidadeService;
import com.raphasantos.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll(){
        List<Cidade> list = cidadeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id){
        Cidade obj = cidadeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
