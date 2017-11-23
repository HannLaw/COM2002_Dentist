import java.util.Date;

public class PatientRecord {

	private Enum title;
	private Enum nameOfPlan;
	private String forename;
	private String surname;
	private String contactNumber;
	private Date dateOfBirth;
	private int patientID;
	private int remainingCheckUps;
	private int remainingHygieneVisits;
	
	public PatientRecord(Enum title, Enum nameOfPlan, String forename, String surname, String contactNumber, Date dateOfBirth, int patientID, int remainingCheckUps, int remainingHygieneVisits) {
		this.title = title;
		this.nameOfPlan = nameOfPlan; 
		this.forename = forename; 
		this.surname = surname; 
		this.contactNumber = contactNumber; 
		this.dateOfBirth = dateOfBirth; 
		this.patientID = patientID; 
		this.remainingCheckUps = remainingCheckUps; 
		this.remainingHygieneVisits = remainingHygieneVisits; 
	}
	
	public Enum getTitle() {
		return title;
	}
	
	public Enum getNameOfPlan() {
		return nameOfPlan;
	}
	
	public String getForename() {
		return forename;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public int getPatientID() {
		return patientID;
	}
	
	public int getRemainingCheckUps() {
		return remainingCheckUps;
	}
	
	public int getRemainingHygieneVisits() {
		return remainingHygieneVisits;
	}
	
	public void setTitle(Enum title) {
		this.title =  title;
	}
	
	public void setNameOfPlan(Enum nameOfPlan) {
		this.nameOfPlan =  nameOfPlan;
	}
	
	public void setForename(String forename) {
		this.forename =  forename;
	}
	
	public void setSurname(String surname)) {
		this.surname =  surname;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber =  contactNumber;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth =  dateOfBirth;
	}
	
	public void setPatientID(int patientID) {
		this.patientID =  patientID;
	}
	
	public void setRemainingCheckUps(int remainingCheckUps) {
		this.remainingCheckUps =  remainingCheckUps;
	}
	
	public void setRemainingHygieneVisits(int remainingHygieneVisits) {
		this.remainingHygieneVisits =  remainingHygieneVisits;
	}
}
