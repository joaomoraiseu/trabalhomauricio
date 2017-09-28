package com.example.joaopedro.trabalhomauricio;

import java.util.ArrayList;

/**
 * Created by Joao Pedro on 16/09/2017.
 */

public class Produto {
    private Integer Quantidade;
    private String Nome;
    private boolean Perecivel;
    private String Categoria;

    public Produto(ListaProdutosActivity listaProdutosActivity, int simple_list_item_checked, ArrayList<Produto> produtos) {
    }

    public Produto(int quantidade, String nome, boolean perecivel, String categoria) {
        Quantidade = quantidade;
        Nome = nome;
        Perecivel = perecivel;
        Categoria = categoria;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public boolean isPerecivel() {
        return Perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        Perecivel = perecivel;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
