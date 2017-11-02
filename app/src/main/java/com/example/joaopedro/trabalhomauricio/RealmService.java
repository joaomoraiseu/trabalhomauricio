package com.example.joaopedro.trabalhomauricio;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by William Cézar on 01/11/2017.
 */

public class RealmService {

    public static  void addProduto(Produto produto , Realm realm) {
        int id =(int)realm.where(Produto.class).count() +1;
        produto.setId(id);
        realm.beginTransaction();
        realm.copyToRealm(produto);
        realm.commitTransaction();

    }
}
