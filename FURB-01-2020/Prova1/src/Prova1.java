import javax.swing.JOptionPane;

public class Prova1 {

	public static void main(String[] args) {
		
		String input;
		int num, i = 1, count = 0, primes = 0, higherPrime = 2, mult3 = 0, pairs = 0;
		int fact = 1;
		boolean seq = false;

		input = JOptionPane.showInputDialog("Informe o " + i + "º número para continuar (somente positivos)");
		num = Integer.parseInt(input);
		
		int smallest = num, lastNum = num;
		
		while(i <= 99) {
			input = JOptionPane.showInputDialog("Informe o " + i + "º número para continuar (somente positivos)");
			num = Integer.parseInt(input);
			
			while(num < 0) {
				JOptionPane.showMessageDialog(null, "Informe apenas números positivos! ");
				input = JOptionPane.showInputDialog("\nInforme o " + i + "º número para continuar (somente positivos)");
				num = Integer.parseInt(input);
			}
			
			if(smallest > num) {
				smallest = num;
			}
			
			//Primes
			for(int j = 1; j <= num; j++) {
				if(num % j == 0) {
					count++;
				}
			}
	
			if(count == 2) {
				primes++;
				if(higherPrime < num) {
					higherPrime = num;
				}
			} 
			// end primes
			
			if(num % 3 == 0) {
				mult3++;
				if(num % 2 == 0) {
					pairs++;
				}
			}
			
			if(lastNum == num) {
				seq = true;
			}
			
			lastNum = num;
			count = 0;
			i++;
		}
		
		for(int j = smallest; j > 1; j--) {
			fact *= j;
		}

		JOptionPane.showMessageDialog(null, "Resultados \n" + "Primos: " + primes + "\nMaior primo: " + (primes != 0 ? higherPrime:"Não foi digitado nenhum primo")
				+ "\nMultiplos de 3: " + mult3 + "\nPares multiplos de 3: " + pairs + "\nFatorial do menor: " + fact + "\nHouve repetição de número na sequência: " + (seq ? "Sim":"Não") + "\nDesenvolvido por Daniel Busarello");
		
	}

}
