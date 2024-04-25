package br.com.edu.ObjProjeto.modelos;

import br.com.edu.ObjProjeto.calculos.Classificavel;

public class Episodio implements Classificavel {

        private int numero;
        private String nome;
        private Serie serie;
        private int totalVizualizacoes;

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotalVizualizacoes() {
        return totalVizualizacoes;
    }

    public void setTotalVizualizacoes(int totalVizualizacoes) {
        this.totalVizualizacoes = totalVizualizacoes;
    }

    @Override
    public int getClassificacao() {
        if (totalVizualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }

}
