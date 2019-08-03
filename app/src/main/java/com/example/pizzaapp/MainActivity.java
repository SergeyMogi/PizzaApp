package com.example.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText phoneNumber;
    private EditText adresse;
    private Button button;
    private Intent activityNext;
    private String name;
    private String adress;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imDone();
        addNameAndAge();

    }

    private void addNameAndAge(){

        activityNext=new Intent(this,Meniu.class);

    }
    private void setTheEditText() {
        firstName=findViewById(R.id.name_id);
        adresse=findViewById(R.id.adress_id);
    }
    private void setTheData() {
        name=firstName.getText().toString();
        adress=adresse.getText().toString();
    }
    private void startTheShowDataActivity() {

            setTheData();
            intent = new Intent(MainActivity.this, Meniu.class);
            intent.putExtra("name", name);
            intent.putExtra("adress", adress);
            startActivity(intent);
        }


    private void imDone(){
        firstName=findViewById(R.id.name_id);
        phoneNumber=findViewById(R.id.phone_num_id);
        adresse=findViewById(R.id.adress_id);
        button=findViewById(R.id.im_done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (firstName.getText().toString().length()<2)
                {
                 popToast("כנראה שלא הכנסת את השם הפרטי שלך");
                }
                else if(phoneNumber.getText().toString().length()<10)
                {
                    popToast("כנראה שלא הכנסת את המספר הטלפון שלך כמו שצריך");
                }
                else if (adresse.getText().toString().length()<3)
                {
                    popToast("כנראה שלא הכנסת כתובת תקינה");
                }
                else
                    {

                            startActivity(activityNext);
                            setTheEditText();
                            startTheShowDataActivity();
                      //      popToast("ברוך הבא  "+firstName.getText());

                    }
            }

        });

    }
    private void popToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
