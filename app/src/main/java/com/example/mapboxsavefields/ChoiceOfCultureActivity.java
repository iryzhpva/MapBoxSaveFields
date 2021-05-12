package com.example.mapboxsavefields;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mapboxsavefields.adapter.CultureAdapter;
import com.example.mapboxsavefields.adapter.CultureCallback;
import com.example.mapboxsavefields.pojo.Crops;

import java.util.ArrayList;
import java.util.List;

import static com.example.mapboxsavefields.ButtonFrag.cropField;

public class ChoiceOfCultureActivity extends AppCompatActivity implements CultureCallback {

    RecyclerView recyclerView;
    CultureAdapter cultureAdapter;
    List<Crops> crops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crops=new ArrayList<>();
        setContentView(R.layout.activity_choice_of_culture);
        recyclerView=findViewById(R.id.id_recycler_culture);
        //TODO запрос /api/farmers/api/sorts, чтобы заполнить List<Crops> и отправить в адаптер
        getCrops("Пшеница",1);
        getCrops("Овес",2);
        getCrops("Хлопок",3);
        getCrops("Соя",4);
        cultureAdapter=new CultureAdapter(crops, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cultureAdapter);
    }

    private void getCrops(String name, int id){
        Crops crop=new Crops();
        crop.setName(name);
        crop.setId(id);
        crops.add(crop);
    }

    @Override
    public void onItemClickListener(Crops crops) {
        cropField.setText(crops.getName());
        finish();
    }
}