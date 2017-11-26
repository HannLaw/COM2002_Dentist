package COM2002_Dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Time;

public class Secretary {
	
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
            	 	System.out.print(" ");
             }	
}	
			
	
	
	public void viewAppointments() throws Exception { 
		try { 
			
			createConnection();
			
			//Find appointments for the week UNFINISHED
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select dateOfAppointment from dentistry.appointments");
			
			Date todays_date = new Date();
			System.out.println(todays_date);
			
			while (resultSet.next()) {

	            Date date = resultSet.getDate("dateOfAppointment");
	            System.out.println("Date: " + date);
	        }
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void bookAppointment(int PatientID, Date date, Time t1, Time t2, Treatment t, Prtner p) throws Exception { 
		try { 

			createConnection();
			
			String treatment = t.name();
			String partner = p.name();
			
			preparedStatement = connect
                    .prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
		    preparedStatement.setDate(1, new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
            preparedStatement.setTime(2, t1);
            preparedStatement.setTime(3, t2);
            preparedStatement.setString(4, partner);
            preparedStatement.setInt(5, PatientID);
            preparedStatement.setString(6, treatment);
            preparedStatement.setBoolean(7, false);
            preparedStatement.executeUpdate();
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void cancelAppointment(int PatientID, Prtner p) throws Exception { 
		try { 
			 
			createConnection();
			
            String partner = p.name();
            preparedStatement = connect
                    .prepareStatement("DELETE FROM appointments WHERE (patientID = " + PatientID + ") AND (partner = '" + partner + "');" );
            preparedStatement.executeUpdate();
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
