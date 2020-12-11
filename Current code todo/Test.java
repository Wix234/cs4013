import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		Property p1 = new Property("23 limerick", "12423", 3221974.00, 2, true);
		Property p2 = new Property("3 limerick", "1213423", 3221972144.00, 2, false);
		TaxCal tax1 = new TaxCal(p1);

		Owner o1 = new Owner("Troy Barnes", "4 Maple Road", "H4T5");
		o1.addProperties(p1);
		o1.addProperties(p2);

		Owner o2 = new Owner("Desmond Lecker", "32 East Harbour Street", "H4T5");
		o2.addProperties(p2);
		o2.addProperties(p1);
		o2.removeProperties(p1);

		Owners machine = new Owners();
		machine.addOwner(o1);
		machine.addOwner(o2);
		machine.addOwner(o1);

		OwnersScreen menu = new OwnersScreen();
		menu.run(machine);
	}

}
