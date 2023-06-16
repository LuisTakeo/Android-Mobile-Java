package com.example.meus_pets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    EditText cIdPet;
    EditText cNome, cTipo, cRaca, cCor;
    Button btnSalvar, btnLimpar, btnExcluir;
    ListView viewPet;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    InputMethodManager imm;

    BancoDados db = new BancoDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imm = (InputMethodManager) this.getSystemService( Service.INPUT_METHOD_SERVICE );

        cIdPet = findViewById(R.id.txtCodigo);

        cNome = findViewById(R.id.petNome);
        cCor = findViewById(R.id.petCor);
        cRaca = findViewById(R.id.petRaca);
        cTipo = findViewById(R.id.petTipoAnimal);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnLimpar = findViewById(R.id.btnLimpar);
        viewPet = findViewById(R.id.listViewPet);

        cNome.requestFocus();

        viewPet.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String conteudo = (String) viewPet.getItemAtPosition( position );

                String codigo = conteudo.substring( 0, conteudo.indexOf( "-" ) );

                Pet pet = db.selecionarPet( Integer.parseInt( codigo ) );

                cIdPet.setText(String.valueOf( pet.getIdPet() )  );
                cNome.setText( pet.getNomePet());
                cTipo.setText(pet.getTipoAnimal());
                cRaca.setText(pet.getRaca());
                cCor.setText(pet.getCor());
            }
        } );

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();

            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idPet = cIdPet.getText().toString();
                String nome = cNome.getText().toString();
                String tipo = cTipo.getText().toString();
                String raca = cRaca.getText().toString();
                String cor = cCor.getText().toString();

                if (nome.isEmpty()) {
                    cNome.setError("Este campo é obrigatorio");
                } else if (idPet.isEmpty()) {

                    db.addPet(new Pet(nome, tipo, raca, cor));
                    Toast.makeText(MainActivity2.this, "Cadastro salvo com sucesso", Toast.LENGTH_SHORT).show();
                    listarPets();
                    limpaCampos();
                    escondeTeclado();

                } else {
                    db.atualizarPet(new Pet(Integer.parseInt(idPet), nome, tipo, raca, cor));
                    Toast.makeText(MainActivity2.this, "Cadastro atualizado com sucesso", Toast.LENGTH_SHORT).show();
                    listarPets();
                    limpaCampos();
                    escondeTeclado();

                }
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idPet = cIdPet.getText().toString();
                if (idPet.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Nenhuma pessoa está selecionada", Toast.LENGTH_SHORT).show();
                } else {

                    Pet pet = new Pet();
                    pet.setIdPet(Integer.parseInt(idPet));
                    db.apagarPet(pet);
                    Toast.makeText(MainActivity2.this, "Registro da pessoa apagada com sucesso", Toast.LENGTH_SHORT).show();
                    cIdPet.setText("");
                    listarPets();
                    limpaCampos();
                }

            }
        });
    }

    void escondeTeclado(){
        imm.hideSoftInputFromWindow( cNome.getWindowToken(),0 );
    }

    public void limpaCampos() {
        cIdPet.setText("");
        cNome.setText("");
        cTipo.setText("");
        cRaca.setText("");
        cCor.setText("");

        cNome.requestFocus();
    }


    public void listarPets(){

        List<Pet> pets = db.listaPet();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, arrayList);

        viewPet.setAdapter(adapter);

        for(Pet c : pets){
            //Log.d( "Lista", "\nID: " + c.getCodigo() + "Nome: " + c.getNome(  ));            //arrayList. add( c.getCodigo() + "-" + c.getCodigo());
            arrayList.add(c.getIdPet() + "-" + c.getNomePet());
            adapter.notifyDataSetChanged();
        }

    }
}