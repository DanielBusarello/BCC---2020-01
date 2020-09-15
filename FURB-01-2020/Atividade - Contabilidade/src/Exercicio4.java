import javax.swing.JOptionPane;

public class Exercicio4 {

	public static void main(String[] args) {
		int qtd = 0, code; 
		float salary = 0, newSalary = 0, oldAmount = 0, newAmount = 0;
		String input, category;
		boolean control = true;
		
		input = JOptionPane.showInputDialog("Informe a quantidade de funcion�rios: ");
		qtd = Integer.parseInt(input);
		
		for(int i = 1; i <= qtd; i++) {
			control = true;
			input = JOptionPane.showInputDialog("Informe o c�digo do funcion�rio: " + i);
			code = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Informe a categoria do funcion�rio: " + i + " (A, B, C, D, E, F, G)");
			category = input;
			
			input = JOptionPane.showInputDialog("Informe o sal�rio atual do funcion�rio: " + i);
			salary = Integer.parseInt(input);
			oldAmount += salary;
			
			while(control) {
				switch(category) {
					case "A": case "C": 
						newSalary = salary * 1.02f;
						control = false;
						break;
					case "B": case"D": case"E":
						newSalary = salary * 1.03f;
						control = false;
						break;
					case "F": case "G":
						newSalary = salary * 1.05f;
						control = false;
						break;
					default: {
						System.out.println("Insira um valor v�lido para a categoria! (A, B, C, D, E, F, G)");
						
						input = JOptionPane.showInputDialog("Informe a categoria do funcion�rio: " + i);
						category = input;
						
						break;
					}
				}
			}
			
			System.out.println("Sal�rio do funcion�rio " + i + " (C�digo: " + code + "), atualizado de: R$" + salary + " para: R$" + newSalary);
			newAmount += newSalary;
			
		}
		
		System.out.println("Valor total dos sal�rios antigos: " + oldAmount);
		System.out.println("Valor total dos sal�rios atuais: " + newAmount);
		
	}
}

