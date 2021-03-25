package com.example.camar.app_lista_filmes_webservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaPrincipal extends AppCompatActivity {

    ListView lst_filmes;

    //GUardo o filme escolhido
    public static Filme filme_escolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        lst_filmes = (ListView)findViewById(R.id.lst_filmes);

        //Crio o Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Obtenho a API
        Api api = retrofit.create(Api.class);

        //Trazer os dados
        Call<ArrayList<Filme>> call = api.getFilmes();

        //Trata o retorno
        call.enqueue(new Callback<ArrayList<Filme>>() {
            //Deu certo...
            @Override
            public void onResponse(Call<ArrayList<Filme>> call, Response<ArrayList<Filme>> response) {
                //Guardo
                ArrayList<Filme> filmes = response.body();

                //Mostra
                lst_filmes.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, filmes));
            }

            //Falhou
            @Override
            public void onFailure(Call<ArrayList<Filme>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Falha na conexão, tente mais tarde :(", Toast.LENGTH_SHORT).show();
            }
        });

        //Tratamento do clique no filme
        lst_filmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Filme filme = (Filme) lst_filmes.getItemAtPosition(position);

                TelaPrincipal.filme_escolhido = filme;

                Intent tela = new Intent (getApplicationContext(), TelaDetalhe.class);
                startActivity(tela);


            }
        });

    }
}
