import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;
//import org.json.JSONObject;

public class ConversorDeMoedas {    

  public static void main(String[] args) {    
    //Scanner scanner = new Scanner(System.in);

    Object[] opcoes = {"Conversor de moedas", "Conversor de temperatura"};

        //mostra as opçoes de converção
        Object sel = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

        //pede para o usuario inserir
        //um valor de moeda para ser convertido
        double moedinha = (Double.parseDouble(JOptionPane.showInputDialog(null, "Insira um valor")));

        BigDecimal b = BigDecimal.valueOf(moedinha);

    //System.out.println("Bem-vindo ao Conversor de Moedas!");
    //System.out.println("Digite a sua chave de acesso da API de conversão de moedas:");
    String apiKey = "5073248996ad447f9f9b69a17b7a185f";
    //scanner.nextLine();

    while (true) {
        //opçoes de moedas
        Object[] moedas = {"De Real para Dólar", "De Real para Euro", "De Real para Libras", "De Real para Peso Argentino", "De Real para Peso Chileno",
                        "De Dolar para Real", "De Euro para real", "De Libras para Real", "De Peso Argentino para Real", "De peso Chileno para Real"};

        //Mostra as opçoes de moedas
        Object selMoeda = JOptionPane.showInputDialog(null, "Escolha uma moeda", "Menu", JOptionPane.PLAIN_MESSAGE, null, moedas, "");
      

      if (selMoeda == null) {
        System.out.println("Obrigado por usar o Conversor de Moedas!");
        break;
      }

      System.out.println("Digite o valor a ser convertido:");
      BigDecimal valor = b;
      BigDecimal resultado = null;
      String moedaOrigem = null;
      String moedaDestino = null;

      switch (moedas.toString()) {
        case "De Real para Dólar":
          moedaOrigem = "BRL";
          moedaDestino = "USD";
          resultado = converterMoedas(apiKey, moedaOrigem, moedaDestino, valor);
          break;
        case "De Real para Euro":
          moedaOrigem = "BRL";
          moedaDestino = "EUR";
          resultado = converterMoedas(apiKey, moedaOrigem, moedaDestino, valor);
          break;
        case "De Dolar para Real":
          moedaOrigem = "USD";
          moedaDestino = "BRL";
          resultado = converterMoedas(apiKey, moedaOrigem, moedaDestino, valor);
          break;
        case "De Euro para real":
          moedaOrigem = "EUR";
          moedaDestino = "BRL";
          resultado = converterMoedas(apiKey, moedaOrigem, moedaDestino, valor);
          break;
        default:
          //qunado o usuario digita um valor inváido
        JOptionPane.showMessageDialog(null, "Valor inválido " +
        "Digite outro valor", "Erro", 0);
          break;
      }

      if (resultado != null) {
        System.out.println("O resultado da conversão é: " + resultado.setScale(2, RoundingMode.HALF_UP));
      }
    }

    //scanner.close();
  }

  private static BigDecimal converterMoedas(String apiKey, String moedaOrigem, String moedaDestino, BigDecimal valor) {
    BigDecimal resultado = null;
    return resultado;

    /*try {
      URL url = new URL("https://openexchangerates.org/api/convert/" + valor + "/" + moedaOrigem + "/" + moedaDestino + "?app_id=" + apiKey);
      HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
      conexao.setRequestMethod("GET");

      Scanner scanner = new Scanner(conexao.getInputStream());
      String resposta = scanner.useDelimiter("\\A").nextLine();
      
    }

    finally {
        
      }
      */
}
}