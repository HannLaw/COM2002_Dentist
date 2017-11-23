import java.util.Date;

public enum Prtner {
    DENTIST, HYGIENIST
}  

public class Appointment {

	private Date startTime;
	private Date endTime;
	private Prtner partner;
	private int patientID;
	private string nameOfTreatment;
	private boolean seen; 

	public Appointment(Date startTime, Date endTime, Prtner partner, int patientID, string nameOfTreatment, boolean seen ) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.partner = partner;
		this.patientID = patientID;
		this.nameOfTreatment = nameOfTreatment;
		this.seen = seen;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	
	public Prtner getPartner() {
		return partner;
	}	

	public int getPatientID() {
		return patientID;
	}	
	
	public string getNameOfTreatment() {
		return nameOfTreatment;
	}

	public boolean getSeen() {
		return seen;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime =  startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime =  endTime;
	}
	
	public void setPartner(Prtner partner) {
		this.partner =  partner;
	}

	public void setPatientID(int patientID) {
		this.patientID =  patientID;
	}
	
	public void setNameOfTreatment(string nameOfTreatment) {
		this.nameOfTreatment =  nameOfTreatment;
	}
	
	public void setSeen(boolean seen) {
		this.seen =  seen;
	}
	
	public String toString(){
		String appointment;
		appointment = "Start time: " + startTime + " End time: " + endTime;
		return appointment;
	}
}