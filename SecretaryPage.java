package com2002;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecretaryPage extends Secretary {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
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
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JComboBox t;
    private JButton bookingSubmit;
    private JButton searchAppt;
    private JComboBox p;
    private JComboBox comboBox3;
    private JTextField adl1_1;
    private JTextField adl2_1;
    private JTextField district1;
    private JTextField city1;
    private JTextField pc1;
    private JButton addPatientBtn;
    private JButton submitButton1;
    private JPanel dentistCal;
    private JPanel hygienistCal;


    public SecretaryPage() extend jFrame {
		public static void main(String[] args) throws Exception {
		    Secretary sec = new Secretary();
	        ResultSet rs = sec.viewAppointments(new Date(2017,10,30));
            // It creates and displays the table
		    JTable table = new JTable(buildTableModel(rs)); 
		}
		
		public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

             ResultSetMetaData metaData = rs.getMetaData();
             // names of columns
             Vector<String> columnNames = new Vector<String>();
             int columnCount = metaData.getColumnCount();
             for (int column = 1; column <= columnCount; column++) {
                 columnNames.add(metaData.getColumnName(column));
             }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

    }


        bookingSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Secretary sec = new Secretary();
				int ipID1;
			    Date dateAppt;
				Time timeAppt;
                if (Validation.bookappointment(patientID2.getText(), date1.getText(), t1.getText(), t1.getText(), this.t.GetItemText(this.t.SelectedItem),this.p.GetItemText(this.p.SelectedItem))) {
			    	ipID1 = getPatientID1(patientID1.getText());
					dateAppt = getDate1(date1.getText());
					timeAppt = getT1(t1.getText());
					sec.bookAppointment(ipID1, dateAppt, timeAppt, t, p);
			    }   
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Input", "Dialog", JOptionPane.ERROR_MESSAGE);	
                }					
            }
        });
		addPatientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Secretary sec = new Secretary();
				//int ipID1;
			    ////Date dateAppt;
				Time timeAppt;
                if (Validation.addPatient(firstName3.getText(), surname3.getText(), dob1.getText(), contact1.getText(), this.p.GetItemText(this.p.SelectedItem))) {
			    	//ipID1 = getPatientID1(patientID1.getText());
					//dateAppt = getDate1(date1.getText());
					//timeAppt = getT1(t1.getText());
					sec.addPatient(getPatientID1(), getDate1(), getT1(), t, p);
			    }   
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Input", "Dialog", JOptionPane.ERROR_MESSAGE);	
                }					
            }
        });
    }

    // Get methods
    String[] typeCombo = {"Checkup", "Hygiene", "Silver Filling", "White Filling", "Gold Crown"};
    t = new JComboBox(typeCombo);
    // Booking an appointment
    public int getPatientID1(String pID1) {
        int ipID1 = Integer.valueOf(pID1);
        return ipID1;
    }

    public Date getDate1(String d1) {
        int year = Integer.valueOf(d1.substring(6));
        int month = Integer.valueOf(d1.substring(3,4));
        int day = Integer.valueOf(d1.substring(0,1));
        Date dateAppt = new Date(year,month,day);
        return dateAppt;
    }

    public Time getT1(String t1) {
        int hour = Integer.valueOf(time.substring(0, 1));
        int minute = Integer.valueOf(time.substring(3, 4));
        Time timeAppt = new Time(hour, minute,00);
        return timeAppt;
    }

	
}