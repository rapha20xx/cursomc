package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.domain.Produto;
import com.raphasantos.cursomc.repositories.CategoriaRepository;
import com.raphasantos.cursomc.repositories.ProdutoRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }
}
