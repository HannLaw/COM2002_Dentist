import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PartnerPage extends  JFrame {
    public JPanel partPagePanel;
    private JTabbedPane tabbedPane1;
    private JTextField patientID;
    private JTextField firstName;
    private JTextField surname;
    private JButton viewApptSubmit;
    private JTextField dayDate;
    private JPanel dayCal;
    private JTextField weekDate;
    private JFrame j = this;
    private String t = j.getTitle();


    public PartnerPage() {
        SecretaryPage sec = new SecretaryPage();

        dayDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t=="DentistPage") {
                    try {
                        sec.viewDAppointments(getDate(dayDate));
                    } catch (Exception c) {
                        System.out.println("Uh oh...");
                    }
                }
                else {
                    try {
                        sec.viewHAppointments(getDate(dayDate));
                    } catch (Exception c) {
                        System.out.println("Uh oh...");
                    }
                }
            }
        });
        weekDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t=="DentistPage") {
                    try {
                        sec.viewDAppointments(getDate(weekDate));
                    } catch (Exception c) {
                        System.out.println("Uh oh...");
                    }
                }
                else {
                    try {
                        sec.viewHAppointments(getDate(weekDate));
                    } catch (Exception c) {
                        System.out.println("Uh oh...");
                    }
                }
            }
        });
    }

    public Date getDate(JTextField d) {
        String dDate = d.getText();
        int yearD = Integer.valueOf(dDate.substring(6));
        int monthD = Integer.valueOf(dDate.substring(3,4));
        int dayD = Integer.valueOf(dDate.substring(0,1));
        Date dateD = new Date(yearD,monthD,dayD);
        return dateD;
    }
}
