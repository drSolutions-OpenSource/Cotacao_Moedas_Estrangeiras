package cotacao;

import classes.ConverterJsonString;
import classes.Moeda;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Obter a contação atual de moedas estrangeiras através do webservice: https://economia.awesomeapi.com.br/last/USD-BRL
 * As seguintes cotações estão disponíveis:
 * - Dólar Americano Comercial (USD-BRL)
 * - Dólar Americano Turismo (USD-BRLT)
 * - Euro (EUR-BRL)
 * - Franco Suíço (CHF-BRL)
 * - Libra Esterlina (GBP-BRL)
 * - Peso Chileno (CLP-BRL)
 *
 * @author Diego Mendes Rodrigues
 */
public class Cotacao {
    static String webService = "https://economia.awesomeapi.com.br/last/";
    static int codigoSucesso = 200;

    /**
     * Realiza a cotação atual de uma moeda estrangeira
     *
     * @param moeda sendo a moeda em que a cotação será realizada (USD, USDT, EUR, CHF, GBP ou CLP)
     * @return a cotação atual da moeda como umo instância da classe Maeda
     */
    public Moeda realizarCotacao(String moeda) {
        if (moeda.equalsIgnoreCase("USD")) {
            return realizarCotacaoMoeda("USD-BRL");
        } else if (moeda.equalsIgnoreCase("USDT")) {
            return realizarCotacaoMoeda("USD-BRLT");
        } else if (moeda.equalsIgnoreCase("EUR")) {
            return realizarCotacaoMoeda("EUR-BRL");
        } else if (moeda.equalsIgnoreCase("CHF")) {
            return realizarCotacaoMoeda("CHF-BRL");
        } else if (moeda.equalsIgnoreCase("GBP")) {
            return realizarCotacaoMoeda("GBP-BRL");
        } else if (moeda.equalsIgnoreCase("CLP")) {
            return realizarCotacaoMoeda("CLP-BRL");
        }
        return new Moeda();
    }

    /**
     * Realiza a cotação da moeda no webservice
     *
     * @param moedaCotada sendo a moeda em que a cotação será realizada
     * @return a cotação atual da moeda como umo instância da classe Maeda
     */
    private Moeda realizarCotacaoMoeda(String moedaCotada) {
        String urlParaChamada = webService + moedaCotada;
        Moeda moeda = new Moeda();

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso) {
//                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
                System.out.println("Falha resposta da requisição realizada com a API");
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = ConverterJsonString.converteJsonEmString(resposta);
            jsonEmString = jsonEmString.replace("{\"" + moedaCotada.replace("-", "")
                    + "\":{", "{");
            jsonEmString = jsonEmString.replace("\"}}", "\"}");

            Gson gson = new Gson();
            moeda = gson.fromJson(jsonEmString, Moeda.class);
            return moeda;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moeda;
    }
}
