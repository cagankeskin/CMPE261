import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 * @version 2.0
 * @author Ibrahim Dogan
 */
public class StudentProgram extends JFrame implements ActionListener {

/**
 * defining variables
 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane myPanes;
	private JPanel pValue;
	private JPanel pDraw;
	private boolean isSelected = false;
	private List<Student> listStudents;
	private DrawChart chart;
	private JScrollPane show;
	List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
	DefaultTableModel model = new DefaultTableModel(new String[] { "First Name", "Last Name", "ID", "Quiz 1", "Quiz 2",
			"Project", "Midterm", "Final", "Average", "Letter Grade" }, 0);

	TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	private JTable table = new JTable(model);

	public StudentProgram() throws FileNotFoundException{
		super("Student Program Version 2.0");
		setVisible(true);

		/*
		 * Menu
		 */

		JMenuBar menubar = new JMenuBar();
		// Student Menu
		JMenu student = new JMenu("Student");

		JMenuItem addStudent = new JMenuItem("Add Student");
		addStudent.addActionListener(this);
		student.add(addStudent);

		JMenuItem removeStudent = new JMenuItem("Remove Student");
		removeStudent.addActionListener(this);
		student.add(removeStudent);

		JMenuItem removeAll = new JMenuItem("Remove All Students");
		removeAll.addActionListener(this);
		student.add(removeAll);

		menubar.add(student);
		// Student Menu Ends

		// Sort Menu
		JMenu sort = new JMenu("Sort");

		JMenuItem sortLastName = new JMenuItem("Sort by Last Name");
		sortLastName.addActionListener(this);
		sort.add(sortLastName);

		JMenuItem sortID = new JMenuItem("Sort by ID");
		sortID.addActionListener(this);
		sort.add(sortID);

		JMenuItem sortAvg = new JMenuItem("Sort by Average");
		sortAvg.addActionListener(this);
		sort.add(sortAvg);

		menubar.add(sort);
		// Sort Menu Ends

		// Filter Menu
		JMenu filter = new JMenu("Filter");

		JMenuItem filterLetter = new JMenuItem("Filter by Letter Grade");
		filterLetter.addActionListener(this);
		filter.add(filterLetter);

		JMenuItem removeFilter = new JMenuItem("Remove Filter");
		removeFilter.addActionListener(this);
		filter.add(removeFilter);

		menubar.add(filter);
		// Sort Menu Ends

		setJMenuBar(menubar);

		pValue = new JPanel();
		pValue.setLayout(new GridLayout());
		// Get students from txt
		listStudents = getStudentFromText();
		// add data to jtable
		rowData(listStudents);

		table.setRowSelectionAllowed(true);
		table.setEnabled(true);
		// Append a row

		show = new JScrollPane(table);
		pValue.add(show);

		pDraw = new JPanel();
		pDraw.setLayout(new BorderLayout());
		chart = new DrawChart(listStudents);
		pDraw.add(chart);

		myPanes = new JTabbedPane();
		myPanes.addTab("Values", pValue);
		myPanes.addTab("Chart", pDraw);

		add(myPanes);

		setSize(1000, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * to remove all data in table
	 */
	public void clearTable() {
		sortKeys.removeAll(sortKeys);
		table.setRowSorter(null);
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		table.setRowSorter(sorter);
	}

	/**
	 * to add data to table
	 * 
	 * @param listStudents
	 */
	public void rowData(List<Student> listStudents) {
		table.setRowSorter(sorter);
		for (Student s : listStudents) {
			model.addRow(
					new String[] { s.getFname() + "", s.getLname() + "", s.getId() + "", s.getQ1() + "", s.getQ2() + "",
							s.getP() + "", s.getM() + "", s.getF() + "", s.getAverage() + "", s.getLgrade() + "" });
		}
	}

	/**
	 * to sort the specific column with index i
	 * 
	 * @param i
	 */
	public void SortColumn(int i) {
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();

		int columnIndexToSort = i;
		if (isSelected == true) {
			isSelected = false;
			sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

		} else if (isSelected == false) {
			isSelected = true;
			sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

		}
		sorter.setSortKeys(sortKeys);
		sorter.sort();
	}

	/**
	 * @param n
	 * @return puts n times student randomly in list.
	 */
	public List<Student> generateStudents(List<Student> listStudents, int n) {
		for (int i = 0; i < n; i++) {
			Student s = new Student();
			listStudents.add(s);
			model.addRow(
					new Object[] { s.getFname() + "", s.getLname() + "", s.getId() + "", s.getQ1() + "", s.getQ2() + "",
							s.getP() + "", s.getM() + "", s.getF() + "", s.getAverage() + "", s.getLgrade() + "" });
		}

		return listStudents;
	}

	/**
	 * to read student.txt to catch data
	 * 
	 * @return List
	 * @throws FileNotFoundException
	 */
	public List<Student> getStudentFromText() throws FileNotFoundException {

		ArrayList<Student> list = new ArrayList<>();
		Scanner read = new Scanner(new File("student.txt"));
		String line = read.nextLine();
		read.close();
		String[] array = line.split(" ");
		for (int i = 0; i < array.length; i = i + 10) {
			Student temp = new Student(array[i], array[i + 1], array[i + 2], Double.parseDouble(array[i + 3]),
					Double.parseDouble(array[i + 4]), Double.parseDouble(array[i + 5]),
					Double.parseDouble(array[i + 6]), Double.parseDouble(array[i + 7]),
					Double.parseDouble(array[i + 8]), array[i + 9]);
			list.add(temp);
		}
		return list;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Add Student")) {
			String number = JOptionPane.showInputDialog(myPanes, "How many Students do you want to add?");
			generateStudents(listStudents, Integer.parseInt(number));
			JOptionPane.showMessageDialog(myPanes,
					number + " students are added. Total number of student is :" + listStudents.size());
			pDraw.remove(chart);
			chart = new DrawChart(listStudents);
			pDraw.add(chart);
			validate();
			repaint();
		}
		if (e.getActionCommand().equals("Remove Student")) {
			int found = 0;
			String id = JOptionPane.showInputDialog(myPanes, "Enter the ID of the student to remove from list");
			sortKeys.removeAll(sortKeys);
			sorter.setSortKeys(sortKeys);
			sorter.setRowFilter(null);
			for (int i = 0; i < listStudents.size(); i++) {
				if (listStudents.get(i).getId().equals(id)) {

					model.removeRow(i);
					listStudents.remove(i);
					JOptionPane.showMessageDialog(myPanes, "Student with ID " + id + " is deleted.");
					found = 1;
					break;
				}
			}
			table.setRowSorter(sorter);
			if (found == 0) {
				JOptionPane.showMessageDialog(myPanes, "No such student is found.");
			}
			pDraw.remove(chart);
			chart = new DrawChart(listStudents);
			pDraw.add(chart);
			validate();
			repaint();
		}

		if (e.getActionCommand().equals("Remove All Students")) {
			sortKeys.removeAll(sortKeys);
			sorter.setSortKeys(sortKeys);
			sorter.setRowFilter(null);
			listStudents.removeAll(listStudents);
			clearTable();
			pDraw.remove(chart);
			chart = new DrawChart(listStudents);
			pDraw.add(chart);
			validate();
			repaint();
		}

		if (e.getActionCommand().equals("Sort by Last Name")) {
			sortKeys.removeAll(sortKeys);
			List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
			if (isSelected == true) {
				sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
				isSelected = false;
			} else if (isSelected == false) {
				sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
				isSelected = true;
			}
			sorter.setSortKeys(sortKeys);
		}
		if (e.getActionCommand().equals("Sort by ID")) {
			sortKeys.removeAll(sortKeys);
			if (isSelected == true) {
				sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
				isSelected = false;
			} else if (isSelected == false) {
				sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
				isSelected = true;
			}
			sorter.setSortKeys(sortKeys);
		}
		if (e.getActionCommand().equals("Sort by Average")) {
			sortKeys.removeAll(sortKeys);
			if (isSelected == true) {
				sortKeys.add(new RowSorter.SortKey(8, SortOrder.ASCENDING));
				isSelected = false;
			} else if (isSelected == false) {
				sortKeys.add(new RowSorter.SortKey(8, SortOrder.DESCENDING));
				isSelected = true;
			}
			sorter.setSortKeys(sortKeys);
		}
		if (e.getActionCommand().equals("Filter by Letter Grade")) {
			String filter = JOptionPane.showInputDialog(myPanes, "Which grade do you want to filter?");
			sorter.setRowFilter(RowFilter.regexFilter(filter, 9));
		}
		if (e.getActionCommand().equals("Remove Filter")) {
			sorter.setRowFilter(null);
		}

	}

	public static void main(String[] args) throws IOException {

		new StudentProgram();

	}
}