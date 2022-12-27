package com.cousinapp.zikirmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    TextView zikir;
    int value=0;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        zikir=findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGII.TTF");
        zikir.setTypeface(typeface);
        sharedPreferences = this.getSharedPreferences("com.burak.zikirmatik", Context.MODE_PRIVATE);

        value = sharedPreferences.getInt("value",0);

        zikir.setText(""+value);






    }

    public void zikir(View view){

        value=Integer.parseInt(zikir.getText().toString());
        value++;
        if (value>9999){
            value=0;
        }
        zikir.setText(""+value);

        sharedPreferences.edit().putInt("value",value).apply();



    }
    public void reset(View view){



        value=Integer.parseInt(zikir.getText().toString());
        value=0;
        zikir.setText(""+value);

        sharedPreferences.edit().putInt("value",value).apply();







    }




}