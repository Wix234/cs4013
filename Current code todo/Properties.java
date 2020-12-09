import java.util.ArrayList;

public class Properties {
	public String ownerName;//temp so i can test it
	private ArrayList<Property> properties = new ArrayList<Property>();
	private ArrayList<Tax> taxes = new ArrayList<Tax>();
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
			TaxCal tax = new TaxCal(p);
			Tax taxed = new Tax(tax.taxInformation(), tax.getTotalTax(p));
			taxes.add(taxed);
		}
	}
	
	public String toStringTaxes() {
		return ("Properties\n " + taxes + "\n");
	}
}
