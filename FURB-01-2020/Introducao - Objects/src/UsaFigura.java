import javax.swing.JOptionPane;

public class UsaFigura {

	public static void main(String[] args) {
		int num, i = 0;
		String input;
		QuadradoClass meu, teu;
		Retangulo ret1, ret2;
		
		input = JOptionPane.showInputDialog("Informe o lado do quadrado meu");
		num = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("Informe a cor do quadrado meu");
		meu = new QuadradoClass(num, input);
		
		System.out.println("--- Meu --- \nArea: " + meu.Area());
		System.out.println("Perímetro: " + meu.Perimetro());
		
		teu = new QuadradoClass(25, "amarelo");
		
		System.out.println("--- Teu --- \nArea: " + teu.Area());
		System.out.println("Perímetro: " + teu.Perimetro());
		
		input = JOptionPane.showInputDialog("Informe o lado maior do retângulo 1: ");
		num = Integer.parseInt(input);
		
		do {
			input = JOptionPane.showInputDialog("Informe o lado menor do retângulo 1: ");
			i = Integer.parseInt(input);	
		} while (i >= num);
		
		input = JOptionPane.showInputDialog("Informe a cor do retângulo 1: ");
		
		ret1 = new Retangulo(num, i, input);
		ret2 = new Retangulo(15, 6, "Verde");
		
		System.out.println("\n --- Ret1 --- \nArea: " + ret1.Area());
		System.out.println("Perímetro: " + ret1.Perimetro());
		
		System.out.println("--- Ret2 --- \nArea: " + ret2.Area());
		System.out.println("Perímetro: " + ret2.Perimetro());
		
	}
}
