import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Object[] opcoes = {"Real para Dólar Americano", "Real para Euro","Real para Libra Esterlina", "Dólar Americano para Real", "Euro para Real", "Libra Esterlina para Real"};

        //mostra as opçoes de converção
        Object sel = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

        if (sel == null) {
            System.out.println("Operação Cancelada!");
            return;
        }

        String moedaOrigem, moedaDestino;

        switch (sel.toString()) {
            case "Real para Dólar Americano":
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                break;
            case "Real para Euro":
                moedaOrigem = "BRL";
                moedaDestino = "EUR";
                break;
            case "Real para Libra Esterlina":
                moedaOrigem = "BRL";
                moedaDestino = "GBP";
                break;
            case "Dólar Americano para Real":
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                break;
            case "Euro para Real":
                moedaOrigem = "EUR";
                moedaDestino = "BRL";
                break;
            case "Libra Esterlina para Real":
                moedaOrigem = "GBP";
                moedaDestino = "BRL";
                break;
            default:
                System.out.println("Opção Inválida!");
                return;
        }

        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira um valor em "+moedaOrigem));

        BigDecimal b = BigDecimal.valueOf(valor);

        String apiKey = "5073248996ad447f9f9b69a17b7a185f";

        BigDecimal resultado = converterMoedas(apiKey, moedaOrigem, moedaDestino, b);

        JOptionPane.showMessageDialog(null, "O resultado da conversão é: " + resultado.setScale(2, RoundingMode.HALF_UP) + " "+moedaDestino, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    private static BigDecimal converterMoedas(String apiKey, String moedaOrigem, String moedaDestino, BigDecimal valor) {
        BigDecimal resultado = null;
        try {
            URL url = new URL("https://openexchangerates.org/api/convert/" + valor + "/" + moedaOrigem + "/" + moedaDestino + "?app_id=" + apiKey);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            Scanner scanner = new Scanner(conexao.getInputStream());
            String resposta = scanner.useDelimiter("\\A").nextLine();

            resultado = new BigDecimal(resposta);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro na conexão com API de conversão de moedas!");
        }

        return resultado;
    }
}
