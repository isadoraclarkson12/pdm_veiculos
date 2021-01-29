package com.example.rec_pdm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prova1pdm.R;
public class VeiculoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public TextView categoria;
    public TextView descricao;
    public ImageView btnVisualizar;
    private ItemList<Veiculo> veiculoItemList;
    private VeiculoAdapter adapter;

    public VeiculoViewHolder(View itemView, VeiculoAdapter adapter) {
        super(itemView);
        this.adapter = adapter;
        this.categoria = (TextView) itemView.findViewById(R.id.txtCategoria);
        this.btnVisualizar = (ImageView) itemView.findViewById(R.id.imgDetalhes);
        this.descricao = (TextView) itemView.findViewById(R.id.txtDescricao);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        this.descricao.setOnClickListener(this);
        this.btnVisualizar.setOnClickListener(this);
    }
    public void bind(ItemList<Veiculo> veiculoItemList) {
        this.categoria.setText(veiculoItemList.item.getCategoria());
        this.descricao.setText(veiculoItemList.item.getDescricao()+"\n"+veiculoItemList.item.getValor());
        this.descricao.setVisibility(veiculoItemList.expanded ? View.VISIBLE : View.GONE);
        itemView.setSelected(veiculoItemList.selected);
        this.veiculoItemList = veiculoItemList;
    }
    private void toggle() {
        int visibility = (veiculoItemList.expanded) ? View.GONE : View.VISIBLE;
        veiculoItemList.expanded = !veiculoItemList.expanded;
        this.descricao.setVisibility(visibility);
    }
    @Override
    public void onClick(View v) {
       if(v == this.btnVisualizar) {
            if (this.adapter.getOnClickSeeDetailsListener() != null) {
                this.adapter.getOnClickSeeDetailsListener().onClickSeeDetails(veiculoItemList.item);
            }
        }
        else {
            this.toggle();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
