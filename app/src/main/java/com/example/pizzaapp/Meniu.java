package com.example.pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Meniu extends AppCompatActivity {

    private CheckBox privetPizza;
    private CheckBox mediumPizaa;
    private CheckBox famellyPizaa;
    private TextView showNameAndAge;
    private ImageView pizzaGiff;
    private String adresse;
    private String name;
    private EditText nameEdit, adresseEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);

        getTheData();
        try
        {
            Toast.makeText(this,  "ברוך הבא "+getIntent().getExtras().get("name"),Toast.LENGTH_LONG).show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        makePizza();
        setTheTextView();
        nameEdit=findViewById(R.id.name_id);
        adresseEdit =findViewById(R.id.adress_id);

    }



    private void getTheData() {

        try
        {
            name = getIntent().getExtras().getString("name", "no value");
            adresse = getIntent().getExtras().getString("adress", "no value");
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    private void setTheTextView() {
        showNameAndAge =findViewById(R.id.order_ditels);
        showNameAndAge.setText("ברוך הבא "+name+" ההזמנה תישלח ל  "+adresse);
    }
    private void makePizza(){
        famellyPizaa=findViewById(R.id.pizza_big);
        mediumPizaa=findViewById(R.id.pizza_medium);
        privetPizza=findViewById(R.id.pizza_small);
    }

}
