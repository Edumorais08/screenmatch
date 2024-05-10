package br.com.edu.screenmatch.principal;

import br.com.edu.screenmatch.modelos.Filme;
import br.com.edu.screenmatch.modelos.Serie;
import br.com.edu.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Janela Indiscreta", 1954);
        meuFilme.avalia(10);
        Filme outroFilme = new Filme("La La Land", 2016);
        outroFilme.avalia(9);
        var terceiroFilme = new Filme("Guardiões da Galáxia", 2014);
        terceiroFilme.avalia(8);
        Serie minhaserie = new Serie("Modern Family", 2009);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(terceiroFilme);
        lista.add(minhaserie);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Leonardo DiCaprio");
        buscaPorArtista.add("Jennifer Lawrence");
        buscaPorArtista.add("Christian Bale");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
