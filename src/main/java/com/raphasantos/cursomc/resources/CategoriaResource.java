package com.raphasantos.cursomc.resources;

import com.raphasantos.cursomc.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @GetMapping
    public List<Categoria> listando(){
        Categoria cat1 = new Categoria(1L,"Informática");
        Categoria cat2 = new Categoria(2L,"Escritŕio");

        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }

}
