package com.example.curd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PresentDetail extends AppCompatActivity {
    ListView listViewTodos ;
    TextView textViewTitle , textViewDescription , exT , exD ;
    ArrayList<Present> arrPresent;
    PresentAdapter adapter;
    int indexTodo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Present present = (Present) getIntent().getSerializableExtra("todo");
        Toast.makeText(this, present.getDescription(), Toast.LENGTH_SHORT).show();
        listViewTodos = findViewById(R.id.listTodo);
        textViewTitle = findViewById(R.id.textView7);
        textViewDescription = findViewById(R.id.textView6);
        exT = findViewById(R.id.cauExample);
        exD = findViewById(R.id.cauExampleDetail);
        textViewTitle.setText(present.getTitle());
        textViewDescription.setText(present.getDescription());
        arrPresent = new ArrayList<>();
        adapter = new PresentAdapter(this , R.layout.row_todo , arrPresent);
        listViewTodos.setAdapter(adapter);
    }
    public void resertValue(){
        textViewTitle.setText("");
        textViewDescription.setText("");
    }
    public void addTodo(View view){
        Present newPresent = new Present(exT.getText().toString() , exD.getText().toString());
        arrPresent.add(newPresent);
        adapter.notifyDataSetChanged();
    }
    public void handleBack(View view){
        finish();
    }
}