package COM2002_Dentist;

import java.sql.Time;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		PatientRecord Paul = new PatientRecord(Ttl.MR, NoP.NHS,"Paul", "Hudson", "007" , "34", "13 S10", new Date (93, 23, 01), 4, 0, 0, 0);
 
        Secretary dao1 = new Secretary();
        dao1.viewAppointments(new Date(2017, 10, 30));
        //dao1.bookAppointment(101, new Date(117, 9, 24), new Time(13,00,00),new Time(13,30,00), Treatment.CHECKUP, Prtner.DENTIST);
        //dao1.cancelAppointment(101, Prtner.DENTIST);
        //dao1.cancelAppointment(1, Prtner.DENTIST);
        //dao1.bookEmptyAppointment(new Date(117, 11, 31), Prtner.DENTIST);
        //dao1.suscribePatient(Paul, NoP.MAINTENANCE);
        //dao1.unsuscribePatient(Paul);
        //dao1.findAppointments(1, Prtner.DENTIST);
        
    }
}
