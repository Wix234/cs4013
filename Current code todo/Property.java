

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class Property{
		private String address;
		private String eircode;
		private double estMarketVal;
		private int location;
		private boolean privResidence;
		private int yearBought;
		private int curYear = Year.now().getValue();
		private ArrayList<Tax> taxes = new ArrayList<Tax>();
		private ArrayList<Tax> taxesDue = new ArrayList<Tax>();
		private ArrayList<Tax> taxesPaid = new ArrayList<Tax>();
		private String name;
		
		public Property(String name, String address, String eircode, double estMarketVal,String located, String privateResidence, int yearBought){
			setAddress(address);
			setEircode(eircode);
			setEstMarketVal(estMarketVal);
			setLocation(located); 
			setPrivResidence(privateResidence);
			setYearBought(yearBought);
			setName(name);
			defaultTax();
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEircode() {
			return eircode;
		}
		public void setEircode(String eircode) {
			this.eircode = eircode;
		}
		public double getEstMarketVal() {
			return estMarketVal;
		}
		public void setEstMarketVal(double estMarketVal) {
			this.estMarketVal = estMarketVal;
		}
		public int getLocation() {
			return location;
		}
		public void setLocation(String located) {
			if(located.equalsIgnoreCase("City")){
					location = 1;
				}else if(located.equalsIgnoreCase("Large town")){
					location = 2;
				}else if(located.equalsIgnoreCase("Small town")){
					location = 3;
				}else if(located.equalsIgnoreCase("Village")){
					location = 4;
				}else if(located.equalsIgnoreCase("Countryside")){
					location = 5;
				}
		}
		public boolean isPrivResidence() {
			return privResidence;
		}
		public void setPrivResidence(String privateResidence) {
			if (privateResidence.equalsIgnoreCase("Yes")){
					privResidence = true;
				}else {
					privResidence = false;
				}	
		}
		public int geYearBought() {
			return yearBought;
		}
		public void setYearBought(int yearBought) {
			this.yearBought = yearBought;
		}
		//create a check if tax for that year was already added
		public void defaultTax(){
			for (int i = yearBought; i <= curYear; i ++) {
				Tax t = new Tax(i);
				taxes.add(t);
			}
		}
		public void addTax(Tax t) {
			for (int i = 0; i < taxes.size(); i++) {
				if (taxes.get(i).getYear() == t.getYear()) {
					taxes.set(i, t);
				}
			}
			if (t.isPaid() == false) {
				taxesDue.add(t);
			} 
		}
		//new method
		public void organiseTaxes(){
			for (int i = 0; i < taxesDue.size(); i++){
				if (taxesDue.get(i).isPaid() != false){
					taxesPaid.add(taxes.get(i));
					taxesDue.remove(taxes.get(i));
				}
			}
		}
		//new method
		public void payTax(Tax t){
			for (int i = 0; i < taxes.size(); i++){
				if (taxes.get(i).getP().getAddress() == t.getP().getAddress() && taxes.get(i).getYear() == t.getYear()){
					taxesDue.remove(t);
					taxes.get(i).setPaid(true);
					taxes.get(i).setYearPaid(curYear);
					taxesPaid.add(t);
				}
			}
		}
		public ArrayList<Tax> getTaxesPaid(){
			return taxesPaid;
		}
		public ArrayList<Tax> getTaxes(){
			return taxes;
		}
		public ArrayList<Tax> getOverDueTax(){
			return taxesDue;
		}
		//new method
		public String PropertywithTaxToString(){
			String temp;
			if (privResidence == true){
				temp = "Yes";
			}else {
				temp = "No";
			}
			String temp2 = null;
			if(location == 1){
				temp2 = "City";
			}else if(location == 2){
				temp2 = "Large town";
			}else if(location == 3){
				temp2 = "Small town";
			}else if(location == 4){
				temp2 = "Village";
			}else if(location == 5){
				temp2 = "Countryside";
			}
			return ("Address:\n" + address + "\n" + eircode + "\nEstimated market value: " + estMarketVal
					+ "\nLocation type: " + temp2 + "\nPrinciple private Residence: " + temp + "\nYear Bought: "  
					+ yearBought + "\n\nAll tax information:\n" + taxes 
					+ "\n").replace("[", "").replace("]", "").replace(",", "");
		}
		public String toString(){	
			organiseTaxes();
			String temp;
			if (privResidence == true){
				temp = "Yes";
			}else {
				temp = "No";
			}
			String temp2 = null;
			if(location == 1){
				temp2 = "City";
			}else if(location == 2){
				temp2 = "Large town";
			}else if(location == 3){
				temp2 = "Small town";
			}else if(location == 4){
				temp2 = "Village";
			}else if(location == 5){
				temp2 = "Countryside";
			}
			return ("Address:\n" + address + "\n" + eircode + "\nEstimated market value: " + estMarketVal
					+ "\nLocation type: " + temp2 + "\nPrinciple private Residence: " + temp + "\nYear Bought: "  
					+ yearBought + "\n\nTax Due and Overdue:\n" + taxesDue + "\n").replace("[", "").replace("]", "").replace(",", "");
		}


}
