import javax.swing.JOptionPane;

public class Exercicio4 {

	public static void main(String[] args) {
		int qtd = 0, code; 
		float salary = 0, newSalary = 0, oldAmount = 0, newAmount = 0;
		String input, category;
		boolean control = true;
		
		input = JOptionPane.showInputDialog("Informe a quantidade de funcionários: ");
		qtd = Integer.parseInt(input);
		
		for(int i = 1; i <= qtd; i++) {
			control = true;
			input = JOptionPane.showInputDialog("Informe o código do funcionário: " + i);
			code = Integer.parseInt(input);
			
			input = JOptionPane.showInputDialog("Informe a categoria do funcionário: " + i + " (A, B, C, D, E, F, G)");
			category = input;
			
			input = JOptionPane.showInputDialog("Informe o salário atual do funcionário: " + i);
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
						System.out.println("Insira um valor válido para a categoria! (A, B, C, D, E, F, G)");
						
						input = JOptionPane.showInputDialog("Informe a categoria do funcionário: " + i);
						category = input;
						
						break;
					}
				}
			}
			
			System.out.println("Salário do funcionário " + i + " (Código: " + code + "), atualizado de: R$" + salary + " para: R$" + newSalary);
			newAmount += newSalary;
			
		}
		
		System.out.println("Valor total dos salários antigos: " + oldAmount);
		System.out.println("Valor total dos salários atuais: " + newAmount);
		
	}
}

