package com.drr.eventview.drr.eventviewer.model;

public class Event{

    private int id;
    private String nome;
    private String localizacao;
    private String data;
    private String preco;
    private String thumb;



    public Event() {}

    public Event(int id, String nome, String localizacao, String data,String preco, String thumb) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.data = data;
        this.preco = preco;
        this.thumb = thumb;
    }

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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
