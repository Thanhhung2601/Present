package com.example.curd_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewTodos ;
    TextView textViewTitle , textViewDescription ;
    ArrayList<Present> arrPresent;
    PresentAdapter adapter;
    int indexTodo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTodos = findViewById(R.id.listTodo);
        textViewTitle = findViewById(R.id.editTextTextPersonName2);
        textViewDescription = findViewById(R.id.editTextTextPersonName3);
        arrPresent = new ArrayList<>();
        adapter = new PresentAdapter(this , R.layout.row_todo , arrPresent);
        listViewTodos.setAdapter(adapter);
        listViewTodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                indexTodo = i ;
                textViewTitle.setText(arrPresent.get(i).getTitle());
                textViewDescription.setText(arrPresent.get(i).getDescription());
            }
        });
        listViewTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Present findedPresent = arrPresent.get(i) ;
                Intent intent  = new Intent() ;
                intent.setClass(MainActivity.this , PresentDetail.class);
                intent.putExtra("todo" , findedPresent);
                startActivity(intent);
                return false;
            }
        });
    }

    public void resertValue(){
        textViewTitle.setText("");
        textViewDescription.setText("");
    }

    public void addTodo(View view){
        Present newPresent = new Present(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrPresent.add(newPresent);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void updateTodo(View view){
        Present newPresent = new Present(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrPresent.set(indexTodo, newPresent);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void deleteTodo(View view){
        arrPresent.remove(indexTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

}