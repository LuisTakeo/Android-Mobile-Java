package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_proc = (Button)findViewById(R.id.button);
        TextView tv_nome = (TextView) findViewById(R.id.tv_recebe_nome);
        EditText et_recebe = (EditText) findViewById(R.id.et_nome);
        TextView tv_bairro = (TextView) findViewById(R.id.tv_bairro);
        EditText et_bairro = (EditText) findViewById(R.id.et_bairro);
        TextView tv_cidade = (TextView) findViewById(R.id.tv_cidade);
        EditText et_cidade = (EditText) findViewById(R.id.et_cidade);
        TextView tv_uf = (TextView) findViewById(R.id.tv_uf);
        EditText et_uf = (EditText) findViewById(R.id.et_estado);

        btn_proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_nome.setText(et_recebe.getText());
                tv_bairro.setText(et_bairro.getText());
                tv_cidade.setText(et_cidade.getText());
                tv_uf.setText(et_uf.getText());
            }
        });


    }
}