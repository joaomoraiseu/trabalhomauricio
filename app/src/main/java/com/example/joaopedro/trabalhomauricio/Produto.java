package com.example.joaopedro.trabalhomauricio;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Joao Pedro on 16/09/2017.
 */

public class Produto extends RealmObject {
    @PrimaryKey
    private Integer Id;
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
    public Produto(){

    }
    public void addRecord(Produto produto ,Context contexto) {
        Realm realm;
        Realm.init(contexto);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(produto);
        realm.commitTransaction();
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

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
