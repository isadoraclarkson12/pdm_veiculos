package com.example.rec_pdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prova1pdm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class listaVeiculos extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private FloatingActionButton fabAddVeiculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos);
        fabAddVeiculo = findViewById(R.id.fabAddVeiculo);
        configurarRecycler();
        this.setupRvVeiculos();
    }

    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.recyclerV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        VeiculoDAO dao = new VeiculoDAO(this);
        adapter = new VeiculoAdapter(dao.buscarTodos());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    private void setupRvVeiculos() {
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private boolean animating = false;
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy < 1 && !this.animating) {
                    this.animating = true;
                    fabAddVeiculo.setVisibility(View.VISIBLE);
                    fabAddVeiculo.animate().alpha(1f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            animating = false;
                        }
                    });
                }
                else if(!this.animating){
                    this.animating = true;
                    fabAddVeiculo.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            fabAddVeiculo.setVisibility(View.GONE);
                            animating = false;
                        }
                    });
                }
            }
        });
    }
    public void onClickAddNewVeiculo(View view) {
        Intent addVeiculoIt = new Intent(this, Cadastro.class);
        startActivity(addVeiculoIt);
    }
}