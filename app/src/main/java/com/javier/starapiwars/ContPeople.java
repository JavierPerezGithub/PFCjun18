package com.javier.starapiwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.javier.starapiwars.models.People;
import com.javier.starapiwars.models.PeopleRespuesta;
import com.javier.starapiwars.models.Planet;
import com.javier.starapiwars.retrofitUtils.RestServiceStarWars;
import com.javier.starapiwars.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContPeople extends AppCompatActivity {
    private final static String TAG = "tag";
    private RecyclerView rv;
    private ArrayList<People> list;
    private AdapterPeople adapterPeople;
    private LinearLayoutManager llm;
    private int cont;
    private boolean aptoParaCargar;
    private String numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_people);
        numero = "";

        if (list == null) {
            list = new ArrayList<>();
            rv = findViewById(R.id.rvPeople);
            adapterPeople = new AdapterPeople(this, list);
            rv.setAdapter(adapterPeople);
            rv.setHasFixedSize(true);
            llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            adapterPeople.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AdapterPeople.MiViewHolder adapter = (AdapterPeople.MiViewHolder) rv.getChildViewHolder(v);
                    adapter.getNombre();
                    int valor = rv.getChildAdapterPosition(v) + 1;
                    People people = list.get(rv.getChildAdapterPosition(v));
                    //Parte de recuperar el planeta

                    String cadena = people.getHomeworld();
                    Log.v("faltaDato", cadena);
                    try {
                        String dato = cadena.substring(29, 31);
                        if (dato.charAt(1) == '/') {
                            numero = String.valueOf(dato.charAt(0));
                        } else {
                            numero = dato;
                        }
                        recuperarPlaneta(valor, people);
                    } catch (StringIndexOutOfBoundsException e) {
                        Intent intent = new Intent(ContPeople.this, PeopleFinalActivity.class);
                        intent.putExtra("object", people);
                        intent.putExtra("position", valor);
                        startActivity(intent);
                        Log.v("saltoExcepcion", cadena);
                    }


                }
            });
            rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    if (dy > 0) {
                        int visibleItemCount = llm.getChildCount();
                        int totalItemCount = llm.getItemCount();
                        int pastVisibleItems = llm.findFirstVisibleItemPosition();

                        if (aptoParaCargar) {
                            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                                Log.i(TAG, "Llegamos al final.");

                                aptoParaCargar = false;
                                cont += 1;
                                cargaDatos(cont);
                            }
                        }
                    }
                }
            });
            cont = 1;
            aptoParaCargar = true;
            cargaDatos(cont);
        }
    }

    private void recuperarPlaneta(final int valor, final People people) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestServiceStarWars.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestServiceStarWars service = retrofit.create(RestServiceStarWars.class);
        Call<Planet> peopleRespuestaCall = service.obtenerPlaneta(numero);

        peopleRespuestaCall.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {

                if (response.isSuccessful()) {
                    Planet planeta = response.body();
                    people.setHomeworld(planeta.getName());
                    Intent intent = new Intent(ContPeople.this, PeopleFinalActivity.class);
                    intent.putExtra("object", people);
                    intent.putExtra("position", valor);
                    startActivity(intent);

                } else {
                    Log.e("error", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }

    private void cargaDatos(int cont) {

        Retrofit rt = RetrofitClient.getClient(RestServiceStarWars.BASE_URL);
        final RestServiceStarWars service = rt.create(RestServiceStarWars.class);
        Call<PeopleRespuesta> peopleRespuestaCall = service.obtenerListaPeople(cont);

        peopleRespuestaCall.enqueue(new Callback<PeopleRespuesta>() {
            @Override
            public void onResponse(Call<PeopleRespuesta> call, Response<PeopleRespuesta> response) {
                aptoParaCargar = true;
                if (response.isSuccessful()) {
                    PeopleRespuesta peopleRespuesta = response.body();
                    ArrayList<People> lista = peopleRespuesta.getResults();
                    adapterPeople.addListaPeople(lista);

                } else {
                    Log.e("error", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<PeopleRespuesta> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}
