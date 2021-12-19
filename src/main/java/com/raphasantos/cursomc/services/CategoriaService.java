package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.DTO.CategoriaDTO;
import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.repositories.CategoriaRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert (Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update (Categoria obj){
        findById(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete (Long id){
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public Page<Categoria>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }
    public Categoria fromDTO(CategoriaDTO objDTO){
        return new Categoria(objDTO.getId(), objDTO.getName());
    }
}
