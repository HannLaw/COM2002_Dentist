import java.util.Date;

public enum Ttl {
  MR, MRS, MISS, MS, DR
}

public enum NoP {
  NHS, MAINTENANCE, ORALHEALTH, DENTALREPAIR
}

public class PatientRecord {

	private Ttl title;
	private NoP nameOfPlan;
	private String forename;
	private String surname;
	private String contactNumber;
	private String houseNumber;
	private String postCode;
	private Date dateOfBirth;
	private int patientID;
	private int remainingCheckUps;
	private int remainingHygieneVisits;
	private int remainingRepairs;

	public PatientRecord(Enum title, Enum nameOfPlan, String forename, String surname, String contactNumber, String houseNumber, String postCode, Date dateOfBirth, int patientID, int remainingCheckUps, int remainingHygieneVisits, int remainingRepairs) {
		this.title = title;
		this.nameOfPlan = nameOfPlan;
		this.forename = forename;
		this.surname = surname;
		this.contactNumber = contactNumber;
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.dateOfBirth = dateOfBirth;
		this.patientID = patientID;
		this.remainingCheckUps = remainingCheckUps;
		this.remainingHygieneVisits = remainingHygieneVisits;
		this.remainingRepairs = remainingRepairs;
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

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getPostCode() {
		return postCode;
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

	public int getRemainingRepairs() {
		return remainingRepairs;
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

	public void setHouseNumber(String houseNumber) {
		this.houseNumber =  houseNumber;
	}

	public void setPostCode(String postCode) {
		this.postCode =  postCode;
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

	public void setRemainingRepairs(int remainingRepairs) {
		this.remainingRepairs =  remainingRepairs;
	}

}
