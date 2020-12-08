import java.util.ArrayList;

public class Owner {

	private String name;
	private String currentAddress;
	private String currentPostcode;
	private ArrayList<Property> propertiesOwned = new ArrayList<Property>();

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

	public void addProperties(Property p) {
		propertiesOwned.add(p);
	}

	public String getProperties() {
		String properties = "\n";
		for (int i = 0; i < propertiesOwned.size(); i++) {
			properties = properties + "Property number " + (i + 1) + ":\n" + propertiesOwned.get(i).toString() + "\n";
		}
		return properties;
	}

	public String toString() {
		return (name + ":\n" + "Current Address: " + currentAddress + "\nCurrent Postcode: " + currentPostcode);
	}
}
