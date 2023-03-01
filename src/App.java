import javax.swing.JOptionPane;

public class App {   
    public static void main(String[] args) throws Exception {        

        Conversor conversor = new Conversor();

        //opções de converção
        Object[] opcoes = {"Conversor de moedas", "Conversor de temperatura"};

        //mostra as opçoes de converção
        Object sel = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

        //pede para o usuario inserir
        //um valor de moeda para ser convertido
        conversor.setValor(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira um valor"))); 

        //opçoes de moedas
        Object[] moedas = {"De Real para Dólar ", "De Real para Euro", "De Real para Libras", "De Real para Peso Argentino", "De Real para Peso Chileno",
                        "De Dolar para Real", "De Euro para real", "De Libras para Real", "De Peso Argentino para Real", "De peso Chileno para Real"};

        //Mostra as opçoes de moedas
        Object selMoeda = JOptionPane.showInputDialog(null, "Escolha uma moeda", "Menu", JOptionPane.PLAIN_MESSAGE, null, moedas, "");

        JOptionPane.showMessageDialog(null, "O valor da conversão é de R$", "Conversão", 1);

        //qunado o usuario digita um valor inváido
        JOptionPane.showMessageDialog(null, "Valor inválido " +
         "Digite outro valor", "Erro", 0);

        //confrima se o usuario
        //quer sair ou fazer outra conversão
        JOptionPane.showConfirmDialog(null, "Deseja sair?", "Conversor", 1);

        //finaliza o programa
        JOptionPane.showMessageDialog(null, "Programa finalizado!", "Conversor", 0);
    }
}
