package cotacao;

import classes.Moeda;

import java.util.Objects;

/**
 * Buscar a última cotação do Dólar, Euro, Franco Suíço, Libra Esterlina e Peso Chileno
 *
 * @author Diego Mendes Rodrigues
 */
public class RealizarCotacoes {
    Cotacao cotacao = new Cotacao();
    Moeda cotacaoDolar;
    Moeda cotacaoDolarTurismo;
    Moeda cotacaoEuro;
    Moeda cotacaoFrancoSuico;
    Moeda cotacaoLibraEsterlina;
    Moeda cotacaoPesoChileno;

    public RealizarCotacoes() {
        novasCotacoes();
    }

    /**
     * Buscar a última cotação das moedas
     */
    public void novasCotacoes() {
        cotacaoDolar = cotacao.realizarCotacao("USD");
        cotacaoDolarTurismo = cotacao.realizarCotacao("USDT");
        cotacaoEuro = cotacao.realizarCotacao("EUR");
        cotacaoFrancoSuico = cotacao.realizarCotacao("CHF");
        cotacaoLibraEsterlina = cotacao.realizarCotacao("GBP");
        cotacaoPesoChileno = cotacao.realizarCotacao("CLP");
    }

    /**
     * Exibir as cotações das moedas no terminal
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
        System.out.println(" ");

        System.out.println("# Franco Suíço");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoFrancoSuico().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: € 1,00 = R$ " + this.getCotacaoFrancoSuico()
                .getCotacaoFormatada());
        System.out.println(" ");

        System.out.println("# Libra Esterlina");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoLibraEsterlina().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: € 1,00 = R$ " + this.getCotacaoLibraEsterlina()
                .getCotacaoFormatada());
        System.out.println(" ");

        System.out.println("# Peso Chileno");
        System.out.println("Data e hora da cotação.: " + this.getCotacaoPesoChileno().getDataCotacaoFormatada());
        System.out.println("Cotação de venda.......: € 1,00 = R$ " + this.getCotacaoPesoChileno()
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

    public Moeda getCotacaoFrancoSuico() {
        return cotacaoFrancoSuico;
    }

    public Moeda getCotacaoLibraEsterlina() {
        return cotacaoLibraEsterlina;
    }

    public Moeda getCotacaoPesoChileno() {
        return cotacaoPesoChileno;
    }

    @Override
    public String toString() {
        return "RealizarCotacoes{" +
                "cotacaoDolar=" + cotacaoDolar +
                ", cotacaoDolarTurismo=" + cotacaoDolarTurismo +
                ", cotacaoEuro=" + cotacaoEuro +
                ", cotacaoFrancoSuico=" + cotacaoFrancoSuico +
                ", cotacaoLibraEsterlina=" + cotacaoLibraEsterlina +
                ", cotacaoPesoChileno=" + cotacaoPesoChileno +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealizarCotacoes that = (RealizarCotacoes) o;
        return Objects.equals(cotacao, that.cotacao) && Objects.equals(cotacaoDolar, that.cotacaoDolar) && Objects.equals(cotacaoDolarTurismo, that.cotacaoDolarTurismo) && Objects.equals(cotacaoEuro, that.cotacaoEuro) && Objects.equals(cotacaoFrancoSuico, that.cotacaoFrancoSuico) && Objects.equals(cotacaoLibraEsterlina, that.cotacaoLibraEsterlina) && Objects.equals(cotacaoPesoChileno, that.cotacaoPesoChileno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cotacao, cotacaoDolar, cotacaoDolarTurismo, cotacaoEuro, cotacaoFrancoSuico, cotacaoLibraEsterlina, cotacaoPesoChileno);
    }
}
