import javax.swing.JOptionPane;

public class Prova2 {

	public static void main(String[] args) {
		int id[] = new int[10], age[] = new int[id.length], uf[] = new int[id.length]; 
		int i, j = 0, aux = 0, average = 0, older = 0;
		boolean sameId = true;
		String input;
		
		for(i = 0; i < id.length; i++) {
			input = JOptionPane.showInputDialog("Digite o número da matrícula do aluno " + (i + 1) + ":");
			
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
			
			
			input = JOptionPane.showInputDialog("Digite o ano de nascimento do aluno " + (i + 1) + ": (formato XXXX).");
			age[i] = Integer.parseInt(input);
			
			while(age[i] < 1920 || age[i] > 2006) {
				JOptionPane.showMessageDialog(null, "Formato incorreto ou idade não permitida (menor de 14 ou mais de 100 anos)");
				input = JOptionPane.showInputDialog("Digite o ano de nascimento do aluno " + (i + 1) + " novamente: (formato XXXX).");
				age[i] = Integer.parseInt(input);
			}
			
			input = JOptionPane.showInputDialog("Digite o estado de origem do aluno " + (i + 1) + ":" 
					+ "\n(1-AC, 2-AL, 3-AP, 4-AM, 5-BA, 6-CE, 7-DF, 8-ES, 9-GO, "
					+ "\n10-MA, 11-MT, 12-MS, 13-MG, 14-PA, 15-PB, 16-PR, 17-PE, 18-PI, 19-RJ, "
					+ "\n20-RN, 21-RS, 22-RO, 23-RR, 24-SC, 25-SP, 26-SE, 27-TO)");
			uf[i] = Integer.parseInt(input);
			
			while(uf[i] < 1 || uf[i] > 27) {
				JOptionPane.showMessageDialog(null, "Estado não encontrado!");
				input = JOptionPane.showInputDialog("Digite o estado de origem do aluno " + (i + 1) + " novamente:" 
						+ "\n(1-AC, 2-AL, 3-AP, 4-AM, 5-BA, 6-CE, 7-DF, 8-ES, 9-GO, "
						+ "\n10-MA, 11-MT, 12-MS, 13-MG, 14-PA, 15-PB, 16-PR, 17-PE, 18-PI, 19-RJ, "
						+ "\n20-RN, 21-RS, 22-RO, 23-RR, 24-SC, 25-SP, 26-SE, 27-TO)");
				uf[i] = Integer.parseInt(input);
			}
			average += (2020 - age[i]);
		}
		
		// Media idade e aluno(s) mais novo(s)
		
		average /= age.length;
		System.out.println("Idade média dos alunos: " + average);
		
		System.out.println("Aluno(s) mais novo(s) que a média de idade:");
		for(i = 0; i < id.length; i++) {
			if(2020 - age[i] < average) {
				System.out.println("ID: " + id[i] + " | Ano de nascimento: " + age[i]);
			} 
			
		}
		
		// Aluno(os) mais velho(os)
		
		for(i = 0; i < id.length; i++) {
			if((2020 - age[i]) > older) {
				older = (2020 - age[i]);
			}
		}
		
		System.out.println("\nAluno(s) mais velho(s): ");
		for(i = 0; i < id.length; i++) {
			if(2020 - age[i] == older) {
				System.out.println("ID: " + id[i] + " | Idade: " + (2020 - age[i]) + " anos | Estado: " + UF(uf, i));
			}
		}
		
		// Verifica estados repetidos
		
		for(i = 0; i < uf.length; i++) {
			for(j = i+1; j < (uf.length); j++) {
				if(uf[i] == uf[j]) {
					aux = 1;
					break;
				}
			}
		}
		if(aux == 1) {
			System.out.println("\nExistem alunos do mesmo estado.\n");
		}
		else
			System.out.println("\nNão existem alunos do mesmo estado.\n");
		
		// Organiza o vetor em ordem crescente
		
		for(i = 0; i <= (id.length - 1); i++) {
			for(j = 0; j < (id.length - 1); j++) {
				if(age[j] < age[j+1]) {
					aux = age[j];
					age[j] = age[j+1];
					age[j+1] = aux;
					
					aux = id[j];
					id[j] = id[j+1];
					id[j+1] = aux;
					
					aux = uf[j];
					uf[j] = uf[j+1];
					uf[j+1] = aux;
				}
			}
		}
		
		for(i = 0; i < id.length; i++) {
			System.out.println("Aluno "+ (i+1) + " | Matrícula: " + id[i] + " | Idade: " + (2020 - age[i]) + " anos ");
		}
		
	}
	
	public static String UF(int uf[], int i) {
		switch(uf[i]) {
			case 1: return "AC";
			case 2: return "AL";
			case 3: return "AP";
			case 4: return "AM";
			case 5: return "BA";
			case 6: return "CE";
			case 7: return "DF";
			case 8: return "ES";
			case 9: return "GO";
			case 10: return "MA";
			case 11: return "MT";
			case 12: return "MS";
			case 13: return "MG";
			case 14: return "PA";
			case 15: return "PB";
			case 16: return "PR";
			case 17: return "PE";
			case 18: return "PI";
			case 19: return "RJ";
			case 20: return "RN";
			case 21: return "RS";
			case 22: return "RO";
			case 23: return "RR";
			case 24: return "SC";
			case 25: return "SP";
			case 26: return "SE";
			case 27: return "TO";
			default: return null;
		}
		 
	}

}
