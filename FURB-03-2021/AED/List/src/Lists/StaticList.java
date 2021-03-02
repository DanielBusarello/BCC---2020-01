package Lists;

public class StaticList {
	private int[] data;
	private int size;
	
	public StaticList() {
		data = new int[10];
		size = 0;
	}
	
	public StaticList(int size) {
		data = new int[size];
		size = 0;
	}
	
	public void add(int e) {
		if(size == data.length) {
			this.resize();
		}
		
		data[size] = e;
		size++;
	}
	
	public int find(int e) {
		int aux = -1;
		for(int i = 0; i < size; i++) {
			if(data[i] == e) {
				aux = i;
				break;
			}
		}

		return aux;
	}
	
	public int size() {
		return this.size;
	}
	
	public void remove(int e) {
		boolean removed = false;
		
		for(int i = 0; i < size-1; i++) {
			if(data[i] == e) {
				removed = true;
				size--;
			} 
			
			if(removed) {
				data[i] = data[i+1];
			}
		}
		
		removed = false;
	}
	private void resize() {
		int[] tempArr = new int[data.length + 10];;
		
		for(int i = 0; i < size-1; i++) {
			tempArr[i] = data[i];
		}
		
		data = tempArr;
	}
	
	private void setType(String type) {
		switch(type) {
			case "int": {
				int[] data = new int[10];
				break;
			}
			case "double": {
				double[] data = new double[10];
			}
			case "String": {
				String[] data = new String[10];
				break;
			}
			case "float": {
				float[] data = new float[10];
				break;
			}
			default: {
				System.out.print("Erro ao criar a lista! O tipo '" + type + "' não está disponível.");
			}
		}
	}
}
