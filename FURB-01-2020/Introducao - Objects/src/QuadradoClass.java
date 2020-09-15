public class QuadradoClass {

	private int lado;
	private String cor;

	// Método construtor
	QuadradoClass(int ld, String cr) {
		lado = ld;
		cor = cr;
	}
	
	public int Area() {
		int result;
		result = lado * lado;
		return result;
	}
	
	public int Perimetro() {
		int prt;
		prt = 4 * lado;
		return prt;
	}
	
	public void Pintar(String como) {
		cor = como;
	}
}
