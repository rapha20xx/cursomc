package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.DTO.ClienteDTO;
import com.raphasantos.cursomc.domain.Cliente;
import com.raphasantos.cursomc.repositories.ClienteRepository;
import com.raphasantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert (Cliente obj){
        obj.setId(null);
        return clienteRepository.save(obj);
    }

    public Cliente update (Cliente obj){
      Cliente newObj = findById(obj.getId());
      updateData(newObj, obj);
        return clienteRepository.save(obj);
    }

    public void delete (Long id){
        findById(id);
        try {
            clienteRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível excluir por que há entidades relacionadas");
        }
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDTO){
       return new Cliente(objDTO.getId(), objDTO.getName(), objDTO.getEmail(),null, null);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setId(obj.getId());
        newObj.setName(obj.getName());
    }
}
