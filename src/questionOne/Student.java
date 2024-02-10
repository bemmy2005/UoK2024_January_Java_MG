package questionOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Student {
	private String Fname;// (string): First name
	private String Lname;// (string): Last name
	private String Gender;// (string): Gender
	private String RegNumber;// (string): Registration number

	public Student() {
		
	}
	public Student(String fname, String lname, String gender, String regNumber) {
		super();
		Fname = fname;
		Lname = lname;
		Gender = gender;
		RegNumber = regNumber;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
	public void register() {
		String host = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO student(Fname,Lname,gender, RegNumber) VALUES (?,?,?,?)";
		String sqlQuery = "SELECT Fname FROM student";

		try (// Establish the connection
				Connection connection = DriverManager.getConnection(host, user, password);
				// Create a prepared statement
				PreparedStatement preparedStatementcheck = connection.prepareStatement(sqlQuery);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatementcheck.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("Fname");
				dataArray.add(data);
			}
			String[] dataArrayAsArray = dataArray.toArray(new String[0]);
			for (String data : dataArrayAsArray) {
				System.out.println(data);
			}
			// Set the values for the prepared statement
			preparedStatement.setString(1, this.Fname);
			preparedStatement.setString(2, this.Lname);
			preparedStatement.setString(3, this.Gender);
			preparedStatement.setString(4, this.RegNumber);
			for(String data:dataArray) {
				if (data==this.Fname) {
					System.out.println("The firstname you entered is already used!");
				}else {
					// Execute the query
					int rowsAffected = preparedStatement.executeUpdate();
					// Check the result
					if (rowsAffected > 0) {
						//System.out.println("Data inserted successfully!");
						JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
					} else {
						//System.out.println("Failed to insert data.");
						JOptionPane.showMessageDialog(null, "Failed to insert data.", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void registertwo() {
		String host = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO student(Fname,Lname,Gender,RegNumber) VALUES (?,?,?,?)";
		String sqlQuery = "SELECT Fname FROM student";

		try (
				// Establish the connection
				Connection connection = DriverManager.getConnection(host, user, password);
				// Create a prepared statement
				PreparedStatement preparedStatementCheck = connection.prepareStatement(sqlQuery);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatementCheck.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("Fname");
				dataArray.add(data);
			}

			/*for (String data : dataArray) {
				System.out.println(data);
			}*/

			// Check for duplicate username
			if (dataArray.contains(this.Fname)) {
				System.out.println("The username you entered is already used!");
				JOptionPane.showMessageDialog(null, "The username you entered is already used!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.Fname.isBlank() && this.Lname.isBlank() && this.RegNumber.isBlank()){
				JOptionPane.showMessageDialog(null, "Please fill in the required informations!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.Fname.length()>10){
				JOptionPane.showMessageDialog(null, "The size of the username cannot be greatter that 10 characters!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else {
				// Set the values for the prepared statement
				preparedStatement.setString(1, this.Fname);
				preparedStatement.setString(2, this.Lname);
				preparedStatement.setString(3, this.Gender);
				preparedStatement.setString(4, this.RegNumber);

				// Execute the query
				int rowsAffected = preparedStatement.executeUpdate();

				// Check the result
				if (rowsAffected > 0) {
					// System.out.println("Data inserted successfully!");
					JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
				} else {
					// System.out.println("Failed to insert data.");
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayInformation() {
		String url = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from student";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				){
			// Get the number of rows in the result set
			resultSet.last();
			int rowCount = resultSet.getRow();
			resultSet.beforeFirst();

			// Define a 2D array of objects
			Object[][] data = new Object[rowCount][4];

			// Process the result set and save data into the array
			int row = 0;
			while (resultSet.next()) {
				String column1Value = resultSet.getString("Fname");
				String column2Value = resultSet.getString("Lname");
				String column3Value = resultSet.getString("Gender");
				String column4Value = resultSet.getString("RegNumber");
				// Save data into the 2D array
				data[row][0] = column1Value;
				data[row][1] = column2Value;
				data[row][2] = column3Value;
				data[row][3] = column4Value;
				row++;
			}

			// Print or use the data from the 2D array
			for (Object[] rowArray : data) {
				for (Object value : rowArray) {
					System.out.print(value + " ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displaytwo() {
		String url = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from student";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				)
		{
			// Process the result set
			while (resultSet.next()) {
				String column1Value = resultSet.getString("Fname");
				String column2Value = resultSet.getString("Lname");
				String column3Value = resultSet.getString("Gender");
				String column4Value = resultSet.getString("RegNumber");

				//System.out.println("id: " + column1Value + ", useaname: " + column2Value + ", password: " + column3Value);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused") DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";

		String sql = "SELECT * FROM student"; // replace your_table with the actual table name
		DefaultTableModel tableModel = null;// = new DefaultTableModel(data, columnNames);
		try (Connection connection = DriverManager.getConnection(host, user, password);

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			// Get column names
			int columnCount = resultSet.getMetaData().getColumnCount();

			Vector<String> columnNames = new Vector<>();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(resultSet.getMetaData().getColumnName(i));
			}

			// Get data rows
			Vector<Vector<Object>> data = new Vector<>();
			while (resultSet.next()) {
				Vector<Object> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(resultSet.getObject(i));
				}
				data.add(row);
			}

			// Create DefaultTableModel and set data
			tableModel = new DefaultTableModel(data, columnNames);
			//table.setModel(tableModel);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public void deletedata(String RegNumber) {
		String url = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";
		//String userInput = JOptionPane.showInputDialog(null, "Enter id:");
		//id=Integer.parseInt(userInput);
		//System.out.println("User entered: " + userInput);
		// SQL query to delete data

		String sql = "DELETE FROM student WHERE RegNumber = ?";
		if(RegNumber==null) 
			JOptionPane.showMessageDialog(null, "No RegNumber entered");
		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the value for the WHERE clause
			stm.setString(1, RegNumber); // Assuming there is a column named 'id' for the WHERE clause

			// Execute the delete

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the student with regnumber  "+RegNumber+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			// Check the user's choice
			if (result == JOptionPane.YES_OPTION) {
				//System.out.println("User clicked Yes");
				int rowsAffected = stm.executeUpdate();
				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "The user with registration number: "+RegNumber+"\n was deleted!");

				} else {
					//System.out.println("Failed to delete data. No matching record found.");

					JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				//System.out.println("User clicked No");
				JOptionPane.showMessageDialog(null, "We can't delete the user");


			}
			// Check the result


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatedata(String RegNumber) {
		String url = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";

		// SQL query to update data
		String sql = "UPDATE student SET Fname = ?, Lname = ?,Gender =?, RegNumber=? where RegNumber='"+RegNumber+"'";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the new values for the update
			stm.setString(1, this.Fname);
			stm.setString(2, this.Lname);
			stm.setString(3, this.Gender);
			stm.setString(4, this.RegNumber);

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the user with idd"+Fname+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			// Check the user's choice
			if (result == JOptionPane.YES_OPTION) {
				// Execute the update
				int rowsAffected = stm.executeUpdate();

				// Check the result
				if (rowsAffected > 0) {
					// System.out.println("Data updated successfully!");
					JOptionPane.showMessageDialog(null, "Data updated successfully!");

				} else {
					System.out.println("Failed to update data. No matching record found.");
					JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

				}
			} else {
				//System.out.println("User clicked No");
				JOptionPane.showMessageDialog(null, "We will not update your data");

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatedata(int id,String uname,String pwd) {
		String url = "jdbc:mysql://localhost/schools";
		String user = "root";
		String password = "";

		// SQL query to update data
		String sql = "UPDATE user SET Fname = ?, Lname = ?, Gender=?, RegNumber=? where id='"+Fname+"'";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the new values for the update
			stm.setString(1, uname);
			stm.setString(2, pwd);
			stm.setString(3, uname);
			stm.setString(4, pwd);

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the user with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			// Check the user's choice
			if (result == JOptionPane.YES_OPTION) {
				// Execute the update
				int rowsAffected = stm.executeUpdate();

				// Check the result
				if (rowsAffected > 0) {
					// System.out.println("Data updated successfully!");
					JOptionPane.showMessageDialog(null, "Data updated successfully!");

				} else {
					System.out.println("Failed to update data. No matching record found.");
					JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

				}
			} else {
				//System.out.println("User clicked No");
				JOptionPane.showMessageDialog(null, "We will not delete your data");

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
