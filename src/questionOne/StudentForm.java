package questionOne;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm implements ActionListener {
	private JFrame frame ;

	private JLabel firstNameLabel=new JLabel("First name: ");
	private JLabel lastNameLabel=new JLabel("Last name: ");
	private JLabel genderLabel=new JLabel("Gender name: "); 
	private JLabel registrationNumberLabel=new JLabel("RegNumber: ");
	String[] options = {"Male", "Female"};

	private JTextField firstNameField=new JTextField(); 
	private JTextField lastNameField=new JTextField(); 
	private JTextField  registrationNumberField=new JTextField();;
	private JComboBox<String> genderComboBox=new JComboBox<>(options);
	//String selectedOption =null;
	private JButton insertButton=new JButton("Create"); 
	private JButton readButton=new JButton("Read"); 
	private JButton updateButton=new JButton("Update"); 
	private JButton deleteButton=new JButton("Delete");

	public StudentForm() {
		createWindow();
		setLocationsAndSize();
		addcompontentstoFrame();
		addActionEvent();
	}


	private void addcompontentstoFrame() {
		frame.add(firstNameLabel);
		frame.add(lastNameLabel);
		frame.add(genderLabel);
		frame.add(registrationNumberLabel);
		frame.add(firstNameField);
		frame.add(lastNameField);
		frame.add(registrationNumberField);
		frame.add(genderComboBox);
		frame.add(insertButton);
		frame.add(readButton);
		frame.add(updateButton);
		frame.add(deleteButton);

	}


	private void setLocationsAndSize() {
		firstNameLabel.setBounds(20, 20, 100, 30);
		lastNameLabel.setBounds(20,70,100,30);
		genderLabel.setBounds(20,120,100,30);
		registrationNumberLabel.setBounds(20,170,100,30);

		firstNameField.setBounds(120,20,150,30);
		lastNameField.setBounds(120,70,150,30);
		genderComboBox.setBounds(120,120,150,30);
		registrationNumberField.setBounds(120,170,150,30);

		insertButton.setBounds(280,20,100,30);
		readButton.setBounds(380,20,100,30);
		updateButton.setBounds(280,120,100,30);
		deleteButton.setBounds(380,120,100,30);

	}


	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Menu form");
		frame.setBounds(10,10,500,250);
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}


	private void addActionEvent() {
		insertButton.addActionListener(this); 
		readButton.addActionListener(this); 
		updateButton.addActionListener(this); 
		deleteButton.addActionListener(this);
		genderComboBox.addActionListener(this);
		/*
		genderComboBox.addActionListener(new ActionListener() {

			@Override
			 public void actionPerformed(ActionEvent e) {
	            // Get the selected item from the JComboBox
	            selectedOption = (String) genderComboBox.getSelectedItem();
	            System.out.println(selectedOption);
	            //System.out.println("Selected item: " + selectedOption);
	        }
		});*/
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Student st=new Student();
		if(e.getSource()== insertButton) {
			st.setFname(firstNameField.getText());
			st.setLname(lastNameField.getText());
			//int index = Arrays.binarySearch(options, genderComboBox.selec);
			String selectedOption = (String) genderComboBox.getSelectedItem();
			st.setGender(selectedOption);
			st.setRegNumber(registrationNumberField.getText());

			st.registertwo();
		}
		if(e.getSource()== 	readButton) {
			DisplayStudentsInATable stview=new DisplayStudentsInATable();
		}
		if(e.getSource()== 	 updateButton) {
			String userInput = JOptionPane.showInputDialog(null, "Please Enter Registration Number:");
			st.setFname(firstNameField.getText());
			st.setLname(lastNameField.getText());
			String selectedOption = (String) genderComboBox.getSelectedItem();
			st.setGender(selectedOption);
			st.setRegNumber(userInput);
			st.updatedata(userInput);
		}
		if(e.getSource()== 	deleteButton) {
			String userInput = JOptionPane.showInputDialog(null, "Please Enter Registration Number:");
			//myuser.deletedata(Integer.parseInt(userInput));
			st.deletedata(userInput);
		}

	}

	public static void main(String[] args) {
		new StudentForm();
	}



}


