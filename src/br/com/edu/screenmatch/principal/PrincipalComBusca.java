package br.com.edu.screenmatch.principal;

import br.com.edu.screenmatch.modelos.Filme;
import br.com.edu.screenmatch.modelos.Titulo;
import br.com.edu.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um filme para busca: ");
        String seuFilme = sc.nextLine();

        seuFilme = seuFilme.toLowerCase();
        seuFilme = seuFilme.replaceAll(" ", "+");

        String chave = "https://www.omdbapi.com/?t=" + seuFilme + "&apikey=4ce2fad8";



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(chave))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
//      Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);


        System.out.println(meuTituloOmdb);
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        System.out.println("HAHAHAHA");
        System.out.println(meuTitulo);

    }
}
