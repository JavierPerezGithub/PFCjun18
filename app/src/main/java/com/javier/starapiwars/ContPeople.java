package com.javier.starapiwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.javier.starapiwars.Objects.FirebaseReferences;
import com.javier.starapiwars.models.People;

import java.util.ArrayList;

public class ContPeople extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<People> list;
    private AdapterPeople adapterPeople;
    private LinearLayoutManager llm;

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
                People people = list.get(rv.getChildAdapterPosition(v));
                Intent intent = new Intent(ContPeople.this, PeopleFinalActivity.class);
                intent.putExtra("object", people);
                startActivity(intent);
            }
        });
    }
}
