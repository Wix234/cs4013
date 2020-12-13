
import java.util.ArrayList;

//The main purpose of this class is to return the 
public class Owners {
	/**
	 * + ownersProperties //returns the details of the owner as well as all the
	 * properties they own
	 * 
	 * + ownersPaidTax // returns the tax paid on each property by that owner in
	 * all the years the owner owned it
	 * 
	 * +ownersTaxProperty // this returns all the tax on the specific property
	 * (both paid and due/overdue) in all the years the owner owned it
	 * 
	 * +ownersDueTax // this returns what tax is due on which property the owner
	 * owns and any overdue tax as well
	 */
	private ArrayList<Owner> ownerDetails;
	public String ownersProperties = "";

	public Owners() {
		ownerDetails = new ArrayList<Owner>();
	}

	public void addOwner(Owner o) {
		boolean exists = false;
		for (int i = 0; i < ownerDetails.size(); i++) {
			if (ownerDetails.get(i) == o) {
				exists = true;
			}
		}
		if (exists == false) {
			ownerDetails.add(o);
		}

	}

	public String getOwner(String name) {
		String temp = null;
		for (int i = 0; i < ownerDetails.size(); i++) {
			if (ownerDetails.get(i).getName() == name) {
				temp = ownerDetails.get(i).toString();
			}
		}
		return temp;
	}

	public void removeOwner(Owner o) {
		for (int i = 0; i < ownerDetails.size(); i++) {
			if (ownerDetails.get(i) == o) {
				ownerDetails.remove(i);
			}
		}
	}

	public String getOwnersProperties() {
		for (int i = 0; i < ownerDetails.size(); i++) {
			Owner o = ownerDetails.get(i);
			ownersProperties = ownersProperties + ("\n\n" + (i + 1) + ")" + o.getAllDetails());
		}
		return ownersProperties;
	}

	public ArrayList<Owner> getOwnerDetails() {
		return ownerDetails;
	}

	public String taxesPaidYear(int year) {
		ArrayList<Tax> temp = new ArrayList<Tax>();
		for (int k = 0; k < ownerDetails.size(); k++) {
			for (int i = 0; i < ownerDetails.get(k).getPropertiesOwned().size(); i++) {
				for (int j = 0; j < propertiesOwned.get(i).getTaxes().size(); j++) {
					if (propertiesOwned.get(i).getTaxes().get(j).getYear() == year) {
						temp.add(propertiesOwned.get(i).getTaxes().get(j));
					}
				}
			}
		}
		return (temp.toString()).replace("[", "").replace("]", "").replace(",", "");
	}

	public String toString() {
		return (ownerDetails.toString()).replace("[", "").replace("]", "").replace(",", "");
	}

}
