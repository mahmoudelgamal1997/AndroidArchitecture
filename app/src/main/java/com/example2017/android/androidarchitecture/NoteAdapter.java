package com.example2017.android.androidarchitecture;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example2017.android.androidarchitecture.Room.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M7moud on 26-Mar-19.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    List<Note> notes=new ArrayList<>();
    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);

        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {

        Note currentNote = notes.get(position);
        holder.title.setText(String.valueOf(currentNote.getTitle()));
        holder.descrip.setText(String.valueOf(currentNote.getDescription()));
        holder.priority.setText(String.valueOf(currentNote.getPriority()));

    }

    public void SetNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView title,descrip,priority;

        public NoteHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.text_view_title);
            descrip=itemView.findViewById(R.id.text_view_description);
            priority=itemView.findViewById(R.id.text_view_priority);

        }
    }
}
