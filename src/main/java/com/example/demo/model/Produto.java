package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;

@Entity // Diz ao spring que a classe é uma tabela
@Table(name = "produtos") // define o nome da tabela no banco
public class Produto {

    @Id //Define que a variavel id eh chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o banco gera o id automaticamente (auto increment)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private Double preco;

    //get and set

    public Long getId(){return id;}
    public void setId(Long newId){ this.id = newId;}

    public String getNome(){return nome;}
    public void setNome(String newName) {this.nome = newName;}

    public Double getPreco(){return preco;}
    public void setPreco(Double newPreco){this.preco = newPreco;}



}
