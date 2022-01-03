package me.anamila.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NewNotesActivity extends AppCompatActivity {
    SharedPreferences pref;
    Gson gson;
    ArrayList<Notes>notesList;
    EditText edtJudul, edtCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        pref = this.getSharedPreferences(getString(R.string.shared_key), Context.MODE_PRIVATE);
        gson = new GsonBuilder().create();

        edtJudul = findViewById(R.id.edtJudul);
        edtCatatan = findViewById(R.id.edtContent);
    }
    public void saveNotes(View view){
        String strListNotes = pref.getString(getString(R.string.notes_key),"[]");
        notesList = gson.fromJson(strListNotes, new TypeToken<ArrayList<Notes>>(){}.getType());
        if(notesList==null) {
            notesList = new ArrayList<>();
        }
        notesList.add(new Notes(edtJudul.getText().toString(),edtCatatan.getText().toString()));

        strListNotes = gson.toJson(notesList);
        pref.edit().putString(getString(R.string.notes_key), strListNotes).apply();

        finish();
    }
    public void cancle(View view){
        finish();
    }
}