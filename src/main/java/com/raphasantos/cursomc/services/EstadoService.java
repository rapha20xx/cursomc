package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.domain.Estado;
import com.raphasantos.cursomc.repositories.EstadoRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public Estado findById(Long id){
        Optional<Estado> obj = estadoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }
}
