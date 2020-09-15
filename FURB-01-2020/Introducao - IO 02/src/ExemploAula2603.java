import javax.swing.JOptionPane;

public class ExemploAula2603 
  {
	public static void main(String[] args) 
      {
		String entra;
		int largura,profundidade,area;
		
		entra = JOptionPane.showInputDialog("INFORME A LARGURA DA SALA");
		largura = Integer.parseInt(entra);
		
		entra = JOptionPane.showInputDialog("INFORME A PROFUNDIDADE DA SALA");
		profundidade = Integer.parseInt(entra);
		
		area = largura * profundidade;
		System.out.println("AREA DA SALA = " + area + " METROS QUADRADOS");
       }
  }