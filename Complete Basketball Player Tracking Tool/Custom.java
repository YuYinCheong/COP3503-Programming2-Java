//Name: Yu Yin, Cheong
//UNF N number: N 01576808
//Date of submission: Apr 27, 2025

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Custom extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	//initialize 
	public JLabel topLabel;
	
	public JLabel fnLabel;
	public JTextField fnField;
	
	public JLabel lnLabel;
	public JTextField lnField;
	
	public JLabel rookieLabel;
	public JCheckBox rookieBox;
	
	public JLabel salaryLabel;
	public JRadioButton salary1RButton;
	public JRadioButton salary2RButton;
	public JRadioButton salary3RButton;
	public JRadioButton salary4RButton;
	public ButtonGroup salaryGroup;
	
	public JLabel positionLabel;
	public JComboBox positionDropDown;
	public String[] positionList = {"PG", "SG", "SF", "PF", "C"};
	
	public JLabel ageLabel;
	public SpinnerNumberModel ageModel = new SpinnerNumberModel(18,18,100,1);
	public JSpinner ageSpinner;
	
	public JButton submitButton;
	public JButton clearButton;
	
	/**
	 * Instantiates a new custom.
	 */
	public Custom() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		
		//set up the title
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		topLabel = new JLabel("Basketball Player Database");
		this.add(topLabel, gbc);
		
		//set up first name
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		fnLabel = new JLabel("First Name:");
		this.add(fnLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		fnField = new JTextField(10);
		this.add(fnField, gbc);
		
		//set up last name
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		lnLabel = new JLabel("Last Name:");
		this.add(lnLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		lnField = new JTextField(10);
		this.add(lnField, gbc);
		
		//set up rookie contract
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		rookieLabel = new JLabel("Rookie Contract?");
		this.add(rookieLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		rookieBox = new JCheckBox();
		this.add(rookieBox, gbc);
		
		//set up yearly salary
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		salaryLabel = new JLabel("Salary (per year):");
		this.add(salaryLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		salary1RButton = new JRadioButton("<$500k");
		this.add(salary1RButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		salary2RButton = new JRadioButton("$500k - $5m");
		this.add(salary2RButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		salary3RButton = new JRadioButton("$5m - $25m");
		this.add(salary3RButton, gbc);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		salary4RButton = new JRadioButton(">$25m");
		this.add(salary4RButton, gbc);
		
		salaryGroup = new ButtonGroup();
		salaryGroup.add(salary1RButton);
		salaryGroup.add(salary2RButton);
		salaryGroup.add(salary3RButton);
		salaryGroup.add(salary4RButton);
		
		//set up the position options
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		positionLabel = new JLabel("Position:");
		this.add(positionLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		positionDropDown = new JComboBox(positionList);
		this.add(positionDropDown, gbc);
		
		//set up the age options
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		ageLabel = new JLabel("Age:");
		this.add(ageLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		ageSpinner = new JSpinner(ageModel); 
		this.add(ageSpinner, gbc);
		
		//set up the submit button
		gbc.gridx = 0;
		gbc.gridy = 10;
		submitButton = new JButton("Submit");
		submitButton.setText("Submit");
		submitButton.setName("Submit");
		submitButton.addActionListener(new MyActionListener());
		this.add(submitButton, gbc);
		
		//set up the clear button
		gbc.gridx = 2;
		gbc.gridy = 10;
		clearButton = new JButton("Clear");
		clearButton.setText("Clear");
		clearButton.setName("Clear");
		clearButton.addActionListener(new MyActionListener());
		this.add(clearButton, gbc);
	}
	
	/**
	 * The listener interface for receiving myAction events.
	 * The class that is interested in processing a myAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addMyActionListener</code> method. When
	 * the myAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see MyActionEvent
	 */
	public class MyActionListener implements ActionListener {
		
		//initialize 
		String fn = "";
		String ln = "";
		String rookie = "";
		String salary = "";
		String position = "";
		Object age;
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() instanceof JButton) {
				JButton theButton = (JButton)e.getSource();
				
				//set each data with corresponding data given by user
				fn = fnField.getText();
				ln = lnField.getText();
				
				if (rookieBox.isSelected())
					rookie = "Yes";
				else
					rookie = "No";
				
				if (salary1RButton.isSelected())
					salary = salary1RButton.getText();
				else if (salary2RButton.isSelected())
					salary = salary2RButton.getText();
				else if (salary3RButton.isSelected())
					salary = salary3RButton.getText();
				else if (salary4RButton.isSelected())
					salary = salary4RButton.getText();
				
				position = (String)positionDropDown.getSelectedItem();
				age = ageSpinner.getValue();
				
				
					
				if (theButton == submitButton) {
					//initialize 
					String filename = "basketballDatabase.csv";
					ArrayList<String> list = new ArrayList<String>();
					
					//create file 
					File file = new File(filename);
					
					if (file.exists()) {
						try {
							//create Scanner to read from file
							Scanner in = new Scanner(file);
							
							//read the header
							String header = in.nextLine();
							
							//while there has next line in the file
							while(in.hasNextLine()) {
								
								//read the line and split by ","
								String line = in.nextLine();
								String[] data = line.split(",");
								
								//set each variables with the corresponding data obtained
								if (data.length >= 6) {
									String firstName = data[0];
									String lastName = data[1];
									String rookieContract = data[2];
									String salaryYearly = data[3];
									String positions = data[4];
									String ages = data[5];
									
									//use the data and add it to the ArrayList with a Catch
									list.add(firstName + "," + lastName + "," + rookieContract + "," + salaryYearly + "," + positions + "," + ages);
								}
							}					
						} catch (FileNotFoundException f1) {
							//if the file is not found, print the statement
							System.out.println("File not found.");
						}
					}
						
					try {
						//create PrintWriter to write data in the specific file
						PrintWriter pw = new PrintWriter(filename);
						
						//write the header of the file
						pw.println("First Name,Last Name,Rookie Contract,Salary(per year),Position,Age");
						
						//write the data that are provided by the user
						for (String s: list) {
							pw.println(s);
						}
						pw.println(fn + "," + ln + "," + rookie + "," + salary + "," + position + "," + age);
						
						//save, flush, and close the PrintWriter
						pw.flush();
						pw.close();
					} catch (FileNotFoundException f) {
						//print if the file cannot be created or opened
						System.out.println("File not found.");
					}
					clear();
				}
				
				else if (theButton == clearButton)
					clear();
			}
		}
		
		/**
		 * Clear all data the user has typed.
		 */
		public void clear() {
			fnField.setText("");
			lnField.setText("");
			rookieBox.setSelected(false);
			salaryGroup.clearSelection();
			positionDropDown.setSelectedIndex(0);
			ageSpinner.setValue(18);
		}
	}
}