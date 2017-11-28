import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecretaryPage extends JFrame {
    private JTabbedPane tabbedPane1;
    public JPanel secPagePanel;
    private JTextField patientID2;
    private JTextField firstName2;
    private JTextField surname2;
    private JTextField patientID1;
    private JTextField firstName1;
    private JTextField surname1;
    private JTextField date1;
    private JTextField t1;
    private JTextField firstName3;
    private JTextField surname3;
    private JTextField dob1;
    private JTextField contact1;
    private JTextField patientID3;
    private JTextField firstName4;
    private JTextField surname4;
    private JTextField weekDate1;
    private JTextField weekDate2;
    private JComboBox t;
    private JButton bookingSubmit;
    private JButton searchAppt;
    private JComboBox p;
    private JComboBox plan2;
    private JTextField adl1_1;
    private JTextField adl2_1;
    private JTextField district1;
    private JTextField city1;
    private JTextField pc1;
    private JButton addPatientBtn;
    private JButton editPatientSubmit;
    private JPanel dentistCal;
    private JPanel hygienistCal;
    private JTable CalenderD;
	private JTable CalenderH;

    public SecretaryPage() {


        bookingSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				int ipID1;
			    Date dateAppt;
				Time timeAppt;
                if (Validation.bookappointment(patientID1.getText(), date1.getText(), t1.getText(), t1.getText(), (String)t.getSelectedItem(),(String)p.getSelectedItem())) {
			    	try {
                        ipID1 = getPatientID1();
                        dateAppt = getDate1();
                        timeAppt = getT1();
                        bookAppointment(getPatientID1(), getDate1(), getT1(), getT(), getP());
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Input", "Dialog", JOptionPane.ERROR_MESSAGE);
                    }
			    }   
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Input", "Dialog", JOptionPane.ERROR_MESSAGE);	
                }					
            }
        });
        addPatientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PatientRecord pRec = new PatientRecord(Ttl.MR, getPlan(), getFirstName3(), getSurname3(), getContactNo(), getADL1(), getPostcode(), getDoB(), getRemCheckups(), getRemHyg(), getRemRep());
                    addPatient(pRec);
                } catch (Exception c) {
                    System.out.println("Oops");
                }
            }
        });
        weekDate1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewDAppointments(getWeekDate(weekDate1));
                } catch (Exception c) {
                    System.out.println("No date shown");
                }
            }
        });
        weekDate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewHAppointments(getWeekDate(weekDate2));
                } catch (Exception c) {
                    System.out.println("No date shown");
                }
            }
        });
    }

    
    //Secretary Methods
    
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
    
	public void bookAppointment(int patientID, Date date, Time t1, Treatment t, Prtner p) throws Exception { 
		try { 

			createConnection();
			
			String treatment = t.name();
			String partner = p.name();
			int timeTaken;
			
			//Find the time taken for the treatment. 
			if (t == Treatment.CHECKUP || t == Treatment.HYGIENE ) {
				timeTaken = 20;
			}
			else timeTaken = 60;
			
			int hours = t1.getHours(); 
			int minutes = t1.getMinutes();
			
			//Use the timeTaken to insert the right endTime and other details in the database. 
			if (timeTaken == 60) {
				preparedStatement = connect
						.prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
				preparedStatement.setDate(1, new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
				preparedStatement.setTime(2, t1);
				preparedStatement.setTime(3, new Time((hours + 1),minutes,00));
				preparedStatement.setString(4, partner);
				preparedStatement.setInt(5, patientID);
				preparedStatement.setString(6, treatment);
				preparedStatement.setBoolean(7, false);
				preparedStatement.executeUpdate();
			}
			else if ((minutes + timeTaken) < 60){
				preparedStatement = connect
						.prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
				preparedStatement.setDate(1, new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
				preparedStatement.setTime(2, t1);
				preparedStatement.setTime(3, new Time(hours,(minutes + 20),00));
				preparedStatement.setString(4, partner);
				preparedStatement.setInt(5, patientID);
				preparedStatement.setString(6, treatment);
				preparedStatement.setBoolean(7, false);
				preparedStatement.executeUpdate();
			}
			else {
				preparedStatement = connect
						.prepareStatement("insert into  dentistry.appointments values (?, ?, ?, ? , ?, ?, ?)");
				preparedStatement.setDate(1, new java.sql.Date(date.getYear(), date.getMonth(), date.getDay()));
				preparedStatement.setTime(2, t1);
				preparedStatement.setTime(3, new Time(hours,(minutes + 20),00));
				preparedStatement.setString(4, partner);
				preparedStatement.setInt(5, patientID);
				preparedStatement.setString(6, treatment);
				preparedStatement.setBoolean(7, false);
				preparedStatement.executeUpdate();
			}
				
			
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
			
			//Book a full day worth of appointment for the partner in question. 
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
			lastDate = getLastDate(month,year); 
			//Work out how many days are in next month. 
			if  ( (date+6) > lastDate ){
					numDaysNxtMonth = (date+6) - lastDate; 
			}
			else numDaysNxtMonth = 0; 
			
			//System.out.println(numDaysNxtMonth);
			
			//Use numDaysNxtMonth to execute the appropriate query.
			ResultSet resultSet2 = statement
					.executeQuery("SELECT COUNT(*) AS count FROM dentistry.appointments WHERE dateOfAppointment BETWEEN '"+ year +
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
					.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Dentitst' AND dateOfAppointment BETWEEN '"+ year +
							"-" + (month+1) + "-"+ date + "' AND '" + year + "-" + (month+1) + "-" + (date+7) + "';");

			}
			else {
				
				resultSet1 = statement
						.executeQuery("SELECT * FROM dentistry.appointments WHERE partner = 'Dentitst' AND dateOfAppointment BETWEEN '"+ year +
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
	        	
	            aptArray[i][0] = date1;
	            aptArray[i][1] = t1;
	            aptArray[i][2] = t2; 
	            aptArray[i][3] = partner; 
	            aptArray[i][4] = pID2; 
	            aptArray[i][5] = trtmnt; 
	            aptArray[i][6] = b; 
	            i ++; 
	        }
			CalenderD = new JTable(aptArray,(Object[]) columns());
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
			lastDate = getLastDate(month,year);
			 
			//Work out how many days are in next month. 
			if  ( (date+6) > lastDate ){
					numDaysNxtMonth = (date+6) - lastDate; 
			}
			else numDaysNxtMonth = 0; 
			
			//System.out.println(numDaysNxtMonth);
			
			//Use numDaysNxtMonth to execute the appropriate query.
			ResultSet resultSet2 = statement
					.executeQuery("SELECT COUNT(*) AS count FROM dentistry.appointments WHERE dateOfAppointment BETWEEN '"+ year +
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
	        	
	            aptArray[i][0] = date1;
	            aptArray[i][1] = t1;
	            aptArray[i][2] = t2; 
	            aptArray[i][3] = partner; 
	            aptArray[i][4] = pID2; 
	            aptArray[i][5] = trtmnt; 
	            aptArray[i][6] = b; 
	            i ++; 
	        }
			CalenderH = new JTable(aptArray,(Object[]) columns());
			if (resultSet1 != null) {
                resultSet1.close();
            }
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
    public Object[] columns() {
        Object[] column = {"Date","Start","End","Partner","PatientID","Treatment","Seen"};
        return column;
    }
	
	public int getLastDate(int month, int year) { 
    	int lastDate = 30;
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
    	
        return lastDate;
        
    }
 
	public void cancelAppointment(int PatientID, Prtner p) throws Exception { 
		try { 
			 
			createConnection();
			
			//Deletes the appointment for a certain patient to see a certain partner
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
			
			//Find all appointments future and previous for a given patient and partner
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
	
	public void subscribePatient(PatientRecord patient, NoP hcp) throws Exception {
		try { 
			 
			createConnection();
			
			patient.setNameOfPlan(hcp);
			String nop = hcp.name();
			int patientID = patient.getPatientID();
			
			//Subscribes patient to a healthcare plan.
            preparedStatement = connect
                    .prepareStatement("UPDATE patients SET healthCarePlan = '"+ nop + "' WHERE patientID = "+ patientID +" ;" );
            preparedStatement.executeUpdate();
			
		}catch (Exception e) {
            throw e;
        } finally {
            close();
        }
	}
	
	public void unsubscribePatient(PatientRecord patient) throws Exception {
		try { 
			 
			createConnection();
			
			patient.setNameOfPlan(NoP.NOPLAN);
			int patientID = patient.getPatientID();
			
			//Unsubscribes patient from a given healthcare plan.
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

    public void addPatient(PatientRecord patient) throws Exception {
        try {

            createConnection();

            String ttl = patient.getTitle().name();
            String nop = patient.getNameOfPlan().name();
            String fn = patient.getForename();
            String ln = patient.getSurname();
            String cn = patient.getContactNumber();
            String hn = patient.getHouseNumber();
            String pc = patient.getPostCode();
            int doby = patient.getDateOfBirth().getYear();
            int dobm = patient.getDateOfBirth().getMonth();
            int dobd = patient.getDateOfBirth().getDate();
            int cu = patient.getRemainingCheckUps();
            int hv = patient.getRemainingHygieneVisits();
            int r = patient.getRemainingRepairs();


            preparedStatement = connect
                    .prepareStatement("insert into  dentistry.patients values (?, ?, ?, ? , ?, ?, ?, ? ,? ,? ,? ,default)");
            preparedStatement.setString(1,ttl);
            preparedStatement.setString(2,fn);
            preparedStatement.setString(3,ln);
            preparedStatement.setDate(4, new java.sql.Date(doby,dobm,dobd));
            preparedStatement.setString(5,cn);
            preparedStatement.setString(6, hn);
            preparedStatement.setString(7,pc);
            preparedStatement.setString(8,nop);
            preparedStatement.setInt(9, cu);
            preparedStatement.setInt(10, hv);
            preparedStatement.setInt(11, r);
            preparedStatement.executeUpdate();

        }catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
  
    // Get methods


    // Booking an appointment
    public int getPatientID1() {
        String pID1 = patientID1.getText();
        int ipID1 = Integer.valueOf(pID1);
        return ipID1;
    }

    public Date getDate1() {
        String d1 = date1.getText();
        int year = Integer.valueOf(d1.substring(6));
        int month = Integer.valueOf(d1.substring(3,4));
        int day = Integer.valueOf(d1.substring(0,1));
        Date dateAppt = new Date(year,month,day);
        return dateAppt;
    }

    public Time getT1() {
        String time = t1.getText();
        int hour = Integer.valueOf(time.substring(0, 1));
        int minute = Integer.valueOf(time.substring(3, 4));
        Time timeAppt = new Time(hour, minute,00);
        return timeAppt;
    }

    public Treatment getT() {
        String type = (String)t.getSelectedItem();
        switch(type) {
            case ("Checkup"):
                return Treatment.CHECKUP;
            case ("Hygiene"):
                return Treatment.HYGIENE;
            case ("Silver Filling"):
                return Treatment.SILVER_FILLING;
            case ("White filling"):
                return Treatment.WHITE_FILLING;
            case ("Gold Crown"):
                return Treatment.GOLD_CROWN;
            default:
                return Treatment.CHECKUP;
        }
    }

    public Prtner getP() {
        String ptnr = (String)p.getSelectedItem();
        switch(ptnr) {
            case ("Dentist"):
                return Prtner.DENTIST;
            case ("Hygienist"):
                return Prtner.HYGIENIST;
            default:
                return Prtner.DENTIST;
        }
    }

    // Adding a patient
    public String getFirstName3() {
        return firstName3.getText();
    }

    public String getSurname3() {
        return surname3.getText();
    }

    public Date getDoB() {
        String birth = dob1.getText();
        int yearB = Integer.valueOf(birth.substring(6));
        int monthB = Integer.valueOf(birth.substring(3,4));
        int dayB = Integer.valueOf(birth.substring(0,1));
        Date dateB = new Date(yearB,monthB,dayB);
        return dateB;
    }

    public String getContactNo() {
        return contact1.getText();
    }

    public NoP getPlan() {
        String name = (String)plan2.getSelectedItem();
        switch(name) {
            case ("No Plan"):
                return NoP.NOPLAN;
            case ("NHS"):
                return NoP.NHS;
            case ("Maintenance Filling"):
                return NoP.MAINTENANCE;
            case ("Oral Health"):
                return NoP.ORALHEALTH;
            case ("Dental Repair"):
                return NoP.DENTALREPAIR;
            default:
                return NoP.NOPLAN;
        }
    }

    public String getADL1() {
            return adl1_1.getText();
    }

    public String getPostcode() {
        return pc1.getText();
    }

    public int getRemCheckups() {
        switch(getPlan()) {
            case NOPLAN:
                return 0;
            default:
                return 2;
        }
    }

    public int getRemHyg() {
        switch(getPlan()) {
            case NOPLAN:
                return 0;
            case ORALHEALTH:
                return 4;
            default:
                return 2;
        }
    }

    public int getRemRep() {
        switch (getPlan()) {
            case NHS:
                return 6;
            case DENTALREPAIR:
                return 2;
            default:
                return 0;
        }
    }

    public Date getWeekDate(JTextField d) {
	    String weekDate = d.getText();
        int yearW = Integer.valueOf(weekDate.substring(6));
        int monthW = Integer.valueOf(weekDate.substring(3,4));
        int dayW = Integer.valueOf(weekDate.substring(0,1));
        Date dateW = new Date(yearW,monthW,dayW);
        return dateW;
    }

}