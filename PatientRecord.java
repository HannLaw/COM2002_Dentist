
import java.util.Date;

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

	public PatientRecord(Ttl title, NoP nameOfPlan, String forename, String surname, String contactNumber, String houseNumber, String postCode, Date dateOfBirth, int remainingCheckUps, int remainingHygieneVisits, int remainingRepairs) {
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

	public Ttl getTitle() {
		return title;
	}

	public NoP getNameOfPlan() {
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

	public void setTitle(Ttl title) {
		this.title =  title;
	}

	public void setNameOfPlan(NoP nameOfPlan) {
		this.nameOfPlan =  nameOfPlan;
	}

	public void setForename(String forename) {
		this.forename =  forename;
	}

	public void setSurname(String surname) {
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
