package com.anderson.domain;

import java.io.Serializable;

/**
 * Created by Anderson on 19/05/2019.
 */

public class SocialMetaTag implements Serializable {

    private String site; // Nome do site na URL cadastrada
    private String title; // Título referente ao nome do produto
    private String url; // URL da consulta
    private String imagem; // URL da imagem fornecida pelo Site

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "SocialMetaTag{" +
                "site='" + site + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
