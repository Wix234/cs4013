
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class TaxCal {
	private double fixedTax = 100;
	private double marketVal;
	private int location;
	private boolean privateResidence;
	private double totalTax;
	private int year;
	private boolean paid;
	private int curYear = Year.now().getValue();
	private int yearPaid;
	
	public TaxCal(Property p, int year, boolean paid, int yearPaid){
		if (p != null) {
			marketVal = p.getEstMarketVal();
			location = p.getLocation();
			privateResidence = p.isPrivResidence();
		}else {
			marketVal = 0;
			location = 0;
			privateResidence = false;
		}
		setYear(year);
		setPaid(paid);
		setYearPaid(yearPaid);
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public int getYearPaid() {
		return yearPaid;
	}
	public void setYearPaid(int yearPaid) {
		this.yearPaid = yearPaid;
	}

	public double estMarketValTax(){
		double taxMarketVal = 0;
		if(marketVal < 150000){
				taxMarketVal = 0;
			}else if (marketVal >= 150000 && marketVal <= 400000){
				taxMarketVal = (marketVal * 0.01);
			}else if (marketVal >= 400001 && marketVal <= 650000){
				taxMarketVal = (marketVal * 0.02);
			}else if (marketVal > 650001){
				taxMarketVal = (marketVal * 0.04);
			}
		return taxMarketVal;
	}
	
	public double taxLocation(){
		double taxLocation = 0;	
		if(location == 1){
				taxLocation = 100;
			}else if(location == 2){
				taxLocation = 80;
			}else if(location == 3){
				taxLocation = 60;
			}else if(location == 4){
				taxLocation = 50;
			}else if(location == 5){
				taxLocation = 25;
			}
		return taxLocation;
	}
	
	public double residenceTax(){
		double privateResTax;	
		if (privateResidence == true){
				privateResTax = 100;
			}else {
				privateResTax = 0;
			}	
		
		return privateResTax;
	}
	//new method
	public double totalTax(Property p){
		double temp = (fixedTax + taxLocation() + estMarketValTax()  + residenceTax());
		totalTax = (fixedTax + taxLocation() + estMarketValTax()  + residenceTax());
		int count = 0;
		if (yearPaid == 0 && p != null) {
			count = curYear - year;
		}else {
			count = yearPaid - year;
		}
		for (int i = 0; i < count; i++){
			totalTax = totalTax + (totalTax * 0.07);
		}
		BigDecimal twoPoints1 = new BigDecimal(totalTax).setScale(2, RoundingMode.HALF_UP);
		totalTax = twoPoints1.doubleValue();
		temp = totalTax - temp;
		BigDecimal twoPoints2 = new BigDecimal(temp).setScale(2, RoundingMode.HALF_UP);
		temp = twoPoints2.doubleValue();
		return totalTax;
	}
	
	public String getTotalTax(Property p){
		double temp = (fixedTax + taxLocation() + estMarketValTax()  + residenceTax());
		totalTax = (fixedTax + taxLocation() + estMarketValTax()  + residenceTax());
		int count = 0;
		if (yearPaid == 0 && p != null) {
			count = curYear - year;
		}else {
			count = yearPaid - year;
		}
		for (int i = 0; i < count; i++){
			totalTax = totalTax + (totalTax * 0.07);
		}
		BigDecimal twoPoints1 = new BigDecimal(totalTax).setScale(2, RoundingMode.HALF_UP);
		totalTax = twoPoints1.doubleValue();
		temp = totalTax - temp;
		BigDecimal twoPoints2 = new BigDecimal(temp).setScale(2, RoundingMode.HALF_UP);
		temp = twoPoints2.doubleValue();
		String str;
		
		
		if (p != null) {
			str = ("FT:" + fixedTax  + " | MT:" + estMarketValTax() + " | TL:" + taxLocation() + " | PR:" + residenceTax() + " | Overdue : "
				+ temp + " | Total tax: " + totalTax).replace("[", "").replace("]", "").replace(",", "");
		}else {
			str = "Missing information on cvs sheet.";
		}
		return str;
	}
