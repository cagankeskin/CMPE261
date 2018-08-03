package ws2;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		MobilePhone x = new MobilePhone("a",2.5,"e");
		MobilePhone y = new MobilePhone("b",2.5,"f");
		MobilePhone z = new MobilePhone("c",2.5,"g");
		MobilePhone v = new MobilePhone("d",2.5,"h");
		ArrayList<MobilePhone> list=new ArrayList<>();
		list.add(x);
		list.add(y);
		list.add(z);
		list.add(v);

		for (MobilePhone a:list) {
			
			if (a.getBrand().equals("ab")) {
				int b=list.indexOf(a);
				list.remove(b);
			}
		}
		
		System.out.println(list);
	}
}
