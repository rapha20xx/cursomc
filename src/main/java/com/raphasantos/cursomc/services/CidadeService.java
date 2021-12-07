package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.domain.Cidade;
import com.raphasantos.cursomc.domain.Estado;
import com.raphasantos.cursomc.repositories.CidadeRepository;
import com.raphasantos.cursomc.repositories.EstadoRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    public Cidade findById(Long id){
        Optional<Cidade> obj = cidadeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
    }
}
