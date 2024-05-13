package br.com.edu.screenmatch.principal;

import br.com.edu.screenmatch.modelos.Filme;

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
        System.out.println(seuFilme);

        String chave = "https://www.omdbapi.com/?t=" + seuFilme + "&apikey=4ce2fad8";



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(chave))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
