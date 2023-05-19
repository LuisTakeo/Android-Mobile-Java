package com.example.calculo_de_salario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgopcoes;
    Button btcalcular;

    EditText edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edsalario = (EditText) findViewById(R.id.edsalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(edsalario.getText().toString());

                int op = rgopcoes.getCheckedRadioButtonId();

                double novo_salario = 0;

                if(op == R.id.rb40) novo_salario = salario + (salario * 0.4);
                else if(op == R.id.rb45)novo_salario = salario + (salario * 0.45);
                else novo_salario = salario + (salario * 0.5);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é: R$" + String.valueOf(novo_salario));
                dialogo.setNeutralButton("Ok", null);

                dialogo.show();
            }
        });

    }
}