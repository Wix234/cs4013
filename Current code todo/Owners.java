import java.util.ArrayList;

// The main purpose of this class is to return the 
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

	private ArrayList<Owner> ownerDetails = new ArrayList<Owner>();

	public String ownersProperties = "";

	public String getOwnersProperties() {
		for (int i = 0; i < ownerDetails.size(); i++) {
			Owner o = ownerDetails.get(i);
			ownersProperties = ownersProperties + ("\n" + (i + 1) + ")\n" + o.getAllDetails());
		}
		return ownersProperties;
	}

	public void addOwner(Owner o) {
		boolean contains = false;
		for (int i = 0; i < ownerDetails.size(); i++) {
			if (o == ownerDetails.get(i)) {
				contains = true;
			}
		}
		if (contains == false) {
			ownerDetails.add(o);
		}
	}

	public void removeOwner(Owner o) {
		for (int i = 0; i < ownerDetails.size(); i++) {
			if (o == ownerDetails.get(i)) {
				ownerDetails.remove(i);
			}
		}
	}

	public ArrayList<Owner> getOwnerDetails() {
		return ownerDetails;
	}

}
