package com.example2017.android.androidarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example2017.android.androidarchitecture.Room.Note;

public class add_note extends AppCompatActivity {

    EditText editText_title;
    EditText editText_description;
    NumberPicker picker_priority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();

        }

        return super.onOptionsItemSelected(item);
    }


    private void saveNote(){

         editText_title=(EditText)findViewById(R.id.edit_text_title);
         editText_description=(EditText)findViewById(R.id.edit_text_description);
         picker_priority=(NumberPicker) findViewById(R.id.number_picker_priority);

        String title=editText_title.getText().toString();
        String description=editText_description.getText().toString();
        int priority=picker_priority.getValue();

        Note note=new Note(title,description,priority);
        MainActivity.noteViewMolde.insert(note);

        Toast.makeText(add_note.this, "done", Toast.LENGTH_SHORT).show();
        finish();

    }

}
