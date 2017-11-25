import java.util.Date;


public class HealthCarePlan {

	private NoP nameOfPlan;
	private int checkUpsCovered;
	private int hygienistVisitsCovered;
	private int repairsCovered;
	private double monthlyCost;

	public HealthCarePlan(NoP nameOfPlan, int checkUpsCovered, int hygienistVisitsCovered, int repairsCovered, double monthlyCost) {
		this.nameOfPlan = nameOfPlan;
		this.checkUpsCovered = checkUpsCovered;
		this.hygienistVisitsCovered = hygienistVisitsCovered;
		this.repairsCovered = repairsCovered;
		this.monthlyCost = monthlyCost;
	}

	public NoP getNameOfPlan() {
		return nameOfPlan;
	}

	public int getCheckUpsCovered() {
		return checkUpsCovered;
	}

	public int getHygienistVisitsCovered() {
		return hygienistVisitsCovered;
	}

	public void setNameOfPlan(NoP nameOfPlan) {
		this.nameOfPlan = nameOfPlan;
	}

	public void setCheckUpsCovered(int checkUpsCovered) {
		this.checkUpsCovered = checkUpsCovered;
	}

	public void setRepairsCovered(int repairsCovered) {
		this.repairsCovered = repairsCovered;
	}

	public void setMonthlyCost(double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}
}
