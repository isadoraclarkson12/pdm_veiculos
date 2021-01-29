package com.example.rec_pdm;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prova1pdm.R;

import java.util.List;

public class VeiculoAdapter  extends RecyclerView.Adapter<VeiculoViewHolder> {
    private final List<Veiculo> veiculos;
    public VeiculoAdapter(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    @Override
    public VeiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VeiculoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlista_style, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VeiculoViewHolder holder, int position) {
        holder.categoria.setText(veiculos.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return veiculos != null ? veiculos.size() : 0;
    }
}
