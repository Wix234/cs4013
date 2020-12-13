
import java.math.BigDecimal;
import java.math.RoundingMode;
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
	public Owners(){
		ownerDetails = new ArrayList<Owner>();
	}
	
	public void addOwner(Owner o){
		boolean exists = false;
		for (int i = 0; i <ownerDetails.size(); i++){
			if (ownerDetails.get(i) == o){
				exists = true;
			}
		}
		if (exists == false){
			ownerDetails.add(o);
		}
		
	}
	public String getOwner(String name){
		String temp = null;
		for (int i = 0; i <ownerDetails.size(); i++){
			if (ownerDetails.get(i).getName() ==name){
				temp = ownerDetails.get(i).toString();
			}
		}
		return temp;
	}
	
	public void removeOwner(Owner o){
		for (int i = 0; i <ownerDetails.size(); i++){
			if (ownerDetails.get(i) == o){
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
	public String taxesPaidYear(int year){
		ArrayList<Tax> temp = null;
		ArrayList<Tax> temp2 = new ArrayList<Tax>();
		for (int i = 0; i < ownerDetails.size(); i++){
			for (int j = 0; j < ownerDetails.get(i).getPropertiesArray().size(); j++){
				temp = ownerDetails.get(i).getPropertiesArray().get(j).getOverDueTax();
				for (int k = 0; k < temp.size(); k++){
					if(temp.get(k).getYear() == year) {
						temp2.add(temp.get(k));
					}
				}
			}
		}
		return (temp2.toString()).replace("[", "").replace("]", "").replace(",", "");
	}
	public String taxesPaidYearLoc(String loc, int year){
		ArrayList<Tax> temp = null;
		ArrayList<Tax> temp2 = new ArrayList<Tax>();
		for (int i = 0; i < ownerDetails.size(); i++){
			for (int j = 0; j < ownerDetails.get(i).getPropertiesArray().size(); j++){
				if (ownerDetails.get(i).getPropertiesArray().get(j).getEircode().contains(loc))
				temp = ownerDetails.get(i).getPropertiesArray().get(j).getOverDueTax();
				if (temp != null) {
					for (int k = 0; k < temp.size(); k++){
						if(temp.get(k).getYear() == year && !temp2.contains(temp.get(k))) {
							temp2.add(temp.get(k));
						}
					}
				}
				
			}
		}
		String str;
		if (temp == null) {
			str = "No taxes due in this area";
		}else {
			str =(temp2.toString()).replace("[", "").replace("]", "").replace(",", "");
		}
		return str; 
	}
	public String taxesStatics(String loc){
		ArrayList<Tax> temp = null;
		ArrayList<Tax> temp2 = new ArrayList<Tax>();
		for (int i = 0; i < ownerDetails.size(); i++){
			for (int j = 0; j < ownerDetails.get(i).getPropertiesArray().size(); j++){
				if (ownerDetails.get(i).getPropertiesArray().get(j).getEircode().contains(loc))
				temp = ownerDetails.get(i).getPropertiesArray().get(j).getTaxes();
				if (temp != null) {
					for (int k = 0; k < temp.size(); k++){
						if(!temp2.contains(temp.get(k))) {
							temp2.add(temp.get(k));
						}
					}
				}
				
			}
		}
		double totalTax = 0;
		double totalTaxPaid= 0;
		int count = 0;
		double average = 0;
		double count2 = 0;
		double perPaid = 0;
		
		for (int i = 0; i < temp2.size(); i++){
			count++;
			totalTax = totalTax + temp2.get(i).getTotalTax(temp2.get(i).getP());
			if(temp2.get(i).isPaid() == true) {
				count2++;
				totalTaxPaid = totalTaxPaid + temp2.get(i).getTotalTax(temp2.get(i).getP());
				
				
			}
		}
		
		average = totalTaxPaid/count;
		perPaid = count2/count;
		
		BigDecimal twoPoints1 = new BigDecimal(totalTaxPaid).setScale(2, RoundingMode.HALF_UP);
		totalTaxPaid = twoPoints1.doubleValue();
		BigDecimal twoPoints2 = new BigDecimal(average).setScale(2, RoundingMode.HALF_UP);
		average = twoPoints2.doubleValue();
		BigDecimal twoPoints3 = new BigDecimal(perPaid).setScale(2, RoundingMode.HALF_UP);
		perPaid = twoPoints3.doubleValue();
		return ("Total tax paid in "+ loc + " : " + totalTaxPaid + "\nAverage tax paid in : " + average +
				"\nTotal paid :"+ count2  +"\nPercentage paid : "+ perPaid + "%\n");
	}
	
	public String toString(){
		return(ownerDetails.toString()).replace("[", "").replace("]", "").replace(",", "");
	}

	
}
