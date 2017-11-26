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
    private JTextField dob;
    private JTextField contact;
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


    public SecretaryPage() {
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

        bookingSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Secretary sec = new Secretary();
                sec.bookAppointment(getPatientID1(), getDate1(), getT1(), t, p);
            }
        });
    }
}
}
