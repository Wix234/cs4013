public class Tax{
	private int year;
	private boolean paid;
	private int yearPaid;
	private Property p;
	public Tax(int year) {
		setYear(year);
		//setPaid(null);
		setP(null);
		setYearPaid(0);
	}
	public Tax(Property p, int year) {
		setYear(year);
		setPaid(false);
		setP(p);
	}
	public Tax(Property p,int year, int yearPaid) {
		setYear(year);
		if (yearPaid == 0) {
			setPaid(false);
		}else {
			setPaid(true);
		}
		setP(p);
		setYearPaid(yearPaid);
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
	public Property getP() {
		return p;
	}
	public void setP(Property p) {
		this.p = p;
	}
	public int getYearPaid() {
		return yearPaid;
	}
	public void setYearPaid(int yearPaid) {
		this.yearPaid = yearPaid;
	}
	
	public String getTaxInfo() {
		TaxCal t = new TaxCal(p, year, paid, yearPaid);
		return t.getTotalTax(p);
	}
	public String toString() {
		return ("| Year : " + year +" | Paid: " + paid + " | Year Paid : " + yearPaid + " | Tax information: " + getTaxInfo() + "\n");
	}
	
}
