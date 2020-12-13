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

	// changed name from addPoperties to addProperty
	public void addProperty(Property p) {
		boolean contains = false;
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			if (getPropertiesOwned().get(i) == p) {
				contains = true;
			}
		}
		if (contains == false) {
			getPropertiesOwned().add(p);
		}
	}

	// changed name from removePoperties to removeProperty
	public void removeProperty(Property p) {
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			if (getPropertiesOwned().get(i) == p) {
				getPropertiesOwned().remove(i);
			}
		}
	}

	public void removeProperties() {
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			getPropertiesOwned().remove(i);
		}
	}

	public String getProperty(String address) {
		String temp = null;
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			if (getPropertiesOwned().get(i).getAddress() == address) {
				temp = getPropertiesOwned().get(i).toString();
			}
		}
		return temp;
	}

	// returns all properties owned by an owner and the tax on them
	public String getProperties() {
		String properties = "\n";
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			properties = properties + "Property number " + (i + 1) + ":\n" + getPropertiesOwned().get(i).toString() + "\n";
		}
		return properties;
	}

	public ArrayList<Property> getPropertiesArray() {
		return getPropertiesOwned();
	}

	public String getAllDetails() {
		return ownerToString();
	}

	// returns just owners details to string used to be called toString
	public String ownerToString() {
		return (name + ":\n" + "Current Address: " + currentAddress + "\nCurrent Postcode: " + currentPostcode);
	}

	public String taxesPaidYear(int year) {
		ArrayList<Tax> temp = new ArrayList<Tax>();
		for (int i = 0; i < getPropertiesOwned().size(); i++) {
			for (int j = 0; j < getPropertiesOwned().get(i).getTaxes().size(); j++) {
				if (getPropertiesOwned().get(i).getTaxes().get(j).getYear() == year) {
					temp.add(getPropertiesOwned().get(i).getTaxes().get(j));
				}
			}
		}
		return (temp.toString()).replace("[", "").replace("]", "").replace(",", "");
	}

	// returns owners details all their property details and all the tax info on
	// each property
	public String toString() {
		return ("Name: " + name + "\nCurrent address: " + currentAddress + "\nEircode: " + currentPostcode + "\n\n"
				+ getPropertiesOwned().toString()).replace("[", "").replace("]", "").replace(",", "");
	}

	public ArrayList<Property> getPropertiesOwned() {
		return propertiesOwned;
	}

	public void setPropertiesOwned(ArrayList<Property> propertiesOwned) {
		this.propertiesOwned = propertiesOwned;
	}

}

