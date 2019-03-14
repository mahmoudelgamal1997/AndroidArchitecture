package com.example2017.android.androidarchitecture.Room;

import android.app.backup.FullBackupDataOutput;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by M7moud on 14-Mar-19.
 */
@Database(entities = {Note.class},version = 1)
public abstract class NoteDataBase extends RoomDatabase {


    public static NoteDataBase instance;
    public abstract NoteDAO noteDAO();

    public static synchronized NoteDataBase getInstace(Context context){

        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteDataBase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }


        return instance;
    }

}
