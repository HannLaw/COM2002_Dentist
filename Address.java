public class Address {

	private String houseNumber;
	private String streetName;
	private String district;
	private String city;
	private String postcode;

	public Address(String hN, String sN, String ds, String ct, String pc) {
    houseNumber = hN;
    streetName = sN;
    district = ds;
    city = ct;
    postcode = pc;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

  public String getStreetName() {
    return streetName;
  }

  public String getDistrict() {
    return district;
  }

  public String getCity() {
    return city;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setHouseNumber(String hN) {
    houseNumber = hN;
  }

  public void setStreetName(String sN) {
    streetName = sN;
  }

  public void setDistrict(String ds) {
    district = ds;
  }

  public void setCity(String ct) {
    city = ct;
  }

  public void setPostcode(String pc) {
    postcode = pc;
  }

}
