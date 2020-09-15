import javax.swing.JOptionPane;

public class Trabalho3 {

	public static void main(String[] args) {
		int id[] = new int[20], age[] = new int[id.length];
		
		PopulateArray(id, age);
		Menu(id, age);
	}
	
	private static void Menu(int id[], int age[]) {
		String input;
		int i, aux;
		
		do {
			input = JOptionPane.showInputDialog("Selecione uma opção:\n" + "1. MOSTRAR\n" + "2. ORDENAR CRESCENTE\n" +
					"3. INVERTER\n" + "4. PROCURAR MATRICULA\n" + "5. PROCURAR IDADE\n" + "6. MEDIA\n" + 
					"7. MAIS JOVEM\n" + "8. ANIVERSARIO\n" + "9. IDADE REPETIDA\n" + "10. POPULAR\n" + "99. VAZAR");
			aux = Integer.parseInt(input);
			
			switch(aux) {
				case 1: {
					for(i = 0; i < id.length; i++) {
						System.out.println("Aluno "+(i+1)+" | ID: "+id[i]+" | Idade: "+age[i]+" anos");
					}
					System.out.print("\n");
					break;
				} case 2: {
					OrganizeArray(id, age, 1);
					break;
				} case 3: {
					OrganizeArray(id, age, 0);
					break;
				} case 4: {
					input = JOptionPane.showInputDialog("Digite o ID do aluno: ");
					aux = Integer.parseInt(input);
					SearchId(id, age, 0, aux);
					break;
				} case 5: {
					input = JOptionPane.showInputDialog("Digite o ID para buscar a idade do aluno");
					aux = Integer.parseInt(input);
					SearchId(id, age, 1, aux);
					break;
				} case 6: { // Media idade
					CalculateAge(id, age, 0);
					break;
				} case 7: { // Mais novo
					CalculateAge(id, age, 1);
					break;
				} case 8: {
					input = JOptionPane.showInputDialog("Digite o ID para buscar o aluno aniversariante");
					aux = Integer.parseInt(input);
					SearchId(id, age, 2, aux);
					break;
				} case 9: { // Idade repetida
					SearchId(id, age, 3, -1);
					break;
				} case 10: { // Repopular os arrays
					PopulateArray(id, age);
					break;
				} case 99:{
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema. \nDesenvolvido por Daniel Busarello");
					break;
				} default:{
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
				}
			}
		} while(aux != 99);
	}
	
	private static void PopulateArray (int id[], int age[]) {
		String input;
		int i, j;
		boolean sameId = true;
		
		for(i = 0; i < id.length; i++) {
			input = JOptionPane.showInputDialog("Digite o ID de matrícula do aluno " + (i + 1) + ": \n");
			id[i] = Integer.parseInt(input);
			
			if(i>0) {
				for(j = 0; j < i; j++) {
					sameId = true;
					while(sameId){
						if(id[i] == id[j]) {
							JOptionPane.showMessageDialog(null, "ID's repetidos não são permitidos!");
							input = JOptionPane.showInputDialog("Digite o número da matrícula do aluno " + (i + 1) + " novamente:\n");
							id[i] = Integer.parseInt(input);
						} else
							sameId = false;
					}
				}
			}
			
			input = JOptionPane.showInputDialog("Digite a idade do aluno " + (i + 1) + ": \n");
			age[i] = Integer.parseInt(input);
			
		}
	}
	
	private static void OrganizeArray(int id[], int age[], int index) {
		int aux = 0;
		int i, j = 0;
		int lastIndex; 
		
		if(index == 0) { // Reverter vetor
			for(i = 0; i < id.length / 2; i++) {
				lastIndex = (id.length - i - 1);
				
				aux = id[i];
				id[i] = id[lastIndex];
				id[lastIndex] = aux;
				
				aux = age[i];
				age[i] = age[lastIndex];
				age[lastIndex] = aux;
			}
		}
		
		else if(index == 1){
			for(i = 0; i < (id.length - 1); i++) {
				for(j = 0; j < (id.length - 1); j++) {
					if(id[j] > id[j+1]) {
						aux = id[j];
						id[j] = id[j+1];
						id[j+1] = aux;
						
						aux = age[j];
						age[j] = age[j+1];
						age[j+1] = aux;
					}
				}
			}
		}
	}
	
	private static void SearchId(int id[], int age[], int index, int value) {
		int aux = 0;
		
		for(int i = 0; i < id.length; i++) {
			if(id[i] == value) {
				if(index == 0) { // Procura o ID de um aluno
					System.out.println("Aluno encontrado! ID: " + value);
				} else if(index == 1) { // Mostra a idade pelo ID
					System.out.println("Aluno com o ID " + value + " tem " + age[i] + " anos");
				} else { // Aniversário
					age[i]++;
					System.out.println("Idade do aluno com ID " + id[i] + " incrementada com sucesso. Novo valor: " + age[i] + " anos");
				}
				
				aux = 1;
				break;
			}
			
			if(index == 3) { // Verifica se existem idades repetidas
				for(int j = i+1; j < (age.length); j++) {
					if(age[i] == age[j]) {
						aux = 1;
					}
				}
				
				if(aux == 1) {
					System.out.println("Existem idades repetidas.");
				} else
					System.out.println("Não existem idades repetidas.");
				aux = 1;
				break;
			}
		}
		
		if(aux == 0) { 
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}
	}

	private static void CalculateAge(int id[], int age[], int index) {
		int younger = age[0], average = 0;
		
		for(int i = 0; i < age.length; i++) {
			if(index==1) {
				if(age[i] <= younger) {
					younger = age[i];
				}
				if(younger == age[i]) {
					System.out.println("O aluno com o ID " + id[i] + " é o mais novo (" + age[i] + " anos)\n");
					break;
				}
			} else {
				average += age[i];
			}
		}
		
		if(index != 1) {
			average /= age.length;
			System.out.printf("Média de idade dos alunos: " + average);
		}
	}
}


