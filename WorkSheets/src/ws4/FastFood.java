package ws4;

import javax.swing.JOptionPane;

public class FastFood {
	
	public static void main(String[] args) {
	Object[] food= {"Hamburger","Pizza","Salad"};
	String s = (String) JOptionPane.showInputDialog(null,
	"Select the food.",
	"Order Food", JOptionPane.QUESTION_MESSAGE, null, food,
	"ham");
	// If a string was returned, say so.
	if ((s != null) && (s.length() > 0)) {
		int price=0;
		String number = JOptionPane.showInputDialog(null, "How many "+s+" do you want?");
		int n=Integer.parseInt(number);
		if(s.equals(food[0]))price=12*n;
		else if(s.equals(food[1]))price=15*n;
		else if(s.equals(food[2]))price=10*n;		
		
		JOptionPane.showMessageDialog(null, "You have to pay "+price+" TL." );
	return;
	}
	/* If you are here, the return value was null/empty. */
	System.out.println("Come on buy something!");
	}
}
