import java.time.Year;
import java.util.ArrayList;

public class Properties {
	public String ownerName;//temp so i can test it
	private ArrayList<Property> properties = new ArrayList<Property>();
	private ArrayList<Tax> taxes = new ArrayList<Tax>();
	private int curYear = Year.now().getValue();
	public Properties(String name){
		this.ownerName = name;
	}
	//needs to check for owners name as well as address
	public void addProperty(String address, String eircode, double estMarketVal,int location, boolean privateResidence, int year){
        boolean found = false;
        for (int i = 0; i < properties.size(); i++){
            if (address == properties.get(i).getAddress()){
                found = true;
            }
        }
        if(found == false){
            Property property = new Property(address, eircode, estMarketVal,
            		location, privateResidence, year);
            properties.add(property);
        }else{
        	 Property property = new Property(address, eircode, estMarketVal,
             		location, privateResidence, year);
        	System.out.println("Property" + property.getAddress() + " already in database. \n");
        }
        
    }
	
	public ArrayList<Property> getProperties(){
		return properties;
	}
	
	//this needs to actually get stuff from owner
	public String getOwnerName(){
		return ownerName;
	}
	public String toString() {
        return (("Property owner: "+ ownerName  +  "\n" + properties).replace("[", "").replace("]", "").replace(",", "") +"\n");
    }
	
	public void addTax() {
		for(int i = 0; i <properties.size(); i ++) {
			Property p = properties.get(i);
			int yearsOwned = curYear- p.getYearBought();
			for (int j = 0; j < yearsOwned; j++) {
				TaxCal tax = new TaxCal(p);
				Tax taxed = new Tax(p, (p.getYearBought() + j), tax.taxInformation(), tax.getTotalTax(p), true);
				taxes.add(taxed);
			}
		}
	}
	public String getTaxForYearX(int year) {
		ArrayList<Tax> temp = new ArrayList<Tax>();
		for (int i = 0; i < taxes.size(); i++) {
			if (year == taxes.get(i).getYear()) {
				temp.add(taxes.get(i));
			}
		}
		return (temp.toString()).replace("[", "").replace("]", "").replace(",", "");
	}
	public String getTaxForPopertyX(String name) {
		ArrayList<Tax> temp = new ArrayList<Tax>();
		for (int i = 0; i < taxes.size(); i++) {
			if (name == taxes.get(i).getName()) {
				temp.add(taxes.get(i));
			}
		}
		return (temp.toString()).replace("[", "").replace("]", "").replace(",", "");
	}
	public String toStringTaxes() {
		return ("Properties\n " + taxes + "\n").replace("[", "").replace("]", "").replace(",", "");
	}
}
