public class Owner {

	private String name;
	private String currentAddress;
	private String currentPostcode;

	public Owner(String name1, String currentAddress1, String currentPostcode1) {
		this.setName(name1);
		this.setCurrentAddress(currentAddress1);
		this.setCurrentPostcode(currentPostcode1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentPostcode() {
		return currentPostcode;
	}

	public void setCurrentPostcode(String currentPostcode) {
		this.currentPostcode = currentPostcode;
	}
}
