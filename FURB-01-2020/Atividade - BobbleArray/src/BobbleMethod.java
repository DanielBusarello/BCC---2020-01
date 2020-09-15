import java.util.Random;
import javax.swing.JOptionPane;

public class BobbleMethod {

	public static void main(String[] args) {
		
		String input;
		int nums[] = new int[20], i, a, control = 0;
		
		for(i = 0; i < nums.length; i++) {
			nums[i] = new Random().nextInt(100) + 1;
		}
		
		while(control < 5) {
			input = JOptionPane.showInputDialog("1. Mostrar \n\t2. Ordenar Crescente \n\t3. Ordenar Decrescente \n\t4. Inverter \n\t5. Sair");
			control = Integer.parseInt(input);
			
			switch(control) {
				case 1:{
					for(i = 0; i < nums.length; i++) {
						System.out.print(" " + nums[i]);
					}
					break;
				}
				case 2:{
					for(int j = 1; j <= (nums.length - 1); j++) {
						for(i = 0; i < (nums.length - 1); i++) {
							if(nums[i] > nums[i + 1]) {
								a = nums[i];
								nums[i] = nums [i + 1];
								nums [i + 1] = a;
							}
						}
					}
					break;
				}
				case 3:{
					for(int j = 1; j <= (nums.length - 1); j++) {
						for(i = 0; i < (nums.length - 1); i++) {
							if(nums[i] < nums[i + 1]) {
								a = nums[i];
								nums[i] = nums [i + 1];
								nums [i + 1] = a;
							}
						}
					}
					break;
				}
				case 4:{
					for(int j = nums.length - 1; j >= 0; j--) {
		                System.out.print(" " + nums[j]);
		            }
					break;
				}
			}
		}
	}
}


