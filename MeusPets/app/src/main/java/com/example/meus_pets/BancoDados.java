package com.example.meus_pets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {

    public static final int VERSAO_BANCO = 1;
    public static final String BANCO_AGENDA = "db_agenda";

    public BancoDados(Context context){
        super(context, BANCO_AGENDA, null, VERSAO_BANCO);
    }

    public static final String TABELA_PET = "tb_pet";
    public static final String COLUNA_CODIGO = "codigo";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TIPO = "tipo";
    public static final String COLUNA_RACA = "raca";
    public static final String COLUNA_COR = "cor";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CRIAR_TABELA = "CREATE TABLE " + TABELA_PET
                + "(" + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTO_INCREMENT, "
                + COLUNA_NOME + " TEXT, " + COLUNA_TIPO + " TEXT,"
                + COLUNA_RACA + " TEXT," + COLUNA_COR + " TEXT)";
        db.execSQL(CRIAR_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addPet(Pet pet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valor = new ContentValues();
        valor.put(COLUNA_NOME, pet.getNomePet());
        valor.put(COLUNA_TIPO, pet.getTipoAnimal());
        valor.put(COLUNA_RACA, pet.getRaca());
        valor.put(COLUNA_COR, pet.getCor());
        db.insert(TABELA_PET, null, valor);
        db.close();
    }


    void apagarPet(Pet pet){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABELA_PET, COLUNA_CODIGO + " +?",
                new String[]{ String.valueOf(pet.getIdPet()) });
        db.close();
    }

    Pet selecionarPet(int codigo){
        SQLiteDatabase db = this.getReadableDatabase();
        // SQLLiteDatabase abrindo o banco
        Cursor cursor = db.query(TABELA_PET, new String[]{COLUNA_CODIGO, COLUNA_NOME,
                COLUNA_TIPO, COLUNA_RACA, COLUNA_COR},
                COLUNA_CODIGO + " =?", new String[]{String.valueOf(codigo)},
                null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }

        Pet pet = new Pet(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4));
        return pet;
        }

        void atualizarPet(Pet pet) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(COLUNA_NOME, pet.getNomePet());
            valor.put(COLUNA_TIPO, pet.getTipoAnimal());
            valor.put(COLUNA_RACA, pet.getRaca());
            valor.put(COLUNA_COR, pet.getCor());
            db.update(TABELA_PET, valor, COLUNA_CODIGO + " =?",
                    new String[]{String.valueOf(pet.getIdPet())});
            db.close();
        }

    public List<Pet> listaPet() {

        List<Pet> petLista = new ArrayList<>();

        String query = "SELECT * FROM " + TABELA_PET;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                Pet pet = new Pet();

                pet.setIdPet(Integer.parseInt(cursor.getString(0)!=null?cursor.getString( 0 ):"0"));
                pet.setNomePet(cursor.getString(1));
                pet.setTipoAnimal(cursor.getString(2));
                pet.setRaca(cursor.getString(3));
                pet.setCor(cursor.getString(4));

                petLista.add(pet);

            } while (cursor.moveToNext());
        }

        return petLista;

    }
}
