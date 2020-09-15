public class Retangulo {
	private int ladoMaior;
	private int ladoMenor;
	private String cor;
	
	Retangulo(int ldMaior, int ldMenor, String cr) {
		ladoMaior = ldMaior;
		ladoMenor = ldMenor;
		cor = cr;
	}
	
	public int Area() {
		return ladoMaior * ladoMenor;
	}
	
	public int Perimetro() {
		return (ladoMaior + ladoMenor) * 2;
	}
	
	public void Pintar(String como) {
		cor = como;
	}
}
