import br.com.edu.ObjProjeto.calculos.CalculadoraDeTempo;
import br.com.edu.ObjProjeto.calculos.FiltroRecomendacao;
import br.com.edu.ObjProjeto.modelos.Episodio;
import br.com.edu.ObjProjeto.modelos.Filme;
import br.com.edu.ObjProjeto.modelos.Serie;

public class Principal {

    public static void main(String[] args) {
        Filme meuFilme = new Filme();

        meuFilme.setNome("Janela Indiscreta");
        meuFilme.setAnoDeLancamento(1954);
        meuFilme.setDuracaoEmMinutos(112);
        meuFilme.setIncluidoNoPlano(true);

        meuFilme.avalia(10);
        meuFilme.avalia(8.5);
        meuFilme.avalia(8.8);

        meuFilme.exibeFichaTecnica();
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("A nota média é: " + meuFilme.pegaMedia());

        Serie minhaserie = new Serie();

        minhaserie.setNome("Modern Family");
        minhaserie.setAnoDeLancamento(2009);
        minhaserie.exibeFichaTecnica();
        minhaserie.setTemporadas(11);
        minhaserie.setEpisodiosPorTemporada(23);
        minhaserie.setMinutosPorEpisodio(21);
        System.out.println("Duração para maratonar Modern Family: " + minhaserie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();

        outroFilme.setNome("La La Land");
        outroFilme.setAnoDeLancamento(2016);
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

    }
}
