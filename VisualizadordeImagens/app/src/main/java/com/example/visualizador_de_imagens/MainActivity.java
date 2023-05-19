package com.example.visualizador_de_imagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgfoto;
    Button btfoto1, btfoto2;
    TextView txtinformacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgfoto = (ImageView) findViewById(R.id.imgfoto);
        btfoto1 = (Button) findViewById(R.id.btfoto1);
        btfoto2 = (Button) findViewById(R.id.btfoto2);

        txtinformacao = (TextView) findViewById(R.id.txtinformacao);
        btfoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.anya);
                txtinformacao.setText("Anya 1");
            }
        });
        btfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.anya2);
                txtinformacao.setText("Anya 2");
            }
        });

    }
}