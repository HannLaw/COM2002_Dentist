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
            	 	System.out.print("");
             }	
}	
			
	
	
	public void viewAppointments(Date d) throws Exception { 
		try { 
			
			createConnection();
			
			
			int year = d.getYear();
			int month = d.getMonth();
			int date = d.getDate();
			int lastDate = 0;
			int numDaysNxtMonth;
			statement = connect.createStatement();
			System.out.println(year);
			System.out.println(date);
			System.out.println(month);
			
			
			 switch (month+1) {
	            case 1:
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
			if  ( (date+7) > lastDate ){
					numDaysNxtMonth = (date+7) - lastDate; 
			}
			else numDaysNxtMonth = 0; 
			
			System.out.println(numDaysNxtMonth);
			
			
			if (numDaysNxtMonth == 0) {
			resultSet = statement
					.executeQuery("select dateOfAppointment from dentistry.appointments WHERE dateOfAppointment BETWEEN '"+ year + "-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month+1) + "-" + (date+7) + "';");
			}
			else {
				
				resultSet = statement
						.executeQuery("select dateOfAppointment from dentistry.appointments WHERE dateOfAppointment BETWEEN '"+ year + "-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month + 2) + "-" + numDaysNxtMonth + "';");
				
			}
				
			
			
			 
			 
			
			while (resultSet.next()) {

	            Date date0 = resultSet.getDate("dateOfAppointment");
	            System.out.println("Date: " + date0);
	        }
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void bookAppointment(int patientID, Date date, Time t1, Treatment t, Prtner p) throws Exception { 
		try { 

			createConnection();
			
			String treatment = t.name();
			String partner = p.name();
			int timeTaken;
			
			
			if (t == Treatment.CHECKUP || t == Treatment.HYGIENE ) {
				timeTaken = 20;
			}
			else timeTaken = 60;
			
			int hours = t1.getHours(); 
			int minutes = t1.getMinutes();
			
			
			preparedStatement = connect
                    .prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
		    preparedStatement.setDate(1, new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
            preparedStatement.setTime(2, t1);
            preparedStatement.setTime(3, new Time(hours,timeTaken,minutes));
            preparedStatement.setString(4, partner);
            preparedStatement.setInt(5, patientID);
            preparedStatement.setString(6, treatment);
            preparedStatement.setBoolean(7, false);
            preparedStatement.executeUpdate();
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void bookEmptyAppointment(Date d, Prtner p) throws Exception { 
		try { 
			
			createConnection();
			
			String partner = p.name();
			
			preparedStatement = connect
                    .prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
		    preparedStatement.setDate(1, new java.sql.Date(d.getYear(), d.getMonth(), d.getDay()));
            preparedStatement.setTime(2, new Time(00,00,00));
            preparedStatement.setTime(3, new Time(23,59,59));
            preparedStatement.setString(4, partner);
            preparedStatement.setInt(5, 1);
            preparedStatement.setString(6, "Check-Up");
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
	
	public void findAppointments(int PatientID, Prtner p) throws Exception { 
		try { 
			
			createConnection();
			String partner = p.name();
			
			//Find appointments for the week UNFINISHED
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT dateOfAppointment FROM dentistry.appointments WHERE (patientID = "+ PatientID + ") AND (partner = '" + partner + "' );");
			
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
	
	public void suscribePatient(PatientRecord patient, NoP hcp) throws Exception { 
		try { 
			 
			createConnection();
			
			patient.setNameOfPlan(hcp);
			String nop = hcp.name();
			int patientID = patient.getPatientID();
			
            preparedStatement = connect
                    .prepareStatement("UPDATE patients SET healthCarePlan = '"+ nop + "' WHERE patientID = "+ patientID +" ;" );
            preparedStatement.executeUpdate();
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void unsuscribePatient(PatientRecord patient) throws Exception { 
		try { 
			 
			createConnection();
			
			patient.setNameOfPlan(NoP.NOPLAN);
			int patientID = patient.getPatientID();
			
            preparedStatement = connect
                    .prepareStatement("UPDATE patients SET healthCarePlan = '-' WHERE patientID = "+ patientID +" ;" );
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
