public enum Option {
  HYGIENE, CHECKUP, SILVER_FILLING, WHITE_FILLING, GOLD_CROWN
}

public class Treatments {

  private Option nameOfTreatment;
  private int costOfTreatment;
  private int lengthOfTreatment;

  public Treatments(Option not, int cot, int lot) {
    nameOfTreatment = not;
    costOfTreatment = cot;
    lengthOfTreatment = lot;
  }

  public Option getNameOfTreatment() {
    return nameOfTreatment;
  }

  public int getCostOfTreatment() {
    return costOfTreatment;
  }

  public int getLengthOfTreatment() {
    return lengthOfTreatment;
  }

  public void setNameOfTreatment(Option not) {
    nameOfTreatment = not;
  }

  public void setLengthOfTreatment(int lot) {
    lengthOfTreatment = lot;
  }

  public void setCostOfTreatment(int cot) {
    costOfTreatment = cot;
  }
}
