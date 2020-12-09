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
	private ArrayList<Tax> taxPaid = new ArrayList<Tax>();
	private ArrayList<Tax> taxDue = new ArrayList<Tax>();

	public String ownersProperties;
	public double ownersPaidTax;
	public double ownersTaxProperty;
	public double ownersDueTax;

	public static String getOwnersProperties(Owner o) {
		return (o.toString() + o.getProperties());
	}

	public void setOwnersPaidTax(Property p){
		ownersPaidTax = 0;
		for (int i = 0; i < taxPaid.size(); i++){
			ownersPaidTax = ownersPaidTax + taxPaid.get(i)./**need to know what return value is called*/;
		}
	}

	public ArrayList<Owner> getOwnerDetails() {
		return ownerDetails;
	}

	public void addOwnerDetails(Owner o) {
		ownerDetails.add(o);
	}

	public ArrayList<Tax> getTaxPaid() {
		return taxPaid;
	}

	public void setTaxPaid(ArrayList<Tax> taxPaid) {
		this.taxPaid = taxPaid;
	}

	public ArrayList<Tax> getTaxDue() {
		return taxDue;
	}

	public void setTaxDue(ArrayList<Tax> taxDue) {
		this.taxDue = taxDue;
	}

}
