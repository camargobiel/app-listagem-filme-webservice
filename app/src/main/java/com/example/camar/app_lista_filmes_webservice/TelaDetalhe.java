package com.example.camar.app_lista_filmes_webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TelaDetalhe extends AppCompatActivity {

    TextView tv_sinopse;
    ImageView img_filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhe);

        tv_sinopse = (TextView)findViewById(R.id.tv_sinopse);
        img_filme = (ImageView)findViewById(R.id.img_filme);

        //Mostro a sinopse
        tv_sinopse.setText(TelaPrincipal.filme_escolhido.getSinopse());

        //Pego o endereço da foto
        String url_imagem = TelaPrincipal.filme_escolhido.getFoto();

        //Mostro a foto
        Picasso.with(this).load(url_imagem).into(img_filme);
    }
}
