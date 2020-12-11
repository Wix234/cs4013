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
	
	public void removeProperty(String address) {
		for (int i = 0; i < propertiesOwned.size(); i++) {
			if (propertiesOwned.get(i).getAddress() == address) {
				propertiesOwned.remove(i);			}
		}
	}
	
	public String getProperty(String address){
		String temp = null;
		for (int i = 0; i < propertiesOwned.size(); i++) {
			if (propertiesOwned.get(i).getAddress() == address) {
				temp = propertiesOwned.get(i).toString();
			}
		}
		return temp;
	}
	
	public ArrayList<Property> getPropertiesArray() {
		return propertiesOwned;
	}
	
	public String getAllDetails() {
		return toString();
	}
	
	public String toString() {
		return ("Name: " + name + "\nCurrent address: " + currentAddress + "\nEircode: " + currentPostcode + "\n\n" 
	+ propertiesOwned.toString()).replace("[", "").replace("]", "").replace(",", "");
	}
	
}
