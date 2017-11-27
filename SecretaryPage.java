import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public SecretaryPage() {


        bookingSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Secretary sec = new Secretary();
				int ipID1;
			    Date dateAppt;
				Time timeAppt;
                if (Validation.bookappointment(patientID1.getText(), date1.getText(), t1.getText(), t1.getText(), (String)t.getSelectedItem(),(String)p.getSelectedItem())) {
			    	try {
                        ipID1 = getPatientID1();
                        dateAppt = getDate1();
                        timeAppt = getT1();
                        sec.bookAppointment(getPatientID1(), getDate1(), getT1(), getT(), getP());
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
                PatientRecord pRec = new PatientRecord(Ttl.MR,getPlan(),getFirstName3(),getSurname3(),getContactNo(),getADL1(),getPostcode(),getDoB(),patientID,remCheckups,remHygiene,remRepairs);
                Secretary sec = new Secretary();
                sec.addPatient(pRec);
            }
        });
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

    public String getADL1() {
            return adl1_1.getText();
    }

    public String getPostcode() {
        return pc1.getText();
    }


}

}