package com.example.meus_pets;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDados extends SQLiteOpenHelper {

    public static final int VERSAO_BANCO = 1;
    public static final String BANCO_AGENDA = "db_agenda";

    public BancoDados(Context context){
        super(context, BANCO_AGENDA, null, VERSAO_BANCO);
    }

    public static final String TABELA_PESSOA = "tb_pessoa";
    public static final String COLUNA_CODIGO = "codigo";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_ENDERECO = "endereco";

}
