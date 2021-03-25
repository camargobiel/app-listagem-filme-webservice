package com.example.camar.app_lista_filmes_webservice;

public class Filme {

    //Atributos
    int id;
    String nome, sinopse, foto;

    //Retorno para o listview - como irá mostrar
    @Override
    public String toString() {
        return nome;
    }

    //Get / Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
