package classes;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Método para converter um JSON recebido via webservice em uma String
 *
 * @author Diego Mendes Rodrigues
 */
public class ConverterJsonString {
    /**
     * Converter um JSON recebido via webservice em uma String
     *
     * @param buffereReader sendo o JSON recebido do webservice
     * @return uma Srting onde ocorreu a conversão do JSON
     * @throws IOException erro caso ocorra uma falha na conversão
     */
    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
