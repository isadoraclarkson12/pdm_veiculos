package com.example.rec_pdm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prova1pdm.R;
public class VeiculoViewHolder extends RecyclerView.ViewHolder{
    public TextView categoria;
    public ImageView btnVisualizar;

    public VeiculoViewHolder(View itemView) {
        super(itemView);
        this.categoria = (TextView) itemView.findViewById(R.id.txtCategoria);
        this.btnVisualizar = (ImageView) itemView.findViewById(R.id.imgDetalhes);

    }
}
