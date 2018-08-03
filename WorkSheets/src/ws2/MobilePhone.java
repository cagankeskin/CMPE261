package ws2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MobilePhone {

	private String brand, color;
	private double price;
	
	public MobilePhone(){
	}
	public MobilePhone(String b,double p,String c){
		brand=b;price=p;color=c;
	}
	public void setBrand(String b){
		brand=b;
	}
	public void setColor(String c){
		color=c;
	}
	public void setPrice(double p){
		price=p;
	}
	public String getBrand(){
		return brand;
	}
	public String getColor(){
		return color;
	}
	public double getPrice(){
		return price;
	}
	public String toString(){
		return "Brand is: "+brand+" Color is: "+color+" Price is: "+price;
	}
	
	public static void printList(ArrayList<MobilePhone> x){
		for(MobilePhone a:x){
			System.out.println(a.toString());
		}
			System.out.println("******");
	}
	//Searching Phone in ArrayList method
	public static int searchPhone(ArrayList<MobilePhone> list,MobilePhone e){
		return list.indexOf(e);
	}
	
	public static void main(String [] args){
		// Create new ArrayList.
        ArrayList<MobilePhone> phones = new ArrayList<>();
        // Create 5 elements.
        MobilePhone p1 = new MobilePhone("Apple",1700,"Space Gray");
        MobilePhone p2 = new MobilePhone("LG",2000,"White");
        MobilePhone p3 = new MobilePhone("Sony",1700,"Black");
        MobilePhone p4 = new MobilePhone("Nokia",1500,"Black");
        MobilePhone p5 = new MobilePhone("Sony",3000,"Yellow");
        // Add 5 elements to ArrayList.
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        phones.add(p5);
        //Printing List
        printList(phones);
        //Replacing new element with first element.
        MobilePhone p6 = new MobilePhone("Blackberry",2790,"Black");
        phones.set(0,p6);
        //Printing List to see the change
        printList(phones);
        //Deleting last 2 elements
        phones.remove(phones.size()-1);
        phones.remove(phones.size()-1);
        //Printing List to see the change
        printList(phones);
        //Replace 2nd and 3rd element.
        MobilePhone temp=phones.get(1);
        phones.set(1, phones.get(2));
        phones.set(2, temp);
        //Printing List to see the change
        printList(phones);
      //Sorting ArrayList By Price
        System.out.println("Sorting ArrayList By Price");
        Collections.sort(phones, new Comparator<MobilePhone>() {
            @Override
            public int compare(MobilePhone p1, MobilePhone p2)
            {
                return  (new Double(p1.getPrice()).compareTo((Double)p2.getPrice()));
            }
        });
        printList(phones);
      //Sorting ArrayList By Brand
        System.out.println("Sorting ArrayList By Brand Name");
        Collections.sort(phones, new Comparator<MobilePhone>() {
            @Override
            public int compare(MobilePhone p1, MobilePhone p2)
            {

                return  p1.getBrand().compareTo(p2.getBrand());
            }
        });
        printList(phones);
	}
}
