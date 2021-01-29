package com.example.rec_pdm;

import android.os.Parcelable;

public class Veiculo implements Comparable<Veiculo> {
    private int id;
    private String descricao;
    private String categoria;
    private float valor;
    private String data;

    public Veiculo(int id, String descricao, String categoria, String data, float valor){
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    @Override
    public boolean equals(Object o){
        return this.id == ((Veiculo)o).id;
    }

    @Override
    public int hashCode(){
        return this.id;
    }

    // -------------------------------- COMPARABLE IMPLEMENTATION

    @Override
    public int compareTo(Veiculo o) {
        String c1  = this.getDescricao();
        String c2= o.getDescricao();
        return c1.compareToIgnoreCase(c2);
    }


}
