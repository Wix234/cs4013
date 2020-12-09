
public class TestProperties {

	public static void main(String[] args) {
		Properties p1 = new Properties("Sean");
		p1.addProperty("12 lol", "123", 123.0, 2, true, 2019);
		p1.addProperty("12 lol", "123", 123.0, 2, true, 2019);
		p1.addProperty("13 lol", "123", 123.0, 2, true, 2020);
		p1.addProperty("13 lol", "123", 123.0, 2, true, 2020);
		System.out.println(p1.toString());
		Properties p2 = new Properties("Conor");
		p2.addProperty("11 nah", "123", 123.0, 2, true, 2010);
		p2.addProperty("12 nah", "123", 123.0, 2, true, 2011);
		p2.addProperty("13 nah", "123", 123.0, 2, true, 2011);
		p2.addProperty("14 nah", "123", 123.0, 2, true, 2012);
		//System.out.println(p2.toString());
		
		p2.addTax();
		System.out.println(p2.getTaxForYearX(2019));
		System.out.println(p2.getTaxForPopertyX("11 nah"));
		System.out.println(p2.toStringTaxes());
	}
}
