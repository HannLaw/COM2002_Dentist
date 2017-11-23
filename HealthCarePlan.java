import java.util.Date;

public class HealthCarePlan {

	private Enum nameOfPlan;
	private int checkUpsCovered;
	private int hygienistVisitsCovered;
	private int repairsCovered;

	public HealthCarePlan(Enum nameOfPlan, int checkUpsCovered, int hygienistVisitsCovered, int repairsCovered) {
		this.nameOfPlan = nameOfPlan;
		this.checkUpsCovered = checkUpsCovered;
		this.hygienistVisitsCovered = hygienistVisitsCovered;
		this.repairsCovered = repairsCovered;
	}

	public Enum getNameOfPlan() {
		return nameOfPlan;
	}

	public int getCheckUpsCovered() {
		return checkUpsCovered;
	}

	public int getHygienistVisitsCovered() {
		return hygienistVisitsCovered;
	}

	public void setNameOfPlan(Enum nameOfPlan) {
		this.nameOfPlan =  nameOfPlan;
	}

	public void setCheckUpsCovered(int checkUpsCovered) {
		this.checkUpsCovered =  checkUpsCovered;
	}

	public void setRepairsCovered(int repairsCovered) {
		this.repairsCovered =  repairsCovered;
	}
}
