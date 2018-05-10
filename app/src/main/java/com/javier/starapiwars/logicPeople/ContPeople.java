package com.javier.starapiwars.logicPeople;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.javier.starapiwars.Objects.FirebaseReferences;
import com.javier.starapiwars.R;
import com.javier.starapiwars.models.People;

import java.util.ArrayList;

public class ContPeople extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<People> list;
    private ArrayList<People> busqueda;
    private AdapterPeople adapterPeople;
    private LinearLayoutManager llm;
    private Spinner spinner;
    private int opcion;
    private EditText etBusqueda;
    private Button btnBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_people);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseReferences.PEOPLE_REFERENCE);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.removeAll(list);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    People people = snapshot.getValue(People.class);
                    list.add(people);
                }
                adapterPeople.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        opcion = 0;
        btnBusqueda = findViewById(R.id.btnBusquedaP);
        etBusqueda = findViewById(R.id.etBusquedaP);
        spinner = findViewById(R.id.spFiltroP);
        String[] contenido = {"Name", "Homeworld"};
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, contenido));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        opcion = 0;
                        break;

                    case 1:
                        opcion = 1;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etBusqueda.getText().toString().length() != 0) {
                    String dato = etBusqueda.getText().toString().trim();
                    if (busqueda == null) {
                        busqueda = new ArrayList<>();
                    }
                    if (busqueda.size() != 0 || busqueda != null) {
                        busqueda.removeAll(busqueda);
                    }

                    switch (opcion) {

                        case 0:
                            String name = "";
                            String sSubPeople = "";
                            int tamDato = dato.length();
                            busqueda.removeAll(busqueda);

                            for (int i = 0; i < list.size(); i++) {
                                name = list.get(i).getName();
                                try {
                                    sSubPeople = name.substring(0, tamDato);
                                    if (sSubPeople.equalsIgnoreCase(dato)) {
                                        busqueda.add(list.get(i));
                                    }
                                } catch (StringIndexOutOfBoundsException e) {

                                }

                            }
                            if (busqueda.size() == 0) {
                                Toast.makeText(ContPeople.this, "Name not found", Toast.LENGTH_LONG).show();
                            } else {
                                adapterPeople = new AdapterPeople(ContPeople.this, busqueda);
                                rv.setAdapter(adapterPeople);
                                adaptador(busqueda);
                            }
                            break;

                        case 1:
                            String planet = "";
                            String sSubPlanet = "";
                            int tDato = dato.length();
                            busqueda.removeAll(busqueda);
                            for (int i = 0; i < list.size(); i++) {

                                planet = list.get(i).getHomeworld();
                                try {
                                    sSubPlanet = planet.substring(0, tDato);
                                    if (sSubPlanet.equalsIgnoreCase(dato)) {
                                        busqueda.add(list.get(i));
                                    }
                                } catch (StringIndexOutOfBoundsException e) {

                                }

                            }
                            if (busqueda.size() == 0) {
                                Toast.makeText(ContPeople.this, "Planet not found", Toast.LENGTH_LONG).show();
                            } else {
                                adapterPeople = new AdapterPeople(ContPeople.this, busqueda);
                                rv.setAdapter(adapterPeople);
                                adaptador(busqueda);
                            }
                            break;
                    }
                }else{
                    Toast.makeText(ContPeople.this,"the field cannot be left empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        list = new ArrayList<>();
        rv = findViewById(R.id.rvPeople);
        adapterPeople = new AdapterPeople(this, list);
        rv.setAdapter(adapterPeople);
        rv.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adaptador(list);
    }

    private void adaptador(final ArrayList<People> list) {
        adapterPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdapterPeople.MiViewHolder adapter = (AdapterPeople.MiViewHolder) rv.getChildViewHolder(v);
                adapter.getNombre();
                People people = list.get(rv.getChildAdapterPosition(v));
                Intent intent = new Intent(ContPeople.this, PeopleFinalActivity.class);
                intent.putExtra("object", people);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            spinner.setVisibility(View.VISIBLE);
            etBusqueda.setVisibility(View.VISIBLE);
            btnBusqueda.setVisibility(View.VISIBLE);


        } else if (item.getItemId() == R.id.action_exit) {
            crearDialogo().show();
        }
        return (true);
    }

    @SuppressLint("NewApi")
    public void Salida() {
        finishAffinity();
    }

    private Dialog crearDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ContPeople.this);
        builder.setCancelable(false);
        builder.setMessage("DO YOU WANT TO EXIT?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Salida();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
