package br.com.edu.screenmatch.principal;

import br.com.edu.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.edu.screenmatch.modelos.Filme;
import br.com.edu.screenmatch.modelos.Titulo;
import br.com.edu.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String seuFilme = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!seuFilme.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            seuFilme = sc.nextLine();

            if (seuFilme.equalsIgnoreCase("sair")) {
                break;
            }

            seuFilme = seuFilme.toLowerCase();
            seuFilme = seuFilme.replaceAll(" ", "+");

            String chave = "https://www.omdbapi.com/?t=" + seuFilme + "&apikey=4ce2fad8";


            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(chave))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

//      Titulo meuTitulo = gson.fromJson(json, Titulo.class);
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                System.out.println(meuTituloOmdb);
//        try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca");
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Programa finalizou corretamente!");

    }
}
