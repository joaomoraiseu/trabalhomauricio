package com.example.joaopedro.trabalhomauricio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class ListaProdutosActivity extends AppCompatActivity {
    Realm realm;
    ProdutosAdapter adapter;
    ListView listView;
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        Button adicionar = (Button)findViewById(R.id.botaoAdicionar);
        Bundle args = getIntent().getExtras();
        getSupportActionBar().setTitle(args.getString("nomeLista"));
        listView = (ListView)findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setTextFilterEnabled(true);

        //IniciaRealm
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        //get all produtos
        RealmResults<Produto> produtosRealm = realm.where(Produto.class).findAll();
        //Convert RealmResults to ArrayList
        produtos.addAll(realm.copyFromRealm(produtosRealm));

        adapter = new ProdutosAdapter(this,android.R.layout.simple_list_item_checked, produtos);

        listView.setAdapter(adapter);
        adicionar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText editNome = (EditText)findViewById(R.id.produtoNome);
                EditText editQuantidade = (EditText)findViewById(R.id.produtoQuantidade);
                CheckBox checkPerecivel = (CheckBox) findViewById(R.id.checkPerecivel);
                Spinner spinner = (Spinner)findViewById(R.id.categorias);
                String nomeProduto = editNome.getText().toString();
                String categoria =  spinner.getSelectedItem().toString();
                Integer quantidade = 0;
                if(!editQuantidade.getText().toString().isEmpty()) {
                    quantidade = Integer.parseInt(editQuantidade.getText().toString());
                }
                boolean perecivel = checkPerecivel.isChecked();
                Produto p = new Produto(quantidade,nomeProduto,perecivel,categoria);
                produtos.add(p);
                //Chama metódo para salvar o produto
                RealmService.addProduto(p,realm);
                adapter.notifyDataSetChanged();
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
            }

        });

    }

}
