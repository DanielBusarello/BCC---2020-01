import javax.swing.JOptionPane;

public class Idades {

	public static void main(String[] args) {
		int idade = 0, media = 0;
		String input;
		
		for(int i = 0; i <= 10; i++) {
			input = JOptionPane.showInputDialog("escreva a idade");
			idade = Integer.parseInt(input);
			
			media += idade;
		}
		
		JOptionPane.showMessageDialog(null, media /= 10);
	}

}
