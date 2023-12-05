//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InsercaoVaziaException extends Exception{

	public void InsercaoVaziaException(){
            exibirMensagem();
	}
        
        public void exibirMensagem() {
            JOptionPane.showMessageDialog(
            null,
            "VALOR NÃO PODE SER VAZIO!",
            "ERRO DE VALIDAÇÃO",
            JOptionPane.ERROR_MESSAGE
            );
        }
}