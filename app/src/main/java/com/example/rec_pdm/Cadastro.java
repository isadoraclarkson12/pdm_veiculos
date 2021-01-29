package com.example.rec_pdm;

import android.content.Intent;
import android.os.Bundle;

import com.example.prova1pdm.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Spinner dropdown = findViewById(R.id.spin_categorias);
        String[] items = new String[]{"Sedan", "SUV", "Camionete", "Hatch","Motocicleta"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Button btnHoje = (Button) findViewById(R.id.btnHoje);
        Button btnSalvar = (Button) findViewById(R.id.btnAddRegistro);
        Button btnVoltar = (Button) findViewById(R.id.btn_Voltar);
        EditText edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        EditText edtData = (EditText) findViewById(R.id.edtData);
        EditText edtValor = (EditText) findViewById(R.id.edtValor);
        //ao clicar insere a data de hoje
        btnHoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date dataHoraAtual = new Date();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                edtData.setText(data);
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Cadastro.this, MainActivity.class);
                startActivity(it);
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //verifica se campos estão vazios antes de salvar
                if(!edtData.getText().toString().isEmpty() && !edtDescricao.getText().toString().isEmpty() && !edtValor.getText().toString().isEmpty()){
                    VeiculoDAO dao = new VeiculoDAO(getBaseContext());
                    boolean sucesso = dao.salvar(edtDescricao.getText().toString(), dropdown.getSelectedItem().toString(), edtData.getText().toString(),Float.parseFloat(edtValor.getText().toString()));
                if(sucesso){
                    Toast.makeText(getApplicationContext(), "Dados inseridos com sucesso.", Toast.LENGTH_LONG).show();
                    Intent itVisualiza = new Intent(Cadastro.this, listaVeiculos.class);
                    startActivity(itVisualiza);
                }else{
                    Toast.makeText(getApplicationContext(), "Erro ao inserir no banco de dados.", Toast.LENGTH_LONG).show();
                }
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos antes de prosseguir.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }
}