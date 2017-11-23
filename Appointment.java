import java.util.Date;

public class Appointment {

	private Date startTime;
	private Date endTime;

	public HealthCarePlan(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getstartTime() {
		return startTime;
	}

	public int getHygienistVisitsCovered() {
		return hygienistVisitsCovered;
	}

	public void setStartTime(Date startTime) {
		this.startTime =  startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime =  endTime;
	}
}
