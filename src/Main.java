import cotacao.RealizarCotacoes;
import ui.TelaCotacao;

/**
 * Sistema que busca as cotações atuais de diversas moedas, como Dólar, Euro, Franco Suíço, Libra Esterlina
 * o e Peso Chileno, exibindo os resultados em uma tela criada com Swing, com a opção de exibir também no terminal
 *
 * @author Diego Mendes Rodrigues
 * @version 1.1
 * @since 12/17/2023
 */
public class Main {
    public static void main(String[] args) {
        /* Buscar a última cotação do Dólar Americano, Dólar Americano Turismo e do Euro */
        RealizarCotacoes cotacoes = new RealizarCotacoes();
//        cotacoes.exibirCotacoesTerminal();

        /* Exibir a tela com as cotações */
        TelaCotacao telaCotacao = new TelaCotacao(cotacoes);
    }
}
