import java.util.Date;

public class Appointment {

	private Date startTime;
	private Date endTime;

	public Appointment(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime =  startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime =  endTime;
	}
}
