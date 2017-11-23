public enum Treatment {
  HYGIENE, CHECKUP, SILVER_FILLING, WHITE_FILLING, GOLD_CROWN
}

public class Treatments {

  private Treatment nameOfTreatment;
  private int costOfTreatment;
  private int lengthOfTreatment;

  public Treatments(Treatment not, int cot, int lot) {
    nameOfTreatment = not;
    costOfTreatment = cot;
    lengthOfTreatment = lot;
  }

  public Treatment getNameOfTreatment() {
    return nameOfTreatment;
  }

  public int getCostOfTreatment() {
    return costOfTreatment;
  }

  public int getLengthOfTreatment() {
    return lengthOfTreatment;
  }

  public void setNameOfTreatment(Treatment not) {
    nameOfTreatment = not;
  }

  public void setLengthOfTreatment(int lot) {
    lengthOfTreatment = lot;
  }

  public void setCostOfTreatment(int cot) {
    costOfTreatment = cot;
  }
}