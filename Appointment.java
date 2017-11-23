import java.util.Date;

public class Appointment {

	private Date startTime;
	private Date endTime;

	public Appointment(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime =  startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime =  endTime;
	}

	public String toString(){
		String appointment;
		appointment = "Start time: " + startTime + " End time: " + endTime;
		return appointment;
	}
}
