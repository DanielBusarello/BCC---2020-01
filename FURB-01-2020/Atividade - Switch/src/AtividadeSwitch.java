import javax.swing.JOptionPane;

public class AtividadeSwitch {
	public static void main(String[] args) 
	 {/* Este programa serve para ensinar algums operações matemáticas básicas 
	     para crianças */
		
 	    int numero, opcao, aux, giro, fat = 1;
 	    String entra;
	    for(giro = 1; giro <= 5; giro = giro +1) {
	    	entra = JOptionPane.showInputDialog("SISTEMA OPERACOES MATEMATICAS"+ 
			   "\n\n\t1. DOBRO\n\t2. QUADRADO"+ 
			   "\n\t3. TRIPLO\n\t4. CUBO\n\t5. FATORIAL\n\t6. PRIMO/NÃO PRIMO\n\t7. PAR/IMPAR \n\n\tQUAL A OPERACAO VOCE QUER APRENDER ");
	    	opcao  = Integer.parseInt(entra);
	        numero = 0;
	        if (opcao <= 7)
	       	     {entra = JOptionPane.showInputDialog("AGORA INFORME UM NUMERO");
	              numero = Integer.parseInt(entra);
	       	     } 
	       	switch (opcao) {
	       		case 1: aux = numero * 2;
	       			System.out.println("DOBRO DE "+numero+" = "+aux);
	       			break;
	       		case 2: aux = numero * numero;
	   		        System.out.println("QUADRADO DE "+numero+" = "+aux);
	   		        break;
	       		case 3: aux = numero * 3;
	       			System.out.println("TRIPLO DE "+numero+" = "+aux);
	       			break;
	       		case 4: aux = numero * numero * numero;
	       			System.out.println("CUBO DE "+numero+" = "+aux);
	       			break;
	       		case 5: {
	       			for(int i = numero; i > 1; i--) {
	       				fat *= i;
	       			}
	       			
	       			System.out.println("FATORIAL DE " + numero + " = " + fat);
	       			fat = 1;
	       			break;
	       		}
	       		case 6: {
	       			aux = 0;
	       			for(int i = 1; i <= numero; i++) {
	       				if(numero % i == 0) {
	       					aux++;
	       				}	
	       			}
	       			if(aux > 2) {
       					System.out.println("NÃO É PRIMO");
       				} else {
       					System.out.println("É PRIMO");
       				}
	       			break;
	       		}
	       		case 7:
	       			if(numero % 2 == 0) { 
	       				System.out.println("É PAR");
	       			}else { 
	       				System.out.println("É IMPAR");
       				}
	       			break;
	       		default: System.out.println("OPCAO INVALIDA"); 		 
	       	}
	    }
	    
	    System.out.println("OBRIGADO POR USAR SISTEMA. DESENVOLVIDO POR DANIEL BUSARELLO ");
	 }
}
