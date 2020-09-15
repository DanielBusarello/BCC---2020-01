import javax.swing.JOptionPane;

public class Prova3 {

	public static void main(String[] args) {
		int i, aux = 0;
		int nums[];
		String input;
		boolean first = true;
		
		input = JOptionPane.showInputDialog("Digite o tamanho da cole��o: ");
		nums = new int[Integer.parseInt(input)];
		
		do {
			input = JOptionPane.showInputDialog("Selecione uma op��o:\n" + "1. INSERIR\n" + "2. MOSTRAR\n" +
					"3. VERIFICAR CRESCENTE\n" + "4. FATORIAL MENOR\n" + "5. INVERTER\n" + "6. REPETIDO\n" + "7. ALTERAR TAMANHO DA COLE��O\n" + "99. VAZAR\n" + "(Tamanho da cole��o atual: " + nums.length + ")");
			aux = Integer.parseInt(input);
				
			while(aux != 1 && aux != 99 && aux != 7 && aux < 7 && first) {
				System.out.println("Por favor, primeiro insira os n�meros da cole��o! (Op��o 1)");
				input = JOptionPane.showInputDialog("Selecione uma op��o:\n" + "1. INSERIR\n" + "2. MOSTRAR\n" +
						"3. VERIFICAR CRESCENTE\n" + "4. FATORIAL MENOR\n" + "5. INVERTER\n" + "6. REPETIDO\n" + "7. ALTERAR TAMANHO DA COLE��O\n" + "99. VAZAR\n" + "(Tamanho da cole��o atual: " + nums.length + ")");
				aux = Integer.parseInt(input);
			}
			
			switch (aux) {
				case 1: {
					for(i = 0; i < nums.length; i++) {
						input = JOptionPane.showInputDialog("Digite o " + (i+1) + "� n�mero");
						nums[i] = Integer.parseInt(input);
					}
					first = false;
					break;
				} case 2:{
					ShowArray(nums);
					break;
				} case 3:{
					Ascending(nums);
					break;
				} case 4:{
					Factorial(nums);
					break;
				} case 5:{
					for(i = 0; i < nums.length / 2; i++) {
						aux = nums[i];
						nums[i] = nums[nums.length - i - 1];
						nums[nums.length - i - 1] = aux;
					}
					break;
				} case 6: {
					Repeated(nums);
					break;
				} case 7:{
					input = JOptionPane.showInputDialog("Digite o tamanho da cole��o: ");
					nums = new int[Integer.parseInt(input)];
					first = true;
					break;
				} case 99:{
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema!"
							+ "\nDesenvolvido por Daniel Busarello");
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma op��o v�lida!");
			}
			
		} while(aux != 99);
	}
	
	public static void ShowArray(int array[]) {
		System.out.println("---- # ----");
		for(int i = 0; i < array.length; i++) {
			System.out.println("N�mero " + (i+1) + ": " + array[i]);
		}
		System.out.println("---- # ----");
	}
	
	public static void Ascending(int array[]) {
		int aux = 0;
		for(int i = 1; i < array.length; i++) {
			if(array[i-1] > array[i]) {
				aux = 1;
				break;
			} 
		}
		if(aux == 1) {
			System.out.println("N�o est� em ordem crescente");
		} else {
			System.out.println("Est� em ordem crescente");
		}
	}
	
	public static void Factorial(int array[]) {
		int i, smaller = array[0];
		double fact = 1;
		
		for(i = 0; i < array.length; i++) {
			if(array[i] <= smaller) {
				smaller = array[i];
			}
		}
		
		for(i = smaller; i > 1; i--) {
			fact *= i;
		}
		System.out.println(fact);
	}
	
	public static void Repeated(int array[]) {
		int aux = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = i+1; j < (array.length); j++) {
				if(array[i] == array[j]) {
					aux = 1;
				}
			}
		}
		
		if(aux == 1) {
			System.out.println("Existem n�meros repetidos.");
		} else
			System.out.println("N�o existem n�meros repetidos.");
	}
}
