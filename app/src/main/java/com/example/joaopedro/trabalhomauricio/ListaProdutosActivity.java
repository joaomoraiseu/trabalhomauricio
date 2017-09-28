package com.example.joaopedro.trabalhomauricio;

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

public class ListaProdutosActivity extends AppCompatActivity {

    ProdutosAdapter adapter;
    ListView listView;
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
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
        adapter = new ProdutosAdapter(this,android.R.layout.simple_list_item_checked, listaProdutos);
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
                listaProdutos.add(p);
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
