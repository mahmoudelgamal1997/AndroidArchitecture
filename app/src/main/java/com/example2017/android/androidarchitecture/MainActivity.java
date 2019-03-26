package com.example2017.android.androidarchitecture;

import android.app.ActionBar;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example2017.android.androidarchitecture.Room.Note;
import com.example2017.android.androidarchitecture.Room.NoteViewMolde;

import java.util.List;

public class MainActivity extends AppCompatActivity {

 public static    NoteViewMolde noteViewMolde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter noteAdapter=new NoteAdapter();
        recyclerView.setAdapter(noteAdapter);

        noteViewMolde= ViewModelProviders.of(this).get(NoteViewMolde.class);
        noteViewMolde.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {

                noteAdapter.SetNotes(notes);

            }
        });


        FloatingActionButton actionBar=(FloatingActionButton) findViewById(R.id.button_add_note);
        actionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),add_note.class);
                startActivity(intent);
            }
        });


    }


}
