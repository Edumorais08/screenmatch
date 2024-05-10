package br.com.edu.screenmatch.principal;

import br.com.edu.screenmatch.calculos.CalculadoraDeTempo;
import br.com.edu.screenmatch.calculos.FiltroRecomendacao;
import br.com.edu.screenmatch.modelos.Episodio;
import br.com.edu.screenmatch.modelos.Filme;
import br.com.edu.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Filme meuFilme = new Filme("Janela Indiscreta", 1954);
        meuFilme.setAnoDeLancamento(1954);
        meuFilme.setDuracaoEmMinutos(112);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.avalia(10);
        meuFilme.avalia(8.5);
        meuFilme.avalia(8.8);

        meuFilme.exibeFichaTecnica();
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("A nota média é: " + meuFilme.pegaMedia());

        Serie minhaserie = new Serie("Modern Family", 2009);
        minhaserie.exibeFichaTecnica();
        minhaserie.setTemporadas(11);
        minhaserie.setEpisodiosPorTemporada(23);
        minhaserie.setMinutosPorEpisodio(21);
        System.out.println("Duração para maratonar Modern Family: " + minhaserie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("La La Land",2016);
        outroFilme.setDuracaoEmMinutos(129);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(minhaserie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio meuEpisodio = new Episodio();
        meuEpisodio.setNumero(136);
        meuEpisodio.setNome("Conexão Perdida");
        meuEpisodio.setSerie(minhaserie);
        meuEpisodio.setTotalVizualizacoes(8400);
        filtro.filtra(meuEpisodio);

        var terceiroFilme = new Filme("Guardiões da Galáxia", 2014);
//        terceiroFilme.setNome("Guardiões da Galáxia");
        terceiroFilme.setDuracaoEmMinutos(121);
//        terceiroFilme.setAnoDeLancamento(2014);
        terceiroFilme.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(terceiroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        for (Filme listaDeFilme : listaDeFilmes) {
            System.out.println(listaDeFilme.getNome());
        }
        System.out.println("toString do filme: " + listaDeFilmes.get(2).toString());

    }
}
