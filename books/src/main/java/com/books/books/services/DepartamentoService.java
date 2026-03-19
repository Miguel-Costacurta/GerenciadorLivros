package com.books.books.services;

import com.books.books.models.DepartamentoModel;
import com.books.books.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){ return departamentoRepository.findAll();}
    public Optional<DepartamentoModel> findById(Long id) {
        return departamentoRepository.findById(id);
    }
    public DepartamentoModel criarDepartamento (DepartamentoModel departamento) { return departamentoRepository.save(departamento); }
    public DepartamentoModel atualizarDepartamento (DepartamentoModel departamento, Long id) {
        DepartamentoModel departamentoAtualizado = departamentoRepository.findById(id).get();
        departamentoAtualizado.setNome(departamento.getNome());
        return departamentoRepository.save(departamentoAtualizado);
    }
    public void deletarDepartamento (Long id) {
        departamentoRepository.deleteById(id);
    }
}
