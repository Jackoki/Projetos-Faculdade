import javax.swing.JOptionPane;

//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class ValorVazioException extends Exception{

	public void ValorVazioException(){
            exibirMensagem();
	}
        
        public void exibirMensagem() {
            JOptionPane.showMessageDialog(
            null,
            "VALOR NÃO PODE SER 0!",
            "ERRO DE VALIDAÇÃO",
            JOptionPane.ERROR_MESSAGE
        );
    }

}