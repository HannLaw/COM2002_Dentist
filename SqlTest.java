//package com2002;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Time;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SqlTest extends JFrame {
	private JTable Calender;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void createConnection() throws Exception {
		try {
			//Create connection with database and initiate statement. 
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/dentistry?"
							+ "user=dentistryuser&password=dentistryuserpw");
		}catch (Exception e) {
			throw e;
		} finally {
			System.out.print("");
		}
	}

	public void viewDAppointments(Date d) throws SQLException,Exception {
		try {

			createConnection();


			int year = d.getYear();
			int month = d.getMonth();
			int date = d.getDate();
			int lastDate = 0;
			int numDaysNxtMonth;
			statement = connect.createStatement();

			//Find out how many days are in the month we are in. 
			switch (month+1) {
				case 1 :
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					lastDate = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					lastDate = 30;
					break;
				case 2:
					if (((year % 4 == 0) &&
							!(year % 100 == 0))
							|| (year % 400 == 0))
						lastDate = 29;
					else
						lastDate = 28;
					break;
				default:
					System.out.println("Invalid month.");
					break;
			}
			//Work out how many days are in next month. 
			if  ( (date+6) > lastDate ){
				numDaysNxtMonth = (date+6) - lastDate;
			}
			else numDaysNxtMonth = 0;

			//System.out.println(numDaysNxtMonth);

			//Use numDaysNxtMonth to execute the appropriate query.
			ResultSet resultSet2 = statement
					.executeQuery("SELECT COUNT(*) AS count FROM dentistry.appointments WHERE partner = 'Dentist' AND dateOfAppointment BETWEEN '"+ year +
							"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month + 2) + "-" + numDaysNxtMonth + "';");
			int amountOfAppointments=0;
			while(resultSet2.next()){

				amountOfAppointments = resultSet2.getInt("count");

			}
			if (resultSet2 != null) {
				resultSet2.close();
			}

			ResultSet resultSet1 = null;
			if (numDaysNxtMonth == 0) {

				resultSet1 = statement
						.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Dentist' AND dateOfAppointment BETWEEN '"+ year +
								"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month+1) + "-" + (date+7) + "';");

			}
			else {

				resultSet1 = statement
						.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Dentist' AND dateOfAppointment BETWEEN '"+ year +
								"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month + 2) + "-" + numDaysNxtMonth + "';");

			}

			String[][] aptArray = new String[amountOfAppointments+1][7];
			int i = 0;
			while (resultSet1.next()) {

				Date date0 = resultSet1.getDate("dateOfAppointment");
				Time stime = resultSet1.getTime("startTime");
				Time etime = resultSet1.getTime("endTime");
				String partner = resultSet1.getString("partner");
				int pID = resultSet1.getInt("patientID");
				String trtmnt = resultSet1.getString("treatmentName");
				boolean seen = resultSet1.getBoolean("seen");

				DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				String date1 = sdf.format(date0);
				DateFormat time1 = new SimpleDateFormat("HH.mm.ss");
				String t1 = time1.format(stime);
				DateFormat time2 = new SimpleDateFormat("HH.mm.ss");
				String t2 = time2.format(etime);
				String pID2 = Integer.toString(pID);
				String b = Boolean.toString(seen);
                System.out.println("wank");
				aptArray[i][0] = date1;
				aptArray[i][1] = t1;
				aptArray[i][2] = t2;
				aptArray[i][3] = partner;
				aptArray[i][4] = pID2;
				aptArray[i][5] = trtmnt;
				aptArray[i][6] = b;
				i ++;
			}
			Calender = new JTable(aptArray,(Object[]) columns());
			if (resultSet1 != null) {
				resultSet1.close();
			}
		}catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public void viewHAppointments(Date d) throws SQLException,Exception {
		try {

			createConnection();


			int year = d.getYear();
			int month = d.getMonth();
			int date = d.getDate();
			int lastDate = 0;
			int numDaysNxtMonth;
			statement = connect.createStatement();

			//Find out how many days are in the month we are in.
			switch (month+1) {
				case 1 :
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					lastDate = 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					lastDate = 30;
					break;
				case 2:
					if (((year % 4 == 0) &&
							!(year % 100 == 0))
							|| (year % 400 == 0))
						lastDate = 29;
					else
						lastDate = 28;
					break;
				default:
					System.out.println("Invalid month.");
					break;
			}
			//Work out how many days are in next month.
			if  ( (date+6) > lastDate ){
				numDaysNxtMonth = (date+6) - lastDate;
			}
			else numDaysNxtMonth = 0;

			//System.out.println(numDaysNxtMonth);

			//Use numDaysNxtMonth to execute the appropriate query.
			ResultSet resultSet2 = statement
					.executeQuery("SELECT COUNT(*) AS count FROM dentistry.appointments WHERE partner = 'Hygienist' AND dateOfAppointment BETWEEN '"+ year +
							"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month + 2) + "-" + numDaysNxtMonth + "';");
			int amountOfAppointments=0;
			while(resultSet2.next()){

				amountOfAppointments = resultSet2.getInt("count");

			}
			if (resultSet2 != null) {
				resultSet2.close();
			}

			ResultSet resultSet1 = null;
			if (numDaysNxtMonth == 0) {

				resultSet1 = statement
						.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Hygienist' AND dateOfAppointment BETWEEN '"+ year +
								"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month+1) + "-" + (date+7) + "';");

			}
			else {

				resultSet1 = statement
						.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Hygienist' AND dateOfAppointment BETWEEN '"+ year +
								"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month + 2) + "-" + numDaysNxtMonth + "';");

			}

			String[][] aptArray = new String[amountOfAppointments+1][7];
			int i = 0;
			while (resultSet1.next()) {

				Date date0 = resultSet1.getDate("dateOfAppointment");
				Time stime = resultSet1.getTime("startTime");
				Time etime = resultSet1.getTime("endTime");
				String partner = resultSet1.getString("partner");
				int pID = resultSet1.getInt("patientID");
				String trtmnt = resultSet1.getString("treatmentName");
				boolean seen = resultSet1.getBoolean("seen");

				DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				String date1 = sdf.format(date0);
				DateFormat time1 = new SimpleDateFormat("HH.mm.ss");
				String t1 = time1.format(stime);
				DateFormat time2 = new SimpleDateFormat("HH.mm.ss");
				String t2 = time2.format(etime);
				String pID2 = Integer.toString(pID);
				String b = Boolean.toString(seen);
				System.out.println("wank");
				aptArray[i][0] = date1;
				aptArray[i][1] = t1;
				aptArray[i][2] = t2;
				aptArray[i][3] = partner;
				aptArray[i][4] = pID2;
				aptArray[i][5] = trtmnt;
				aptArray[i][6] = b;
				i ++;
			}
			Calender = new JTable(aptArray,(Object[]) columns());
			if (resultSet1 != null) {
				resultSet1.close();
			}
		}catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	private void close() {
		try {

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}

		}
		catch (Exception e) {

		}
	}

	public SqlTest(String title, Date date) {
		super(title);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("noun_20400_cc.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		if (title == "Dentist Calender") {
			try {
				viewDAppointments(date);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("No date shown");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("No date shown");
				e.printStackTrace();
			}
		}
		else {
			try {
				viewHAppointments(date);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("No date shown");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("No date shown");
				e.printStackTrace();
			}
		}
		//Calender = new JTable(rows(), columns());
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(Calender.getTableHeader(),BorderLayout.PAGE_START);
		getContentPane().add(Calender, BorderLayout.CENTER);
	}

	public Object[][] rows() {
		Object[][] row = {
				{"Date","Start","End","Partner","PatiantID","Treatment","Seen"},
				{"Date","Start","End","Partner","PatiantID","Tent","Seen"}
		};
		return row;
	}

	public Object[] columns() {
		Object[] column = {"Date","Start","End","Partner","PatientID","Treatment","Seen"};
		return column;
	}
}