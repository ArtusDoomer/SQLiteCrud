package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipal extends AppCompatActivity {
    Button b1, b2;

    ProgressBar pb1;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        b1 = findViewById(R.id.btn_nuevo);
        b2 = findViewById(R.id.btn_editar);
        pb1 = findViewById(R.id.pb1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.setVisibility(View.VISIBLE);
                Timer timer = new Timer();
                TimerTask timertask;
                timertask = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;

                        pb1.setProgress(counter);
                        if(counter == 50){
                            timer.cancel();
                            Intent opcion = new Intent(MenuPrincipal.this, dialogo.class);
                            startActivity(opcion);
                        }
                    }
                };
                timer.schedule(timertask,50,50);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.setVisibility(View.VISIBLE);
                Timer timer = new Timer();
                TimerTask timertask = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;

                        pb1.setProgress(counter);
                        if(counter == 50){
                            timer.cancel();
                            Intent opcion = new Intent(MenuPrincipal.this, item.class);
                            startActivity(opcion);
                        }
                    }
                };
                timer.schedule(timertask,50,50);
            }
        });

    }
}
