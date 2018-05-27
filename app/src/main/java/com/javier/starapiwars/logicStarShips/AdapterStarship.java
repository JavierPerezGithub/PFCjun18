package com.javier.starapiwars.logicStarShips;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javier.starapiwars.R;
import com.javier.starapiwars.models.Starship;

import java.util.ArrayList;

public class AdapterStarship extends RecyclerView.Adapter<AdapterStarship.MiViewHolder> implements View.OnClickListener {
    private ArrayList<Starship> datos;
    private View.OnClickListener listener;
    private Context context;

    public AdapterStarship(Context context, ArrayList<Starship> list) {
        this.context = context;
        datos = list;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_people, parent, false);
        v.setOnClickListener(this);
        MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {

        holder.nombre.setText(datos.get(position).getName());
    }

    @Override
    public int getItemCount() {

        return datos.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        public TextView getNombre() {
            return nombre;
        }

        public MiViewHolder(View view) {
            super(view);
            nombre = view.findViewById(R.id.tvItemNomPeople);
        }
    }public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}