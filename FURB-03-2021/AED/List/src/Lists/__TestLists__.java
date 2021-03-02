package Lists;

import java.util.ArrayList;

public class __TestLists__ {

	public static void main(String[] args) {
		StaticList staticList = new StaticList();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		staticList.add(10);
		staticList.add(20);
		staticList.add(30);
		staticList.add(40);
		staticList.add(50);
		
		arrayList.add(10);
		arrayList.add(20);
		
		staticList.remove(40);
		System.out.println(staticList.find(20));
		System.out.println(staticList.find(40));
		System.out.println(staticList.find(50));

		System.out.println("Size: " + staticList.size());
		
	}

}
