package com.example.demo.service;

import com.example.demo.exception.ProdutoNotFoundException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
 //cria as funções
    @Autowired
    private ProdutoRepository repository;
    public List<Produto> listar(){return repository.findAll();}
    public Produto salvar (Produto p){return repository.save(p);}
    public void deletar (Long id){repository.deleteById(id);}
    public Produto buscarPorId(Long id) {return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));}
}
