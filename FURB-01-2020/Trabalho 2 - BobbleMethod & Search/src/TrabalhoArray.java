import javax.swing.JOptionPane;

public class TrabalhoArray {

	public static void main(String[] args) {
		
		String input;
		int id[] = new int[5], age[] = new int[id.length];
		int aux = 0, i = 0, j = 0, average = 0, older = 0;
		boolean sameId = true;
		
		for(i = 0; i < id.length; i++) {
			input = JOptionPane.showInputDialog("Digite o ID de matrícula do funcionário " + (i + 1) + ": \n");
			id[i] = Integer.parseInt(input);
			
			sameId = true;
			
			if(i>0) { // Checks if the ID is the same
				for(j = 0; j < i; j++) {
					sameId = true;
					while(sameId) { 
						if(id[i] == id[j]) {
							JOptionPane.showMessageDialog(null, "ID's repetidos não são permitidos!");
							input = JOptionPane.showInputDialog("Digite o ID de matrícula do funcionário " + (i + 1) + " novamente: \n");
							id[i] = Integer.parseInt(input);
						} else
							sameId = false;
					}
				}
			}
			
			input = JOptionPane.showInputDialog("Digite a idade do funcionário " + (i + 1) + ": \n");
			age[i] = Integer.parseInt(input);
			
			average += age[i];
		}
		
		while(aux != 99) {
			input = JOptionPane.showInputDialog("Selecione uma opção:\n" + "1. MOSTRAR\n" + "2. ORDENAR CRESCENTE\n" +
					"3. ORDENAR DECRESCENTE\n" + "4. INVERTER\n" + "5. PROCURAR MATRICULA\n" + "6. PROCURAR IDADE\n" + 
					"7. MEDIA\n" + "8. MAIS IDOSO\n" + "9. ANIVERSARIO\n" + "10. IDADE REPETIDA\n" + "99. VAZAR");
			aux = Integer.parseInt(input);
			
			switch(aux) {
				case 1:	{
					for(j = 0; j < id.length; j++) {
						System.out.println("Funcionário "+(j+1)+": ID: "+id[j]+" | Idade: "+age[j]+" anos");
					}
					System.out.print("\n");
					break;
				} case 2: {
					OrganizeVect(id, age, 0); //SearchVect(vector, operation, index, code (id/age)) 
					break;
				} case 3: {
					OrganizeVect(id, age, 1); 
					break;
				} case 4: {
					OrganizeVect(id, age, 2);
					break;
				} case 5: {
					input = JOptionPane.showInputDialog("Digite o ID do funcionário: ");
					aux = Integer.parseInt(input);
					SearchID(id, age, 0, aux); //SearchID(vect1, vect2, index, value) -> index 0 = find ID; index 1 = find age by ID;
					break;
				} case 6: {
					input = JOptionPane.showInputDialog("Digite o ID para buscar a idade do funcionário");
					aux = Integer.parseInt(input);
					SearchID(id, age, 1, aux);
					break;
				} case 7: {
					average /= age.length;
					System.out.println("Média de idade dos funcionários: " + average);
					break;
				} case 8: {
					for(i = 0; i < id.length; i++) {
						if(age[i] > older) {
							older = age[i];
						}
					}
					for(i = 0; i < id.length; i++) {
						if(older == age[i]) {
							System.out.println("O funcionário com o ID " + id[i] + " é o mais velho (" + age[i] + " anos)\n");
							break;
						}
					}
					break;
				} case 9: {
					input = JOptionPane.showInputDialog("Digite o ID para buscar o funcionário aniversariante");
					aux = Integer.parseInt(input);
					SearchID(id, age, 2, aux);
					break;
				} case 10: { //Same age
					for(i = 0; i < age.length; i++) {
						for(j = i+1; j < (age.length); j++) {
							if(age[i] == age[j]) {
								aux = 1;
							}
						}
					}
					if(aux == 1) {
						System.out.println("Existem idades repetidas.");
					}
					else
						System.out.println("Não existem idades repetidas.");
					
					aux = 0;
					break;
				} case 99:{
					JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema. Saindo...\n \t\t   Desenvolvido por Daniel Busarello");
					break;
				}
					default:{
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
				}
			}
		}
	}
	
	public static void OrganizeVect(int id[], int age[], int index) {
		int aux = 0;
		int i, j = 0;
		
		if(index == 2) { //Reverse vector
			for(i = 0; i < id.length / 2; i++) {
				aux = id[i];
				id[i] = id[id.length - i - 1];
				id[id.length - i - 1] = aux;
				
				aux = age[i];
				age[i] = age[age.length - i - 1];
				age[age.length - i - 1] = aux;
			}
		} 
		else {
			for(i = 0; i <= (id.length - 1); i++) {
				for(j = 0; j < (id.length - 1); j++) {
					if(index == 0) { //Organize vector ascending
						if(id[j] > id[j+1]) {
							aux = id[j];
							id[j] = id[j+1];
							id[j+1] = aux;
							 
							aux = age[j];
							age[j] = age[j+1];
							age[j+1] = aux;
						}
					} else{ //Organize vector descending
						if(id[j] < id[j+1]) {
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
	}
	
	public static void SearchID(int id[], int age[], int index, int value) {
		int aux = 0;
		
		for(int i = 0; i < id.length; i++) {
			if(id[i] == value) {
				if(index == 0) {
					System.out.println("Funcionário encontrado! ID: " + value);
				} else if(index == 1) {
					System.out.println("Funcionário com o ID " + value + " tem: " + age[i] + " anos");
				} else if(index == 2) {
					age[i]++;
					System.out.println("Idade do funcionário com ID " + id[i] + " incrementada com sucesso. Novo valor: " + age[i] + " anos");
				}
				aux = 1;
				break;
			} 
		}
		if(aux == 0) {
			System.out.println("Funcionário não encontrado!");
		}
		aux = 0;
	}
	
}

