import javax.swing.JOptionPane;

public class Aula2603 
   {public static void main(String[] args) 
	{
	   int idade;
	   String nome, entra;
	   
	   nome = JOptionPane.showInputDialog("NOME? ");
	   System.out.println("Bom dia "+ nome);
	   
	   entra = JOptionPane.showInputDialog("QUAL SUA IDADE?");
	   idade = Integer.parseInt(entra);
	   System.out.println("Você tem " + idade + " anos");
	}
   }

	