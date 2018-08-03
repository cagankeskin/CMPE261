import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
/**
 * 
 * @author Abraham
 * @schoolno 11512112
 */
public class Seat {
	/**
	 * Setting up the variables
	 */
	public JTextField field;
	String occupiedBy;
	
	/**
	 * Default constructor
	 */
	public Seat() {
		// TODO Auto-generated constructor stub
		field = new JTextField();
		field.setEditable(false);
		field.setText("Not Booked");
		field.setBackground(Color.WHITE);
		field.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field.setEditable(false);
	}
	
	/**
	 * This method sets the seat as booked
	 * with occupiedBy(as thread name)
	 * and sets the textfield red with "booked by agent ****"
	 */
	public void setBooked() {
			field.setForeground(Color.WHITE);
			field.setFont(new Font("Tahoma", Font.PLAIN, 15));
			field.setBackground(Color.RED);
			field.setEditable(false);
			occupiedBy = Thread.currentThread().getName();
			field.setText("Booked by Agent " + occupiedBy);
			

	}
}
