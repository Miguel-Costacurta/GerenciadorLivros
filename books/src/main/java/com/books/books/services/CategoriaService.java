package com.books.books.services;

import com.books.books.models.CategoriaModel;
import com.books.books.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }
    public Optional<CategoriaModel> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    public CategoriaModel criarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }
    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    public CategoriaModel atualizarCategoria(CategoriaModel categoria, Long id) {
        CategoriaModel categoriaAtualizado = categoriaRepository.findById(id).get();
        categoriaAtualizado.setNome(categoria.getNome());
        return categoriaRepository.save(categoriaAtualizado);

    }

}
