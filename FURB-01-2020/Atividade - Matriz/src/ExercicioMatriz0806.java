import javax.swing.JOptionPane;

public class ExercicioMatriz0806 {

	public static void main(String[] args) {
		String input;
		int matrixA[][], matrixB[][], matrixC[][], matrixD[][], aux = 1;
		
		matrixA = new int[4][4];
		matrixB = new int[4][4];
		matrixC = new int[4][4];
		matrixD = new int[4][4];

		while (aux != 0) {
			
			if(aux != 1) {
				input = JOptionPane.showInputDialog("Deseja executar uma nova operação? \n 1 - Sim \n 0 - Não");
				aux = Integer.parseInt(input);
			}
			
			switch (aux) {
			case 1: {
				Populate(matrixA);
				
				// mB = mA'
				Transposed(matrixA, matrixB);
				
				// mC = mA + mB
				SumMatrix(matrixA, matrixB, matrixC);
		
				// mD = mA * mB
				Multiplication(matrixA, matrixB, matrixD);
				
				ShowMatrix(matrixA, "A");
				ShowMatrix(matrixB, "B");
				ShowMatrix(matrixC, "C");
				ShowMatrix(matrixD, "D");
				
				System.out.println("\nSoma diagonal A: " + Diagonal(matrixA));
				System.out.println("Soma diagonal B: " + Diagonal(matrixB));
				System.out.println("Soma diagonal C: " + Diagonal(matrixC));
				System.out.println("Soma diagonal D: " + Diagonal(matrixD));
				
				aux = 2;
				break;
			} 
			default:
				break;
			}
		}
	}
	
	public static void SumMatrix(int matrix1[][], int matrix2[][], int matrix3[][]) {
		int i, j;
		
		for(i = 0; i < matrix1.length; i++) {
			for(j = 0; j < matrix1.length; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
	}
	
	public static void Multiplication(int matrix1[][], int matrix2[][], int matrix3[][]) {
		int i, j, k, aux = 0;
		
		for(i = 0; i < matrix1.length; i++) {
			for(j = 0; j < matrix1.length; j++) {
				aux = 0;
				for(k = 0; k < matrix1.length; k++) {
					aux += (matrix1[i][k] * matrix2[k][j]);
					matrix3[i][j] = aux;
				}
			}
		}
	}
	
	public static void Transposed(int matrix1[][], int matrix2[][]) {
		int i, j;
		for(i = 0; i < matrix1.length; i++) {
			for(j = 0; j < matrix1.length; j++) {
				matrix2[j][i] = matrix1[i][j]; 
			}
		}
	}
	
	public static int Diagonal(int matrix[][]) {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		
		return sum;
	}

	public static void Populate(int matrix[][]) {
		String input;
		int i, j;
		
		for(i = 0; i < matrix.length; i++) {
			for(j = 0; j < matrix.length; j++) {
				input = JOptionPane.showInputDialog("Digite o índice [" + (i) + "]" + "[" + (j) + "]");
				matrix[i][j] = Integer.parseInt(input);
			}
		}
	}
	
	public static void ShowMatrix(int matrix[][], String index) {
		int i, j;
		
		System.out.println("\n ----VALORES DA MATRIZ " + index + "----\n");
		
		for(i = 0; i < matrix.length; i++) {
			for(j = 0; j < matrix.length; j++) {
				System.out.print(" [" + matrix[i][j] + "] ");
				if(j==matrix.length-1) {
					System.out.print("\n");
				}

			}
		}
	}
}
