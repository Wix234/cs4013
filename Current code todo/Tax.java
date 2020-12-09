public class Tax {
	private String taxInfo;
	private double total;
	private int year;
	private boolean paid;
	private String name;
	
	public Tax() {
	}
	public Tax(Property p,int year, String info, double total, boolean paid) {
		name = p.getAddress();
		setTaxInfo(info);
		setTotal(total);
		setYear(year);
		setPaid(paid);
	}
	
	public String getTaxInfo() {
		return taxInfo;
	}

	public void setTaxInfo(String taxInfo) {
		this.taxInfo = taxInfo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public String getName() {
		return name;
	}
	public String taxInfo(Property p) {
		TaxCal tax = new TaxCal(p);
		return (tax.taxInformation() + " | Total tax is:" + tax.getTotalTax(p));
	}
	
	public String toString() {
		return ("Name : " + name + " Year : " + year + taxInfo + " Total tax " + total + " Paid : " +  paid + 
				"\n" ).replace("[", "").replace("]", "").replace(",", "");
	}
}
