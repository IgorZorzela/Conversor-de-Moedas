import java.text.DecimalFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ConversorDeMoedas {

    public static void main(String[] args) {

        //opções de converção
        String[] opcoes = {"Real para Dólar", "Real para Euro", "Real para Libra",
                        "Dolár para Real", "Dólar para Euro", "Dólar para Libra",
                        "Euro para Real", "Euro para Libra", "Euro para Dólar",
                        "Libra para Euro", "Libra para Dólar", "Libra para Real"};

        boolean continuar = true;

        while(continuar){
            //mostra as opções de conversão
            String escolha = (String) JOptionPane.showInputDialog(null, "Esolha uma opção", "Conversor de moedas",JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes);

            //verifica se foi selecionado
            if(escolha != null){
                //mostra o campo para inserir
                //o valor a ser convertido
                String valor = JOptionPane.showInputDialog(null, "Digite o valor que deseja converter:", "Conversor de moedas", JOptionPane.PLAIN_MESSAGE);

                //verifica se foi inseirdo um valor válido
                //e se o campo não ficou vazio
                if(valor != null && !valor.isEmpty()){
                    double resultado = Double.parseDouble(valor);

                    double valorMoeda = 0.0;
                    String simbolo = "";

                    //depois cai nesse switch onde vai ler qual foi
                    //as moedas que o usuario escolheu converter
                    switch (escolha) {
                        case "Real para Dólar" -> {
                            valorMoeda = 0.19;
                            simbolo = "$";
                            break;
                        }

                        case "Real para Euro" -> {
                            valorMoeda = 0.18;
                            simbolo = "€";
                            break;
                        }
                        
                        case "Real para Libra" -> {
                            valorMoeda = 0.16;
                            simbolo = "£";
                            break;
                        }
                        
                        case "Dolár para Real" -> {
                            valorMoeda = 5.24;
                            simbolo = "R$";
                            break;
                        }
                        
                        case "Dólar para Euro" -> {
                            valorMoeda = 0.93;
                            simbolo = "€";
                            break;
                        }
                        
                        case "Dólar para Libra" -> {
                            valorMoeda = 0.82;
                            simbolo = "£";
                            break;
                        }
                        
                        case "Euro para Real" -> {
                            valorMoeda = 5.63;
                            simbolo = "R$";
                            break;
                        }
                        
                        case "Euro para Libra" -> {
                            valorMoeda = 0.88;
                            simbolo = "£";
                            break;
                        }
                        
                        case "Euro para Dólar" -> {
                            valorMoeda = 1.07;
                            simbolo = "$";
                            break;
                        }

                        case "Libra para Euro" -> {
                            valorMoeda = 1.13;
                            simbolo = "€";
                             break;
                        }  
                        
                        case "Libra para Dólar" -> {
                            valorMoeda = 1.21;
                            simbolo = "$";
                             break;
                        }
                        
                        case "Libra para Real" -> {
                            valorMoeda = 6.37;
                            simbolo = "R$";
                            break;
                        }                                                                                         
                        
                    }
                    //formata o número
                    DecimalFormat df = new DecimalFormat("0.00");

                    //calcula o valor da conversão
                    double valorFinal = (resultado * valorMoeda);
                    JOptionPane.showMessageDialog(null, "O valor da conversão é de " + simbolo + (df.format(valorFinal)), "Conversor de moedas", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Valor inválido", "Conversor de moedas", JOptionPane.ERROR_MESSAGE);
            }

            //no final verifica se u usuario
            //deseja fazer uma nova conversão
            // ou sair da aplicação
            JDialog.setDefaultLookAndFeelDecorated(true);
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.NO_OPTION) {
                continuar = false;
            } else if (resposta == JOptionPane.CLOSED_OPTION) {
                continuar = false;
            }
        }
    }
}