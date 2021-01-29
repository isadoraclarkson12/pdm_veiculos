package com.example.rec_pdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prova1pdm.R;

import java.util.List;

public class VeiculoAdapter extends RecyclerView.Adapter<VeiculoViewHolder> {
    private final List<Veiculo> veiculos;
    private OnClickSeeDetailsListener listener;
    public VeiculoAdapter(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    public interface OnClickSeeDetailsListener {
        void onClickSeeDetails(Veiculo veiculo);
    }
    @Override
    public VeiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.itemlista_style, parent, false);
        VeiculoViewHolder veiculoViewHolder = new VeiculoViewHolder(itemView, this);
        return veiculoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VeiculoViewHolder holder, int position) {
        holder.categoria.setText(veiculos.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return veiculos != null ? veiculos.size() : 0;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    public OnClickSeeDetailsListener getOnClickSeeDetailsListener() {
        return listener;
    }
    public OnClickSeeDetailsListener getListener() {
        return listener;
    }
    public void setOnClickSeeDetailsListener(OnClickSeeDetailsListener listener) {
        this.listener = listener;
    }
}
