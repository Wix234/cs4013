import java.util.ArrayList;

public class Owner{
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
	//changed name from addPoperties to addProperty
	public void addProperty(Property p) {
		boolean contains = false;
		for (int i = 0; i <propertiesOwned.size(); i++){
			if (propertiesOwned.get(i) == p){
				contains = true;
			}
		}
		if (contains == false){
			propertiesOwned.add(p);
		}
	}
	//changed name from removePoperties to removeProperty
	public void removeProperty(Property p) {
		for (int i = 0; i < propertiesOwned.size(); i++) {
			if (propertiesOwned.get(i) == p) {
				propertiesOwned.remove(i);			}
		}
	}
	
	public void removeProperties() {
		for (int i = 0; i < propertiesOwned.size(); i++) {
				propertiesOwned.remove(i);			}
	}
	
	public String getProperty(String address){
		String temp = null;
		for (int i = 0; i < propertiesOwned.size(); i++) {
			if (propertiesOwned.get(i).getAddress() == address) {
				temp = propertiesOwned.get(i).PropertywithTaxToString();
			}
		}
		return temp;
	}
	//returns all properties owned by an owner and the tax on them
	public String getProperties() {
		String properties = "\n";
		for (int i = 0; i < propertiesOwned.size(); i++) {
			properties = properties + "Property number " + (i + 1) + ":\n" + propertiesOwned.get(i).toString() + "\n";
		}
		return properties;
	}
	public ArrayList<Property> getPropertiesArray() {
		return propertiesOwned;
	}
	
	
	public String getAllDetails() {
		return ownerToString();
	}
	//returns just owners details to string used to be called toString
	public String ownerToString() {
		return (name + ":\n" + "Current Address: " + currentAddress + "\nCurrent Postcode: " + currentPostcode);
	}
	//returns owners details all their property details and all the tax info on each property
	public String toString() {
		return ("Name: " + name + "\nCurrent address: " + currentAddress + "\nEircode: " + currentPostcode + "\n\n" 
	+ propertiesOwned.toString()).replace("[", "").replace("]", "").replace(",", "");
	}
	
}
