import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Trabalho1 {

	public static void main(String[] args) {
	
		String input;
		
		// Control variables
		boolean prime = false, pair = false, seqNum = false;
		double fact = 1;
		int count = 0, lastNum = 0, total = 0;
		
		int num = 0, average = 0, higherNum = 0, higherPair = 0, primes = 0, odd = 0, mult5 = 0, mult3 = 0, qtt22 = 0; 		
		
		ArrayList<Integer> repeatedNums = new ArrayList<Integer>();
		
		while (num <= 30) {
			input = JOptionPane.showInputDialog("Informe um n�mero positivo: \n (Para sair, digite qualquer n�mero maior que 30)");
			num = Integer.parseInt(input);
			
			// Verifica se o n�mero � positivo
			while(num < 0 || input == null) {
				JOptionPane.showMessageDialog(null, "Informe apenas n�meros positivos! ");
				input = JOptionPane.showInputDialog("Informe um n�mero positivo: \n (Para sair, digite qualquer n�mero maior que 30)");
				num = Integer.parseInt(input);
			}
			
			if(num > 30) {
				JOptionPane.showMessageDialog(null, "Encerrando o programa... \nPressione o bot�o para ver os resultados ");
				break;
			}
			
			// Fatorial
			for(int i = 2; i <= num; i++) {
				fact *= i;
			}
			
			// Primo / N�o primo
			for(int i = 1; i <= num; i++) {
				if(num % i == 0) {
					count++;
				}
			}
	
			if(count == 2) {
				prime = true;
				primes++;
			} else
				prime = false;
			
			// Par / Impar
			if(num % 2 == 0) {
				pair = true;
				
				if(higherPair < num) {
					higherPair = num;
				}
			} else {
				pair = false;
				odd++;
			}
			
			JOptionPane.showMessageDialog(null, "O n�mero: " + num + "\n" + (num==0 ? "INDETERMINADO":(prime ? "� PRIMO":"N�O � PRIMO")) + "\n"
					+ (pair ? "� PAR":"� �MPAR") + "\nFATORIAL: " + fact);
			
			average += num;
			
			if(higherNum < num) {
				higherNum = num;
			}
			
			// Multiplos de 5
			if(num % 5 == 0) {
				mult5++;
				
				// Multiplos de 5 e 3
				if(num % 3 == 0) {
					mult3++;
				}
			}
			
			if(num == 22) {
				qtt22++;
			}
			 
			// Repeti��o do n�mero
			if(lastNum == num) {
				seqNum = true;
				repeatedNums.add(num);
			}
			
			total++;
			
			fact = 1;
			count = 0;
			lastNum = num;
					
		}
		
		JOptionPane.showMessageDialog(null, "Resultados: \n" +
				"Total de opera��es: " + total + "\n"
				+ "M�dia: " + (total>0 ? (average/total):0) + "\n"
				+ "Maior n�mero: " + higherNum + "\n"
				+ "Total de primos: " + primes + "\n"
				+ "Total de �mpares: " + odd + "\n"
				+ "Maior par: " + higherPair + "\n"
				+ "Multiplos de 5: " + mult5 + "\n"
				+ "Multiplos de 5 e 3: " + mult3 + "\n"
				+ "Total de n�meros 22: " + qtt22 + "\n"
				+ (seqNum ? ("Houve repeti��o do(s) n�mero(s) " + repeatedNums):"N�o houve repeti��o de n�meros") + "\n\n"
				+ "Sistema desenvolvido por Daniel Busarello");
	}
	
}
