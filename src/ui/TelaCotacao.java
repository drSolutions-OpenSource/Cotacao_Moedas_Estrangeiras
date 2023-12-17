package ui;

import cotacao.RealizarCotacoes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Tela para exibir a cotação atual de moedas estrangeiras, como o Dólar, Euro, Franco Suíço, Libra Esterlina
 * e o Peso Chileno
 *
 * @author Diego Mendes Rodrigues
 */
public class TelaCotacao extends JDialog {
    /* Painel com os componentes da tela */
    JPanel painel = new JPanel(new GridBagLayout());

    /* Componentes da tela */
    JLabel tituloCotacao = new JLabel("Cotação Atual de Moedas");
    JLabel espacador = new JLabel(" ");
    JComboBox moedas = new JComboBox();
    JLabel espacador2 = new JLabel(" ");
    JLabel valorDaMoeda = new JLabel("Valor da moeda: R$ 0,0000");
    JLabel dataDaCotacao = new JLabel("Data da Cotação: --/--/-- --:--:--");
    JLabel espacador3 = new JLabel(" ");
    JButton btnNovaCotacao = new JButton("Buscar uma nova cotação");

    /* Cotações das moedas */
    RealizarCotacoes cotacoes;

    /**
     * Construtor que exibe a tela com as cotações das moedas
     *
     * @param cotacoesRealizadas sendo as cotações das moedas
     */
    public TelaCotacao(RealizarCotacoes cotacoesRealizadas) {
        /* Cotações das moedas */
        this.cotacoes = cotacoesRealizadas;

        /* Propriedades básicas da tela */
        setTitle("Cotação de Moedas");
        setSize(new Dimension(300, 260));
        setLocationRelativeTo(null);
        setResizable(false);
        painel.setBorder(new EmptyBorder(0, 20, 10, 20));

        /* Controlador para o posicionamento dos componentes na Tela */
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        /* Componentes da Tela */
        tituloCotacao.setPreferredSize(new Dimension(240, 25));
        tituloCotacao.setFont(new Font("", Font.PLAIN, 18));
        tituloCotacao.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(tituloCotacao, gridBagConstraints);

        gridBagConstraints.gridy++;
        espacador.setPreferredSize(new Dimension(240, 20));
        painel.add(espacador, gridBagConstraints);

        gridBagConstraints.gridy++;
        moedas.setPreferredSize(new Dimension(240, 25));
        moedas.addItem(new Item("USD-BRL", "Dólar Americano"));
        moedas.addItem(new Item("USD-BRLT", "Dólar Americano Turismo"));
        moedas.addItem(new Item("EUR-BRL", "Euro"));
        moedas.addItem(new Item("CHF-BRL", "Franco Suíço"));
        moedas.addItem(new Item("GBP-BRL", "Libra Esterlina"));
        moedas.addItem(new Item("CLP-BRL", "Peso Chileno"));
        moedas.setMaximumRowCount(34);

        moedas.addActionListener(e -> {
            JComboBox c = (JComboBox) e.getSource();
            Item item = (Item) c.getSelectedItem();
            exibirValores(item.getCodigo());
        });
        painel.add(moedas, gridBagConstraints);

        gridBagConstraints.gridy++;
        espacador2.setPreferredSize(new Dimension(240, 15));
        painel.add(espacador2, gridBagConstraints);

        gridBagConstraints.gridy++;
        valorDaMoeda.setPreferredSize(new Dimension(240, 30));
        painel.add(valorDaMoeda, gridBagConstraints);

        gridBagConstraints.gridy++;
        dataDaCotacao.setPreferredSize(new Dimension(240, 30));
        painel.add(dataDaCotacao, gridBagConstraints);

        gridBagConstraints.gridy++;
        espacador3.setPreferredSize(new Dimension(240, 15));
        painel.add(espacador3, gridBagConstraints);

        gridBagConstraints.gridy++;
        btnNovaCotacao.setPreferredSize(new Dimension(240, 30));
        painel.add(btnNovaCotacao, gridBagConstraints);

        btnNovaCotacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cotacoes.novasCotacoes();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                moedas.setSelectedIndex(0);
                exibirValores("USD-BRL");
            }
        });

        /* Adicionar o painel na tela */
        add(painel, BorderLayout.WEST);

        /* Fechar o sistema quando clicar o X */
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });

        /* Exibir a tela */
        setVisible(true);

        /* Colocar o valor do Dólar como a primeira cotação */
        exibirValores("USD-BRL");
    }

    /**
     * Alterar a cotação da moeda na tela
     *
     * @param moedaExibida sendo a moeda que será exibida
     */
    private void exibirValores(String moedaExibida) {
        String valor = "R$ 0,0000";
        String data = "--/--/-- --:--:--";

        if (moedaExibida.equalsIgnoreCase("USD-BRL")) {
            valor = cotacoes.getCotacaoDolar().getCotacaoFormatada();
            data = cotacoes.getCotacaoDolar().getDataCotacaoFormatada();
        } else if (moedaExibida.equalsIgnoreCase("USD-BRLT")) {
            valor = cotacoes.getCotacaoDolarTurismo().getCotacaoFormatada();
            data = cotacoes.getCotacaoDolarTurismo().getDataCotacaoFormatada();
        } else if (moedaExibida.equalsIgnoreCase("EUR-BRL")) {
            valor = cotacoes.getCotacaoEuro().getCotacaoFormatada();
            data = cotacoes.getCotacaoEuro().getDataCotacaoFormatada();
        } else if (moedaExibida.equalsIgnoreCase("CHF-BRL")) {
            valor = cotacoes.getCotacaoFrancoSuico().getCotacaoFormatada();
            data = cotacoes.getCotacaoFrancoSuico().getDataCotacaoFormatada();
        } else if (moedaExibida.equalsIgnoreCase("GBP-BRL")) {
            valor = cotacoes.getCotacaoLibraEsterlina().getCotacaoFormatada();
            data = cotacoes.getCotacaoLibraEsterlina().getDataCotacaoFormatada();
        } else if (moedaExibida.equalsIgnoreCase("CLP-BRL")) {
            valor = cotacoes.getCotacaoPesoChileno().getCotacaoFormatada();
            data = cotacoes.getCotacaoPesoChileno().getDataCotacaoFormatada();
        }

        valorDaMoeda.setText("Valor da moeda: R$ " + valor);
        dataDaCotacao.setText("Data da Cotação: " + data);
    }
}
