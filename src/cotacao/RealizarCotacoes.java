package cotacao;

import classes.Moeda;

import java.util.Objects;

/**
 * Buscar a última cotação do Dólar Americano, Dólar Americano Turismo e do Euro
 *
 * @author Diego Mendes Rodrigues
 */
public class RealizarCotacoes {
    Cotacao cotacao = new Cotacao();
    Moeda cotacaoDolar;
    Moeda cotacaoDolarTurismo;
    Moeda cotacaoEuro;

    /**
     * Buscar a última cotação do Dólar Americano, Dólar Americano Turismo e do Euro
     */
    public RealizarCotacoes() {
        cotacaoDolar = cotacao.realizarCotacao("USD");
        cotacaoDolarTurismo = cotacao.realizarCotacao("USDT");
        cotacaoEuro = cotacao.realizarCotacao("EUR");
    }

    /**
     * Exibir as cotações do Dólar Americano Comercial, Dólar Americano Turismo e do Euro no terminal
     */
    public void exibirCotacoesTerminal() {
        /* Exibir os resultados */
        System.out.println("# Dólar Americano Comercial");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoDolar().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: $ 1,00 = R$ " + this.getCotacaoDolar()
                .getCotacaoFormatada());
        System.out.println(" ");

        System.out.println("# Dólar Americano Turismo");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoDolarTurismo().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: $ 1,00 = R$ " + this.getCotacaoDolarTurismo()
                .getCotacaoFormatada());
        System.out.println(" ");

        System.out.println("# Euro");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoEuro().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: € 1,00 = R$ " + this.getCotacaoEuro()
                .getCotacaoFormatada());
    }

    public Moeda getCotacaoDolar() {
        return cotacaoDolar;
    }

    public Moeda getCotacaoDolarTurismo() {
        return cotacaoDolarTurismo;
    }

    public Moeda getCotacaoEuro() {
        return cotacaoEuro;
    }

    @Override
    public String toString() {
        return "RealizarCotacoes{" +
                "cotacao=" + cotacao +
                ", cotacaoDolar=" + cotacaoDolar +
                ", cotacaoDolarTurismo=" + cotacaoDolarTurismo +
                ", cotacaoEuro=" + cotacaoEuro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealizarCotacoes that = (RealizarCotacoes) o;
        return Objects.equals(cotacao, that.cotacao) && Objects.equals(cotacaoDolar, that.cotacaoDolar) && Objects.equals(cotacaoDolarTurismo, that.cotacaoDolarTurismo) && Objects.equals(cotacaoEuro, that.cotacaoEuro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cotacao, cotacaoDolar, cotacaoDolarTurismo, cotacaoEuro);
    }
}
