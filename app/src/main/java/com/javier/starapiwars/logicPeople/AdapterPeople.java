package com.javier.starapiwars.logicPeople;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.javier.starapiwars.models.People;
import com.javier.starapiwars.R;
import java.util.ArrayList;

/**
 * Created by Javier on 09/04/2018.
 */

public class AdapterPeople extends RecyclerView.Adapter<AdapterPeople.MiViewHolder> implements View.OnClickListener {
    private ArrayList<People> datos;
    private View.OnClickListener listener;
    private Context context;

    public AdapterPeople(Context context, ArrayList<People> list) {
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
        holder.nombre.setText(datos.get(position).getName().toLowerCase());
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
            nombre.setTypeface(Typeface.createFromAsset(view.getContext().getAssets(), "fonts/starjout.ttf"));
        }
    }public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}