package questionOne;


import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {

	private JLabel firstNameLabel, lastNameLabel, genderLabel, registrationNumberLabel;
	private JTextField firstNameField, lastNameField, registrationNumberField;
	private JComboBox<String> genderComboBox;
	private JButton insertButton, readButton, updateButton, deleteButton;

	public StudentForm() {
		super("Student Information Form");

		// Define the labels and text fields
		firstNameLabel = new JLabel("First name:");
		firstNameField = new JTextField(15);
		lastNameLabel = new JLabel("Last name:");
		lastNameField = new JTextField(15);
		genderLabel = new JLabel("Gender:");
		genderComboBox = new JComboBox<>(new String[] {"Male", "Female"});
		registrationNumberLabel = new JLabel("Registration Number:");
		registrationNumberField = new JTextField(15);

		// Define the buttons
		insertButton = new JButton("Insert");
		readButton = new JButton("Read");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");

		// Add components to the panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(firstNameLabel, new GridBagConstraints(0, 0, 1, 1));
		panel.add(firstNameField, new GridBagConstraints(1, 0, 2, 1));
		panel.add(lastNameLabel, new GridBagConstraints(0, 1, 1, 1));
		panel.add(lastNameField, new GridBagConstraints(1, 1, 2, 1));
		panel.add(genderLabel, new GridBagConstraints(0, 2, 1, 1));
		panel.add(genderComboBox, new GridBagConstraints(1, 2, 2, 1));
		panel.add(registrationNumberLabel, new GridBagConstraints(0, 3, 1, 1));
		panel.add(registrationNumberField, new GridBagConstraints(1, 3, 2, 1));
		panel.add(insertButton, new GridBagConstraints(0, 4, 1, 1));
		panel.add(readButton, new GridBagConstraints(1, 4, 1, 1));
		panel.add(updateButton, new GridBagConstraints(2, 4, 1, 1));
		panel.add(deleteButton, new GridBagConstraints(3, 4, 1, 1));

		// Add the panel to the frame
		add(panel);

		// Set the size and location of the frame
		setSize(400, 300);
		setLocationRelativeTo(null);

		// Make the frame visible
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentForm();
	}
}


