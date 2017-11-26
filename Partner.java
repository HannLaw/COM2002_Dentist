package COM2002_Dentist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Time;

public class Partner {
	
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
			
	public void dayView(Prtner p) throws Exception { 
		try { 
			
			createConnection();
			
			statement = connect.createStatement();
			
			Date date = new Date();
			int year = date.getYear(); 
			int month = date.getMonth();
			int day = date.getDate();
			String partner = p.name();
			System.out.println(year);
			System.out.println(month);
			System.out.println(day);
			
			resultSet = statement
					.executeQuery("select * from dentistry.appointments WHERE (dateOfAppointment = '"+ (year+1900) + "-" + (month+1) + "-"+ day + "');");
			
			while (resultSet.next()) {

	            Date date0 = resultSet.getDate("dateOfAppointment");
	            Time time = resultSet.getTime("startTime");
	            System.out.println("Date: " + date);
	        }
			
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