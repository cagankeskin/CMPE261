import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ibrahim Dogan
 * @schoolno 11512112
 * @comments I have fun with this project actually
 * First I learned how to use locks and threads with real example.
 * Second I learned how to use Layouts(Grid,Flow,Border).
 */
public class Test extends JFrame implements ActionListener, Runnable {
	/**
	 * Setting up the variables
	 */
	private int noOfSeats;
	private int noOfAgents;
	private int noOfWait;
	private JFrame frame;
	private JTextField seatNumber;
	private JTextField agentNumber;
	private JTextField waitTime;
	private JPanel panel_1;
	private Seat[] seats;
	private Random ran = new Random();

	private int counter = 0;
	private Lock lock = new ReentrantLock();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Test window = new Test();
		window.frame.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		// User Area Starts
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel seatsLabel = new JLabel("Seats");
		panel.add(seatsLabel);

		seatNumber = new JTextField();
		panel.add(seatNumber);
		seatNumber.setColumns(10);

		JLabel AgentsLabel = new JLabel("Number of Agents");
		panel.add(AgentsLabel);

		agentNumber = new JTextField();
		panel.add(agentNumber);
		agentNumber.setColumns(10);

		JLabel maxWaitTime = new JLabel("Waiting Time");
		panel.add(maxWaitTime);

		waitTime = new JTextField();
		panel.add(waitTime);
		waitTime.setColumns(10);

		JButton createSeats = new JButton("Create Seats");
		createSeats.addActionListener(this);
		panel.add(createSeats);

		JButton bookSeats = new JButton("Book Seats");
		bookSeats.addActionListener(this);
		panel.add(bookSeats);
		// End of User Area
		
		//Seat area starts
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(8, 8, 10, 10));
		//Seat area ends
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("Create Seats")) {
			noOfSeats = Integer.parseInt(seatNumber.getText());
			seats = new Seat[noOfSeats];
			for (int i = 0; i < noOfSeats; i++) {
				Seat s = new Seat();
				seats[i] = s;
				panel_1.add(s.field);
			}
			// validating for debug(jpanel does not refresh)
			frame.validate();
		}

		else if (arg0.getActionCommand().equals("Book Seats")) {
			noOfAgents = Integer.parseInt(agentNumber.getText());
			noOfWait = Integer.parseInt(waitTime.getText());
			for (int i = 1; i <= noOfAgents; i++) {
				Thread t = new Thread(this);
				t.setName(i + "");
				t.start();

			}
		}

	}
	/**
	 * I used counter as index in here
	 * to set book seats
	 */
	public void run() {
		while (counter<seats.length) {
			try {
				Thread.sleep(ran.nextInt(noOfWait));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.lock();
			if(counter<seats.length) {
			seats[counter].setBooked();
			
			//System.out.println(counter+" occ by "+ seats[counter].occupiedBy);
			counter++;}
			else {
				endMessage();
			}
			lock.unlock();
			
		}
	}
	/**
	 * end message and calculating 
	 * occupied seats by agents
	 */
	private synchronized void endMessage() {
		// TODO Auto-generated method stub
		int [] agentsSeats= new int[noOfAgents];
		for (int i = 0; i < agentsSeats.length; i++) {
			int counter=0;
			for (int j = 0; j < seats.length; j++) {
				int occupiedBy=Integer.parseInt(seats[j].occupiedBy);
				if((occupiedBy-1)==i) {
					counter++;
					agentsSeats[i]=counter;
				}
			}
		}
		String str="";
		for (int i = 0; i < agentsSeats.length; i++) {
			str=str+"Agent "+(i+1)+" took "+agentsSeats[i]+" seats.\n";
		}
		JOptionPane.showMessageDialog(this, str);
		System.exit(0);

	}
}
