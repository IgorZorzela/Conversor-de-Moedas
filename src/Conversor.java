public class Conversor {

    private double valor;
    public double getValor() {
      return valor;
    }

    public void setValor(double valor) {
      this.valor = valor;
    }

    private Moedas moeda;

    //JOptionPane.showMessageDialog(null, "Bem vindo ao conversor de moedas", null, 1);
      // moeda = JOptionPane.showInputDialog(null, "Selecione uma moeda", null, 3);

       public void setMoeda(Moedas moeda){
        this.moeda = moeda;        
       }
    
}
