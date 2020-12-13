


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
		private ArrayList<Tax> taxes;
		private ArrayList<Tax> taxesDue = new ArrayList<Tax>();;
		private String name;
		private ArrayList<Payments> paymentsMade = new ArrayList<Payments>() ;
		
		public Property(String name, String address, String eircode, double estMarketVal,String located, String privateResidence, int yearBought){
			setAddress(address);
			setEircode(eircode);
			setEstMarketVal(estMarketVal);
			setLocation(located); 
			setPrivResidence(privateResidence);
			setYearBought(yearBought);
			setName(name);
			taxes = new ArrayList<Tax>();
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
		}
		//new method
		public void getTaxDue(){
			for (int i = 0; i < taxes.size(); i++){
				if (taxes.get(i).getYearPaid() == 0){
					taxesDue.add(taxes.get(i));
				}
			}
		}
		//new method
		public void defualtPayment(){
			for (int i = yearBought; i < curYear; i++){
				Payments p = new Payments(getAddress(),i);
				paymentsMade.add(p);
			}
			
		}
		//new method
		public void makeAPayment(Tax t){
			//double tax = 0;
			for (int i = 0; i < taxes.size(); i++){
				if (taxes.get(i).getP().getAddress() == t.getP().getAddress() && taxes.get(i).getYear() == t.getYear()){
					//tax = taxes.get(i).getTotalTax((taxes.get(i).getP()));
					taxes.get(i).setPaid(true);
				}
			}
			//Payments payment = new Payments(address, year , tax, amount, yearPaid);
			//paymentsMade.add(payment);	
		}
		public ArrayList<Tax> getOverDueTax(){
			getTaxDue();
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
			getTaxDue();
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
