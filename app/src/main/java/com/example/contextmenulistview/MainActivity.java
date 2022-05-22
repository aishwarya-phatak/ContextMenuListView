package com.example.contextmenulistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewFoodItems;
    ArrayAdapter<String> stringArrayAdapter;
    String [] foodItems = {"Pav bhaji","Vada Pav","Pani Puri","Medu vada"};
    int menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        stringArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,foodItems);
        listViewFoodItems.setAdapter(stringArrayAdapter);
        registerForContextMenu(listViewFoodItems);
    }


    private void initViews()
    {
        listViewFoodItems = findViewById(R.id.listViewFoodItems);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        menuItem = item.getItemId();
        switch(menuItem)
        {
            case R.id.like:
                makeToast("Like");
                break;
            case R.id.dislike:
                makeToast("Dislike");
                break;
            case R.id.comments:
                makeToast("Comments");
                break;
            case R.id.addToCart:
                makeToast("Add To Cart");
                break;
        }
        return super.onContextItemSelected(item);
    }


    private void makeToast(String textInput)
    {
        Toast.makeText(this,textInput,Toast.LENGTH_SHORT).show();
    }
}