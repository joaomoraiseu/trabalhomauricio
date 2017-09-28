package com.example.joaopedro.trabalhomauricio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joao Pedro on 16/09/2017.
 */

public class ProdutosAdapter extends ArrayAdapter<Produto> {

    Context contexto;
    ArrayList<Produto> produtos;

    public ProdutosAdapter(Context context, int resource,
                       ArrayList<Produto> objects){
        super(context, resource, objects);
        this.contexto = context;
        this.produtos = objects;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent){
        View linhaView = LayoutInflater.from(contexto)
                .inflate(R.layout.adapterprodutos, parent, false);

        TextView quantidade = (TextView)linhaView.
                findViewById(R.id.quantidade);

        TextView nomeProduto = (TextView)linhaView.
                findViewById(R.id.nomeProduto);

        TextView nomeCategoria = (TextView)linhaView.
                findViewById(R.id.nomeCategoria);

        CheckBox perecivel = (CheckBox) linhaView.
                findViewById(R.id.checkCategoria);

        quantidade.setText(produtos.get(position).getQuantidade().toString());

        nomeProduto.setText(produtos.get(position).getNome());

        nomeCategoria.setText(produtos.get(position).getCategoria());

        perecivel.setChecked(produtos.get(position).isPerecivel());

        return linhaView;

    }
}
