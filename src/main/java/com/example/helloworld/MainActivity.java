package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;
import java.util.Stack;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void main(String[] args) {
        TextView textView = (TextView) findViewById(R.id.textView);
        int i = 0;
        do {
            textView.setText(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (i < 10);

    }

    public void OnMyButtonClick(View view) throws InterruptedException {
        TextView textView = (TextView) findViewById(R.id.textView);


            Date dat1 = new Date();

            int h, m, s, f, t, o;

            int d;

            h = dat1.getHours();
            m = dat1.getMinutes();
            s = dat1.getSeconds();

            f = (h * 3600) + (m * 60) + s;
            t = (f - 6 * 3600);
            d = t % (72 + 28);

            if (h >= 0 && h < 6) {
                textView.setText("Светофор работает в ночном режиме ");

            } else if
            (f >= 21600) { // Работа в дневное время
                if (d < 85 && d >= 58) {
                    o = 85 - d;
                    textView.setText("Cостояние : Горит зеленый" + " Осталось   : " + o + " Секунда");
                    Thread.sleep(100);

                } else if (d <= 58) {
                    o = 58 - d;
                    textView.setText("Cостояние : Горит красный" + " Осталось   : " + o + " Секунд");
                }

                Thread.sleep(100);
            }
            if (d >= 85) {
                o = 156 - d;

                textView.setText("Cостояние : Горит красный" + " Осталось   : " + o + " Секунда");
            }
            Thread.sleep(1000);
        }
    }



