package com.example.camar.app_lista_filmes_webservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://sujeitoprogramador.com/";

    @GET("r-api/?api=filmes")
    Call<ArrayList<Filme>> getFilmes();
}
