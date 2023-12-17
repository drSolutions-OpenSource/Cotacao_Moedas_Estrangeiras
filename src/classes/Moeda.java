package classes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Classe utilizada na realização da conversão dos valores recebidos no formato JSON, para uma classe
 * Os valores das contações das moedas estão em: https://economia.awesomeapi.com.br/last/USD-BRL
 *
 * @author Diego Mendes Rodrigues
 */
public class Moeda {
    String code;
    String codein;
    String name;
    String high;
    String low;
    String varBid;
    String pctChange;
    String bid;
    String ask;
    String timestamp;
    String create_date;

    public Moeda() {
    }

    public Moeda(String code, String codein, String name, String high, String low, String varBid, String pctChange,
                 String bid, String ask, String timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVarBid() {
        return varBid;
    }

    public void setVarBid(String varBid) {
        this.varBid = varBid;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "classes.Moeda{" +
                "code='" + code + '\'' +
                ", codein='" + codein + '\'' +
                ", name='" + name + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", varBid='" + varBid + '\'' +
                ", pctChange='" + pctChange + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moeda moeda = (Moeda) o;
        return Objects.equals(code, moeda.code) && Objects.equals(codein, moeda.codein) &&
                Objects.equals(name, moeda.name) && Objects.equals(high, moeda.high) &&
                Objects.equals(low, moeda.low) && Objects.equals(varBid, moeda.varBid) &&
                Objects.equals(pctChange, moeda.pctChange) && Objects.equals(bid, moeda.bid) &&
                Objects.equals(ask, moeda.ask) && Objects.equals(timestamp, moeda.timestamp) &&
                Objects.equals(create_date, moeda.create_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, codein, name, high, low, varBid, pctChange, bid, ask, timestamp, create_date);
    }

    /**
     * Devolver a cotação da moeda formatada em 999,9999
     *
     * @return sendo a contação da moeda formatada
     */
    public String getCotacaoFormatada() {
        DecimalFormat df = new DecimalFormat("##0.0000");
        BigDecimal valor = new BigDecimal(this.getAsk());
        return df.format(valor);
    }

    /**
     * Retornar a data formatada em dd/MM/yyyy HH:mm:ss
     *
     * @return sendo a data formatada, ou null caso ocorra um erro na conversão
     */
    public String getDataCotacaoFormatada() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat dateFormatExibicao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataCotacao = null;

        try {
            dataCotacao = dateFormat.parse(this.getCreate_date());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return dateFormatExibicao.format(dataCotacao);
    }
}
