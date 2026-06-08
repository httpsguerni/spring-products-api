package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // controle REST (converte p/ JSON)
@RequestMapping("/produtos") //Define a URL base. Todos os endpoints dessa classe começam com /produtos
public class ProdutoController {
    //chamada de funções

    //cria e instancia esse objeto pra mim automaticamente
    @Autowired
    private ProdutoService service;

    @GetMapping // GET /produtos
    public List<Produto> listar(){return service.listar();}

    @PostMapping //POST /produtos
    //@RequestBody => Pega o corpo da requisição (o JSON que você envia) e converte automaticamente para o objeto "Produto"
    //@Valid => Realiza a validação do campo
    public Produto criar (@Valid @RequestBody Produto p){return service.salvar(p);}

    @PutMapping("/{id}")//PUT /produtos/{id}
    //@PathVariable => pega o valor que está na URL. ex: /PUT /produtos/5 (5)
    public Produto atualizar (@PathVariable Long id, @Valid @RequestBody Produto p){
        p.setId(id);
        return service.salvar(p);
    }

    @DeleteMapping("/{id}") //DELETE /produtos/{id]
    public void deletar(@PathVariable Long id){service.deletar(id);}

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id){return service.buscarPorId(id);}
}
