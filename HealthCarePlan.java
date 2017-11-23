import java.util.Date;

public class HealthCarePlan {

	private Enum nameOfPlan;
	private int checkUpsCovered;
	private int hygienistVisitsCovered;
	private int repairsCovered;

	public HealthCarePlan(Enum nameOfPlan, int checkUpsCovered, int hygienistVisitsCovered, int repairsCovered, float monthlyCost) {
		this.nameOfPlan = nameOfPlan;
		this.checkUpsCovered = checkUpsCovered;
		this.hygienistVisitsCovered = hygienistVisitsCovered;
		this.repairsCovered = repairsCovered;
		this.monthlyCost = monthlyCost;
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
		this.nameOfPlan = nameOfPlan;
	}

	public void setCheckUpsCovered(int checkUpsCovered) {
		this.checkUpsCovered = checkUpsCovered;
	}

	public void setRepairsCovered(int repairsCovered) {
		this.repairsCovered = repairsCovered;
	}
	
	public void setMonthlyCost(float monthlyCost) {
		this.monthlyCost = monthlyCost;
	}
}