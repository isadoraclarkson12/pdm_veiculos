package com.example.rec_pdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private final String TABLE_VEICULOS = "Veiculos";
    private DbGateway gw;

    public VeiculoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }
    public boolean salvar(String descricao, String categoria, String data, float valor){
        ContentValues cv = new ContentValues();
        cv.put("Descricao", descricao);
        cv.put("Categoria", categoria);
        cv.put("Data", data);
        cv.put("Valor", valor);
        return gw.getDatabase().insert(TABLE_VEICULOS, null, cv) > 0;
    }
    public List<Veiculo> buscarTodos(){
        List<Veiculo> veiculos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Veiculos", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String descricao = cursor.getString(cursor.getColumnIndex("Descricao"));
            String categoria = cursor.getString(cursor.getColumnIndex("Categoria"));
            String data = cursor.getString(cursor.getColumnIndex("Data"));
            float valor = cursor.getFloat(cursor.getColumnIndex("Valor"));
            veiculos.add(new Veiculo(id, descricao, categoria, data, valor));
        }
        cursor.close();
        return veiculos;
    }
}
