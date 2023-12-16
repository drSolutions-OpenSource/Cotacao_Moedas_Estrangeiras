import cotacao.RealizarCotacoes;

/**
 * Sistema que busca as cotações atuais do Dólar Americano Comercial, Dólar Americano Turismo e Euro, exibindo os
 * resultados no terminal
 *
 * @author Diego Mendes Rodrigues
 * @version 1.0 12/16/2023
 */
public class Main {
    public static void main(String[] args) {
        /* Buscar a última cotação do Dólar Americano, Dólar Americano Turismo e do Euro */
        RealizarCotacoes cotacoes = new RealizarCotacoes();
        cotacoes.exibirCotacoesTerminal();
    }
}
